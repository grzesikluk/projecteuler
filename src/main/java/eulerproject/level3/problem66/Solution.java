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

        for (int i = 2; i <= maxD; i=primes.getNextPrime(i)) {

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
        final int limit = CONV_LIMIT;

        List<Integer> convFractions = ContinuedFraction.getPartialQuotientsForQuadraticSurd(D,CONV_LIMIT);

        int i = 1;

        while (i < limit) {
            BigFraction convFraction = ContinuedFraction.getConvergent(convFractions, i);
            Pair<BigInteger, BigInteger> pair = new Pair<>(convFraction.getNominator(), convFraction.getDenominator());

            if (isThisPairPellsEquationSolution(pair, D))
                return pair;
            i++;
        }

        return null;

    }

    public static boolean isThisPairPellsEquationSolution(Pair<BigInteger, BigInteger> pair, int D) {
        BigInteger result = pair.getKey().pow(2).subtract(new BigInteger(Integer.toString(D)).multiply(pair.getValue().pow(2)));
        return result.equals(BigInteger.ONE);
    }

}
