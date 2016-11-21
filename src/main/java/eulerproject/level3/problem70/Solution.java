package eulerproject.level3.problem70;

import eulerproject.tools.StringHelper;
import eulerproject.tools.primes.Primes;

import static eulerproject.tools.functions.EulersTotient.eulersTotientFunction;

/**
 * Created by Lukasz on 2016-11-12.
 */
public class Solution {

    private static Primes primes;
    private static int[] primesList;
    private static int MAX = 10000000;
    private static int[] eulerTotientFunctionResults;

    static {

        primes = new Primes(MAX);
        primes.generatePrimes();
        primesList = primes.asList();
        eulerTotientFunctionResults = new int[MAX];

        System.out.println("got primes");
    }

    public static void main(String[] args) {
        int store = 0;
        double val = 100, temp = 0;
        int fi = 0;

        calculateResults();

        for (int i = 2; i < MAX; i++) {

            fi = eulerTotientFunctionResults[i];

            if ((temp = (double) i / (double) fi) < val) {
                if (StringHelper.isPermutation(Integer.toString(fi), Integer.toString(i))) {
                    store = i;
                    val = temp;
                }
            }
        }

        System.out.println("Min = " + val + " is for n=" + store);

    }

    public static void calculateResults() {
        System.out.println("start calculate ");
        for (int i = 2; i < MAX; i++) {
                eulerTotientFunctionResults[i] = eulersTotientFunction(i, primesList);
        }
        System.out.println("stop calculate");
    }
}
