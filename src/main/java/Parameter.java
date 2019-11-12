public class Parameter {
    private String name;
    private String type;
    private AttributeMatrix att;//String expression ->null

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

    public AttributeMatrix getAtt() {
        return att;
    }

    public void setAtt(AttributeMatrix att) {
        this.att = att;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", att=" + att +
                '}';
    }
}
