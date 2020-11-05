package homework_6.expression_parser;

public abstract class Expression {

    public abstract double apply();

    public void print() {
        System.out.println(this.toString() + "=" + this.apply());
    }
}
