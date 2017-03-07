package eulerproject.newest.problem593;

import eulerproject.tools.functions.ModularNumber;
import eulerproject.tools.functions.Statistics;
import eulerproject.tools.primes.Primes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lukasz on 2017-03-07.
 */
public class Solution {
    private static int MAX = 1_000_000_000;
    private static int MODULO = 10007;

    private static Map<Integer, Long> cachedSValues;
    private static Map<Integer, Long> cachedS2Values;

    static  {
        cachedSValues = new HashMap<>();
        cachedS2Values = new HashMap<>();
    }

    public static void main(String[] args) {
        int[] primes = new Primes(MAX).asList();

        
        System.out.println(primes.length > 10_010_000);

    }

    public static long getSValue(int k, int[] primesArray) {

        if (k > primesArray.length || k < 1)
            throw new IllegalArgumentException("Wrong input value " + k);

        ModularNumber number = new ModularNumber(MODULO, primesArray[k - 1]);
        number = number.powerModular(k);

        return number.getValue();
    }

    public static long getSValueCached(int k, int[] primesArray) {

        if(!cachedSValues.containsKey(k)) {
            cachedSValues.put(k,getSValue(k, primesArray));
        }

        return cachedSValues.get(k);

    }


    public static long getS2Value(int k, int[] primes) {
        return getSValueCached(k, primes) + getSValueCached((int) Math.floor(k / 10000) + 1, primes);
    }

    public static long getS2ValueCached(int k, int[] primes) {
        if(!cachedS2Values.containsKey(k)) {
            cachedS2Values.put(k,getS2Value(k, primes));
        }

        return cachedS2Values.get(k);
    }

    public static double medianOfS2Value(int i, int j, int[] primes) {
        long[] s2Values = new long[j - i + 1];

        for (int k = i; k <= j; k++) {
            s2Values[k - i] = getS2Value(k, primes);
        }

        return Statistics.median(s2Values);
    }

    public static double getFValue(int n, int k, int[] primes) {
        double result = 0;

        for (int i = 1; i <= n - k + 1; i++) {
            result += medianOfS2Value(i, i + k - 1, primes);
        }
        return result;
    }


}
