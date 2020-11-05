package homework_7.catfood;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int amount) {
        if (amount <= food) {
            food -= amount;
            return true;
        } else return false;
    }

    public void addFood(int amount) {
        food += amount;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
