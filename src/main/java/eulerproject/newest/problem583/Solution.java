package eulerproject.newest.problem583;

/**
 * Created by Lukasz on 2016-12-24.
 */
public class Solution {
    private static final int MAX_PERIMETER = 10000;


    public static void main(String[] args) {
        long resultOld1=0, resultOld2=0;

        for (int i = 2000; i < 3000; i++) {

            resultOld1 = getSolution(i);
            if(resultOld1 != resultOld2) {
                System.out.println(i + " " + (resultOld1));
                resultOld2 = resultOld1;
            }

        }

    }

    public static int getSolution(int max) {
        int result = 0;

        for (int x = 1; x < max / 2; x++)
            for (int y = 1; y < (max - 2 * x) / 2; y++) {
                int maxZ = (int) Math.sqrt(x * x / 4 + y * y);

                for (int z = x / 2; z <= maxZ && 2*z+2*y+x <= max; z++) {
                    HeronEnvelope heronEnvelope = new HeronEnvelope(x, y, z);

                    if ( heronEnvelope.checkIfAllDiagonalsIntegral())
                        result += heronEnvelope.getPerimeter();
                }


            }
        return result;
    }

}
