package eulerproject.tools.generators;

import java.util.List;
import java.util.Set;

/**
 * Created by Lukasz on 2017-01-01.
 */
public class PartitionsNumbersImpl implements PartitionsNumbers {

    @Override
    public Set<List<Integer>> getAllIntegerPartitions(Integer n) {
        return null;
    }


    /**
     * One of the easiest ways of computing the sequence p(n) is recursively
     * using the formula
     * p(n) = SUM  (-1)^(k-1)  p(n - k(3k+-1)/2)
     * where the sum is evaluated over all k such that k(3k+-1)/2 is in the
     * range from 1 to n.
     */

    @Override
    public Integer partitionFunction(Integer n) {
        int result = 0;

        if (n == 0 || n == 1)
            return 1;
        else if (n < 0)
            return 0;
        else {
            int k, l;

            for (int i = 0; i <= n; i++) {
                k = PolygonalNumbers.getPentagonalNumber(i);
                l = PolygonalNumbers.getPentagonalNumber(-i);

                if (k >= 1 && k <= n)
                    result += getMinusOnePower(i - 1) * partitionFunction(n - k);

                if (i != 0)
                    if (l >= 1 && l <= n)
                        result += getMinusOnePower(i - 1) * partitionFunction(n - l);

            }
        }

        return result;
    }

    private int getMinusOnePower(int power) {
        if (power % 2 == 0)
            return 1;
        else
            return -1;
    }
}
