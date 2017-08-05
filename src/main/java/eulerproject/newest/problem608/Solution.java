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
    public static final long N = 100;
//    public static final int NDIV2 = 500_000_000;


    public static final int M = 3; //M!
    public static final int NDIV2 = (int) (2*N);

    private static Primes primes;

    public static void main(String[] args) {

        primes = new Primes((int) NDIV2);
        primes.init();

        System.out.println("Got primes");

        FactorsFinder finder = new FactorsFinder(PrimeFactorization.getPAdicValuationPrimes(M));
        System.out.println("Find factors");
        finder.findFactors(0, 1L);
        List<Long> allMFactorialDivisors = finder.getAllFactors();

        ModularNumberLong sum = new ModularNumberLong(MODULO, 0);

        for (Long divisor : allMFactorialDivisors) {
            for (int i = 1; i <= N; i++) {
                ModularNumberLong product = getNumberOfDivisorsWithModulo(getPrimeFactorizationForMultiplied(divisor, i, primes), MODULO);
                sum = sum.addModular(product);
            }
        }

        System.out.println(sum);

    }


    public static ModularNumberLong getNumberOfDivisorsWithModulo(Map<Integer, Integer> primeFactorialMap, long modulo) {
        ModularNumberLong result = new ModularNumberLong(modulo, 1L);

        for (Integer key : primeFactorialMap.keySet())
            result = result.multiplyModular(primeFactorialMap.get(key) + 1);

        return result;
    }

    public static Map<Integer, Integer> getPrimeFactorizationForMultiplied(long a, long b, Primes primes) {
        Map<Integer, Integer> aFactorizaton = PrimeFactorization.getPrimeFactorsWithPower(a, primes);
        Map<Integer, Integer> bFactorizaton = PrimeFactorization.getPrimeFactorsWithPower(b, primes);
        Map<Integer, Integer> result = new HashMap<>();

        result.putAll(aFactorizaton);

        for(Integer prime:bFactorizaton.keySet()) {

            if(result.containsKey(prime))
                result.replace(prime, bFactorizaton.get(prime) + result.get(prime)); //add values
            else
                result.put(prime, bFactorizaton.get(prime));
        }

        return result;
    }

}
