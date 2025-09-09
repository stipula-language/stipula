import ast.*;
import lib.Pair;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.StipulaLexer;
import parser.StipulaParser;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;


public class Compile {

	public static void main(String[] args) throws Exception {

		String fileName = args[0];
		FileInputStream is = new FileInputStream(fileName);
		ANTLRInputStream input = new ANTLRInputStream(is);
		StipulaLexer lexer = new StipulaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		StipulaParser parser = new StipulaParser(tokens);
		
		if (parser.getNumberOfSyntaxErrors() == 0) { 

			ParseTree t = parser.prog();

			/* TYPE CHECKING */
			TypeChecker code = new TypeChecker();
			@SuppressWarnings("unchecked")
			Map<Pair<String, Integer>, Type> types = (Map<Pair<String, Integer>, Type>) code.visit(t);
			ArrayList<Pair<String,ArrayList<Pair<String,Type>>>> funParams = code.getFunParams();
			ArrayList<String> nc = code.getNames();
			System.out.println("TYPE CHECKING:");
			System.out.println("==================");
			TypeInference typeinferencer = new TypeInference(types,nc,funParams);			
			typeinferencer.print_map();
			System.out.println("==================");

			/* INTERPRETER */
			Interpreter codeInterpreter = new Interpreter();
			Object program = codeInterpreter.visit(t);
			((Program) program).runProgram(typeinferencer);

			
		}
	}
}