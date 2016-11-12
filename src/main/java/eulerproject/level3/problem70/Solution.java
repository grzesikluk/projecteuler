package eulerproject.level3.problem70;

import eulerproject.tools.StringHelper;
import eulerproject.tools.primes.Primes;

import static eulerproject.tools.functions.EulersTotient.eulersTotientFunction;

/**
 * Created by Lukasz on 2016-11-12.
 */
public class Solution {

    private static Primes primes;
    private static int MAX = 10000000;

    static {
        primes = new Primes(MAX);
        primes.generatePrimes();
        System.out.println("got primes");
    }

    public static void main(String[] args) {
        int store = 0;
        double val = 100, temp = 0;
        int prime = 2;

        for (int i = 2; i < MAX && i > 0; i = primes.getNextPrime(i)) {
            int fi = eulersTotientFunction(i);

            if ((temp = (double) i / (double) fi) < val) {
                if (StringHelper.isPermutation(new Integer(fi).toString(), new Integer(i).toString())) {
                    store = i;
                    val = temp;

                }
                System.out.println("Found permuted min = " + val + " is for n=" + store);
            }

        }

        System.out.println("Min = " + val + " is for n=" + store);

    }

    public static boolean check(int k) {
        String input = new Integer(k).toString();
        String output = new Integer(eulersTotientFunction(k)).toString();

        return StringHelper.isPermutation(input, output);
    }
}
