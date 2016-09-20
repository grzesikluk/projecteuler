package eulerproject.level3.problem58;

/**
 * Created by Lukasz on 2016-09-19.
 */
public class Solution {

    private static final int MIN = 3957;
    private static final int MAX = 10000;
    private static final double THRESHOLD = 0.1;

    public static void main(String[] args) {
        int k = MIN;
        while(k<MAX) {
            if (new SpiralNumberArray(k).getPrimeRatioOnDiagonals(k)< THRESHOLD) {
                System.out.println(k);
                break;
            }
            k+=2;
            System.out.println((double)k/(double)MAX);
        }

    }


}