package eulerproject.tools.functions;

import eulerproject.tools.fractions.BigFraction;

import java.math.BigInteger;
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


    /**
     * Return 1/(conv + fraction)
     *
     * @param conv
     * @param input
     * @return
     */
    public static BigFraction getNextPart(Integer conv, BigFraction input) {
        BigFraction result = new BigFraction(new BigInteger(conv.toString()), new BigInteger("1"));

        result = result.add(input);
        result = result.simplifyFraction();
        result = result.revertFraction();

        return result;

    }
}
