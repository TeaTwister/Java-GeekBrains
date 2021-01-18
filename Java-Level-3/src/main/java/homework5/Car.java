package homework5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static final ReentrantLock photoFinish = new ReentrantLock();
    private static CountDownLatch startLine;
    private static CountDownLatch finishLine;
    private static int CARS_COUNT = 0;

    private final Race race;
    private final int speed;
    private final String name;

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public static void setStartLine(CountDownLatch startLine) {
        Car.startLine = startLine;
    }

    public static void setFinishLine(CountDownLatch finishLine) {
        Car.finishLine = finishLine;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            startLine.countDown();
            startLine.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (photoFinish.tryLock()) System.out.println("Победитель - " + name + "!");
        finishLine.countDown();
    }
}
