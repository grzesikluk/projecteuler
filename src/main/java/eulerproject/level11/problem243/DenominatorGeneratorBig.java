package eulerproject.level11.problem243;

import eulerproject.tools.primes.Primes;

import java.math.BigInteger;

/**
 * Created by Lukasz on 2016-11-10.
 *
 *
 *
 */
public class DenominatorGeneratorBig {
    private static final int MAX = 1000;
    private static Primes primes;

    private static BigInteger factor;
    private static BigInteger index;
    private static int primeIndex;

    static {
        init();
    }


    public static BigInteger getNext() {

        if (index.equals(new BigInteger(new Long(primeIndex).toString()))) {
            primeIndex = primes.getNextPrime(primeIndex);
            factor = factor.multiply(index);
            index = new BigInteger("2");
        } else {
            index = index.add(BigInteger.ONE);
        }


        return factor.multiply(index);
    }

    public static void init() {
        primes = new Primes(MAX);
        primes.generatePrimes();

        factor = new BigInteger("30");
        index = BigInteger.ZERO;
        primeIndex = 7;
    }


}
