import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
public class MyVisitor<T> extends SRLangBaseVisitor<T> {
    HashMap<String, Object> table = new HashMap<>();

    /*--------------------------------Declaration------------------------------------*/
    @Override
    public T visitDeclaration(SRLangParser.DeclarationContext ctx) {
        T ans = null;

        if (ctx.typeDeclaration() != null) {

        } else if (ctx.objDeclaration() != null) {
            ArrayList<T> objDeclarations = (ArrayList<T>) visitObjDeclaration(ctx.objDeclaration());
            for (T variable: objDeclarations){
                Variable aux = (Variable) variable;
                table.put(aux.getName(), aux);
                table.put(aux.getName(), aux);
                System.out.println(aux);
            }
        } else if (ctx.optypeDeclaration() != null) {

        } else if (ctx.semDeclaration() != null) {

        } else if (ctx.opDeclaration() != null) {

        } else {
            System.err.println("unexpected Error: visitDeclaration");
            System.exit(-2);
        }
        return ans;
    }

    @Override
    public T visitObjDeclaration(SRLangParser.ObjDeclarationContext ctx) {
        String actionType = ctx.varOrConst().getText();
        boolean isConst;
        ArrayList <T> myVars  = (ArrayList<T>) visitVarDefLP(ctx.varDefLP());
        if (actionType.equals("var")) {
            isConst = false;
        } else if (actionType.equals("const")) {
            isConst = true;
        } else {
            System.err.println("unexpected Error: VisitObjDeclaration");
            System.exit(-2);
            return null;
        }
        for(T myVar: myVars){
            Variable aux = (Variable) myVar;
            aux.setConst(isConst);
        }
        return (T) myVars;
    }

    @Override
    public T visitVarDefLP(SRLangParser.VarDefLPContext ctx) {
        ArrayList <T> args = new ArrayList();
        //varDef -> some Arrays of Variable
        for (int i = 0; i < ctx.varDef().size(); i++) {
            //get an Array
            ArrayList <T> aux = (ArrayList<T>) visitVarDef(ctx.varDef(i));
            //And add the variables to args to create a new array with the variables
            args.addAll(aux);
        }
        return (T) args;
    }

    @Override
    public T visitVarDef(SRLangParser.VarDefContext ctx) {
        ArrayList<T> args = new ArrayList<>();
        //VarDef: idSubsLP varAtt
        //idSubsLP -> Variables with name
        args = (ArrayList<T>) visitIdSubsLP(ctx.idSubsLP());
        //Variable with type and value
        Variable auxVar = (Variable) visitVarAtt(ctx.varAtt());
        if (auxVar == null) {
            //varAtt-> : := separator
            return (T) args;
        } else {
            //type and value
            if(auxVar.getType()!=null){
                //type->it uses colon and it's for all variable
                for (T arg : args) {
                    Variable aux = (Variable) arg;
                    aux.setType((auxVar.getType()));
                }
            }
            if(auxVar.getValue()!=null){
                //Value->it uses assignation operator and it's for the last variable o no?
                /* if it's for the last variable
                Variable aux = (Variable) args.get(args.size()-1);
                aux.setValue(auxVar.getValue());
                */
                for (T arg : args) {
                    Variable aux = (Variable) arg;
                    aux.setValue(auxVar.getValue());
                }
            }
            return (T) args;
        }

    }

    @Override
    public T visitVarAtt(SRLangParser.VarAttContext ctx) {
        Variable varAux = new Variable();
        if (ctx.TK_SEPARATOR() != null) {
            return null;
        } else {
            //Colon give variable type
            if (ctx.TK_COLON() != null) {
                varAux.setType(visitType(ctx.type()).toString());
            }
            //Give a value T
            if (ctx.TK_ASSIGN() != null) {
                //varAux.setType();
                varAux.setValue(visitExpression(ctx.expression()));
            }
            return (T) varAux;
        }
    }

    /*--------------------------type specification--------------------------*/
    @Override
    public T visitType(SRLangParser.TypeContext ctx) {
        if (ctx.subscripts() != null) {
            //No idea subscripts

        } else if (ctx.unsubType() != null) {
            return visitUnsubType(ctx.unsubType());
        }
        return null;
    }

    @Override
    public T visitUnsubType(SRLangParser.UnsubTypeContext ctx) {
        if (ctx.basicType() != null) {
            //CHAR BOOL FILE REAL INT
            return visitBasicType(ctx.basicType());
        } else if (ctx.stringDef() != null) {
            //CHAR BOOL FILE REAL INT
            return visitBasicType(ctx.basicType());
        } else if (ctx.enumDef() != null) {

        } else if (ctx.pointerDef() != null) {

        } else if (ctx.recordDef() != null) {

        } else if (ctx.unionDef() != null) {

        } else if (ctx.capabilityDef() != null) {

        } else if (ctx.qualifiedID() != null) {

        }
        return null;
    }

    @Override
    public T visitBasicType(SRLangParser.BasicTypeContext ctx) {
        if (ctx.TK_BOOL() != null) {
            return (T) ctx.TK_BOOL().getText();
        } else if (ctx.TK_CHAR() != null) {
            return (T) ctx.TK_CHAR().getText();
        } else if (ctx.TK_INT() != null) {
            return (T) ctx.TK_INT().getText();
        } else if (ctx.TK_REAL() != null) {
            return (T) ctx.TK_REAL().getText();
        } else if (ctx.TK_FILE() != null) {
            return (T) ctx.TK_FILE().getText();
        }
        return null;
    }

    /*------------------------------miscellaneous------------------------------*/
    @Override
    public T visitIdSubsLP(SRLangParser.IdSubsLPContext ctx) {
        /*
        Tener en cuenta que devuelve una lista de algo. Para declaretion->variables con solo
        el nombre; pero su fin es devolver una lista de id
        */
        ArrayList<T> args = new ArrayList<>();
        for (int i = 0; i < ctx.idSubs().size(); i++) {
            args.add(visitIdSubs(ctx.idSubs(i)));
        }
        return (T) args;
    }

    @Override
    public T visitIdSubs(SRLangParser.IdSubsContext ctx) {
        Variable auxVar = new Variable();
        String name = ctx.TK_ID().getText();
        if (nameIsInUse(name)) {
            //Kill
            AuxMethods.errorGenerator(ctx.TK_ID().getSymbol().getLine(),
                    ctx.TK_ID().getSymbol().getCharPositionInLine() + 1, name);
        } else {
            auxVar.setName(name);
        }
        if (ctx.subscripts() != null) {
            //-->Is a Matrix
            auxVar.setAtt((AttributeMatrix) visitSubscripts(ctx.subscripts()));
        }
        return (T) auxVar;
    }

    @Override
    public T visitSubscripts(SRLangParser.SubscriptsContext ctx) {
        int value = 0;
        //bracketedList
        AttributeMatrix auxAtt = new AttributeMatrix(value);
        //values expressions
        return (T) auxAtt;
    }

    /*--------------------------blocks and statements----------------------------------------------*/
    @Override
    public T visitBracketedList(SRLangParser.BracketedListContext ctx) {
        return null;
    }

    @Override
    public T visitWriteStatement(SRLangParser.WriteStatementContext ctx) {
        List<T> args = new LinkedList<>();
        String toPrint = "";
        for (int i = 0; i < ctx.parenList().parenItemList().expression().size(); i++) {
            args.add(visitExpression(ctx.parenList().parenItemList().expression(i)));
        }
        if (ctx.TK_WRITE().getText().equals("write")) {
            for (T arg : args) {
                toPrint += (" ") + arg.toString();
            }
            System.out.println(toPrint.trim());
        } else {
            for (T arg : args) {
                toPrint += arg.toString();
            }
            System.out.print(toPrint);
        }
        return super.visitWriteStatement(ctx);
    }


    /*----------------------------- expressionession -----------------------------*/
    @Override
    public T visitExpression(SRLangParser.ExpressionContext ctx) {
        if (ctx.literal() != null) {
            return visitLiteral(ctx.literal());
        } else if (ctx.parenList() != null) {
            //Invocacion Funcion, evaluar
            return (T) (Object) evaluarInvocacionFuncion(ctx);
        } else {
            return null;
        }
    }

    @Override
    public T visitLiteral(SRLangParser.LiteralContext ctx) {
        if (ctx.TK_SLIT() != null) {
            String str = ctx.TK_SLIT().getText();
            return (T) str.substring(1, str.length() - 1);
        } else if (ctx.TK_BLIT() != null) {
            return (T) (Boolean) Boolean.parseBoolean(ctx.TK_BLIT().getText());
        } else if (ctx.TK_RLIT() != null) {
            return (T) (Double) Double.parseDouble(ctx.TK_RLIT().getText());
        } else if (ctx.TK_ILIT() != null) {
            return (T) (Integer) Integer.parseInt(ctx.TK_ILIT().getText()); //NO CONSIDERA TODOS LOS TIPOS DE ILIT
        } else if (ctx.TK_CLIT() != null) {
            //return (T) (Character) ctx.TK_CLIT().getText(); //Caracteres, probar
            return (T) (Character) ctx.TK_CLIT().getText().charAt(1);
        } else if (ctx.TK_NLIT() != null) {
            //Null o Noop
            return null;
        } else if (ctx.TK_FLIT() != null) {
            //Flujos de datos, importante. Revisar.
            return (T) ctx.TK_FLIT().getText();
        } else {
            return null;
        }
    }

    /*---------------------NASH----------------------*/
    private boolean nameIsInUse(String name) {
        boolean ans = false;
        if (table.get(name) != null) {
            ans = true;
        }
        return ans;
    }

    private T evaluarInvocacionFuncion(SRLangParser.ExpressionContext ctx) {
        //Funcion es interna de SR?
        String functionIden = ctx.expression(0).TK_ID().getText();
        List<T> args = new LinkedList<>();
        for (int i = 0; i < ctx.parenList().parenItemList().expression().size(); i++) {
            args.add(visitExpression(ctx.parenList().parenItemList().expression(i)));
        }
        switch (functionIden) {
            //Basic functions
            case "max":
                System.out.println("max");
                double max = Double.MIN_VALUE;
                //Comprobar tipos de los argumentos? integers o reals
                for (T arg : args) {
                    System.out.println(arg.getClass());
                    if (!arg.getClass().equals(Integer.class) && !arg.getClass().equals(Double.class)) {
                        AuxMethods.error("Argumentos de la función Max solo pueden ser enteros o reales. (");
                    }
                }
                /*for(T arg : args){
                    if((double)arg > max){
                        max = (double)arg;
                    }
                }
                return (T)(Double)max;*/
                return null;
            //break;
            default:
                System.out.println("Pvt");
                break;
        }
        //Funcion declarada, buscar y llamar (?)

        return null;
    }

}
