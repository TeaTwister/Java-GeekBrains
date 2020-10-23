import java.util.Scanner;

public class GuessANumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rangeFrom = 0;
        int rangeTo = 9;
        int maxTries = 3;
        System.out.printf("Welcome to the game, you need to guess a number from %d to %d!%n", rangeFrom, rangeTo);
        do {
            System.out.println("Good luck!");
            int answer = rangeFrom + (int) (Math.random() * (rangeTo - rangeFrom + 1));
            playRounds(maxTries, answer, in);
        } while (wannaPlay(in));
        System.out.println("See you next time!");
        in.close();
    }

    public static void playRounds(int tries, int rightAnswer, Scanner scanner) {
        for (int i = 0; i < tries; i++) {
            System.out.printf(tries - i > 1 ? "You have %d tries left! " : "This is your last try! ", tries - i);
            System.out.println("Your guess: ");
            int guess = scanner.nextInt();
            if (guess == rightAnswer) {
                System.out.println("Right! You're the best!");
                return;
            }
            System.out.print("Wrong! The number is ");
            if (rightAnswer > guess) System.out.print("greater than ");
            else System.out.print("less than ");
            System.out.printf("%d!%n", guess);
        }
        System.out.printf("The number was %d! Good luck next time!", rightAnswer);
    }

    public static boolean wannaPlay(Scanner scanner) {
        System.out.print("\nWanna play again? 1 - yes / 0 - no: ");
        return scanner.next().equals("1");
    }
}
