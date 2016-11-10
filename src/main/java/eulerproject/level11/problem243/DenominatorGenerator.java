package eulerproject.level11.problem243;

import eulerproject.tools.primes.Primes;

/**
 * Created by Lukasz on 2016-11-10.
 */
public class DenominatorGenerator {
    private static final int MAX = 1000;
    private static Primes primes;

    private static long factor;
    private static long index;
    private static int primeIndex;

    static {
        init();
    }


    public static long getNext() {

        if (index == primeIndex) {
            primeIndex = primes.getNextPrime(primeIndex);
            factor = factor * index;
            index = 2;
        } else {
            index++;
        }


        return factor * index;
    }

    public static void init() {
        primes = new Primes(MAX);
        primes.generatePrimes();

        factor = 30;
        index = 0;
        primeIndex = 7;
    }


}
