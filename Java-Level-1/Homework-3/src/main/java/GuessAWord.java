import java.util.Scanner;

public class GuessAWord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leek", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int maxLength = 0;
        for (String word : words) {
            maxLength = Math.max(word.length(), maxLength);
        }
        System.out.println("Welcome to the game, you need to guess a word!");
        do {
            System.out.println("Good luck!");
            String word = words[(int) (Math.random() * words.length)];
            playGuessWord(word, maxLength, in);
        } while (wannaPlay(in));
        System.out.println("See you next time!");
        in.close();
    }

    public static void playGuessWord(String answer, int length, Scanner scanner) {
        StringBuilder sb = new StringBuilder(length);
        sb.append("#".repeat(length));
        String guess = "";
        do {
            System.out.println("Take a guess:");
            printRightChars(guess, answer, sb);
            guess = scanner.next().toLowerCase();
        } while (!guess.equals(answer));
        System.out.println("Good guess! Look at you go!");
    }

    private static void printRightChars(String guess, String answer, StringBuilder sb) {
        char c;
        int i;
        int minLength = Math.min(guess.length(), answer.length());
        for (i = 0; i < minLength; i++) {
            c = guess.charAt(i) == answer.charAt(i) | sb.charAt(i) == answer.charAt(i) ? answer.charAt(i) : '#';
            sb.setCharAt(i, c);
        }
        for (; i < answer.length(); i++) {
            sb.setCharAt(i, sb.charAt(i) == answer.charAt(i) ? answer.charAt(i) : '#');
        }
        for (; i < sb.capacity(); i++) {
            sb.setCharAt(i, '#');
        }
        System.out.println(sb);
    }

    public static boolean wannaPlay(Scanner scanner) {
        System.out.print("\nWanna play again? 1 - yes / 0 - no: ");
        return scanner.next().equals("1");
    }

}
