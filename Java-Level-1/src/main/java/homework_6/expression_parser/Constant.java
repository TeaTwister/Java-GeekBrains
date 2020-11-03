package homework_6.expression_parser;

public class Constant extends Expression {

    private final double VALUE;

    public Constant(double value) {
        this.VALUE = value;
    }

    @Override
    public double apply() {
        return VALUE;
    }

    @Override
    public String toString() {
        return String.valueOf(VALUE);
    }
}
