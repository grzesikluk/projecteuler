package eulerproject.tools.sequences;

import eulerproject.tools.primes.PrimeFactorization;

import java.util.HashMap;
import java.util.Map;


public class SequenceGeneratorImplCachedA008472 extends SequenceGeneratorImplA008472{
/*http://oeis.org/A008472*/

    Map<Long, Long> cache;

    @Override
    public void init(long k) {
        super.init(k);
        cache = new HashMap<>();

    }

    @Override
    public void init(long k, int[] p) {
        super.init(k,p);
        cache = new HashMap<>();
    }

    @Override
    public long getNumber(long k) {
        long result = 0;

        if (k == 0 || k == 1)
            return 0;

        if (cache.containsKey(k))
            result = cache.get(k);
        else {

            Map<Integer, Integer> factorMap = PrimeFactorization.getPrimeFactorsWithPower(k, primes);

            result = 0;

            for (Integer prime : factorMap.keySet())
                result += prime;

            cache.put(k, result);
        }
        return result;
    }

}
