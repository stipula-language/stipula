import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Stack;
import org.javatuples.Triplet;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ast.Asset;
import ast.AssetType;
import ast.BooleanType;
import ast.Contract;
import ast.DateUtils;
import ast.Disputer;
import ast.Field;
import ast.Interpreter;
import ast.LiquidityAnalysis;
import ast.LiquidityCalculator;
//import ast.StipulaVisitorImpl;
//import ast.StipulaWalker;
import ast.Node;
import ast.Program;
import ast.RealType;
import ast.TimeType;
import ast.BooleanType;
import ast.GeneralType;

import ast.STentry;
import ast.StipulaVisitorImpl;
import ast.StipulaWalker;
import ast.StringType;
import ast.SymbolTableStack;
import ast.Type;
import ast.TypeChecker;
import ast.TypeInference;
import ast.TypeInferenceListener;
import javafx.util.Pair;
import parser.*;
import util.Environment;
import util.SemanticError;



public class Test {

	public static void print_map(Map<Pair<String,Integer>,Type> types){
		for(Pair<String,Integer> s: types.keySet()) {
			System.out.print("var: " + s.getKey() +" type: " + types.get(s).getTypeName());
			if(s.getValue()>0) {
				int toPrint = Integer.valueOf(s.getValue())-1;
				System.out.println(" function #" + toPrint);
			}
			else {
				System.out.println("");
			}
		}
	}



	public static void main(String[] args) throws Exception {
	    
		String fileName = "prova.stipula";
		FileInputStream is = new FileInputStream(fileName);
		ANTLRInputStream input = new ANTLRInputStream(is);
		StipulaLexer lexer = new StipulaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		StipulaParser parser = new StipulaParser(tokens);

		ParseTreeWalker walker = new ParseTreeWalker();

		
		if (parser.getNumberOfSyntaxErrors() == 0) { 

			StipulaVisitorImpl visitor = new StipulaVisitorImpl();
			ParseTree t = parser.prog();
			Node ast = visitor.visit(t); //generazione AST 
			//System.out.println("Visualizing AST...");
			//System.out.println("\n");
			//System.out.println(ast.toVisit());
			//TypeInferenceListener listener = new TypeInferenceListener();
			//ParseTreeWalker.DEFAULT.walk(listener, t);

			/* TYPE CHECKING */
			TypeChecker code = new TypeChecker();
			Map<Pair<String, Integer>, Type> types = (Map<Pair<String, Integer>, Type>) code.visit(t);
			ArrayList<Pair<String,ArrayList<Pair<String,Type>>>> funParams = code.getFunParams();
			ArrayList<String> nc = code.getNames();
			System.out.println("TYPE CHECKING:");
			System.out.println("==================");
			TypeInference typeinferencer = new TypeInference(types,nc,funParams);			
			typeinferencer.print_map();
			System.out.println("==================");

			//print_map(types);
			/* INTERPRETER */

			Interpreter codeInterpreter = new Interpreter();
			Object program = codeInterpreter.visit(t);
			((Program) program).runProgram(typeinferencer);

			/*
			 * TypeChecker tc = new TypeChecker(); Map<Pair<Node,Node>,Node> types = new
			 * HashMap<>();
			 * 
			 * Stack<HashMap<Node,Node>> envs = listener.getEnvironments();
			 * Stack<HashMap<Node,Node>> pairs = listener.getPairs(); // rimuovo le coppie
			 * con un elemento == "_" for(int i=0; i<pairs.size(); i++) {
			 * Iterator<Map.Entry<Node,Node>> it = pairs.get(i).entrySet().iterator(); while
			 * (it.hasNext()) { Map.Entry<Node,Node> entry = it.next();
			 * if(entry.getValue().toVisit().equals("_") ||
			 * entry.getKey().toVisit().equals("_")) { it.remove(); } } }
			 * 
			 * 
			 * for(int i=1; i<envs.size(); i++) { for(Node el : envs.get(0).keySet()) {
			 * putElement(envs.get(i),el,envs.get(0).get(el)); } }
			 * 
			 * System.out.println("====================="); System.out.
			 * println("Mapping for all the variables and their types before the type inference:"
			 * ); System.out.println("=====================");
			 * 
			 * printStack(envs);
			 * 
			 * System.out.println("=====================");
			 * System.out.println("Mapping for all the couples the type inference:");
			 * System.out.println("=====================");
			 * 
			 * printStack2(pairs);
			 * 
			 * for(int i=1; i<pairs.size(); i++) {
			 * 
			 * for (Node node: pairs.get(i).keySet()) {
			 * 
			 * tc.unify(node,pairs.get(i).get(node),envs.get(i)); } } types = tc.getTypes();
			 * System.out.println("=====================");
			 * System.out.println("Mapping for all the couples (var x var) and their types:"
			 * ); System.out.println("=====================");
			 * 
			 * for(Pair<Node,Node> vc : types.keySet()) { if(types.get(vc)==null) {
			 * System.out.println("("+vc.getKey().toVisit()+","+vc.getValue().toVisit()
			 * +") -> TBD");
			 * 
			 * } else {
			 * System.out.println("("+vc.getKey().toVisit()+","+vc.getValue().toVisit()
			 * +") -> " + types.get(vc).toVisit()); } }
			 * System.out.println("====================="); HashMap<Node,Node> allVars =
			 * tc.getAllVars(); System.out.
			 * println("Mapping for all the variables and their types after the type inference:"
			 * ); System.out.println("====================="); for(int i=0; i<envs.size();
			 * i++) { for(Node el : envs.get(i).keySet()) { if(!contains(el,allVars)) {
			 * putElement(allVars,el,envs.get(i).get(el)); } } tc.addVariables(envs.get(i));
			 * }
			 * 
			 * 
			 * allVars = tc.getAllVars(); for(Node e : allVars.keySet()) {
			 * if(allVars.get(e)!=null) { System.out.println(e.toVisit() + " -> " +
			 * allVars.get(e).toVisit());
			 * 
			 * } else { System.out.println(e.toVisit() + " -> " );
			 * 
			 * } } System.out.println("=====================");
			 * System.out.println("Testing liquidity analysis:");
			 * System.out.println("=====================");
			 * 
			 * LiquidityAnalysis l = new LiquidityAnalysis();
			 * ParseTreeWalker.DEFAULT.walk(l, t);
			 * ArrayList<Map<Triplet<String,String,String>,ArrayList<ArrayList<Node>>>>
			 * typesLiquidity = l.getLiquidityTypes(); for(int i=0; i<typesLiquidity.size();
			 * i++){ for(Map.Entry<Triplet<String,String,String>,
			 * ArrayList<ArrayList<Node>>> entry : typesLiquidity.get(i).entrySet()) {
			 * Triplet<String,String,String> label = entry.getKey();
			 * System.out.println(label+" "); ArrayList<ArrayList<Node>> typesTmp =
			 * entry.getValue(); if(typesTmp!=null) { for(int j=0; j<typesTmp.size(); j++) {
			 * for(int k=0; k<typesTmp.get(j).size(); k++) {
			 * System.out.print(" \t "+typesTmp.get(j).get(k).toVisit()+" "); }
			 * System.out.println(""); } }
			 * 
			 * } System.out.println(""); } String init = "Q0";
			 * ArrayList<ArrayList<Triplet<String,String,String>>> reach = new
			 * ArrayList<ArrayList<Triplet<String,String,String>>>(); reach =
			 * l.calcComputations(init); for(int i = 0; i<reach.size(); i++) { for(int j=0;
			 * j<reach.get(i).size(); j++) { Triplet<String,String,String> label =
			 * reach.get(i).get(j); System.out.print(label+" "); } System.out.println("");
			 * 
			 * } System.out.println(""); System.out.println("=================");
			 * System.out.println("");
			 * 
			 * ArrayList<Map<ArrayList<Triplet<String,String,String>>,ArrayList<ArrayList<
			 * Node>>>> typesComp = l.getTypesComputations(reach); printTypes(typesComp);
			 * System.out.println(""); System.out.println("=================");
			 * System.out.println(""); boolean separateLiquidity =
			 * l.separateLiquidity(typesComp,init); System.out.println("");
			 * System.out.println("================="); System.out.println("");
			 * if(separateLiquidity) {
			 * 
			 * System.out.println("The contract is NOT separate-liquid."); } else {
			 * System.out.println("The contract is separate-liquid."); }
			 */

		}
	}
}