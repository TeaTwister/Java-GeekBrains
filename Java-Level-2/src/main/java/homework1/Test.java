package homework1;

public class Test {
    public static void main(String[] args) {
        Athlete h1 = new Human("Joe");
        h1.jump(0.51);
        h1.run(200);
        Athlete c1 = new Cat("Cookie");
        c1.jump(2.2);
        c1.run(50);
        Athlete r1 = new Robot("Spot");
        r1.jump(0.4);
        r1.run(200);

        Obstacle t1 = new Track(1000);
        Obstacle w1 = new Wall(0.3);
        t1.overcome(r1);
        System.out.println("---");


        Athlete r2 = new Robot("C-3PO");
        Athlete[] team = {h1, c1, r1, r2};
        Obstacle[] course = {t1, w1};

        for (Athlete a : team) {
            for (Obstacle o : course) {
                if (!o.overcome(a)) break;
            }
        }
        System.out.println("---");


        Course c = new Course(course);
        Team t = new Team(team);
        c.go(t);
        System.out.println("---");
        t.showResults();
    }
}
