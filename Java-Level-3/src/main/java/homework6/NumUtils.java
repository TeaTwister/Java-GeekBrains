package homework6;

public class NumUtils {
    public static int[] getNumberAfterLastFour(int[] input) {
        int length = 0;
        int i;
        for (i = input.length - 1; i >= 0; i--) {
            if (input[i] == 4) break;
            length++;
        }
        if (i == -1) throw new RuntimeException("There is no 4 in provided array");
        i++;
        int[] output = new int[length];
        for (; i < input.length; i++) {
            int j = length + i - input.length;
            output[j] = input[i];
        }
        return output;
    }

    public static boolean containsOnlyOnesAndFours(int[] array) {
        boolean containsOne = false;
        boolean containsFour = false;
        for (int i : array) {
            if (i != 1 && i != 4) return false;
            else if (!containsOne && i == 1) containsOne = true;
            else if (!containsFour && i == 4) containsFour = true;
        }
        return containsOne && containsFour;
    }
}
