package eulerproject.newest.problem578;

import eulerproject.tools.primes.PrimeFactorization;
import eulerproject.tools.primes.Primes;

/**
 * Created by Lukasz on 2016-11-21.
 */
public class Solution {

//    public static long MAX = 10000000000000L;
    public static long MAX = 10000000L;
    private static Primes primes;

    public static void main(String[] args) {
        primes = new Primes((int)MAX/1000);
        System.out.println("Primes initiated");


        System.out.println(countDecreasingFactorized(MAX,primes));

    }


    public static boolean isDecreasingFactorized(long k, Primes primes) {
        Integer previous = null;

        for(Integer key: PrimeFactorization.getPrimeFactorsWithPower(k,primes).values()) {

            if(previous == null) {
                previous = key;
            }
            else {
                if (previous < key)
                    return false;
                else
                    previous = key;
            }
        }

        return true;

    }


    public static int countDecreasingFactorized(long k, Primes primes) {
        int counter=0;

        for(long i=0;i<k;i++)
            if(isDecreasingFactorized(i,primes)) {
                counter++;
//                System.out.println(i);
            };

        return counter;


    }


}
