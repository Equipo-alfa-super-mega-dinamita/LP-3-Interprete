import java.util.Arrays;

public class Method {
    private String name;
    private String type;
    private Parameter [] parameters;

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

    public Parameter[] getAttributes() {
        return parameters;
    }

    public Parameter[] getParameters() {
        return parameters;
    }

    public void setParameters(Parameter[] parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Method{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", parameters=" + Arrays.toString(parameters) +
                '}';
    }
}
