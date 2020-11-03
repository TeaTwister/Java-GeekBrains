package homework_6.expression_parser;

public class Binary extends Expression{
    Expression leftOperand, rightOperand;
    Operation operation;

    public Binary(Expression left, Expression right, Operation operation) {
        leftOperand = left;
        rightOperand = right;
        this.operation = operation;
    }

    @Override
    public double apply() {
        return operation.apply(leftOperand, rightOperand);
    }

    @Override
    public String toString() {
        return "(" + leftOperand.toString() + operation.toString() + rightOperand.toString() + ")";
    }
}
