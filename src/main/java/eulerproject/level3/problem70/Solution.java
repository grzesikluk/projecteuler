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
    private static List<Integer> primesList;
    private static int MAX = 10000000;

    static {
        primes = new PrimesSet(MAX);
        primesList = primes.getSet().stream().collect(Collectors.toList());

        System.out.println("got primes");
    }

    public static void main(String[] args) {
        int store = 0;
        double val = 100, temp = 0;
        int prime = 2;

        for (int i = 2; i < MAX ;i++) {

            int fi = eulersTotientFunction(i,primesList);

            if ((temp = (double) i / (double) fi) < val) {
                if (StringHelper.isPermutation(new Integer(fi).toString(), new Integer(i).toString())) {
                    store = i;
                    val = temp;
                    System.out.println("Found permuted min = " + val + " is for n=" + store);
                }

            }

        }

        System.out.println("Min = " + val + " is for n=" + store);

    }

}
