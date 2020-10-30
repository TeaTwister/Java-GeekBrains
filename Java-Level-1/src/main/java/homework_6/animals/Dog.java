package homework_6.animals;

public class Dog extends Animal {

    static final double RUN = 500.;
    static final double SWIM = 10.;
    static final double JUMP = 0.5;

    public Dog(String name) {
        super(name, RUN, SWIM, JUMP);
    }
}
