public class AuxMethods {
    public static void errorGenerator(int line, int col,String name){
        System.err.printf("<%d:%d> Error semantico, la variable con nombre: \"" + name + "\" ya fue declarada.\n", line, col);
        System.exit(-1);
    }
    public static void error(String err){
        System.err.printf(err);
        System.exit(-1);
    }

    public static void error(String err,int lin,int col){
        System.err.printf(err+" En linea: "+lin+", columna: "+col);
        System.exit(-1);
    }

    public static boolean valueIsOfTypes(Object value, Class... classes){
        boolean isOfTypes = false;
        for(Class c : classes){
            if(value.getClass().equals(c)){
                return true;
            }
        }
        return false;
    }

}
