import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static int fieldSide = 5;
    public static int winCondition = 4;
    static char[][] field;

    static final char DOT_CHAR = '•';
    static final char X_CHAR = 'X';
    static final char O_CHAR = 'O';
    static char player;

    static int[] lastMove;
    static int moveCount;

    static ArrayList<int[]> availableMoves = new ArrayList<>(fieldSide * fieldSide);

    static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            emptyField();
            player = X_CHAR;
            for (moveCount = 0; moveCount < fieldSide * fieldSide; moveCount++) {
                printField();
                playerMove(player);
                if (checkWin()) {
                    System.out.printf("Player %c wins!%n", player);
                    break;
                }
                playerChange();
            }
            printField();
            if (moveCount == fieldSide * fieldSide) {
                System.out.println("Draw!");
            }
        } while (wannaPlay());
        SCANNER.close();
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
        availableMoves.removeIf(cell -> Arrays.equals(cell, move));
    }

    public static boolean checkWin() {
        boolean win = checkDiagonals(lastMove);
        win = checkRow(lastMove[0]) || win;
        win = checkColumn(lastMove[1]) || win;
        return win;
    }

    private static boolean isLeftDiagonal(int[] move) {
        return move[0] == move[1];
    }

    private static boolean isRightDiagonal(int[] move){
        return move[0] == (fieldSide - 1) - move[1];
    }
    
    private static boolean checkDiagonals(int[] move) {
        int row = move[0];
        int column = move[1];
        int leftLength = fieldSide - Math.abs(row - column);
        int left = 0;
        int maxLeft = 0;
        int rightLength = row + column + 1;
        rightLength = rightLength <= fieldSide ? rightLength : fieldSide - rightLength % fieldSide;
        int right = 0;
        int maxRight = 0;
        if (leftLength >= winCondition) {
            int rowStart = Math.max(row - column, 0);
            int columnStart = rowStart == 0 ? column - row : 0;
            for (int i = 0; i < leftLength; i++) {
                if (field[rowStart + i][columnStart + i] == player) left++;
                else {
                    maxLeft = Math.max(maxLeft, left);
                    left = 0;
                }
            }
        }
        if (rightLength >= winCondition) {
            int rowStart = row + column < fieldSide ? 0 : (row + column + 1) % fieldSide;
            int columnStart = rowStart == 0 ? row + column : fieldSide - 1;
            for (int i = 0; i < rightLength; i++) {
                if (field[rowStart + i][columnStart - i] == player) right++;
                else {
                    maxRight = Math.max(maxRight, right);
                    right = 0;
                }
            }
        }
        return Math.max(maxLeft, left) >= winCondition || Math.max(maxRight, right) >= winCondition;
    }

    private static boolean checkRow(int row) {
        int score = 0;
        int maxScore = 0;
        for (int i = 0; i < fieldSide; i++) {
            if (field[row][i] == player) score++;
            else {
                maxScore = Math.max(maxScore, score);
                score = 0;
            }
        }
        return Math.max(maxScore, score) >= winCondition;
    }

    private static boolean checkColumn(int column) {
        int score = 0;
        int maxScore = 0;
        for (int i = 0; i < fieldSide; i++) {
            if (field[i][column] == player) score++;
            else {
                maxScore = Math.max(maxScore, score);
                score = 0;
            }
        }
        return Math.max(maxScore, score) >= winCondition;
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
        return move;
    }

    private static int countPriority(int[] move) {
        int score = 0;
        if (isLeftDiagonal(move)) score += countLeftDiagonal() + 1;
        if (isRightDiagonal(move)) score += countRightDiagonal() + 1;
        score += countRowAndColumn(move);
        return score;
    }

    private static int countLeftDiagonal() {
        int oCount = 0;
        int xCount = 0;
        for (int i = 0; i < fieldSide; i++) {
            if (field[i][i] == X_CHAR ) xCount++;
            if (field[i][i] == O_CHAR) oCount++;
        }
        if (oCount == winCondition - 1) return fieldSide * fieldSide * fieldSide;
        if (xCount == winCondition - 1) return fieldSide * fieldSide;
        return Math.abs(xCount + oCount);
    }

    private static int countRightDiagonal() {
        int oCount = 0;
        int xCount = 0;
        for (int i = 0; i < fieldSide; i++) {
            if (field[i][(fieldSide - 1) - i] == X_CHAR) xCount++;
            if (field[i][(fieldSide - 1) - i] == O_CHAR) oCount++;
        }
        if (oCount == winCondition - 1) return fieldSide * fieldSide * fieldSide;
        if (xCount == winCondition - 1) return fieldSide * fieldSide;
        return xCount + oCount;
    }

    private static int countRowAndColumn(int[] move) {
        int row = move[0];
        int rowXCount = 0;
        int rowOCount = 0;
        int column = move[1];
        int colXCount = 0;
        int colOCount = 0;
        for (int i = 0; i < fieldSide; i++) {
            if (field[row][i] == X_CHAR) rowXCount++;
            if (field[row][i] == O_CHAR) rowOCount++;
            if (field[i][column] == X_CHAR) colXCount++;
            if (field[i][column] == O_CHAR) colOCount++;
        }
        if (rowOCount == winCondition - 1 || colOCount == winCondition - 1) return fieldSide * fieldSide * fieldSide;
        if (rowXCount == winCondition - 1 || colXCount == winCondition - 1) return fieldSide * fieldSide;
        return rowXCount + rowOCount + colXCount + colOCount;
    }


    public static boolean wannaPlay() {
        System.out.print("\nWanna play again? 1 - yes / 0 - no: ");
        return SCANNER.next().equals("1");
    }
}

