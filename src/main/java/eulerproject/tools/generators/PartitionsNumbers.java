package eulerproject.tools.generators;

import java.util.List;
import java.util.Set;

/**
 * Created by Lukasz on 2017-01-01.
 */
public interface PartitionsNumbers {

    Set<List<Integer>> getAllIntegerPartitions(Integer n);

    Integer partitionFunction(Integer n);

}
