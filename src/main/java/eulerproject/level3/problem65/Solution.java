package eulerproject.level3.problem65;

import eulerproject.tools.fractions.BigFraction;

import java.math.BigInteger;
import java.util.List;

import static eulerproject.tools.functions.ContinuedFraction.getConvergentsListForEulerConstant;
import static eulerproject.tools.functions.ContinuedFraction.getNextPart;

/**
 * Created by Lukasz on 2016-11-07.
 */
public class Solution {
    public static final int MAX = 100;

    public static void main(String[] args) {

        List<Integer> convs = getConvergentsListForEulerConstant(MAX);

        int i = convs.size() - 1;

        BigFraction next = new BigFraction(new BigInteger("1"), new BigInteger(convs.get(i).toString()));

        while (i-- > 0) {
            next = getNextPart(convs.get(i), next);
//            System.out.println(next);
        }
        System.out.println(next.revertFraction());
        System.out.println(sumOfDigits(next.revertFraction().getNominator().toString()));

    }


    private static int sumOfDigits(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result += (int) (c - 48);
        }
        return result;

    }


}
