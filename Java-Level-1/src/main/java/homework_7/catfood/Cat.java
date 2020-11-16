package homework_7.catfood;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean fedUp = false;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        fedUp = plate.decreaseFood(appetite);
    }

    public void info() {
        System.out.println(name + " is fed up: " + fedUp);
    }
}
