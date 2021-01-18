package homework5;

import java.util.Arrays;

public class Main {
    static final int SIZE = 1_000_000;

    public static void main(String[] args) {
        float[] single = new float[SIZE];
        float[] multi = new float[SIZE];
        Arrays.fill(single, 1f);
        Arrays.fill(multi, 1f);
        singleThread(single);
        multiThread(multi, 8);
        System.out.println(Arrays.equals(single, multi));
    }

    public static void singleThread(float[] floats) {
        Thread t = new Thread(() -> process(floats));
        long startMillis = System.currentTimeMillis();
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long finMillis = System.currentTimeMillis();
        System.out.printf("Single thread time = %d%n", finMillis - startMillis);
    }

    static void process(float[] floats) {
        process(floats, 0);
    }

    static void process(float[] floats, int pos) {
        for (int i = 0; i < floats.length; i++) {
            floats[i] = (float)(floats[i]
                    * Math.sin(0.2f + (i + pos) / 5)
                    * Math.cos(0.2f + (i + pos) / 5)
                    * Math.cos(0.4f + (i + pos) / 2));
        }
    }

    public static void multiThread(float[] floats, int threadsCount) {
        int increment = floats.length / threadsCount;
        int remainder = floats.length % threadsCount;
        int pos;

        float[][] floatsDivided = new float[threadsCount][];
        pos = 0;
        long divideStartMillis = System.currentTimeMillis();
        for (int i = 0; i < threadsCount; i++) {
            int length = increment;
            if (i == 0) length += remainder;
            floatsDivided[i] = new float[length];
            System.arraycopy(floats, pos, floatsDivided[i], 0, length);
            pos += length;
        }
        long divideFinMillis = System.currentTimeMillis();

        Thread[] threads = new Thread[threadsCount];
        long[] threadsStartMillis = new long[threadsCount];
        long[] threadsFinMillis = new long[threadsCount];
        pos = 0;
        for (int i = 0; i < threadsCount; i++) {
            int finalPos = pos;
            int finalI = i;
            threads[i] = new Thread(() -> process(floatsDivided[finalI], finalPos));
            pos += increment;
            if (i == 0) pos += remainder;
            threadsStartMillis[i] = System.currentTimeMillis();
            threads[i].start();
        }
        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadsFinMillis[i] = System.currentTimeMillis();
        }

        pos = 0;
        long mergeStartMillis = System.currentTimeMillis();
        for (int i = 0; i < threadsCount; i++) {
            int length = floatsDivided[i].length;
            System.arraycopy(floatsDivided[i], 0, floats, pos, length);
            pos += length;
        }
        long mergeFinMillis = System.currentTimeMillis();

        System.out.printf("Multi thread time = %d%n" +
                "   Division time = %d%n" +
                "   Merge time = %d%n",
                mergeFinMillis - divideStartMillis,
                divideFinMillis - divideStartMillis,
                mergeFinMillis - mergeStartMillis);
        for (int i = 0; i < threadsCount; i++) {
            System.out.printf("   Thread %d time = %d%n", i + 1,
                    threadsFinMillis[i] - threadsStartMillis[i]);
        }
    }
}

