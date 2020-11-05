package homework_6.animals;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Digit");
        System.out.println(dog);
        dog.run(500.);
        dog.swim(10.);
        dog.jump(0.5);
        Cat cat = new Cat("Cookie");
        System.out.println(cat);
        cat.run(200.);
        cat.jump(2.);
        cat.swim(1.);
    }
}
