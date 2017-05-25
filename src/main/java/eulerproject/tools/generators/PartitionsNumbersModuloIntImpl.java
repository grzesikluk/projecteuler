package eulerproject.tools.generators;

import eulerproject.tools.functions.ModularNumberInt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PartitionsNumbersModuloIntImpl implements PartitionsNumbers {

    private int modulo;
    private Map<Integer, ModularNumberInt> mapOfResults;

    public PartitionsNumbersModuloIntImpl(int modulo) {
        this.modulo = modulo;

        mapOfResults = new HashMap<>();
        mapOfResults.put(0, new ModularNumberInt(modulo, 1));
        mapOfResults.put(1, new ModularNumberInt(modulo, 1));
    }

    @Override
    public Set<List<Integer>> getAllIntegerPartitions(Integer n) {
        return null;
    }


    @Override
    public Integer partitionFunction(Integer n) {
        Integer result = partitionFunctionRecursive(n).getValue();


        return (result<0)?(modulo+result):result;
    }

    private ModularNumberInt partitionFunctionRecursive(Integer n) {

        ModularNumberInt result = new ModularNumberInt(modulo, 0);
        int k, l;

        if (mapOfResults.containsKey(n))
            return mapOfResults.get(n);


        for (int i = 0; i <= n; i++) {
            k = PolygonalNumbers.getPentagonalNumber(i);
            l = PolygonalNumbers.getPentagonalNumber(-i);

            if (k >= 1 && k <= n)
                result = result.addModular(partitionFunctionRecursive(n - k).multiplyModular(getMinusOnePower(i - 1)));

            if (i != 0)
                if (l >= 1 && l <= n)
                    result = result.addModular(partitionFunctionRecursive(n - l).multiplyModular(getMinusOnePower(i - 1)));

        }

        mapOfResults.put(n, result);
        return result;
    }

    private int getMinusOnePower(int power) {
        if (power % 2 == 0)
            return 1;
        else
            return -1;
    }

}
