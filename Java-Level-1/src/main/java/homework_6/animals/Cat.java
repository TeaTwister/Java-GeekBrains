package homework_6.animals;

public class Cat extends Animal {

    static final double RUN = 200.;
    static final double SWIM = 0.;
    static final double JUMP = 2.;

    public Cat(String name) {
        super(name, RUN, SWIM, JUMP);
    }

    @Override
    public void swim(double distance) {
        System.out.printf("Cats can't swim, you silly! " +
                "Not even for %.0f m!%n", distance);
    }
}
