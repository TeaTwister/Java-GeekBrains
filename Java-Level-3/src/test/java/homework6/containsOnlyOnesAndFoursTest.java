package homework6;

import junit.framework.TestCase;
import org.junit.Assert;

public class containsOnlyOnesAndFoursTest extends TestCase {
    public void test() {
        int[] array = {1, 1, 1, 4, 4, 1, 4, 4};
        Assert.assertTrue(NumUtils.containsOnlyOnesAndFours(array));
    }

    public void testNoOnes() {
        int[] array = {4, 4};
        Assert.assertFalse(NumUtils.containsOnlyOnesAndFours(array));
    }

    public void testNoFours() {
        int[] array = {1, 1};
        Assert.assertFalse(NumUtils.containsOnlyOnesAndFours(array));
    }

    public void testOnePair() {
        int[] array = {1, 4};
        Assert.assertTrue(NumUtils.containsOnlyOnesAndFours(array));
    }

    public void testDifferentNumber() {
        int[] array = {7, 1, 4};
        Assert.assertFalse(NumUtils.containsOnlyOnesAndFours(array));
    }
}