package eulerproject.level3.problem73;

import eulerproject.tools.fractions.Fraction;
import eulerproject.tools.primes.Primes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lukasz on 2016-12-13.
 */
public class Solution {
    private static final int MAX = 12000;
    private static Fraction searchedFraction = new Fraction(1, 2);  //0,42857142857142857142857142857143
    private static Fraction lowerBoundaryFraction = new Fraction(1, 3);
    private static Primes primes;
    private static Set<Fraction> fractionSet;

    static {
        primes = new Primes(MAX / 2);
        primes.init();
    }

    public static void main(String[] args) {
        System.out.println("Starting " + new Date());
        initFractionArray();
        System.out.println(getResult());
        System.out.println("End " + new Date());

    }

    public static void initFractionArray() {
        Fraction newFraction;
        fractionSet = new HashSet<>();

        for (int denominator = 2; denominator < MAX; denominator++) {

            int minNominator = getNominatorMinValue(denominator, lowerBoundaryFraction);
            int maxNominator = getNominatorMaxValue(denominator, searchedFraction);

            for (int nominator = minNominator; nominator <= maxNominator; nominator++) {

                newFraction = new Fraction(nominator, denominator);

                if (newFraction.isReducedProperFraction())
                    fractionSet.add(newFraction);

            }
        }

    }

    public static long getResult() {
        return fractionSet.size();
    }


    public static int getNominatorMinValue(int denominator, Fraction limit) {
        int res = 1;

        if (denominator == limit.getDenominator())
            return (int) limit.getNominator() - 1;

        while (res * limit.getDenominator() < limit.getNominator() * denominator)
            res++;

        return res - 1;
    }

    public static int getNominatorMaxValue(int denominator, Fraction limit) {
        int res = 1;

        while (res * limit.getDenominator() < limit.getNominator() * denominator)
            res++;

        return res - 1;
    }


}
