package eulerproject.problem44;

import java.time.LocalTime;

/**
 * Created by Lukasz on 2016-08-28.
 */
public class Solution {

    private static void timeNow(){
        System.out.println(LocalTime.now());
    }

    private static final int MAX = 100000;
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

    public static boolean isPentagon(long i) {
        for (long val : pentagons)
            if (val == i) return true;
            else if (val > i) return false;

        return false;
    }

    public static long getNextPentagon(long i) {
        for (long k = i + 1; k < MAX; k++)
            if (isPentagon(k))
                return k;
        return MAX;
    }


    public static boolean conditionFirst(int a, int b) {
        if (a != b)
            return (isPentagon(Math.abs(pentagons[a] - pentagons[b])) &&
                    isPentagon(Math.abs(pentagons[a] + pentagons[b])));
        else
            return false;
    }

    public static long getDiff(int a, int b) {
        return Math.abs(pentagons[a] - pentagons[b]);
    }

    /**
     * Searching should start from first index i up to some distance (can be maximum). If the condition is fulfilled
     * then the max distance should be updated accordingly. Further searching should be performed until the end.
     *
     * Maximum pentagonal should be determined by the distances. The two consecutive pentagonals should have difference
     * less that the distance.
     *
     * @param args
     */
    public static void main(String[] args) {
        int dist = 1040;

        for (int i = 1; i < MAX; i++) {
            for (int j = i+1; j < i + dist && j < MAX; j++) {
                if (conditionFirst(i, j)) {
                    System.out.println(printHelp(i) + " " + printHelp(j) + " " + getDiff(i, j));
                    dist = j-i;
                    continue;
                }
            }

        }
        timeNow();
    }
    private static String printHelp(int k) {
        return "P["+k+"] = "+pentagons[k];
    }

}
