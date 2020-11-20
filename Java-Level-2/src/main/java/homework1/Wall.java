package homework1;

public class Wall implements Obstacle {
    private final double HEIGHT;

    public Wall(double height) {
        HEIGHT = height;
    }

    @Override
    public boolean overcome(Athlete athlete) {
        return athlete.jump(HEIGHT);
    }
}
