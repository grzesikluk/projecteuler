package eulerproject.tools.statistics;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ExpectedValueAggregatorArrayImpl implements ExpectedValueAggregator<Integer>
{
    private long[] statMap;


    public ExpectedValueAggregatorArrayImpl(int max) {
        statMap = new long[max];
    };

    public void clear() {
        IntStream.range(0,statMap.length).forEach(i->statMap[i]=0);
    }

    public double getExpectedValue() {
        long sum = getSum();
        final double[] result = {0L};

        IntStream.range(0,statMap.length).forEach(i ->{
            result[0] += i * (double)statMap[i]/sum;
        });

        return result[0];
    }

    @Override
    public void increment(final Integer key)
    {
        statMap[key]++;
    }

    public long getSum() {
        return Arrays.stream(statMap).sum();
    }

}
