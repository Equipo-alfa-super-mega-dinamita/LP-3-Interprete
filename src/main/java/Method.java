import java.util.Arrays;

public class Method {
    private String name;
    private String type;
    private String [] attributes;

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

    public String[] getAttributes() {
        return attributes;
    }

    public void setAttributes(String[] attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Method{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }
}
