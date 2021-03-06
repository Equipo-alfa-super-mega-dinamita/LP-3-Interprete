import org.antlr.v4.runtime.Token;

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
            for (T variable : objDeclarations) {
                Variable aux = (Variable) variable;
                table.put(aux.getName(), aux);
                System.out.println(aux);
            }
        } else if (ctx.optypeDeclaration() != null) {

        } else if (ctx.semDeclaration() != null) {

        } else if (ctx.opDeclaration() != null) {
            ArrayList<T> opDeclaration = (ArrayList<T>) visitOpDeclaration(ctx.opDeclaration());
            for (T method : opDeclaration) {
                Method aux = (Method) method;
                table.put(aux.getName(), aux);
                System.out.println(aux);
            }
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
        ArrayList<T> myVars = (ArrayList<T>) visitVarDefLP(ctx.varDefLP());
        if (actionType.equals("var")) {
            isConst = false;
        } else if (actionType.equals("const")) {
            isConst = true;
        } else {
            System.err.println("unexpected Error: VisitObjDeclaration");
            System.exit(-2);
            return null;
        }
        for (T myVar : myVars) {
            Variable aux = (Variable) myVar;
            aux.setConst(isConst);
        }
        return (T) myVars;
    }

    @Override
    public T visitVarDefLP(SRLangParser.VarDefLPContext ctx) {
        ArrayList<T> args = new ArrayList();
        //varDef -> some Arrays of Variable
        for (int i = 0; i < ctx.varDef().size(); i++) {
            //get an Array
            ArrayList<T> aux = (ArrayList<T>) visitVarDef(ctx.varDef(i));
            //And add the variables to args to create a new array with the variables
            args.addAll(aux);
        }
        return (T) args;
    }

    @Override
    public T visitVarDef(SRLangParser.VarDefContext ctx) {
        ArrayList<T> args;
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
            if (auxVar.getType() != null) {
                //type->it uses colon and it's for all variable
                for (T arg : args) {
                    Variable aux = (Variable) arg;
                    aux.setType((auxVar.getType()));
                }
            }
            if (auxVar.getValue() != null) {
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
            AuxMethods.error("Subscribs no definidos en este punto");
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
            //String
            return (T) ctx.stringDef().TK_STRING().getText();
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
        int value = ctx.bracketedList().size();//num []
        AttributeMatrix auxAtt = new AttributeMatrix(value);
        //bracketedList
        for (int i = 0; i < value; i++) {
            //expressions in []
            auxAtt.setExpressionValue(i, (String) visitBracketedList(ctx.bracketedList(i)));
        }
        //values expressions
        return (T) auxAtt;
    }

    @Override
    public T visitBracketedList(SRLangParser.BracketedListContext ctx) {
        return visitBoundLP(ctx.boundLP());
    }

    @Override
    public T visitBoundLP(SRLangParser.BoundLPContext ctx) {
        //bounds list
        String internalExpression = "";
        internalExpression += visitBounds(ctx.bounds(0));
        for (int i = 1; i < ctx.bounds().size(); i++) {
            internalExpression += "," + visitBounds(ctx.bounds(i));
        }
        return (T) internalExpression;
    }

    @Override
    public T visitBounds(SRLangParser.BoundsContext ctx) {
        //bound list
        String internalExpression = "";
        internalExpression += visitBound(ctx.bound(0));
        for (int i = 1; i < ctx.bound().size(); i++) {
            internalExpression += ":" + visitBound(ctx.bound(i));
        }
        return (T) internalExpression;
    }

    @Override
    public T visitBound(SRLangParser.BoundContext ctx) {
        //expression or aster
        if (ctx.expression() != null) {
            //expression
            return visitExpression(ctx.expression());
        } else {
            //TK_ASTER
            return (T) ctx.TK_ASTER().getText();
        }
    }

    @Override
    public T visitQualifiedID(SRLangParser.QualifiedIDContext ctx) {
        if (ctx.TK_PERIOD() != null) {
            String s = ctx.TK_ID(0).getText() + ctx.TK_PERIOD().getText() + ctx.TK_ID(1);
            return (T) s;
        } else {
            return (T) ctx.TK_ID(0).getText();
        }
    }

    /*--------------------------blocks and statements----------------------------------------------*/
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
        return null;
    }

    @Override
    public T visitStatement(SRLangParser.StatementContext ctx) {
        if(ctx.skipStatement()!=null){
            AuxMethods.error("skipStatement "+"No esta disponible");
        }else if(ctx.stopStatement()!=null){
            AuxMethods.error("stopStatement "+"No esta disponible");
        }else if (ctx.exitStatement()!=null){
            AuxMethods.error("exitStatement "+"No esta disponible");
        }else if (ctx.nextStatement()!=null){
            AuxMethods.error("nextStatement "+"No esta disponible");
        }else if (ctx.returnStatement()!=null){
            AuxMethods.error("returnStatement "+"No esta disponible");
        }else if (ctx.replyStatement()!=null){
            AuxMethods.error("replyStatement "+"No esta disponible");
        }else if (ctx.forwardStatement()!=null){
            AuxMethods.error("forwardStatement "+"No esta disponible");
        }else if (ctx.sendStatement()!=null){
            AuxMethods.error("sendStatement "+"No esta disponible");
        }else if (ctx.explicitCall()!=null){
            AuxMethods.error("explicitCall "+"No esta disponible");
        }else if (ctx.destroyStatement()!=null){
            AuxMethods.error("destroyStatement "+"No esta disponible");
        }else if (ctx.beginEnd()!=null){
            AuxMethods.error("beginEnd "+"No esta disponible");
        }else if (ctx.ifStatement()!=null){
            AuxMethods.error("ifStatement "+"No esta disponible");
        }else if (ctx.doStatement()!=null){
            AuxMethods.error("doStatement "+"No esta disponible");
        }else if (ctx.forAllStatement()!=null){
            AuxMethods.error("forAllStatement "+"No esta disponible");
        }else if(ctx.vStatement()!=null){
            AuxMethods.error("vStatement "+"No esta disponible");
        }else if (ctx.inputStatement()!=null){
            AuxMethods.error("inputStatement "+"No esta disponible");
        }else if (ctx.receiveStatement()!=null){
            AuxMethods.error("receiveStatement "+"No esta disponible");
        }else if (ctx.pStatement()!=null){
            AuxMethods.error("pStatement "+"No esta disponible");
        }else if (ctx.concurrentStatement()!=null){
            AuxMethods.error("concurrentStatement "+"No esta disponible");
        }else if (ctx.writeStatement()!=null){
            AuxMethods.error("writeStatement "+"No esta disponible");
        }
        return  null;
    }

    @Override
    public T visitIfStatement(SRLangParser.IfStatementContext ctx) {
        return super.visitIfStatement(ctx);
    }

    /*----------------------------- expressionession -----------------------------*/
    @Override
    public T visitExpression(SRLangParser.ExpressionContext ctx) {

        if(ctx.TK_ID()!=null){
            //Revisar si está definido
            String ident = ctx.TK_ID().getText();
            Object value = table.get(ident);

            if(value==null){
                Token token = ctx.TK_ID().getSymbol();
                AuxMethods.error("Identificador no definido.", token.getLine(), token.getCharPositionInLine()-2);
            }

            if(value.getClass().equals(Variable.class)){
                return (T)((Variable)value).getValue();
            }else{
                System.out.println("Identificador no es una variable. Kha");
                return null;
            }

        }else if (ctx.literal() != null) {
            return visitLiteral(ctx.literal());
        } else if (ctx.parenList() != null) {
            //Invocacion funcion, evaluar
            return (T) evaluarInvocacionFuncion(ctx);

            //SUFFIX EXPRESSION
        } else if (ctx.TK_INCR() != null) {
            T arg = visitExpression(ctx.expression(0));
            if (!AuxMethods.valueIsOfTypes(arg, Integer.class, Double.class)) {
                Token token = ctx.TK_INCR().getSymbol();
                AuxMethods.error("Operandos de incremento solo pueden ser enteros o reales.", token.getLine(), token.getCharPositionInLine() + 1);
            }
            if (arg.getClass().equals(Integer.class)) {
                return (T) (Integer) (((Integer) arg) + 1);
            } else {
                return (T) (Double) (((Double) arg) + 1.0);
            }
        //BINARY EXPRESSION

        //Agregación
        }else if(ctx.TK_PLUS() != null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionSum(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        }else if(ctx.TK_MINUS() != null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionMinus(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        }else if(ctx.TK_CONCAT() != null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionConcat(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        }else if(ctx.TK_EXPON()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionExpon(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        //Exponenciación
        }else if(ctx.TK_ASTER()!= null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionMult(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        //Multiplicacion y asociados
        }else if(ctx.TK_DIV()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionDiv(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        }else if(ctx.TK_MOD()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionMod(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        }else if(ctx.TK_REMDR()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionRemdr(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        //BitShift
        }else if(ctx.TK_RSHIFT()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionRShift(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        }else if(ctx.TK_LSHIFT()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionLShift(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        //Relational Operators
        }else if(ctx.TK_EQ()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionEqual(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        }else if(ctx.TK_NE()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionNotEqual(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        }else if(ctx.TK_GT()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionGT(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        }else if(ctx.TK_GE()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionGE(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        }else if(ctx.TK_LT()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionLT(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        }else if(ctx.TK_LE()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionLE(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        //Logic operators
        }else if(ctx.TK_AND()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionAnd(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        }else if(ctx.TK_OR()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionOr(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        }else if(ctx.TK_XOR()!=null){
            return (T) AuxBinaryExpressionVisitors.BinaryExpressionXor(ctx,visitExpression(ctx.expression(0)),visitExpression(ctx.expression(1)));
        //ASIGNACIÓN
        }else if(ctx.TK_ASSIGN()!=null){
            String ident = ctx.expression(0).TK_ID().getText();
            //Revisar si está declarada
            Variable var= (Variable) table.get(ident);
            if(var == null){
                Token tk = ctx.TK_ASSIGN().getSymbol();
                AuxMethods.error("Variable no declarada.",tk.getLine(),tk.getCharPositionInLine()-2);
            }
            //Revisar si el tipo coincide
            Class type=null;
            try{
                type=Class.forName("java.lang."+AuxMethods.convertToJavaType(var.getType()));
            }catch(Exception e){
                Token tk = ctx.TK_ASSIGN().getSymbol();
                AuxMethods.error("Tipo de variable no soportado.",tk.getLine(),tk.getCharPositionInLine()-2);
            }
            Object value = visitExpression(ctx.expression(1));
            if(value.getClass().equals(type)){
                var.setValue(value);
            }else{
                Token tk = ctx.TK_ASSIGN().getSymbol();
                AuxMethods.error("Imposible asignar, tipos no coinciden."+value.getClass()+" no puede asignarse a variable de tipo "+type+".",tk.getLine(),tk.getCharPositionInLine()-2);
            }
            return null;
        }else{
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

    /*----------------------------top-level body statementents-----------------------------*/
    @Override
    public T visitOpDeclaration(SRLangParser.OpDeclarationContext ctx) {
        //opDeclaration: opOrExternal operDefLP
        visitOpOrExternal(ctx.opOrExternal());
        return visitOperDefLP(ctx.operDefLP());
    }

    @Override
    public T visitOpOrExternal(SRLangParser.OpOrExternalContext ctx) {
        //TK_OP | TK_EXTERNAL // external maybe it's not necessary
        if (ctx.TK_OP() != null) {
            return (T) ctx.TK_OP().getText();
        } else {
            AuxMethods.error("External no esta definido");
            return (T) ctx.TK_EXTERNAL().getText();
        }
    }

    @Override
    public T visitOperDefLP(SRLangParser.OperDefLPContext ctx) {
        //operDef --> , list
        ArrayList<T> args = new ArrayList<>();
        for (int i = 0; i < ctx.operDef().size(); i++) {
            //get an Array
            ArrayList<T> aux = (ArrayList<T>)visitOperDef(ctx.operDef(i));
            //And add the variables to args to create a new array with the variables
            args.addAll(aux);
        }
        return (T) args;
    }

    @Override
    public T visitOperDef(SRLangParser.OperDefContext ctx) {
        //idSubsLP (Variable list name)->
        //opPrototype | colonOpt qualifiedID
        //names
        ArrayList<Variable> args = (ArrayList<Variable>) visitIdSubsLP(ctx.idSubsLP());
        ArrayList<Method> mArgs = new ArrayList<>();
        for (Variable arg : args) {
            Method mAux = new Method();
            mAux.setName(arg.getName());
            mArgs.add(mAux);
        }
        if (ctx.opPrototype() != null) {
            //Parameters and return or type |call|send => skip
            Method mAux = (Method) visitOpPrototype(ctx.opPrototype());
            for (Method mArg: mArgs){
                mArg.setType(mAux.getType());
                mArg.setVarToReturn(mAux.getVarToReturn());
                mArg.setParameters(mAux.getParameters());
            }
        } else {
            AuxMethods.error("colonOpt qualifiedID aun no está definida");
        }


        return (T) mArgs;
    }

    @Override
    public T visitColonOpt(SRLangParser.ColonOptContext ctx) {
        if (ctx.TK_COLON() != null) {
            return (T) ctx.TK_COLON().getText();
        } else {
            /* epsilon (Empty production) */
            return null;
        }
    }

    /*----------------------------------optype-----------------------------------------------*/
    @Override
    public T visitOpPrototype(SRLangParser.OpPrototypeContext ctx) {
        //prototype opRestrictionOpt
        return visitPrototype(ctx.prototype());
    }

    @Override
    public T visitOpRestrictionOpt(SRLangParser.OpRestrictionOptContext ctx) {
        //TK_LBRACE opRestriction TK_RBRACE //skip
        AuxMethods.error("opRestrictionOpt Aun no definida");
        return null;
    }

    @Override
    public T visitOpRestriction(SRLangParser.OpRestrictionContext ctx) {
        if (ctx.TK_CALL() != null) {
            if (ctx.TK_SEND() != null) {
                String s = ctx.TK_CALL().getText() + ctx.TK_COMMA().getText() + ctx.TK_SEND().getText();
                return (T) s;
            } else {
                return (T) ctx.TK_CALL().getText();
            }
        } else {
            //Send
            if (ctx.TK_CALL() != null) {
                String s = ctx.TK_SEND().getText() + ctx.TK_COMMA().getText() + ctx.TK_CALL().getText();
                return (T) s;
            } else {
                return (T) ctx.TK_SEND().getText();
            }
        }
    }

    /*--------------------------------------parameters---------------------------------------*/
    @Override
    public T visitPrototype(SRLangParser.PrototypeContext ctx) {
        Method auxMethod = new Method();
        //parameters returnSpecificOptional
        //parameters
        if (ctx.parameters().paramSpecificList() != null) {
            ArrayList<Variable> args = (ArrayList<Variable>) visitParameters(ctx.parameters());
            auxMethod.setParameters(args);
        }
        //returnSpecificOptional //return;
        Variable aux = (Variable) visitReturnSpecificOptional(ctx.returnSpecificOptional());
        if (aux != null) {
            auxMethod.setType(aux.getType());
            if (aux.getName() != null) {
                auxMethod.setVarToReturn(aux);
            }
        }
        return (T) auxMethod;
    }

    @Override
    public T visitParameters(SRLangParser.ParametersContext ctx) {
        //TK_LPAREN paramSpecificList TK_RPAREN
        if (ctx.paramSpecificList() != null) {
            return visitParamSpecificList(ctx.paramSpecificList());
        } else {
            return null;
        }

    }

    @Override
    public T visitParamSpecificList(SRLangParser.ParamSpecificListContext ctx) {
        //¿ | paramSpecificLP
        if (ctx.paramSpecificLP() != null) {
            return visitParamSpecificLP(ctx.paramSpecificLP());
        } else {
            return null;
        }
    }

    @Override
    public T visitParamSpecificLP(SRLangParser.ParamSpecificLPContext ctx) {
        //paramSpecific (TK_SEPARATOR paramSpecific)* TK_SEPARATOR?
        ArrayList<T> args = new ArrayList<>();
        for (int i = 0; i < ctx.paramSpecific().size(); i++) {
            //get an Array
            ArrayList<T> aux = (ArrayList<T>) visitParamSpecific(ctx.paramSpecific(i));
            //And add the variables to args to create a new array with the variables
            args.addAll(aux);
        }
        return (T) args;
    }

    @Override
    public T visitParamSpecific(SRLangParser.ParamSpecificContext ctx) {
        //paramKindOptional->
        //type|idSubsLP TK_COLON type
        if (visitParamKindOptional(ctx.paramKindOptional()) != null) {
            String word = (String) visitParamKindOptional(ctx.paramKindOptional());
            if (word.equals("val")) {
                AuxMethods.errorFunNotDefine(word, ctx.paramKindOptional().TK_VAL().getSymbol().getLine(),
                        ctx.paramKindOptional().TK_REF().getSymbol().getCharPositionInLine() + 1);
            } else if (word.equals("ref")) {
                AuxMethods.errorFunNotDefine(word, ctx.paramKindOptional().TK_REF().getSymbol().getLine(),
                        ctx.paramKindOptional().TK_REF().getSymbol().getCharPositionInLine() + 1);
            } else if (word.equals("res")) {
                AuxMethods.errorFunNotDefine(word, ctx.paramKindOptional().TK_RES().getSymbol().getLine(),
                        ctx.paramKindOptional().TK_REF().getSymbol().getCharPositionInLine() + 1);
            } else if (word.equals("var")) {
                AuxMethods.errorFunNotDefine(word, ctx.paramKindOptional().TK_VAR().getSymbol().getLine(),
                        ctx.paramKindOptional().TK_REF().getSymbol().getCharPositionInLine() + 1);
            }
            return null;
        } else {
            if (ctx.idSubsLP() != null) {
                //name list
                ArrayList<T> args = (ArrayList<T>) visitIdSubsLP(ctx.idSubsLP());
                //type
                String type = (String) visitType(ctx.type());
                for (T arg : args) {
                    Variable aux = (Variable) arg;
                    aux.setType(type);
                }
                return (T) args; //variables with name and type
            } else {
                AuxMethods.error("Necesita identificador");
                return null;
            }
        }
    }

    @Override
    public T visitParamKindOptional(SRLangParser.ParamKindOptionalContext ctx) {
        if (ctx.TK_REF() != null) {
            return (T) ctx.TK_REF().getText();
        } else if (ctx.TK_RES() != null) {
            return (T) ctx.TK_RES().getText();
        } else if (ctx.TK_VAL() != null) {
            return (T) ctx.TK_VAL().getText();
        } else if (ctx.TK_VAR() != null) {
            return (T) ctx.TK_VAR().getText();
        } else {
            ///* epsilon (Empty production) */
            return null;
        }
    }

    @Override
    public T visitReturnSpecificOptional(SRLangParser.ReturnSpecificOptionalContext ctx) {
        //returnSpecificNull| TK_RETURNS->
        //type|idSubs TK_COLON type|TK_ID TK_BOGUS
        if (ctx.returnSpecificNull() != null) {
            return null;
        } else {
            Variable auxVar = new Variable();
            auxVar.setType((String) visitType(ctx.type()));
            if (ctx.idSubs() != null) {
                Variable aux = (Variable) visitIdSubs(ctx.idSubs());
                auxVar.setName(aux.getName());
                auxVar.setAtt(aux.getAtt());
            }
        }
        return null;
    }


    /*------------------------------------NASH---------------------------------------*/
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
        /*//Para recorrer los argumentos e introducirlos en una lista
        List<T> args = new LinkedList<>();
        for(SRLangParser.ExpressionContext expression : ctx.parenList().parenItemList().expression()){
            args.add(visitExpression(expression));
        }*/

        switch (functionIden) {
            //Basic functions
            case "max":
                double max = Double.MIN_VALUE;
                //Recorrer los argumentos
                for (SRLangParser.ExpressionContext expression : ctx.parenList().parenItemList().expression()) {
                    T arg = visitExpression(expression);
                    //System.out.println(arg+": "+AuxMethods.valueIsOfTypes(arg,Integer.class,Double.class));
                    if (!AuxMethods.valueIsOfTypes(arg, Integer.class, Double.class)) {
                        Token token = ctx.expression(0).TK_ID().getSymbol();
                        AuxMethods.error("Argumentos de la función Max solo pueden ser enteros o reales.", token.getLine(), token.getCharPositionInLine() + 1);
                    }

                    if (arg.getClass().equals(Integer.class)) {
                        if ((Double.valueOf((Integer) arg)) > max) {
                            max = Double.valueOf((Integer) arg);
                        }
                    } else {
                        if ((Double) arg > max) {
                            max = (Double) arg;
                        }
                    }
                }
                return (T) (Double) max;
            case "min":
                double min = Double.MAX_VALUE;
                //Recorrer los argumentos
                for (SRLangParser.ExpressionContext expression : ctx.parenList().parenItemList().expression()) {
                    T arg = visitExpression(expression);
                    //System.out.println(arg+": "+AuxMethods.valueIsOfTypes(arg,Integer.class,Double.class));
                    if (!AuxMethods.valueIsOfTypes(arg, Integer.class, Double.class)) {
                        Token token = ctx.expression(0).TK_ID().getSymbol();
                        AuxMethods.error("Argumentos de la función Min solo pueden ser enteros o reales.", token.getLine(), token.getCharPositionInLine() + 1);
                    }

                    if (arg.getClass().equals(Integer.class)) {
                        if ((Double.valueOf((Integer) arg)) < min) {
                            min = Double.valueOf((Integer) arg);
                        }
                    } else {
                        if ((Double) arg < min) {
                            min = (Double) arg;
                        }
                    }
                }
                return (T) (Double) min;
            case "length":
                T arg;
                if(ctx.parenList().parenItemList().expression().size()!=1){
                    Token token = ctx.expression(0).TK_ID().getSymbol();
                    AuxMethods.error("Función length solo puede tener un argumento", token.getLine(), token.getCharPositionInLine() + 1);
                }
                return (T)AuxMathFunctions.length(ctx, visitExpression(ctx.parenList().parenItemList().expression(0)));
            case "sqrt":
                if(ctx.parenList().parenItemList().expression().size()!=1){
                    Token token = ctx.expression(0).TK_ID().getSymbol();
                    AuxMethods.error("Función sqrt solo puede tener un argumento", token.getLine(), token.getCharPositionInLine() + 1);
                }
                //No vale la pena abstraer el trozo de código
                return (T)AuxMathFunctions.sqrt(ctx, visitExpression(ctx.parenList().parenItemList().expression(0)));
            case "floor":
                if(ctx.parenList().parenItemList().expression().size()!=1){
                    Token token = ctx.expression(0).TK_ID().getSymbol();
                    AuxMethods.error("Función floor solo puede tener un argumento", token.getLine(), token.getCharPositionInLine() + 1);
                }
                arg = visitExpression(ctx.parenList().parenItemList().expression(0));

                if (!AuxMethods.valueIsOfTypes(arg, Double.class, Integer.class)) {
                    Token token = ctx.expression(0).TK_ID().getSymbol();
                    AuxMethods.error("Argumento de la función floor solo puede ser entero o real.", token.getLine(), token.getCharPositionInLine() + 1);
                }else{
                    return (T) (Double)Math.floor(Double.parseDouble(arg.toString()));
                }
            case "ceil":
                if(ctx.parenList().parenItemList().expression().size()!=1){
                    Token token = ctx.expression(0).TK_ID().getSymbol();
                    AuxMethods.error("Función ceil solo puede tener un argumento", token.getLine(), token.getCharPositionInLine() + 1);
                }
                arg = visitExpression(ctx.parenList().parenItemList().expression(0));

                if (!AuxMethods.valueIsOfTypes(arg, Double.class, Integer.class)) {
                    Token token = ctx.expression(0).TK_ID().getSymbol();
                    AuxMethods.error("Argumento de la función ceil solo puede ser entero o real.", token.getLine(), token.getCharPositionInLine() + 1);
                }else{
                    return (T) (Double)Math.ceil(Double.parseDouble(arg.toString()));
                }
            case "round":
                if(ctx.parenList().parenItemList().expression().size()!=1){
                    Token token = ctx.expression(0).TK_ID().getSymbol();
                    AuxMethods.error("Función round solo puede tener un argumento", token.getLine(), token.getCharPositionInLine() + 1);
                }
                arg = visitExpression(ctx.parenList().parenItemList().expression(0));

                if (!AuxMethods.valueIsOfTypes(arg, Double.class, Integer.class)) {
                    Token token = ctx.expression(0).TK_ID().getSymbol();
                    AuxMethods.error("Argumento de la función round solo puede ser entero o real.", token.getLine(), token.getCharPositionInLine() + 1);
                }else{
                    return (T) (Integer)Math.round(Float.parseFloat(arg.toString()));
                }
                return null;
            default:
                System.out.println("Pvt");
                break;
        }
        //Funcion declarada, buscar y llamar (?)

        return null;
    }

}
