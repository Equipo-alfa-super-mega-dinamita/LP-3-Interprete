import java.util.ArrayList;

public class Method {
    private String name;
    private String type;
    private Variable varToReturn;
    private ArrayList<Variable> parameters;
    private SRLangParser.BlockContext ctx;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Variable> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Variable> parameters) {
        this.parameters = parameters;
    }

    public Variable getVarToReturn() {
        return varToReturn;
    }

    public void setVarToReturn(Variable varToReturn) {
        this.varToReturn = varToReturn;
    }
    public void setCtx(SRLangParser.BlockContext ctx) {
        this.ctx = ctx;
    }
    @Override
    public String toString() {
        return "Method{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", varToReturn='" + varToReturn + '\'' +
                ", parameters=" + parameters +
                '}';
    }


}
