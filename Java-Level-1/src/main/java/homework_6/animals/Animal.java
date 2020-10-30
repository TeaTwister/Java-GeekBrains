package homework_6.animals;

public abstract class Animal {
    String name;
    private double runDistance;
    private double swimDistance;
    private double jumpDistance;

    public Animal(String name, double run, double swim, double jump) {
        this.name = name;
        runDistance = run * (Math.random() * 0.4 + 0.8);
        swimDistance = swim * (Math.random() * 0.6 + 0.7);
        jumpDistance = jump * (Math.random() * 1 + 0.5);
    }

    public void run(double distance) {
        if (Math.abs(distance) <= runDistance) {
            System.out.printf("%s successfully ran %.1f m%n", name, distance);
        } else {
            System.out.printf("%s can't run for %.1f m%n", name, distance);
        }
    }

    public void swim(double distance) {
        if (Math.abs(distance) <= swimDistance) {
            System.out.printf("%s successfully swam %.1f m%n", name, distance);
        } else {
            System.out.printf("%s can't swim for %.1f m%n", name, distance);
        }
    }

    public void jump(double distance) {
        if (Math.abs(distance) <= jumpDistance) {
            System.out.printf("%s successfully jumped %.1f m%n", name, distance);
        } else {
            System.out.printf("%s can't jump %.1f m%n", name, distance);
        }

    }

    @Override
    public String toString() {
        return String.format("Animal{name='%s', runDistance=%.1f, " +
                "swimDistance=%.1f, jumpDistance=%.1f}",
                name, runDistance, swimDistance, jumpDistance);
    }
}
