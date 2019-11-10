
public class MyVisitor<T> extends SRLangBaseVisitor<T> {
z

    @Override
    public T visitWriteStatement(SRLangParser.WriteStatementContext ctx ){
        String s = visitExpression(ctx.expression()).toString();
        System.out.println(s);
        return super.visitWriteStatement(ctx);
    }

    @Override
    public T visitExpression(SRLangParser.ExpressionContext ctx){
        if(ctx.literal() != null){
            return visitLiteral(ctx.literal());
        }else{
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T visitLiteral(SRLangParser.LiteralContext ctx){
        if(ctx.TK_SLIT()!=null){
            return (T) ctx.TK_SLIT().getText();
        }else if(ctx.TK_BLIT()!=null){
            return (T) (Boolean) Boolean.parseBoolean(ctx.TK_BLIT().getText());
        }else if(ctx.TK_RLIT()!=null){
            return (T) (Double) Double.parseDouble(ctx.TK_RLIT().getText());
        }else if(ctx.TK_ILIT()!=null){
            return (T) (Integer) Integer.parseInt(ctx.TK_ILIT().getText());
        }else if(ctx.TK_CLIT()!=null){
            //return (T) (Character) ctx.TK_CLIT().getText(); //Caracteres, probar
            return (T) ctx.TK_SLIT().getText();
        }else if(ctx.TK_NLIT()!=null){
            //Null o Noop
            return null;
        }else if(ctx.TK_FLIT()!=null){
            //Flujos de datos, importante. Revisar.
            return (T) ctx.TK_SLIT().getText();
        }else{
            return null;
        }
    }
}
