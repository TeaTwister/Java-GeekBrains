package homework2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int i, int j) {
        super(String.format("Illegal number format @[%d][%d]%n", i, j));
    }
}
