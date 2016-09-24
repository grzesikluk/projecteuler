package eulerproject.level3.problem58;

/**
 * Created by Lukasz on 2016-09-19.
 */
public class Solution {

    private static final int MAX = 30001;
    private static final double THRESHOLD = 0.1;

    public static void main(String[] args) {
        SpiralNumberArrayDiagonal spiralArray = new SpiralNumberArrayDiagonal(MAX);

        int k =3;
        double result =0;
        while(k<MAX) {
            if ((result=spiralArray.getPrimeRatioOnDiagonals(k))< THRESHOLD) {
                System.out.println(k);
                System.out.println(result);
                System.exit(0); ;
            }
            k+=2;
        }

    }


}