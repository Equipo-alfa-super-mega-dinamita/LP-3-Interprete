import org.antlr.v4.runtime.Token;

public class AuxBinaryExpressionVisitors {

    //Agregación
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
            Token token = ctx.TK_MINUS().getSymbol();
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

    //Exponenciacion
    public static Object BinaryExpressionExpon(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class,Double.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class,Double.class)){
            Token token = ctx.TK_EXPON().getSymbol();
            AuxMethods.error("Operandos de exponenciación solo pueden ser enteros o reales.",token.getLine(),token.getCharPositionInLine()+1);
        }
        if(arg1.getClass().equals(Double.class)){
            if(arg2.getClass().equals(Double.class)){
                return  Math.pow(((Double)arg1),((Double)arg2));
            }else{
                return  Math.pow(((Double)((Double)arg1)),Double.valueOf((Integer)arg2));
            }
        }else{
            if(arg2.getClass().equals(Double.class)){
                return  Math.pow(Double.valueOf((Integer)arg1),(Double)arg2);
            }else{
                return  Math.pow(Double.valueOf((Integer)arg1),Double.valueOf((Integer)arg2));
            }
        }
    }

    //Multiplicacion y asociados
    public static Object BinaryExpressionMult(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class,Double.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class,Double.class)){
            Token token = ctx.TK_ASTER().getSymbol();
            AuxMethods.error("Operandos de multiplicación solo pueden ser enteros o reales.",token.getLine(),token.getCharPositionInLine()+1);
        }
        if(arg1.getClass().equals(Double.class)){
            if(arg2.getClass().equals(Double.class)){
                return  (Double)(((Double)arg1)*((Double)arg2));
            }else{
                return  (Double)(((Double)arg1)*Double.valueOf((Integer)arg2));
            }
        }else{
            if(arg2.getClass().equals(Double.class)){
                return (Double)(Double.valueOf((Integer)arg1)*((Double)arg2));
            }else{
                return (Integer)(((Integer)arg1)*((Integer)arg2));
            }
        }
    }

    public static Object BinaryExpressionDiv(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class,Double.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class,Double.class)){
            Token token = ctx.TK_DIV().getSymbol();
            AuxMethods.error("Operandos de division solo pueden ser enteros o reales.",token.getLine(),token.getCharPositionInLine()+1);
        }
        if(arg1.getClass().equals(Double.class)){
            if(arg2.getClass().equals(Double.class)){
                return  (Double)(((Double)arg1)/((Double)arg2));
            }else{
                return  (Double)(((Double)arg1)/Double.valueOf((Integer)arg2));
            }
        }else{
            if(arg2.getClass().equals(Double.class)){
                return (Double)(Double.valueOf((Integer)arg1)/((Double)arg2));
            }else{
                if(((Integer)arg1)%((Integer)arg2)==0){
                    return (Integer)(((Integer)arg1)/((Integer)arg2));
                }else{
                    return (Double) (double) (((Integer) arg1) / ((Integer) arg2));
                }
            }
        }
    }

    public static Object BinaryExpressionMod(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class,Double.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class,Double.class)){
            Token token = ctx.TK_MOD().getSymbol();
            AuxMethods.error("Operandos de modulo inválidos.",token.getLine(),token.getCharPositionInLine()+1);
        }
        if(arg1.getClass().equals(Double.class)){
            if(arg2.getClass().equals(Double.class)){
                return  (Double)(((Double)arg1)%((Double)arg2));
            }else{
                return  (Double)(((Double)arg1)%(Integer)arg2);
            }
        }else{
            if(arg2.getClass().equals(Double.class)){
                return (Double)(((Integer)arg1)%((Double)arg2));
            }else{
                return (Integer)(((Integer)arg1)%((Integer)arg2));
            }
        }
    }

    public static Object BinaryExpressionRemdr(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class,Double.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class,Double.class)){
            Token token = ctx.TK_REMDR().getSymbol();
            AuxMethods.error("Operandos de modulo inválidos.",token.getLine(),token.getCharPositionInLine()+1);
        }
        if(arg1.getClass().equals(Double.class)){
            if(arg2.getClass().equals(Double.class)){
                return  (Double)(((Double)arg1)%((Double)arg2));
            }else{
                return  (Double)(((Double)arg1)%(Integer)arg2);
            }
        }else{
            if(arg2.getClass().equals(Double.class)){
                return (Double)(((Integer)arg1)%((Double)arg2));
            }else{
                return (Integer)(((Integer)arg1)%((Integer)arg2));
            }
        }
    }

    //BitShift
    public static Object BinaryExpressionRShift(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class)){
            Token token = ctx.TK_RSHIFT().getSymbol();
            AuxMethods.error("Operandos de rshift inválidos.",token.getLine(),token.getCharPositionInLine()+1);
        }
        return (int) (((int)(arg1))>>((int)(arg2)));
    }

    public static Object BinaryExpressionLShift(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class)){
            Token token = ctx.TK_LSHIFT().getSymbol();
            AuxMethods.error("Operandos de lshift inválidos.",token.getLine(),token.getCharPositionInLine()+1);
        }
        return (int) (((int)(arg1))<<((int)(arg2)));
    }

    //Relational Operators
    public static Object BinaryExpressionEqual(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if((arg1.getClass().equals(Integer.class)||arg1.getClass().equals(Double.class))&&(arg2.getClass().equals(Integer.class)||arg2.getClass().equals(Double.class))){
            return (boolean)(Double.valueOf(arg1.toString()).compareTo(Double.valueOf(arg2.toString()))==0);
        }else if(arg1.getClass().equals(String.class)&& arg2.getClass().equals(String.class)){
            return (boolean)((String)arg1).equals(arg2);
        }else{
            return arg1.equals(arg2);
        }
    }

    public static Object BinaryExpressionNotEqual(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if((arg1.getClass().equals(Integer.class)||arg1.getClass().equals(Double.class))&&(arg2.getClass().equals(Integer.class)||arg2.getClass().equals(Double.class))){
            return (boolean)(Double.valueOf(arg1.toString()).compareTo(Double.valueOf(arg2.toString()))!=0);
        }else if(arg1.getClass().equals(String.class)&& arg2.getClass().equals(String.class)){
            return !(boolean)((String)arg1).equals(arg2);
        }else{
            return !arg1.equals(arg2);
        }
    }

    public static Object BinaryExpressionGT(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class,Double.class,String.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class,Double.class,String.class)){
            Token token = ctx.TK_GT().getSymbol();
            AuxMethods.error("Operandos de > inválidos.",token.getLine(),token.getCharPositionInLine()+1);
        }

        if((arg1.getClass().equals(Integer.class)||arg1.getClass().equals(Double.class))&&(arg2.getClass().equals(Integer.class)||arg2.getClass().equals(Double.class))){
            return (boolean)(Double.valueOf(arg1.toString()).compareTo(Double.valueOf(arg2.toString()))>0);
        }else if(arg1.getClass().equals(String.class)&& arg2.getClass().equals(String.class)){
            return ((String)arg1).length()>((String)arg2).length();
        }else{
            Token token = ctx.TK_GT().getSymbol();
            AuxMethods.error("Operandos de > inválidos.",token.getLine(),token.getCharPositionInLine()+1);
            return null;
        }
    }

    public static Object BinaryExpressionGE(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class,Double.class,String.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class,Double.class,String.class)){
            Token token = ctx.TK_GE().getSymbol();
            AuxMethods.error("Operandos de >= inválidos.",token.getLine(),token.getCharPositionInLine()+1);
        }

        if((arg1.getClass().equals(Integer.class)||arg1.getClass().equals(Double.class))&&(arg2.getClass().equals(Integer.class)||arg2.getClass().equals(Double.class))){
            return (boolean)(Double.valueOf(arg1.toString()).compareTo(Double.valueOf(arg2.toString()))>=0);
        }else if(arg1.getClass().equals(String.class)&& arg2.getClass().equals(String.class)){
            return ((String)arg1).length()>=((String)arg2).length();
        }else{
            Token token = ctx.TK_GE().getSymbol();
            AuxMethods.error("Operandos de >= inválidos.",token.getLine(),token.getCharPositionInLine()+1);
            return null;
        }
    }

    public static Object BinaryExpressionLT(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class,Double.class,String.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class,Double.class,String.class)){
            Token token = ctx.TK_LT().getSymbol();
            AuxMethods.error("Operandos de < inválidos.",token.getLine(),token.getCharPositionInLine()+1);
        }

        if((arg1.getClass().equals(Integer.class)||arg1.getClass().equals(Double.class))&&(arg2.getClass().equals(Integer.class)||arg2.getClass().equals(Double.class))){
            return (boolean)(Double.valueOf(arg1.toString()).compareTo(Double.valueOf(arg2.toString()))<0);
        }else if(arg1.getClass().equals(String.class)&& arg2.getClass().equals(String.class)){
            return ((String)arg1).length()<((String)arg2).length();
        }else{
            Token token = ctx.TK_LT().getSymbol();
            AuxMethods.error("Operandos de < inválidos.",token.getLine(),token.getCharPositionInLine()+1);
            return null;
        }
    }

    public static Object BinaryExpressionLE(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class,Double.class,String.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class,Double.class,String.class)){
            Token token = ctx.TK_LE().getSymbol();
            AuxMethods.error("Operandos de <= inválidos.",token.getLine(),token.getCharPositionInLine()+1);
        }

        if((arg1.getClass().equals(Integer.class)||arg1.getClass().equals(Double.class))&&(arg2.getClass().equals(Integer.class)||arg2.getClass().equals(Double.class))){
            return (boolean)(Double.valueOf(arg1.toString()).compareTo(Double.valueOf(arg2.toString()))<=0);
        }else if(arg1.getClass().equals(String.class)&& arg2.getClass().equals(String.class)){
            return ((String)arg1).length()<=((String)arg2).length();
        }else{
            Token token = ctx.TK_LE().getSymbol();
            AuxMethods.error("Operandos de <= inválidos.",token.getLine(),token.getCharPositionInLine()+1);
            return null;
        }
    }

    //Operadores logicos

    public static Object BinaryExpressionAnd(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class,Boolean.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class,Boolean.class)){
            Token token = ctx.TK_AND().getSymbol();
            AuxMethods.error("Operandos de AND inválidos.",token.getLine(),token.getCharPositionInLine()+1);
        }

        if((arg1.getClass().equals(Integer.class))&&(arg2.getClass().equals(Integer.class))){
            //Bitwise AND
            return ((Integer)arg1)&((Integer)arg2);
        }else if(arg1.getClass().equals(Boolean.class)&& arg2.getClass().equals(Boolean.class)){
            return ((Boolean)arg1)&&((Boolean)arg2);
        }else{
            Token token = ctx.TK_AND().getSymbol();
            AuxMethods.error("Operandos de AND inválidos.",token.getLine(),token.getCharPositionInLine()+1);
            return null;
        }
    }

    public static Object BinaryExpressionOr(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class,Boolean.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class,Boolean.class)){
            Token token = ctx.TK_OR().getSymbol();
            AuxMethods.error("Operandos de OR inválidos.",token.getLine(),token.getCharPositionInLine()+1);
        }

        if((arg1.getClass().equals(Integer.class))&&(arg2.getClass().equals(Integer.class))){
            //Bitwise OR
            return ((Integer)arg1)|((Integer)arg2);
        }else if(arg1.getClass().equals(Boolean.class)&& arg2.getClass().equals(Boolean.class)){
            return ((Boolean)arg1)||((Boolean)arg2);
        }else{
            Token token = ctx.TK_OR().getSymbol();
            AuxMethods.error("Operandos de OR inválidos.",token.getLine(),token.getCharPositionInLine()+1);
            return null;
        }
    }

    public static Object BinaryExpressionXor(SRLangParser.ExpressionContext ctx, Object arg1, Object arg2){
        if(!AuxMethods.valueIsOfTypes(arg1,Integer.class,Boolean.class) || !AuxMethods.valueIsOfTypes(arg2,Integer.class,Boolean.class)){
            Token token = ctx.TK_XOR().getSymbol();
            AuxMethods.error("Operandos de XOR inválidos.",token.getLine(),token.getCharPositionInLine()+1);
        }

        if((arg1.getClass().equals(Integer.class))&&(arg2.getClass().equals(Integer.class))){
            //Bitwise XOR
            return ((Integer)arg1)^((Integer)arg2);
        }else if(arg1.getClass().equals(Boolean.class)&& arg2.getClass().equals(Boolean.class)){
            return ((Boolean)arg1)^((Boolean)arg2);
        }else{
            Token token = ctx.TK_XOR().getSymbol();
            AuxMethods.error("Operandos de XOR inválidos.",token.getLine(),token.getCharPositionInLine()+1);
            return null;
        }
    }
}
