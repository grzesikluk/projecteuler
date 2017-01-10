package eulerproject.level3.problem65;

import eulerproject.tools.fractions.BigFraction;

import java.util.List;

import static eulerproject.tools.fractions.ContinuedFraction.*;

/**
 * Created by Lukasz on 2016-11-07.
 */
public class Solution {
    public static final int MAX = 100;

    public static void main(String[] args) {

        List<Integer> convs = getConvergentsListForEulerConstant(MAX);

        BigFraction next = getConvergentValue(convs,100);

        System.out.println(next);
        System.out.println(sumOfDigits(next.getNominator().toString()));

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
