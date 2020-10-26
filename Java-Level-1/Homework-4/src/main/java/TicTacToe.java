import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static int fieldSide = 3;
    static char[][] field;

    static final char DOT_CHAR = '•';
    static final char X_CHAR = 'X';
    static final char O_CHAR = 'O';
    static char player = X_CHAR;

    static int[] lastMove;
    static int moveCount;

    static ArrayList<int[]> availableMoves = new ArrayList<>(fieldSide * fieldSide);

    static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            emptyField();
            for (moveCount = 0; moveCount < fieldSide * fieldSide; moveCount++) {
                printField();
                playerMove(player);
                if (moveCount >= 4 && checkWin()) {
                    System.out.printf("Player %c wins!", player);
                    break;
                }
                playerChange();
            }
            printField();
            if (moveCount == fieldSide * fieldSide) {
                System.out.println("Draw!");
            }
        } while (true);
    }


    private static void emptyField() {
        field = new char[fieldSide][fieldSide];
        availableMoves.clear();
        for (int i = 0; i < fieldSide; i++) {
            for (int j = 0; j < fieldSide; j++) {
                field[i][j] = DOT_CHAR;
                availableMoves.add(new int[]{i, j});
            }
        }
    }


    private static void printField() {
        printColNumbers();
        printRows();
        printColNumbers();
    }

    private static void printColNumbers() {
        System.out.print(" ");
        for (int i = 0; i < fieldSide; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
    }

    private static void printRows() {
        for (int i = 0; i < fieldSide; i++) {
            System.out.print((i + 1) + " ");
            printRow(i);
            System.out.print(i + 1);
            System.out.println();
        }
    }

    private static void printRow (int row) {
        for (int i = 0; i < fieldSide; i++) {
            System.out.print(field[row][i] + " ");
        }
    }


    public static void playerMove(char player) {
        int[] move = new int[2];
        System.out.println();
        switch (player) {
            case X_CHAR:
                move = humanMove();
                break;
            case O_CHAR:
                move = computerMove();
                break;
        }
        commitMove(move, player);
    }

    private static int[] humanMove() {
        int[] move;
        do {
            System.out.print("Enter the coordinates: ");
            move = askForMove();
        } while (isInvalidMove(move));
        return move;
    }

    private static int[] askForMove() {
        try {
            int row = SCANNER.nextInt() - 1;
            int column = SCANNER.nextInt() - 1;
            return new int[]{row, column};
        } catch (InputMismatchException e) {
            System.out.printf("Input two numbers from 1 to %d, separated by space: ", fieldSide);
            SCANNER.nextLine();
            return askForMove();
        }
    }

    private static boolean isInvalidMove(int[] move) {
        try {
            if (field[move[0]][move[1]] != DOT_CHAR) {
                System.out.print("Choose empty cell! ");
                return true;
            } else return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("Coordinates should be in range from 1 to %d! ", fieldSide);
            return true;
        }
    }

    public static void commitMove(int[] move, char playerSign) {
        field[move[0]][move[1]] = playerSign;
        lastMove = move;
        availableMoves.remove(move);
    }

    public static boolean checkWin() {
        boolean win = false;
        if (isInDiagonal(lastMove)) {
            win = checkDiagonals();
        }
        win = checkRow(lastMove[0]) || win;
        win = checkColumn(lastMove[1]) || win;
        return win;
    }

    private static boolean isInDiagonal(int[] move) {
        return isLeftDiagonal(move) || isRightDiagonal(move);
    }

    private static boolean isLeftDiagonal(int[] move) {
        return move[0] == move[1];
    }

    private static boolean isRightDiagonal(int[] move){
        return move[0] == (fieldSide - 1) - move[1];
    }
    
    private static boolean checkDiagonals() {
        boolean flagL = field[0][0] == player;
        boolean flagR = field[0][fieldSide - 1] == player;
        if (!(flagL || flagR)) {
            return false;
        }
        for (int i = 0; i < fieldSide; i++) {
            if (field[i][i] != player) {
                flagL = false;
            }
            if (field[i][fieldSide - 1 - i] != player) {
                flagR = false;
            }
            if (!(flagL || flagR)) break;
        }
        return flagL || flagR;
    }

    private static boolean checkRow(int row) {
        for (int i = 0; i < fieldSide; i++) {
            if (field[row][i] != player) return false;
        }
        return true;
    }

    private static boolean checkColumn(int column) {
        for (int i = 0; i < fieldSide; i++) {
            if (field[i][column] != player) return false;
        }
        return true;
    }

    private static void playerChange() {
        player = player == X_CHAR ? O_CHAR : X_CHAR;
    }


    private static int[] computerMove() {
        int[] move = new int[2];
        int maxPriority = 0;
        for (int[] candidate : availableMoves) {
            int priority = countPriority(candidate);
            if (priority > maxPriority) {
                maxPriority = priority;
                move = candidate;
            }
        }
        return opposite(lastMove);
    }

    private static int countPriority(int[] move) {
        int score = 0;
        if (isLeftDiagonal(move)) {
            score++;
            score += countLeftDiagonal();
        }
        if (isRightDiagonal(move)) {
            score++;
            score += countRightDiagonal();
        }

    }

    private static int countLeftDiagonal() {
        int score = 0;
        for (int i = 0; i < fieldSide; i++) {
            if (field[i][i] == X_CHAR ) score++;
            if (field[i][i] == O_CHAR) score--;
        }
        if (score == -2) return 4;
        return Math.abs(score);
    }

    private static int countRightDiagonal() {
        int score = 0;
        for (int i = 0; i < fieldSide; i++) {
            if (field[i][(fieldSide - 1) - i] == X_CHAR ) score++;
            if (field[i][(fieldSide - 1) - i] == O_CHAR) score--;
        }
        if (score == -2) return 4;
        return Math.abs(score);
    }


    private static boolean isInCorner (int[] move) {
        return move[0] % 2 == 0 && move[1] % 2 == 0;
    }

    private static int[] opposite(int[] move) {
        int[] oppositeMove = new int[2];
        for (int i = 0; i < move.length; i++) {
            oppositeMove[i] = fieldSide - 1 - move[i];
        }
        return oppositeMove;
    }
}

