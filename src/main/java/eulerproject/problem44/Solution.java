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
    private static final int MIN = 10000;

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


    public static boolean checkCondition(int a, int b) {
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
        int dist = 2167-1019;
        long diff = 5482659;


        for (int i = MIN; i < MAX; i++) {
            for (int j = i+1; j < i + dist && j < MAX-1 && getDiff(j, j+1)< diff; j++) {
                if (checkCondition(i, j)) {

                    diff = getDiff(i,j);
                    dist = j-i; //update distance accordingly
                    System.out.println("Progress " + (float)i*100/(float)MAX + "%");
                    System.out.println(printHelp(i) + " " + printHelp(j) + " diff " + getDiff(i, j));

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
