package eulerproject.tools.generators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Lukasz on 2017-01-01.
 */
public class PartitionsNumbersImpl implements PartitionsNumbers {


    private int max;
    private Map<Integer, Integer> mapOfResults;

    public PartitionsNumbersImpl(int max) {
        this.max = max;
        mapOfResults = new HashMap<>();
        mapOfResults.put(0, 1);
        mapOfResults.put(1, 1);
    }

    @Override
    public Set<List<Integer>> getAllIntegerPartitions(Integer n) {
        return null;
    }


    @Override
    public Integer partitionFunction(Integer n) {
        int result = 0;
        int k, l;

        if (mapOfResults.containsKey(n))
            return mapOfResults.get(n);


        for (int i = 0; i <= n; i++) {
            k = PolygonalNumbers.getPentagonalNumber(i);
            l = PolygonalNumbers.getPentagonalNumber(-i);

            if (k >= 1 && k <= n)
                result += getMinusOnePower(i - 1) * partitionFunction(n - k);

            if (i != 0)
                if (l >= 1 && l <= n)
                    result += getMinusOnePower(i - 1) * partitionFunction(n - l);

        }

        mapOfResults.put(n,result);

        return result;
    }

    private int getMinusOnePower(int power) {
        if (power % 2 == 0)
            return 1;
        else
            return -1;
    }
}
