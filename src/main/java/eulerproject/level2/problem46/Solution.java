package eulerproject.level2.problem46;

import eulerproject.tools.Primes;

/**
 * Created by Lukasz on 2016-08-30.
 */
public class Solution {

    private static final int MAX = 1000000;

    private static Primes primes;

    public static void main(String[] args) {
        primes = new Primes(MAX);

        for (int i = 9; i < MAX; i += 2) {

            if (!primes.isPrime(i))
                if (check(i)) {
                    System.out.println(i);
                    break;
                }
        }

    }

    /**
     * number is prime + 2*square
     *
     * @param k
     * @return
     */
    public static boolean check(int k) {

        for (int prime = 2; prime < k; prime = primes.getNextPrime(prime)) {
            for (int j = 1; 2 * j * j <= k - prime; j++)
                if (k == (prime + 2 * j * j))
                    return false;
        }
        return true;

    }
}
