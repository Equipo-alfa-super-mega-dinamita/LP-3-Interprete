import java.util.Arrays;

public class AttributeMatrix {
    private int dimensions;
    private String expression[];

    public AttributeMatrix(int dimensions) {
        this.dimensions = dimensions;
        this.expression = new String[dimensions];
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }

    public String[] getexpression() {
        return expression;
    }

    public void setExpressionValue(int index, String value) {
        this.expression[index] = value;
    }


    @Override
    public String toString() {
        return "AttributeMatrix{" +
                "dimensions=" + dimensions +
                ", expression=" + Arrays.toString(expression) +
                '}';
    }
}
