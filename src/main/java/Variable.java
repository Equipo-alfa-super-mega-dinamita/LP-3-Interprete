public class Variable<T> {
    private String name;
    private T Value;
    private String type;


    private boolean isConst;
    private boolean isArray;
    private boolean ArraySize;


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

    public boolean isArray() {
        return isArray;
    }

    public void setArray(boolean array) {
        isArray = array;
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

    public boolean isArraySize() {
        return ArraySize;
    }

    public void setArraySize(boolean arraySize) {
        ArraySize = arraySize;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "name='" + name + '\'' +
                ", Value=" + Value +
                ", type='" + type + '\'' +
                ", isConst=" + isConst +
                '}';
    }
}
