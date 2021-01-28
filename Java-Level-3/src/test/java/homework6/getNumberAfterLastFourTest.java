package homework6;

import junit.framework.TestCase;
import org.junit.Assert;

public class getNumberAfterLastFourTest extends TestCase {
    public void test() {
        int[] array = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] expected = {1, 7};
        int[] actual = NumUtils.getNumberAfterLastFour(array);
        Assert.assertArrayEquals(expected, actual);
    }

    public void testFirstFour() {
        int[] array = {4, 2, 2, 3, 1, 7};
        int[] expected = {2, 2, 3, 1, 7};
        int[] actual = NumUtils.getNumberAfterLastFour(array);
        Assert.assertArrayEquals(expected, actual);
    }

    public void testLastFour() {
        int[] array = {4, 2, 2, 3, 1, 4};
        int[] expected = {};
        int[] actual = NumUtils.getNumberAfterLastFour(array);
        Assert.assertArrayEquals(expected, actual);
    }

    public void testOnlyFour() {
        int[] array = {4};
        int[] expected = {};
        int[] actual = NumUtils.getNumberAfterLastFour(array);
        Assert.assertArrayEquals(expected, actual);
    }

    public void testNoFour() {
        int[] array = {2, 2, 3, 1};
        Assert.assertThrows(RuntimeException.class, () -> NumUtils.getNumberAfterLastFour(array));
    }
}