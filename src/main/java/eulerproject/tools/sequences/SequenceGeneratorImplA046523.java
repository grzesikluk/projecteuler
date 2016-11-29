package eulerproject.tools.sequences;

import eulerproject.tools.primes.PrimeFactorization;
import eulerproject.tools.primes.Primes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by grzesikl on 29/11/2016.
 */
public class SequenceGeneratorImplA046523 implements SequenceGenerator {


    int[] primes;
    long max;

    @Override
    public void init(long k) {
        int primeSize = (int)(Math.sqrt((double) k / 2));

        Primes p = new Primes(primeSize);
        p.generatePrimes();
        primes = p.asList();

    }

    @Override
    public void init(long k, int[] p) {
        max = k;
        this.primes = p;
    }

    @Override
    public long getNumber(long k) {
        Map<Integer, Integer> factorMap = PrimeFactorization.getPrimeFactorsWithPower(k, primes);
        List<Integer> factorSignature = factorMap.values().stream().sorted((a,b)->b-a).collect(Collectors.toList());

        Map<Integer, Integer> factorMapConverted = new LinkedHashMap<>();

        int primeix = 0;
        int prime = primes[primeix++];

        for (Integer key : factorSignature) {
            factorMapConverted.put(prime, key);
            prime = primes[primeix++];
        }

        return PrimeFactorization.getNumberFromFactorMap(factorMapConverted);
    }

    @Override
    public long getSize() {
        return max;
    }
}
