package eulerproject.level3.problem85;

/**
 * Created by grzesikl on 23/02/2017.
 */
public class Solution {
    public final static int MAX = 1000;
    public final static int SEARCHED = 2000_000;

    public static void main(String[] args) {
        long mFound = 1;
        long nFound = 1;
        long distance = SEARCHED;

        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                long noRect = getNoOfRectangles(i, j);

                if (distance > calcDistance(noRect)) {
                    mFound = i; nFound = j; //store both
                    distance = calcDistance(noRect);
                }
            }
        }

        System.out.println("Result: " + mFound + " " + nFound + " " +mFound * nFound);
    }

    public static long getNoOfRectangles(long m, long n) {
        return m * (m + 1) * n * (n + 1) / 4;
    }

    public static long calcDistance(long dist) {
        return Math.abs(SEARCHED - dist);
    }
}
