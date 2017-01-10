package eulerproject.level3.problem66;

import eulerproject.tools.fractions.BigFraction;
import eulerproject.tools.fractions.ContinuedFraction;
import eulerproject.tools.primes.Primes;
import javafx.util.Pair;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by grzesikl on 09/01/2017.
 */
public class Solution {
    private static final int CONV_LIMIT = 100;
    private static final int MAX = 1000;
    private static final Primes primes = new Primes(MAX);

    static {
        primes.init();
    }

    public static void main(String[] args) {
        System.out.println(getSolution(MAX));
    }

    private static BigInteger bigIntegerSqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength() / 2);
        BigInteger div2 = div;
        for (; ; ) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }

    public static int getSolution(int maxD) {
        BigInteger tempX = BigInteger.ZERO;
        int result = 1;

        for (int i = 2; i <= maxD; i = primes.getNextPrime(i)) {

            if (!isSquare(new BigInteger(Integer.toString(i)))) {
//                System.out.println("Checking no: " + i);
                Pair<BigInteger, BigInteger> pair = getPellsEquationSolution(i);

                if (pair == null)
                    throw new IllegalArgumentException("didnt found solution for i=" + i);
                else {
                    BigInteger x = pair.getKey();

                    if (x.compareTo(tempX) > 0) {
                        System.out.println(pair.getKey() + " " + pair.getValue() + " " + i);
                        tempX = x;
                        result = i;
                    }
                }
            }

        }

        return result;

    }

    public static boolean isSquare(BigInteger i) {
        return i.equals(bigIntegerSqrt(i).pow(2));
    }

    public static Pair<BigInteger, BigInteger> getPellsEquationSolution(int D) {
        List<Integer> convFractions = ContinuedFraction.getPartialQuotientsForQuadraticSurd(D, CONV_LIMIT);

        int r = ContinuedFraction.getPeriodOfPartialQuotients(convFractions) - 1;
        BigFraction convFraction;

        if (r % 2 == 0)
            convFraction = ContinuedFraction.getConvergent(convFractions, 2 * r + 1);
        else
            convFraction = ContinuedFraction.getConvergent(convFractions, r);

        Pair<BigInteger, BigInteger> pair = new Pair<>(convFraction.getNominator(), convFraction.getDenominator());

        return pair;

    }

}
