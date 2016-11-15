package eulerproject.level3.problem70;

import eulerproject.tools.StringHelper;
import eulerproject.tools.primes.PrimesSet;

import java.util.List;
import java.util.stream.Collectors;

import static eulerproject.tools.functions.EulersTotient.eulersTotientFunction;

/**
 * Created by Lukasz on 2016-11-12.
 */
public class Solution {

    private static PrimesSet primes;
    private static int[] primesList;
    private static int MAX = 10000000;
    private static int[] resultsEulerFunction;

    static {

        primes = new PrimesSet(MAX);
        primesList = new int[MAX];
        resultsEulerFunction = new int[MAX];

        int ix = 0;
        for (Integer i : primes.getSet()) {
            primesList[ix++] = i;

        }

        System.out.println("got primes");
    }

    public static void main(String[] args) {
        int store = 0;
        double val = 100, temp = 0;
        int fi = 0;

        calculateResults();

        for (int i = 2; i < MAX; i++) {

            fi = resultsEulerFunction[i];

            if ((temp = (double) i / (double) fi) < val) {
                if (StringHelper.isPermutation(Integer.toString(fi), Integer.toString(i))) {
                    store = i;
                    val = temp;
                    System.out.println("Found permuted min = " + val + " is for n=" + store);
                }
            }
        }

        System.out.println("Min = " + val + " is for n=" + store);

    }

    public static void calculateResults() {
        System.out.println("start calculate ");
        for (int i = 2; i < MAX; i++) {

            if(resultsEulerFunction[i] == 0) {

                if (primes.getSet().contains(i)) {
                    resultsEulerFunction[i] = i - 1;
                    //use other primes to generate results
                }
                else
                    resultsEulerFunction[i] = eulersTotientFunction(i, primesList);
                if (i % 1000 == 0)
                    System.out.println((double) i / MAX);
            }
            else {
                // do skip
            }
        }
        System.out.println("stop calculate");
    }
}
