public class TicTacToe {
    public static int fieldSide;
    static char[][] field;

    public static void main(String[] args) {
        fieldSide = 3;
        field = emptyField(fieldSide);

    }

    private static char[][] emptyField(int side) {
        field = new char[side][side];
    }
}
