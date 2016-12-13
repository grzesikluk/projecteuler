package eulerproject.level3.problem71;

import eulerproject.tools.fractions.Fraction;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-12-13.
 */
public class Solution {
    private static final int MAX = 10000;
    private static Set<Fraction> fractions;
    private static Fraction searchedFraction = new Fraction(3, 7);
    private static Fraction lowerBoundaryFraction = new Fraction(2, 7);

    public static void main(String[] args) {
        initFractionArray();
        System.out.println(fractions.size());
        System.out.println(getResult());

    }

    public static void initFractionArray() {
        fractions = new TreeSet<>();
        Fraction newFraction;

        for (int denominator = 2; denominator <= MAX; denominator++) {
            for (int nominator = 1; nominator < denominator; nominator++) {

                newFraction = new Fraction(nominator, denominator);

                if (newFraction.compareTo(searchedFraction) > 0)
                    break;

                if (isInProperRange(newFraction)) {
                    if (newFraction.getHighestCommonFraction() == 1) {
                        fractions.add(new Fraction(nominator, denominator));
                        lowerBoundaryFraction = newFraction;

                    }

                }


            }
        }

    }

    public static Fraction getResult() {
        List<Fraction> fractionsList = fractions.stream().collect(Collectors.toList());
        return fractionsList.get(fractionsList.size() - 1);
    }

    public static boolean isInProperRange(Fraction fraction) {
        return fraction.compareTo(lowerBoundaryFraction) > 0 ;
    }

}
