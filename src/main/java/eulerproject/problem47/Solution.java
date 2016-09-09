package projecteuler.problem47;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by grzesikl on 09/09/2016.
 */
public class Solution {
    private static final int MAX = 10000000;
    private static Primes primes = new Primes(MAX);
    private static final int NO_CONSECUTIVES = 4;
    private static final int NO_DISTINCT_PRIMES = 4;

    public static void main(String[] args) {
        int i = 2;

        while(i+NO_CONSECUTIVES < MAX) {
            if (checkCondition(i,NO_CONSECUTIVES,NO_DISTINCT_PRIMES)) {
                System.out.println(i);
                break;
            }
            i++;
        }


    }

    public static boolean checkCondition(int k, int noConsecutives, int noDistinct) {

        for (int i = 0;i<noConsecutives; i++)
            if (getNumberOfDistinctPrimes(k+i)!= noDistinct)
                return false;
        return true;
    }

    public static int getNumberOfDistinctPrimes(int number) {
        Set<Integer> result = new HashSet<>();

        for(int k=2;k<number;k=primes.getNextPrime(k)) {
            if (k == 0)
                System.exit(2); //the maximum reached

            if (number%k == 0)
                result.add(k);
        }

        return result.size();

    }





}
