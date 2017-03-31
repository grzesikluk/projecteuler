package eulerproject.tools.sequences;

import eulerproject.tools.primes.PrimeFactorization;
import eulerproject.tools.primes.Primes;

import java.util.Map;


public class SequenceGeneratorImplA008472 implements SequenceGenerator {
/*http://oeis.org/A008472*/

    int[] primes;
    long max;

    @Override
    public void init(long k) {
        int primeSize = (int) (Math.sqrt((double) k / 2));

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

        if (k == 0 || k == 1)
            return 0;

        Map<Integer, Integer> factorMap = PrimeFactorization.getPrimeFactorsWithPower(k, primes);

        long result = 0;

        for (Integer prime : factorMap.keySet())
            result += prime;

        return result;
    }

    @Override
    public long getSize() {
        return max;
    }
}
