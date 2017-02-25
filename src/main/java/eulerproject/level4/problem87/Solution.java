package eulerproject.level4.problem87;

import eulerproject.tools.primes.Primes;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lukasz on 2017-02-25.
 */
public class Solution {
    private static long MAX = 50_000_000;
    private static long MAX_PRIME = (long) Math.sqrt(MAX); //max is determined by square
    private static Primes primes;

    static {
        primes = new Primes((int) MAX_PRIME);
        primes.init();
    }

    public static void main(String[] args) {
        int counter = 0;
        Set<Long> distinctValues = new HashSet<>();

        for (int i = 2; i < MAX_PRIME && i != 0; i = primes.getNextPrime(i))
            for (int j = 2; j < MAX_PRIME && j != 0; j = primes.getNextPrime(j))
                for (int k = 2; getValue(i, j, k) < MAX && k != 0; k = primes.getNextPrime(k)) {
                    distinctValues.add(getValue(i, j, k));
                }


        System.out.println(distinctValues.size());

    }


    public static long getValue(long a, long b, long c) {
        return a * a + b * b * b + c * c * c * c;
    }


}
