public class AuxMethods {
    public static void errorGenerator(int line, int col,String name){
        System.err.printf("<%d:%d> Error semantico, la variable con nombre: \"" + name + "\" ya fue declarada.\n", line, col);
        System.exit(-1);
    }
    public static void error(String err){
        System.err.printf(err);
        System.exit(-1);
    }
}
