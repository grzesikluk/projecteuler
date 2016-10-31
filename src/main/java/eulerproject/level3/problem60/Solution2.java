package eulerproject.level3.problem60;

import eulerproject.tools.primes.PrimesSet;

import java.util.concurrent.ExecutionException;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class Solution2 {

    private static PrimesSet primes;
    private static int MAX_PRIME = 3123;

    static {
        primes = new PrimesSet(MAX_PRIME);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for (int i =2 ;i <MAX_PRIME-100;i=primes.getNextPrime(i))
            for (int j=i;j<MAX_PRIME-100;j=primes.getNextPrime(j)) {

                Dublet d = new Dublet(i,j);

                if (d.isConcPrime()) {
                    System.out.println(d);

                }

            }

    }




}



