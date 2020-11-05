package homework_7.catfood;

public class Main {
    public static void main(String[] args) {
        Plate p = new Plate(0);
        p.info();
        p.addFood(16);
        p.info();
        Cat[] cats = new Cat[10];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Name " + (i + 1), i + 1);
            cats[i].eat(p);
            cats[i].info();
            p.info();
        }
    }
}
