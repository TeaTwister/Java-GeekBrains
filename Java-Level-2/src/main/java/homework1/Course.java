package homework1;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void go (Team team) {
        Athlete[] athletes = team.getAthletes();
        for (int i = 0; i < athletes.length; i++) {
            int count = 0;
            for (Obstacle o : obstacles) {
                if (o.overcome(athletes[i])) count++;
                else break;
            }
            team.getFinishes()[i] = (count == obstacles.length);
        }
    }
}
