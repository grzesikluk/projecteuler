package eulerproject.level3.problem72;


import eulerproject.tools.fractions.Fraction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lukasz on 2016-12-13.
 */
public class Solution {
    private static final int MAX = 100;

    public static void main(String[] args) {

        for(int i=1;i<MAX;i++)
            System.out.println(initFractionArray(i).size());

    }

    public static List<Fraction> initFractionArray(int max) {
        Fraction newFraction;
        List<Fraction> result = new ArrayList<>();

        for (int denominator = 2; denominator <= max; denominator++) {
            for (int nominator = 1; nominator < denominator; nominator++) {
                newFraction = new Fraction(nominator, denominator);

                if (newFraction.isReducedProperFraction())
                    result.add(newFraction);
            }
        }
        return result;

    }




}
