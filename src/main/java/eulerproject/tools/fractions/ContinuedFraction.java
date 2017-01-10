package eulerproject.tools.fractions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lukasz on 2017-01-10.
 */
public class ContinuedFraction {


    public static List<Integer> getPartialQuotientsForEulerConstant(int max) {
        List<Integer> partialQuotients = new LinkedList<>();

        partialQuotients.add(new Integer(2));

        int i = 1;
        int k = 1;

        while (i < max) {
            if ((i + 1) % 3 == 0) {
                partialQuotients.add(new Integer(2 * k));
                k++;
            } else
                partialQuotients.add(new Integer(1));
            i++;
        }

        return partialQuotients;
    }

    public static List<Integer> getPartialQuotientsForQuadraticSurd(int S, int limit) {

        int l = limit - 1;
        List<Integer> result = new ArrayList<>();

        int m = 0;
        int d = 1;
        int a = (int) Math.floor(Math.sqrt(S));
        int floorS = (int) Math.floor(Math.sqrt(S));

        result.add(a);

        while (l > 0) {

            m = d * a - m;
            d = (S - m * m) / d;

            if (d == 0)
                break; //finish

            a = (int) Math.floor((floorS + m) / d);

            result.add(a);

            l--;
        }

        return result;

    }

    public static List<Integer> getPartialQuotientsForNumber(double N, int limit) {
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

    public static BigFraction getConvergent(List<Integer> convs, int N) {
        int i = N;

        if(N >= convs.size())
            throw new IllegalArgumentException("N value is too big.");

        BigFraction next = new BigFraction(new BigInteger("1"), new BigInteger(convs.get(i).toString()));

        while (i-- > 0)
            next = getNextPart(convs.get(i), next);

        return next.revertFraction();
    }

    private static BigFraction getNextPart(Integer conv, BigFraction input) {
        BigFraction result = new BigFraction(new BigInteger(conv.toString()), new BigInteger("1"));

        return result.add(input).simplifyFraction().revertFraction();

    }

}
