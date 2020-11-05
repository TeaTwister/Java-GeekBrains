package homework_6.expression_parser;

public enum Operation {
    ADD("+") {
        @Override
        public double apply(Expression left, Expression right) {
            return left.apply() + right.apply();
        }
    },
    SUBTRACT("-") {
        @Override
        public double apply(Expression left, Expression right) {
            return left.apply() - right.apply();
        }
    },
    MULTIPLY("*") {
        @Override
        public double apply(Expression left, Expression right) {
            return left.apply() * right.apply();
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(Expression left, Expression right) {
            return left.apply() / right.apply();
        }
    };

    private final String SIGN;

    Operation(String sign) {
        this.SIGN = sign;
    }

    public abstract double apply(Expression left, Expression right);

    @Override
    public String toString() {
        return SIGN;
    }
}
