package eulerproject.tools.statistics;

import java.util.HashMap;
import java.util.Map;

public class ExpectedValueAggregator
{
    private Map<Long,Long> statMap;


    public ExpectedValueAggregator() {
        statMap = new HashMap<>();
    };

    public void clear() {
        statMap.clear();
    }

    public void increment(Long key) {
        Long k;

        if((k=statMap.get(key)) != null) {
            k++;
            statMap.put(key,k);
        }
        else {
            statMap.put(key,1L);
        }
    }

    public void increment(Long key, long val) {
        Long k;

        if((k=statMap.get(key)) != null) {
            k+=val;
            statMap.put(key,k);
        }
        else {
            statMap.put(key,val);
        }
    }

    public double getExpectedValue() {

        long sum = getSum();
        final double[] result = {0L};

        statMap.forEach((Long k, Long v) ->{
            result[0] += k * (double)v/sum;
        });

        return result[0];

    }

    public long getSum() {
        return statMap.values().stream().mapToLong(s->s).sum();
    }

}
