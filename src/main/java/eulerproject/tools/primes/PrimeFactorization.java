package eulerproject.tools.primes;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by Lukasz on 2016-11-21.
 */
public class PrimeFactorization {

    public static long[] getPrimeFactors(long k, Primes primes) {
        long temp = k;
        int prime = 2;
        List<Long> result = new LinkedList<>();

        while (prime > 1 && 2 * prime <= k) {

            while (temp % prime == 0) {
                temp /= prime;
                result.add((long) prime);
            }

            prime = primes.getNextPrime(prime);
        }

        if (temp == k)
            result.add(temp);

        return result.stream().mapToLong(i -> i).toArray();
    }

    public static Map<Integer, Integer> getPrimeFactorsWithPower(long k, Primes primes) {
        return getPrimeFactorsWithPower(k, primes.toArray());
    }


    public static Map<Integer, Integer> getPrimeFactorsWithPower(long k, int[] primes) {
        Map<Integer, Integer> result = new LinkedHashMap<>();

        long temp = k;
        int primeIndex = 0;
        int prime = primes[primeIndex++];

        int[] primeNumber = new int[primes.length];
        int[] primePowers = new int[primes.length];

        IntStream.range(0, primes.length - 1).forEach(s ->
                {
                    primeNumber[s] = 0;
                    primePowers[s] = 0;
                }
        );

        if (k == 1) {
            result.put(prime, 0);
            return result;
        }

        int i = 0;
        while (prime > 1 && prime <= k) {
            primeNumber[i] = prime;

            while (temp % prime == 0) {
                temp /= prime;
                primePowers[i]++;
            }

            prime = primes[primeIndex++];
            i++;
        }

        if (temp == k) {
            primeNumber[i] = (int) k;
            primeNumber[i] = 1;
        }

        IntStream.range(0, primeNumber.length - 1).forEach(
                s -> {
                    if (primePowers[s] != 0)
                        result.put(primeNumber[s], primePowers[s]);
                }
        );
        return result;
    }

    private static boolean isIncreasingKeyMap(Map<Integer, Integer> map) {
        Integer previous = null;
        for (Integer key : map.values()) {

            if (previous == null) {
                previous = key;
            } else {
                if (previous < key)
                    return false;
                else
                    previous = key;
            }
        }

        return true;
    }

    public static boolean isIncreasingFactorized(long k, Primes primes) {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        long temp = k;
        int prime = 2;

        while (prime > 1 && 2 * prime <= k) {

            while (temp % prime == 0) {
                temp /= prime;
                if (result.containsKey(prime))
                    result.replace(prime, result.get(prime) + 1);
                else
                    result.put(prime, 1);
            }

            if (!isIncreasingKeyMap(result))
                return false;

            prime = primes.getNextPrime(prime);
        }

        return true;
    }

    public static boolean isDecreasingFactorized(long k, int[] primes) {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        long temp = k;
        int primeix = 0;
        int prime = primes[primeix];

        while (prime > 1 && 2 * prime <= k) {

            while (temp % prime == 0) {
                temp /= prime;
                if (result.containsKey(prime))
                    result.replace(prime, result.get(prime) + 1);
                else
                    result.put(prime, 1);
            }

            if (!isIncreasingKeyMap(result))
                return true;

            prime = primes[primeix++];
        }

        return false;
    }

    public static long getNumberFromFactorMap(Map<Integer, Integer> map) {
        long result = 1L;

        for (Integer factor : map.keySet()) {
            Integer power = map.get(factor);

            int i = 0;
            while (i++ < power)
                result *= factor;
        }

        return result;
    }

    /**
     * @param n - this value will be input to n!
     * @return
     */
    public static Map<Integer, Integer> getPAdicValuationPrimes(int n) {
        Map<Integer, Integer> result = new HashMap<>();

        Primes primes = new Primes(n + 1);
        primes.init();

        int prime = 1;

        while ((prime = primes.getNextPrime(prime)) != 0) {

            int pow = 0;
            int sum = 0;
            long floor = 0;

            do {
                pow++;
                floor = (long) Math.floor(n / Math.pow(prime, pow));
                sum += floor;
            }
            while (0L != floor);

            result.put( prime, sum);
        }
        return result;
    }


    public static int getSumOfProperDivisors(int k, int[] primes) {
        Map<Integer, Integer> primeFactors = PrimeFactorization.getPrimeFactorsWithPower(k, primes);

        int result = 1;

        for (Integer prime : primeFactors.keySet()) {
            result *= IntStream.range(0, primeFactors.get(prime) + 1).map(s -> (int) Math.pow(prime, s)).sum();
        }

        return result - k;
    }


    public static long getSumOfDivisors(Map<Integer, Integer> primeFactorialMap) {
        long result = 1L;

        for (Integer prime : primeFactorialMap.keySet()) {
            result *= LongStream.range(0, primeFactorialMap.get(prime) + 1L).map(s -> (int) Math.pow(prime, s)).sum();
        }

        return result;
    }

    public static long getNumberOfDivisors(Map<Integer, Integer> primeFactorialMap) {
        int result = 1;

        for (Integer key : primeFactorialMap.keySet())
            result *= (primeFactorialMap.get(key) + 1);

        return result;
    }


}
