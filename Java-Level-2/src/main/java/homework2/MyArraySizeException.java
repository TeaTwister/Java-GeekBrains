package homework2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(int expectedSize) {
        super(String.format("The array is not of expected square %d size", expectedSize));
    }
}
