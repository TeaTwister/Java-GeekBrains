import homework2.Main;
import homework2.MyArrayDataException;
import homework2.MyArraySizeException;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Homework2Test {

    public static void fillWithOnes(String[][] array) {
        for (String[] strings : array) {
            Arrays.fill(strings, "1");
        }
    }

    @Test
    public void testSizeException() {
        String[][] array;
        for (int i = 3; i <= 5; i++) {
            for (int j = 3; j <= 5 ; j++) {
                array = new String[i][j];
                fillWithOnes(array);
                if (!(i == 4 && j == 4)) {
                    String[][] finalArray = array;
                    assertThrows(MyArraySizeException.class,
                            () -> Main.arraySum(finalArray));
                } else {
                    assertEquals(16, Main.arraySum(array));
                }
            }
        }
    }

    @Test
    public void testDataException() {
        String[][] array = new String[4][4];
        fillWithOnes(array);
        array[1][3] = "s";
        Exception e = assertThrows(MyArrayDataException.class,
                () -> Main.arraySum(array));
        String[] message = e.getMessage()
                .replaceAll("\\D", " ")
                .trim()
                .split(" +");
        assertEquals(1, Integer.parseInt(message[0]));
        assertEquals(3, Integer.parseInt(message[1]));
    }
}
