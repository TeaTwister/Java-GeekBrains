import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {


        int[] onesZeroes = new int[10];
        for (int i = 0; i < onesZeroes.length; i++) {
            onesZeroes[i] = (int) (Math.random() * 2);
        }
        System.out.println(Arrays.toString(onesZeroes));
        for (int i = 0; i < onesZeroes.length; i++) {
            onesZeroes[i] = 1 - onesZeroes[i];
        }
        System.out.println(Arrays.toString(onesZeroes));
        System.out.println();


        int[] multiplesOf3 = new int[8];
        for (int i = 0; i < multiplesOf3.length; i++) {
            multiplesOf3[i] = i * 3;
        }
        System.out.println(Arrays.toString(multiplesOf3));
        System.out.println();


        int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] *= numbers[i] < 6 ? 2 : 1;
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println();


        int side = 10;
        int[][] onesZeroes2D = new int[side][side];
        for (int i = 0; i < onesZeroes2D.length; i++) {
            onesZeroes2D[i][i] = onesZeroes2D[i][onesZeroes2D.length - 1 - i] = 1;
        }
        for (int i = 0; i < onesZeroes2D.length; i++) {
            for (int j = 0; j < onesZeroes2D.length; j++) {
                System.out.printf("%2d", onesZeroes2D[i][j]);
            }
            System.out.println();
        }
        System.out.println();


        int[] searchForMinMaxHere = new int[10];
        for (int i = 0; i < searchForMinMaxHere.length; i++) {
            searchForMinMaxHere[i] = (int) (Math.random() * 200 - 100);
        }
        int max = searchForMinMaxHere[0];
        int min = searchForMinMaxHere[0];
        System.out.println(Arrays.toString(searchForMinMaxHere));
        for (int candidate : searchForMinMaxHere) {
            max = candidate > max ? candidate : max;
            min = candidate < min ? candidate : min;

        }
        System.out.printf("Maximum is %d, minimum is %d%n", max, min);
        System.out.println();


        int[] checkBalanceHere1 = {1, 1, 1, 2, 1};
        System.out.println(checkBalance(checkBalanceHere1));
        int[] checkBalanceHere2 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(checkBalanceHere2));
        int[] checkBalanceHere3 = {5, 6, 7, 8, 9};
        System.out.println(checkBalance(checkBalanceHere3));
        System.out.println();


        int[] shiftIt = new int[9];
        for (int i = 0; i < shiftIt.length; i++) {
            shiftIt[i] = i + 1;
        }
        System.out.println(Arrays.toString(shiftIt));
        shiftByAmount(shiftIt, -200);
        System.out.println(Arrays.toString(shiftIt));
        shiftByAmount(shiftIt, 200);
        System.out.println(Arrays.toString(shiftIt));

    }


    public static boolean checkBalance(int[] array) {
        int left = array[0], right = array[1];
        for (int i = 2; i < array.length; i++) {
            right += array[i];
        }
        for (int i = 1; i < array.length; i++) {
            if (left == right) {
                return true;
            }
            left += array[i];
            right -= array[i];
        }
        return false;
    }


    public static void shiftByAmount(int[] array, int shift) {
        int shiftCount, iterations;
        int shiftActual = shift % array.length;
        if (shiftActual == 0) {
            return;
        }
        if (array.length % shiftActual == 0) {
            shiftCount = Math.abs(shiftActual);
        } else {
            shiftCount = 1;
        }
        iterations = array.length / shiftCount;
        for (int i = 0; i < shiftCount; i++) {
            int index = i;
            int storage = array[i];
            for (int j = 1; j < iterations; j++) {
                int shiftFrom = (index - shiftActual + array.length) % array.length;
                array[index] = array[shiftFrom];
                index = shiftFrom;
            }
            array[index] = storage;
        }
    }
}
