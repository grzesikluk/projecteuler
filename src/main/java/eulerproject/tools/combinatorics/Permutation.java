package eulerproject.tools.combinatorics;

import java.util.List;

/**
 * Created by Lukasz on 2016-08-28.
 */
public interface Permutation <T>{

    void generate(int k, List<T> input, Listener listener);

}
