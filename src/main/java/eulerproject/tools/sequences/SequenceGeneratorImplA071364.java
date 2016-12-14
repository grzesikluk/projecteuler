package eulerproject.tools.sequences;

import eulerproject.tools.primes.PrimeFactorization;
import eulerproject.tools.primes.Primes;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by grzesikl on 29/11/2016.
 */
public class SequenceGeneratorImplA071364 implements SequenceGenerator {

    int[] primes;
    long max;

    SequenceGeneratorImplA071364(long k) {
        init(k);
    }

    SequenceGeneratorImplA071364(long k, int[] p) {
        init(k,p);
    }

    @Override
    public void init(long k) {
        int primeSize = (int)(Math.sqrt((double) k / 2));
        Primes p = new Primes(primeSize);
        p.init();
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
        Map<Integer, Integer> factorMapConverted = new LinkedHashMap<>();

        int primeix = 0;
        int prime = primes[primeix++];

        for (Integer key : factorMap.keySet()) {
            factorMapConverted.put(prime, factorMap.get(key));
            prime = primes[primeix++];
        }

        return PrimeFactorization.getNumberFromFactorMap(factorMapConverted);
    }

    @Override
    public long getSize() {
        return max;
    }
}
