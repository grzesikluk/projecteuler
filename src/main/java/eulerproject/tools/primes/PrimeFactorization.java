package eulerproject.tools.primes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Lukasz on 2016-11-21.
 */
public class PrimeFactorization {

    public static int[] getPrimeFactors(long k, Primes primes) {
        long temp = k;
        int prime = 2;
        List<Integer> result = new LinkedList<>();


        while (prime > 0 && prime < 2*k) {

            while(temp % prime == 0) {
                temp /= prime;
                result.add(prime);
            }


            prime = primes.getNextPrime(prime);
        }


        return result.stream().mapToInt(i -> i).toArray();
    }

    public static Map<Integer,Integer> getPrimeFactorsWithPower(long k, Primes primes) {
        List<Integer> arrayOfPrimeFactors = IntStream.of(getPrimeFactors(k,primes)).boxed().collect(Collectors.toList());
        Map<Integer,Integer> result = new LinkedHashMap<>();

        for(Integer i:arrayOfPrimeFactors) {
            if(result.containsKey(i))
                result.replace(i,result.get(i) + 1);
            else
                result.put(i,1);
        }

        return result;

    }

}
