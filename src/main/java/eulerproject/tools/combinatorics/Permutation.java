package eulerproject.tools.combinatorics;

import java.util.List;

/**
 * Created by Lukasz on 2016-08-28.
 */
public interface Permutation <T>{

    void generate(List<T> input, Listener listener);

}
