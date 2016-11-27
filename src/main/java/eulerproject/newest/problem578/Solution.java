package eulerproject.newest.problem578;

import eulerproject.tools.primes.PrimeFactorization;
import eulerproject.tools.primes.Primes;

/**
 * Created by Lukasz on 2016-11-21.
 */
public class Solution {

    private static final long MAX = 10000000000000L;
    private static final long MAX_PRIME = (long) Math.sqrt((double) MAX / 2);

    private static Primes primes;

    public static void main(String[] args) {
        primes = new Primes((int) MAX_PRIME);
        System.out.println("Primes initiated");

        System.out.println(countIncreasingFactorsNumbers(MAX,primes));

    }


    public static int countIncreasingFactorsNumbers(long k, Primes primes) {
        int counter=0;
        int[] primes_list = primes.asList();

        for(long i=0;i<k;i++)
            if(PrimeFactorization.isIncreasingFactorized(i,primes_list))
                counter++;

        return counter;
    }



}
