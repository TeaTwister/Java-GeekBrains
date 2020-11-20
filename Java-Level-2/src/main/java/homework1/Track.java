package homework1;

public class Track implements Obstacle {
    private final int LENGTH;

    public Track(int length) {
        LENGTH = length;
    }

    @Override
    public boolean overcome(Athlete athlete) {
        return athlete.run(LENGTH);
    }
}
