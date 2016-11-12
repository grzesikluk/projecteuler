package eulerproject.level3.problem69;

import eulerproject.tools.primes.Primes;

import static eulerproject.tools.functions.EulersTotient.eulersTotientFunction;

/**
 * Created by Lukasz on 2016-11-12.
 */
public class Solution {
    private static Primes primes;
    private static final int MAX = 1000000;

    static {
        primes = new Primes(MAX);
        primes.generatePrimes();
    }



    public static void main(String[] args) {

        int store = 0;
        double val = 0,temp = 0;
        int prime = 2;

        for(int i=2;i<MAX;i=prime*i) {

            if((temp=(double)i/(double)eulersTotientFunction(i))> val) {
                store = i;
                val = temp;
            }
            prime = primes.getNextPrime(prime);

        }

        System.out.println("MAx = " + val + " is for n=" +store);
    }






}
