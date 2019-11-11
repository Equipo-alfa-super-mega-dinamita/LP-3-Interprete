import org.antlr.v4.runtime.Token;

public class AuxBinaryExpressionVisitors {

    public static Object BinaryExpressionSum(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class,Double.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class,Double.class)){
            Token token = ctx.TK_PLUS().getSymbol();
            AuxMethods.error("Operandos de suma solo pueden ser enteros o reales.",token.getLine(),token.getCharPositionInLine()+1);
        }
        if(arg1.getClass().equals(Double.class)){
            if(arg2.getClass().equals(Double.class)){
                return  (Double)(((Double)arg1)+((Double)arg2));
            }else{
                return (Double)(((Double)arg1)+Double.valueOf((Integer)arg2));
            }
        }else{
            if(arg2.getClass().equals(Double.class)){
                return (Double)(((Double)arg2)+Double.valueOf((Integer)arg1));
            }else{
                return (Integer)(((Integer)arg1)+((Integer)arg2));
            }
        }
    }

    public static Object BinaryExpressionMinus(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class,Double.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class,Double.class)){
            Token token = ctx.TK_PLUS().getSymbol();
            AuxMethods.error("Operandos de resta solo pueden ser enteros o reales.",token.getLine(),token.getCharPositionInLine()+1);
        }
        if(arg1.getClass().equals(Double.class)){
            if(arg2.getClass().equals(Double.class)){
                return  (Double)(((Double)arg1)-((Double)arg2));
            }else{
                return  (Double)(((Double)arg1)-Double.valueOf((Integer)arg2));
            }
        }else{
            if(arg2.getClass().equals(Double.class)){
                return (Double)(Double.valueOf((Integer)arg1)-((Double)arg2));
            }else{
                return (Integer)(((Integer)arg1)-((Integer)arg2));
            }
        }
    }

    public static Object BinaryExpressionConcat(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,String.class,Character.class) || !AuxMethods.valueIsOfTypes(arg2,String.class,Character.class)){
            Token token = ctx.TK_CONCAT().getSymbol();
            AuxMethods.error("Operandos de concatenación solo pueden ser Strings o caracteres.",token.getLine(),token.getCharPositionInLine()+1);
        }
        if(arg1.getClass().equals(String.class)){
            if(arg2.getClass().equals(String.class)){
                return  (String)(((String)arg1)+((String)arg2));
            }else{
                return  (String)(((String)arg1)+String.valueOf((Character)arg2));
            }
        }else{
            if(arg2.getClass().equals(String.class)){
                return (String)(String.valueOf((Character)arg1)+((String)arg2));
            }else{
                return (String)(((Character)arg1)+""+((Character)arg2));
            }
        }
    }

    
}
