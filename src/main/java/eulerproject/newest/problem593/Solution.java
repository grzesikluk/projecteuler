package eulerproject.newest.problem593;

import eulerproject.tools.functions.Statistics;
import eulerproject.tools.primes.Primes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lukasz on 2017-03-07.
 */
public class Solution {
    private static int MAX_PRIME = 200_000_000; //well tuned
    private static int MAX  = 10_000_000;
    private static int MIN  = 100_000;
    private static int MODULO = 10007;
    private static Map<Integer, Integer> cachedSValues;
    private static Map<Integer, Integer> cachedS2Values;

    static {
        //pre-allocate for faster
        cachedSValues = new HashMap<>(MAX_PRIME);
        cachedS2Values = new HashMap<>(MAX_PRIME);
    }

    public static void main(String[] args) {
        int[] primes = new Primes(MAX_PRIME).asList();
        if (!(primes.length > MAX))
            throw new AssertionError("Primes too small"); //make sure it's big enough

        System.out.println(primes.length + " " + primes[primes.length-1]);
//        System.out.println(getFValue(MAX, MIN, primes));

    }

    public static int getSValue(int k, int[] primesArray) {

        if (k > primesArray.length || k < 1)
            throw new IllegalArgumentException("Wrong input value " + k);

        int value = primesArray[k-1] % MODULO;
        int resultVal = value;

        for(int i=1;i<k;i++)
            resultVal = (resultVal * value) % MODULO;


        return resultVal;
    }

    public static int getSValueCached(int k, int[] primesArray) {

        if (!cachedSValues.containsKey(k)) {
            cachedSValues.put(k, getSValue(k, primesArray));
        }

        return cachedSValues.get(k);

    }

    public static int getS2Value(int k, int[] primes) {
        return getSValueCached(k, primes) + getSValueCached((int) Math.floor(k / 10000) + 1, primes);
    }

    public static int getS2ValueCached(int k, int[] primes) {
        if (!cachedS2Values.containsKey(k)) {
            cachedS2Values.put(k, getS2Value(k, primes));
        }

        return cachedS2Values.get(k);
    }

    public static double medianOfS2Value(int i, int j, int[] primes) {
        int[] s2Values = new int[j - i + 1];

        for (int k = i; k <= j; k++)
            s2Values[k - i] = getS2ValueCached(k, primes);

        return Statistics.median(s2Values);
    }

    public static int[] getMedianOfS2ValueInitArray(int i, int j, int[] primes) {
        int[] s2Values = new int[j - i + 1];

        for (int k = i; k <= j; k++)
            s2Values[k - i] = getS2ValueCached(k, primes);

        Arrays.sort(s2Values);

        return s2Values;
    }

    public static double getFValue(int n, int k, int[] primes) {

        assert(primes.length >= n);

        MedianArray medianArray = new MedianArray(getMedianOfS2ValueInitArray(1, k, primes));
        double result = medianArray.median();

        int i = 1;
        while (i <= n - k ) {
            //move array, remove first, add next
            int first = getS2ValueCached(i, primes);
            int last = getS2ValueCached(i + k, primes);

            medianArray.remove(first);
            medianArray.add(last);

            result += medianArray.median();

            i++;
        }

        return result;
    }
}
