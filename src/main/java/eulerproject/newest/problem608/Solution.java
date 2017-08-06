package eulerproject.newest.problem608;

import eulerproject.tools.functions.ModularNumberLong;
import eulerproject.tools.primes.PrimeFactorization;
import eulerproject.tools.primes.Primes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by lgrzesik on 03/08/2017.
 */
public class Solution {
    public static final long MODULO = 1_000_000_000L + 7L;
    //    public static final long N = 1_000_000_000_000L;
    public static final long N = 1000_000;
//    public static final int NDIV2 = 500_000_000;


    public static final int M = 4; //M!
    public static final int NDIV2 = (int) (2*N);

    private static Primes primes;

    public static void main(String[] args) {

        primes = new Primes((int) NDIV2);
        primes.init();
        int[] primesArray = primes.toArray();

        System.out.println("Got primes");
        Map<Integer, Integer> factorizationMap = PrimeFactorization.getPAdicValuationPrimes(M);
        System.out.println("got factorizaton map");
        FactorsFinder finder = new FactorsFinder(factorizationMap);
        System.out.println("Find factors " + PrimeFactorization.getNumberOfDivisors(factorizationMap));
        finder.findFactors(0, 1L); //todo:optimise
        System.out.println("Got divisors");

        List<Long> allMFactorialDivisors = finder.getAllFactors();

        ModularNumberLong sum = new ModularNumberLong(MODULO, 0);

        for (Long divisor : allMFactorialDivisors) {

            Map<Integer, Integer> mapForDivisor = PrimeFactorization.getPrimeFactorsWithPower(divisor, primesArray);

            for (int i = 1; i <= N; i++) {
                Map<Integer, Integer> mapForI = PrimeFactorization.getPrimeFactorsWithPower(i, primesArray);
                System.out.println(i);

                ModularNumberLong product = getNumberOfDivisorsWithModulo(getPrimeFactorizationForMultiplied(mapForDivisor, mapForI), MODULO); //todo:optimise
                sum = sum.addModular(product);
            }
            System.out.println(divisor);
        }

        System.out.println(sum);

    }

    public static ModularNumberLong getNumberOfDivisorsWithModulo(Map<Integer, Integer> primeFactorialMap, long modulo) {
        ModularNumberLong result = new ModularNumberLong(modulo, 1L);

        for (Integer key : primeFactorialMap.keySet())
            result = result.multiplyModular(primeFactorialMap.get(key) + 1);

        return result;
    }

    public static Map<Integer, Integer> getPrimeFactorizationForMultiplied(long a, long b, int[] primes) {
        Map<Integer, Integer> aFactorizaton = PrimeFactorization.getPrimeFactorsWithPower(a, primes);
        Map<Integer, Integer> bFactorizaton = PrimeFactorization.getPrimeFactorsWithPower(b, primes);

        return getPrimeFactorizationForMultiplied(aFactorizaton, bFactorizaton);
    }


    public static Map<Integer, Integer> getPrimeFactorizationForMultiplied(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        Map<Integer, Integer> result = new HashMap<>();

        result.putAll(a);

        for (Integer prime : b.keySet()) {

            if (result.containsKey(prime))
                result.replace(prime, b.get(prime) + result.get(prime)); //add values
            else
                result.put(prime, b.get(prime));
        }

        return result;
    }
}
