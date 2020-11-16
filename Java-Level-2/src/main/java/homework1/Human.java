package homework1;

public class Human implements Athlete {
    private final String NAME;
    private final int RUN_RANGE = 32186;
    private final double JUMP_HEIGHT = 0.6;

    public Human(String name) {
        NAME = name;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= RUN_RANGE) {
            System.out.printf("%s just ran %d meters!%n", NAME, distance);
            return true;
        } else {
            System.out.printf("%s can't run %d meters!%n", NAME, distance);
            return false;
        }
    }

    @Override
    public boolean jump(double height) {
        if (height <= JUMP_HEIGHT) {
            System.out.printf("%s just jumped %.1f meters!%n", NAME, height);
            return true;
        } else {
            System.out.printf("%s can't jump %.1f meters!%n", NAME, height);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Human " + NAME;
    }
}
