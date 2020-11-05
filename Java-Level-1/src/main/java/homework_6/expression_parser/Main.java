package homework_6.expression_parser;

public class Main {
    public static void main(String[] args) {
        Constant a = new Constant(25);
        Constant b = new Constant(5);
        Binary expr = new Binary(a, b, Operation.ADD);
        System.out.println(expr.apply());
        System.out.println(expr);
        a.print();


        Expression[] arr = {a, b, b, expr};
        Operation[] oparr = {Operation.ADD, Operation.MULTIPLY, Operation.DIVIDE};
        Flat flat = new Flat(arr, oparr);
        System.out.println(flat.apply());
        flat.print();
        System.out.println(ExpressionParser.parse("0").apply());
        ExpressionParser.parse("(5 + 56 * 5 - 10 / -8)").print();

        ExpressionParser.parse("1 + (2 * (1 + ((2 / 0) * 2)) * (3 + 8))").print();

    }
}