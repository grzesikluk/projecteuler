package eulerproject.tools.sequences;

import java.util.HashMap;
import java.util.Map;

public class SequenceGeneratorImplCachedA000607 extends SequenceGeneratorImplA000607 {
    private Map<Long, Long> cache;

    @Override
    public void init(long k) {
        super.init(k);
        cache = new HashMap<>();
    }

    @Override
    public void init(long k, int[] primes) {
        super.init(k, primes);
        cache = new HashMap<>();
    }

    protected long getNumberRecursion(long n) {
        // a(n) = (1/n)*Sum_{k=1..n} A008472(k)*a(n-k)

        if(cache.containsKey(n))
            return cache.get(n);
        
        else {

            int sum = 0;

            if (n == 0)
                return 1;
            else if (n == 1)
                return 0;
            else if (n == 2)
                return 1;


            for (int k = 1; k <= n; k++) {
                sum += sequenceGeneratorA008472.getNumber(k) * getNumberRecursion(n - k);
            }
            
            cache.put(n, sum/n);

            return sum / n;
        }
    }

}
