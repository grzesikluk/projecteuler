package eulerproject.level3.problem60;

import eulerproject.tools.primes.Primes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class Solution {
    private static int[] primesArray;
    private static int MAX = 5000;
    private static int MAX_PRIME = MAX*10000;
    private static Primes primes;


    static {
        primes = new Primes(MAX_PRIME);
        primes.generatePrimes();
        primesArray = primes.asList();

        System.out.println("Primes initiated. " + primesArray.length );
    }


    public static void main(String[] args)  {
        Map<Integer,Integer> pairs = new HashMap<>();


        for(int i=0;i<MAX;i++)
            for(int j=i;j<MAX;j++){

                if(isPrimePair(i,j))
                    System.out.println(i + " " + j);
            }


    }

    public static boolean isPrimePair(int a, int b) {
        Integer ab = new Integer(Integer.toString(a)+Integer.toString(b));
        Integer ba = new Integer(Integer.toString(b)+Integer.toString(a));

        return  primes.isPrime(ab) && primes.isPrime(ba);
    }






}
