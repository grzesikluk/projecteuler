package eulerproject.level3.problem72;


import eulerproject.tools.fractions.Fraction;
import eulerproject.tools.functions.EulersTotient;
import eulerproject.tools.primes.Primes;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int MAX = 1000000;

    public static void main(String[] args) {

        int[] primes = new Primes(MAX).toArray();
        System.out.println(EulersTotient.sumOfEulersTotientFunction(MAX +1,primes)-1);

//        System.out.println(initFractionArray(MAX).size()); -- that will take forever

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
