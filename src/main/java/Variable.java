public class Variable<T> {
    private String name;
    private T Value;
    private String type;
    private AttributeMatrix att;

    private boolean isConst;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return Value;
    }

    public void setValue(T value) {
        Value = value;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isConst() {
        return isConst;
    }

    public void setConst(boolean aConst) {
        isConst = aConst;
    }

    public AttributeMatrix getAtt() {
        return att;
    }

    public void createAtt(int dimensions) {
        this.att = new AttributeMatrix(dimensions);
    }
    public  void setAttValue(int index, String value){
        this.att.setExpressionValue(index,value);
    }

    public void setAtt(AttributeMatrix att) {
        this.att = att;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "name='" + name + '\'' +
                ", Value=" + Value +
                ", type='" + type + '\'' +
                ", Att=" + att +
                ", isConst=" + isConst +
                '}';
    }
}
