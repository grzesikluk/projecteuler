package eulerproject.newest.problem583;

/**
 * Created by Lukasz on 2016-12-24.
 */
public class Solution {
    private static final int MAX_PERIMETER = 10000;
    private static long result = 0;


    public static void main(String[] args) {

        for (int x = 1; x < MAX_PERIMETER/2; x++)
            for (int y = 1; y < (MAX_PERIMETER-2*x)/2; y++) {

                for (int flap = x / 2; flap < y*2; flap++) {
                    HeronEnvelope heronEnvelope = new HeronEnvelope(x, y, flap);

                    if (heronEnvelope.checkIfProperEnv()) {
                        if (heronEnvelope.getPerimeter() <= MAX_PERIMETER && heronEnvelope.checkIfAllDiagonalsIntegral() ) {
                            System.out.println(heronEnvelope);
                            result+=heronEnvelope.getPerimeter();
                        }
                    } else {
                        break;
                    }
                }


            }
        System.out.println(result);

    }
}
