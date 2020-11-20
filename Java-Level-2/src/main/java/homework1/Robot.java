package homework1;

public class Robot implements Athlete {
    private final String NAME;
    private final int RUN_RANGE = 8640;
    private final double JUMP_HEIGHT = 0.3;


    public Robot(String name) {
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
        return "Robot " + NAME;
    }
}
