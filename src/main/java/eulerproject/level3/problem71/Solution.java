package eulerproject.level3.problem71;

import eulerproject.tools.fractions.Fraction;
import eulerproject.tools.primes.Primes;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-12-13.
 */
public class Solution {
    private static final int MAX = 1_000_000;
    private static Set<Fraction> fractions;
    private static Fraction searchedFraction = new Fraction(3, 7);
    private static Fraction lowerBoundaryFraction = new Fraction(2, 7);
    private static Primes primes;

    static {
        primes = new Primes(MAX / 2);
        primes.init();
    }

    public static void main(String[] args) {
        initFractionArray();
        System.out.println(fractions.size());
        System.out.println(getResult());


//        for(int i=0;i<MAX;i++) {
//            if(i%1000 == 0)
//            System.out.println(i + " " + PrimeFactorization.getPrimeFactors(i,primes));
//        }

    }

    public static void initFractionArray() {
        fractions = new TreeSet<>();
        Fraction newFraction;

        for (int denominator = 2; denominator <= MAX; denominator++) {

            for (int nominator = getNominatorMinValue(denominator); nominator < getNominatorMaxValue(denominator); nominator++) {

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
        return fractionsList.get(fractionsList.size() - 1);
    }

    public static boolean isInProperRange(Fraction fraction) {
        return fraction.compareTo(lowerBoundaryFraction) > 0;
    }


    public static int getNominatorMinValue(int denominator) {
        return 1;
    }

    public static int getNominatorMaxValue(int denominator) {
        return denominator;
    }


}
