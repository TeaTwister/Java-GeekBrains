import homework5.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class Homework5Test {
    static final int SIZE = 1_000_000;
    static float[] single = new float[SIZE];
    static float[] multi = new float[SIZE];

    @BeforeClass
    public static void setSingle() {
        Arrays.fill(single, 1f);
        Main.singleThread(single);
    }

    @Before
    public void setMulti() {
        Arrays.fill(multi, 1f);
    }

    @Test
    public void testEqualTwoThreads() {
        Main.multiThread(multi, 2);
        Assert.assertArrayEquals(single, multi, 0);
    }

    @Test
    public void testEqualThreeThreads() {
        Main.multiThread(multi, 3);
        Assert.assertArrayEquals(single, multi, 0);
    }
}
