package eulerproject.tools.fractions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grzesikl on 08/11/2016.
 * <p>
 * The factor is An = An-1, 1/(sqrt(square)-denomNumber))
 * <p>
 * https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Continued_fraction_expansion
 */
public class SquareRootContinuedFraction {
    private int S;

    public SquareRootContinuedFraction(int S) {
        this.S = S;
    }

    public List<Integer> getFactors(int limit) {
        int l = limit-1;
        List<Integer> result = new ArrayList<>();


        int m =0 ;
        int S = this.S;
        int d = 1;
        int s = (int) Math.floor(Math.sqrt(S));

        result.add(s);

        int[] vector = new int[]{m,S,d,s};

        while (l > 0) {
            vector = getNextFractionFactor(vector);
            result.add(vector[3]);

            l--;
        }

        return result;
    }


    public int[] getNextFractionFactor(int[] input) {
        int m = input[0];
        int S = input[1];
        int d = input[2];
        int a = input[3];

        int[] result = new int[4];

        int nextM = d * a - m;
        int nextD = (S - nextM * nextM) / d;
        int floorS = (int) Math.floor(Math.sqrt(S));
        int nextA = (int) Math.floor((floorS + nextM) / nextD);

        //msda
        result[0] = nextM;
        result[1] = S;
        result[2] = nextD;
        result[3] = nextA;

        return result;

    }

}
