package eulerproject.level3.problem71;

import eulerproject.tools.fractions.Fraction;
import eulerproject.tools.primes.Primes;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-12-13.
 */
public class Solution {
    private static final int MAX = 100;
    private static Set<Fraction> fractions;
    private static Fraction searchedFraction = new Fraction(3, 7);
    private static Fraction lowerBoundaryFraction = new Fraction(2, 7);
    private static Primes primes;

    static {
        primes = new Primes(MAX / 2);
        primes.init();
    }

    public static void main(String[] args) {
        System.out.println("Starting " + new Date());
        initFractionArray();
        System.out.println(fractions.size());
        System.out.println(getResult());
        System.out.println("End " + new Date());

    }

    public static void initFractionArray() {
        fractions = new TreeSet<>();
        Fraction newFraction;

        for (int denominator = 2; denominator <= MAX; denominator++) {
            int minNominator = getNominatorMinValue(denominator, lowerBoundaryFraction);
            int maxNominator = getNominatorMaxValue(denominator, searchedFraction);

            for (int nominator = minNominator; nominator <= maxNominator; nominator++) {

                newFraction = new Fraction(nominator, denominator);

                if (newFraction.isReducedProperFraction()) {
                    fractions.add(new Fraction(nominator, denominator));
                    lowerBoundaryFraction = newFraction;

                }

            }
        }

    }

    public static Fraction getResult() {
        List<Fraction> fractionsList = fractions.stream().collect(Collectors.toList());
        return fractionsList.get(fractionsList.size() - 2);
    }


    public static int getNominatorMinValue(int denominator, Fraction limit) {
        int res = 1;

        if(denominator == limit.getDenominator())
            return (int)limit.getNominator();

        while( res < limit.getNominator() * denominator / limit.getDenominator())
            res++;

        return res+1;
    }

    public static int getNominatorMaxValue(int denominator, Fraction limit) {
        int res = 1;

        if(denominator == limit.getDenominator())
            return (int)limit.getNominator();

        while( res < limit.getNominator() * denominator / limit.getDenominator())
            res++;

        return res;
    }


}
