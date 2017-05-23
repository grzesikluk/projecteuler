package eulerproject.tools.functions;

import eulerproject.tools.primes.Primes;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class SigmaFunctionBerndtCachedImpl extends SigmaFunctionBerndtImpl{

    private Map<Pair<Long, Long>, Long> cachedValues;

    public SigmaFunctionBerndtCachedImpl(Primes primes) {
        super(primes);
        cachedValues = new HashMap<>();
    }

    public long getValueModular(long k, long n, long modulo) {
        Pair<Long, Long> pair = new Pair(new Long(k), new Long(n));

        if (cachedValues.containsKey(pair)) {
            return cachedValues.get(pair);
        } else {
            long result = super.getValueModular(k,n,modulo);

            cachedValues.put(pair, result);
            return result;

        }


    }


}
