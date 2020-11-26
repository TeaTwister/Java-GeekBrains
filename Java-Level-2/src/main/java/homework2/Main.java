package homework2;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        String[][][] testArray = new String[3][][];
        testArray[0] = new String[1][5];
        testArray[1] = new String[4][4];
        testArray[2] = new String[4][4];
        for (int i = 0; i < testArray[2].length; i++) {
            for (int j = 0; j < testArray[2][i].length; j++) {
                testArray[2][i][j] = String.format("%d", i * j);
            }
        }
        for (String[][] array : testArray) {
            try {
                System.out.println(arraySum(array));
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int arraySum(String[][] array) {
        final int SIZE = 4;
        if (array.length == SIZE) {
            for (int i = 0; i < SIZE; i++) {
                if (array[i].length != SIZE) throw new MyArraySizeException(SIZE);
            }
        } else throw new MyArraySizeException(SIZE);
        int sum = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                try {
                    sum += parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
