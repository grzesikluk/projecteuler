package eulerproject.newest.problem578;

import eulerproject.tools.primes.PrimeFactorization;
import eulerproject.tools.primes.Primes;
import eulerproject.tools.sequences.SequenceGenerator;
import eulerproject.tools.sequences.SequenceGeneratorImplA071365;

import java.util.*;

/**
 * Created by Lukasz on 2016-11-21.
 */
public class Solution {

    private static final long MAX = 10_000_000_000_000L;
    private static final long MAX_PRIME = (long) Math.sqrt((double) MAX / 2);

    private static Primes primes;

    public static void main(String[] args) {
        primes = new Primes((int) MAX_PRIME);
        System.out.println("Primes initiated");

        //testing purpose
        for (long i = 1; i < 100; i++) {
            long k = countIncreasingFactorsNumbersFromSequence(i * 1000, primes);
            System.out.println(i + " " + k + " " + (double) k / (i*100));
//            System.out.println(k);
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
        return k-result.size();
    }

    public static void addNextFoundNumber(Set<Long> set, long k) {
        set.add(k);
    }

    public static long countIncreasingFactorsNumbersFromSequence(long k, Primes primes) {
        SequenceGenerator sg = new SequenceGeneratorImplA071365();
        sg.init(k,primes.asList());

        return k-sg.getSize();
    }
}