package eulerproject.level3.problem71;

import eulerproject.tools.fractions.Fraction;
import eulerproject.tools.primes.Primes;

import java.util.Date;

/**
 * Created by Lukasz on 2016-12-13.
 */
public class Solution {
    private static final int MAX = 1000000;
    private static Fraction searchedFraction = new Fraction(3, 7);  //0,42857142857142857142857142857143
    private static Fraction lowerBoundaryFraction = new Fraction(2, 7);
    private static Primes primes;

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

        for (int denominator = MAX-1; denominator > MAX/2; denominator--) {

            int minNominator = getNominatorMinValue(denominator, lowerBoundaryFraction);
            int maxNominator = getNominatorMaxValue(denominator, searchedFraction);

            for (int nominator = maxNominator; nominator >= minNominator; nominator--) {

                newFraction = new Fraction(nominator, denominator);

                if (newFraction.isReducedProperFraction()) {

                    if(lowerBoundaryFraction.compareTo(newFraction) < 0) {
                        lowerBoundaryFraction = newFraction;
                        System.out.println(lowerBoundaryFraction + " " + (double) lowerBoundaryFraction.getNominator() / lowerBoundaryFraction.getDenominator());
                    }

                }

            }
        }

    }

    public static long getResult() {
        return lowerBoundaryFraction.getNominator();
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

        return res-1;
    }


}
