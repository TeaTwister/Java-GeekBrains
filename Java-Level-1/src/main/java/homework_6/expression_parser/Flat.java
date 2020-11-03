package homework_6.expression_parser;

import java.util.ArrayList;
import java.util.Arrays;

public class Flat extends Expression{
    Expression[] operands;
    Operation[] operations;
    public Flat(Expression[] operands, Operation[] operations) {
        this.operands = operands;
        this.operations = operations;
    }

    @Override
    public double apply() {
        if (this.operands.length == 1 /*| this.operations.length == 0*/) {
            return operands[0].apply();
        }
        ArrayList<Expression> operands = new ArrayList<>(Arrays.asList(this.operands));
        ArrayList<Operation> operations = new ArrayList<>(Arrays.asList(this.operations));
        for (int i = 0; i < operations.size(); i++) {
            Expression left = operands.get(i);
            Expression right = operands.get(i + 1);
            Operation op = operations.get(i);
            if (op == Operation.MULTIPLY || op == Operation.DIVIDE) {
                Binary binary = new Binary(left, right, op);
                operations.remove(i);
                operands.set(i, binary);
                operands.remove(i + 1);
                i--;
            }
        }
        for (int i = 0; i < operations.size();) {
            Expression left = operands.get(i);
            Expression right = operands.get(i + 1);
            Operation op = operations.get(i);
            Binary binary = new Binary(left, right, op);
            operations.remove(i);
            operands.set(i, binary);
            operands.remove(i + 1);
        }
        return operands.get(0).apply();
    }

    @Override
    public String toString() {
        if (this.operands.length == 1 /*| this.operations.length == 0*/) {
            return operands[0].toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        int i;
        for (i = 0; i < operations.length; i++) {
            sb.append(operands[i].toString()).append(operations[i].toString());
        }
        sb.append(operands[i].toString()).append(")");
        return sb.toString();
    }
}
