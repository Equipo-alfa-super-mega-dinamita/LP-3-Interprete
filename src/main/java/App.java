import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class App{
    public static void main(String[] args) throws Exception {
        System.out.println("holi");
        SRLangLexer lexer;
        if (args.length>0)
            lexer = new SRLangLexer(CharStreams.fromFileName(args[0]));
        else
            lexer = new SRLangLexer(CharStreams.fromStream(System.in));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SRLangParser parser = new SRLangParser(tokens);
        ParseTree tree = parser.components();

        MyVisitor<Object> loader = new MyVisitor<Object>();
        loader.visit(tree);
    }
}

