package eulerproject.problem44;

import java.time.LocalTime;

/**
 * Created by Lukasz on 2016-08-28.
 */
public class Solution {

    private static void timeNow() {
        System.out.println(LocalTime.now());
    }

    private static final int MAX = 5000;
    private static final int MIN = 1000;

    private static long[] pentagons = new long[MAX];

    static {
        timeNow();
        for (int k = 0; k < MAX; k++)
            pentagons[k] = getPentagon(k);
        System.out.println("Init finished");
    }


    public static long getPentagon(long i) {
        return i * (3 * i - 1) / 2;
    }

    public static boolean isPentagon(long value) {
        int index = 0;
        //jump to index maximum but less that pent[i]

        while (index < MAX ) {
            if (pentagons[index] == value) return true;
            else if (pentagons[index] > value) return false;
            index++;
        }
        return false;
    }

    public static long getNextPentagon(long i) {
        for (long k = i + 1; k < MAX; k++)
            if (isPentagon(k))
                return k;
        return MAX;
    }


    public static boolean checkCondition(int a, int b) {
        if (a != b)
            return (isPentagon(Math.abs(pentagons[a] - pentagons[b])) &&
                    isPentagon(Math.abs(pentagons[a] + pentagons[b])));
        else
            return false;
    }

    public static boolean checkConditionTest(int a, int b) {
        if (a != b)
            return isPentagon(Math.abs(pentagons[a] + pentagons[b]));
        else
            return false;
    }


    public static long getDiff(int a, int b) {
        return Math.abs(pentagons[a] - pentagons[b]);
    }

    /**
     * Searching should start from first index i up to some distance (can be maximum). If the condition is fulfilled
     * then the max distance should be updated accordingly. Further searching should be performed until the end.
     * <p>
     * Maximum pentagonal should be determined by the distances. The two consecutive pentagonals should have difference
     * less that the distance.
     *
     * @param args
     */
    public static void main(String[] args) {
        int dist = MAX;
        long diff = pentagons[MAX-1];

        for (int i = MIN; i < MAX; i++) {
            for (int j = i + 1; j < i + dist && j < MAX - 1 && getDiff(j, j + 1) < diff; j++) {
                if (checkCondition(i, j)) {

                    diff = getDiff(i, j);
                    dist = j - i; //update distance accordingly
                    System.out.println("Progress " + (float) i * 100 / (float) MAX + "%");
                    System.out.println(printHelp(i) + " " + printHelp(j) + " diff " + getDiff(i, j));

                    continue;
                }
            }
        }
        timeNow();
    }

    private static String printHelp(int k) {
        return "P[" + k + "] = " + pentagons[k];
    }

}
