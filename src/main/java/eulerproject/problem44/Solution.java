package eulerproject.problem44;

/**
 * Created by Lukasz on 2016-08-28.
 */
public class Solution {

    private static final int MAX = 10000000;
    private static final int MIN_DIST = 1;
    private static final int MAX_DIST = 2;

    private static long[] pentagons = new long[MAX];

    static {
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

    public static boolean conditionFirst(int a, int b) {
        if (a != b)
            return (isPentagon(Math.abs(pentagons[a] - pentagons[b])) && isPentagon(Math.abs(pentagons[a] + pentagons[b])));
        else
            return false;
    }

    public static long getDiff(int a, int b) {
        return Math.abs(pentagons[a] - pentagons[b]);
    }

    public static void main(String[] args) {

        for (int dist = MIN_DIST; dist < MAX_DIST; dist++) {


            for (int i = 1; i < MAX-dist; i++) {
                if (conditionFirst(i, i + dist)) {
                    System.out.println("Dist is " + dist);
                    System.out.println(" for i=" + i + "j = " + i + dist + " diff is " + getDiff(i, i + dist));
                }
            }

        }
    }


}
