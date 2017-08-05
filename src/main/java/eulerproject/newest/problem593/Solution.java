package eulerproject.newest.problem593;

import eulerproject.tools.functions.ModularNumberInt;
import eulerproject.tools.functions.Statistics;
import eulerproject.tools.primes.Primes;
import eulerproject.tools.statistics.FleetingMedianArray;

import java.util.*;

/**
 * Created by Lukasz on 2017-03-07.
 */
public class Solution {
    private static int MAX_PRIME = 200_000_000; //well tuned
    private static int MAX = 10_000_000;
    private static int MIN = 100_000;
    private static int MODULO = 10007;
    private static Map<Integer, Integer> cachedSValues;

    static {
        cachedSValues = new HashMap<>(MAX_PRIME);
    }

    public static void main(String[] args) {
        int[] primes = new Primes(MAX_PRIME).toArray();
        System.out.println(getFValue(MAX, MIN, primes));

    }


    public static int getSValue(int k, int[] primesArray, int modulo) {

        if (k > primesArray.length || k < 1)
            throw new IllegalArgumentException("Wrong input value " + k);

        int value = primesArray[k - 1] % modulo;
        return new ModularNumberInt(modulo,value).powerModularOptimised(k).getValue();

    }

    public static int getSValueCached(int k, int[] primesArray) {

        if (!cachedSValues.containsKey(k)) {
            cachedSValues.put(k, getSValue(k, primesArray, MODULO));
        }

        return cachedSValues.get(k);

    }

    public static int getS2Value(int k, int[] primes) {
        return getSValueCached(k, primes) + getSValueCached((int) Math.floor(k / 10000) + 1, primes);
    }

    public static double medianOfS2Value(int i, int j, int[] primes) {
        int[] s2Values = new int[j - i + 1];

        for (int k = i; k <= j; k++)
            s2Values[k - i] = getS2Value(k, primes);

        return Statistics.median(s2Values);
    }

    public static int[] getMedianOfS2ValueInitArray(int i, int j, int[] primes) {
        int[] s2Values = new int[j - i + 1];

        for (int k = i; k <= j; k++)
            s2Values[k - i] = getS2Value(k, primes);

        Arrays.sort(s2Values);

        return s2Values;
    }

    public static double getFValue(int n, int k, int[] primes) {

        assert (primes.length >= n);

        FleetingMedianArray fleetingMedianArray = new FleetingMedianArray(getMedianOfS2ValueInitArray(1, k, primes));
        double result = fleetingMedianArray.median();

        int i = 1;
        while (i <= n - k) {
            //move array, remove first, add next
            int first = getS2Value(i, primes);
            int last = getS2Value(i + k, primes);

            fleetingMedianArray.remove(first);
            fleetingMedianArray.add(last);

            result += fleetingMedianArray.median();

            i++;
        }

        return result;
    }
}
