import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputPath = (args.length > 0) ? args[0] : "./input/license.stipula";

        Path in = Paths.get(inputPath).normalize();
        String outFileName = in.getFileName().toString().replaceFirst("\\.stipula$", ".java");
        Path parent = in.getParent();
        Path outDir;
        if (parent != null && parent.getFileName() != null && parent.getFileName().toString().equals("input")) {
            Path gp = parent.getParent() == null ? Paths.get(".") : parent.getParent();
            outDir = gp.resolve("output");
        } else {
            outDir = (parent != null) ? parent : Paths.get(".");
        }
        Path out = outDir.resolve(outFileName);

        String source = Files.readString(in);
        CharStream cs = CharStreams.fromString(source);
        StipulaLexer lexer = new StipulaLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        StipulaParser parser = new StipulaParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener(){
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new RuntimeException("Syntax error at " + line + ":" + charPositionInLine + " - " + msg);
            }
        });

        ParseTree tree = parser.program();
        Translator.HarvestListener hl = new Translator.HarvestListener(parser, tokens);
        ParseTreeWalker.DEFAULT.walk(hl, tree);

        String outJava = Translator.emitJava(hl.ir);
        Files.createDirectories(out.getParent());
        try (BufferedWriter writer = Files.newBufferedWriter(out)) {
            writer.write(outJava);
        }
        System.out.println("Java code written to " + out.toString());
    }
}