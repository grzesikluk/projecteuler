package eulerproject.tools.sequences;

import eulerproject.tools.primes.PrimeFactorization;
import eulerproject.tools.primes.Primes;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by grzesikl on 29/11/2016.
 */
public class SequenceGeneratorImplA071365 implements SequenceGenerator {
    int[] primes;
    List<Long> numbersInSeq;
    long max;

    public SequenceGeneratorImplA071365() {
        numbersInSeq = new LinkedList<>();

    }

    @Override
    public void init(long k) {
        int primeSize = (int) (Math.sqrt((double) k / 2));
        Primes p = new Primes(primeSize);
        p.init();
        primes = p.asList();
        max = k;
        generateNumbers();

    }

    @Override
    public void init(long k, int[] p) {
        max = k;
        primes = p;
        generateNumbers();
    }

    private void generateNumbers() {

        for (long i = 0; i < max; i++) {

            Map<Integer, Integer> factorMap = PrimeFactorization.getPrimeFactorsWithPower(i, primes);

             if (factorMap.size() > 1) {
                List<Integer> factorSignature = factorMap.values().stream().sorted((a, b) -> b - a).collect(Collectors.toList());

                Map<Integer, Integer> factorMapConverted_a = new LinkedHashMap<>();
                Map<Integer, Integer> factorMapConverted_b = new LinkedHashMap<>();

                int primeIx = 0;
                int prime;

                for (Integer key : factorSignature) {
                    prime = primes[primeIx++];
                    factorMapConverted_a.put(prime, key);
                }

                primeIx = 0;

                for (Integer key : factorMap.keySet()) {
                    prime = primes[primeIx++];
                    factorMapConverted_b.put(prime, factorMap.get(key));
                }
                ;

                if (!factorMapConverted_a.equals(factorMapConverted_b)) {
                    numbersInSeq.add(new Long(i));
                }
            }
        }
    }

    @Override
    public long getNumber(long k) {
        return numbersInSeq.get((int) k);
    }

    @Override
    public long getSize() {
        return numbersInSeq.size();
    }

}
