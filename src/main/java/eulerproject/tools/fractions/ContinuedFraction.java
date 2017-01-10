package eulerproject.tools.fractions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lukasz on 2017-01-10.
 */
public class ContinuedFraction {


    public static List<Integer> getConvergentsListForEulerConstant(int max) {
        List<Integer> result = new LinkedList<>();

        result.add(new Integer(2));

        int i = 1;
        int k = 1;

        while (i < max) {
            if ((i + 1) % 3 == 0) {
                result.add(new Integer(2 * k));
                k++;
            } else
                result.add(new Integer(1));
            i++;
        }

        return result;
    }


    private static BigFraction getNextPart(Integer conv, BigFraction input) {
        BigFraction result = new BigFraction(new BigInteger(conv.toString()), new BigInteger("1"));

        result = result.add(input);
        result = result.simplifyFraction();
        result = result.revertFraction();

        return result;

    }

    public static List<Integer> getConvergentsForNSqrt(int S, int limit) {

        int l = limit-1;
        List<Integer> result = new ArrayList<>();

        int m =0 ;
        int d = 1;
        int s = (int) Math.floor(Math.sqrt(S));

        result.add(s);

        int[] vector = new int[]{m,S,d,s};

        while (l > 0) {
            vector = getNextFractionFactorForNSqrt(vector);
            if(vector!=null)
                result.add(vector[3]);
            else
                break;

            l--;
        }

        return result;

    }


    private static int[] getNextFractionFactorForNSqrt(int[] input) {
        int m = input[0];
        int S = input[1];
        int d = input[2];
        int a = input[3];

        int[] result = new int[4];

        int nextM = d * a - m;
        int nextD = (S - nextM * nextM) / d;

        if(nextD == 0)
            return null; //finish

        int floorS = (int) Math.floor(Math.sqrt(S));
        int nextA = (int) Math.floor((floorS + nextM) / nextD);

        //msda
        result[0] = nextM;
        result[1] = S;
        result[2] = nextD;
        result[3] = nextA;

        return result;

    }

    public static List<Integer> getConvergents(double N, int limit) {
        List<Integer> result = new ArrayList<>();

        int tmp = 0;
        int k = 0;
        double tempN = N;

        while (k < limit) {
            tmp = (int) Math.floor(tempN);

            result.add(new Integer(tmp));
            if ((tempN - tmp) == 0)
                break;

            tempN = 1 / (tempN - tmp);

            k++;
        }

        return result;
    }

    public static BigFraction getConvergentValue(List<Integer> convs, int N) {
        int i = N;

        BigFraction next = new BigFraction(new BigInteger("1"), new BigInteger(convs.get(i).toString()));

        while (i-- > 0)
            next = getNextPart(convs.get(i), next);

        return next.revertFraction();
    }

}
