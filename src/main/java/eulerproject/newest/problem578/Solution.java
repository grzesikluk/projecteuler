package eulerproject.newest.problem578;

import eulerproject.tools.primes.PrimeFactorization;
import eulerproject.tools.primes.Primes;

import java.util.*;

/**
 * Created by Lukasz on 2016-11-21.
 */
public class Solution {

    private static final long MAX = 1000000000L;
    private static final long MAX_PRIME = (long) Math.sqrt((double) MAX / 2);

    private static Primes primes;

    public static void main(String[] args) {
        primes = new Primes((int) MAX_PRIME);
        System.out.println("Primes initiated");

        //testing purpose
        for (long i = 1; i < MAX; i++) {
            long k = countIncreasingFactorsNumbers(i * 1000000, primes);
            System.out.println(i + " " + k + " " + (double) k / i);
        }
    }


    public static long countIncreasingFactorsNumbers(long k, Primes primes) {
        long counter = 0;
        int[] primes_list = primes.asList();
        Set<Long> result = new LinkedHashSet<>();

        for (long i = 0; i < k; i++)
            if (PrimeFactorization.isDecreasingFactorized(i, primes_list)) {
                addNextFoundNumber(result, i);
            }


        System.out.println(result);
        return result.size() - counter;
    }

    public static void addNextFoundNumber(Set<Long> set, long k) {
        for (Long i : set)
            if ((k % i) == 0)
                return;
        set.add(k);
    }


}
