import org.antlr.v4.runtime.Token;

public class AuxMathFunctions {

    public static Object length(SRLangParser.ExpressionContext ctx, Object arg){

        if (!AuxMethods.valueIsOfTypes(arg, String.class)) {
            Token token = ctx.expression(0).TK_ID().getSymbol();
            AuxMethods.error("Argumento de la función length solo puede ser una cadena de caracteres.", token.getLine(), token.getCharPositionInLine() + 1);
        }else{
            return (Object) (Integer)arg.toString().length();
        }
        return null;
    }

    public static Object sqrt(SRLangParser.ExpressionContext ctx, Object arg){

        if (!AuxMethods.valueIsOfTypes(arg, Double.class, Integer.class)) {
            Token token = ctx.expression(0).TK_ID().getSymbol();
            AuxMethods.error("Argumento de la función sqrt solo puede ser entero o real.", token.getLine(), token.getCharPositionInLine() + 1);
        }else{
            return (Object) (Double)Math.sqrt(Double.parseDouble(arg.toString()));
        }
        return null;
    }

}
