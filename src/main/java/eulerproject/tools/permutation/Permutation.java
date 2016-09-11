package eulerproject.tools.permutation;

import java.util.LinkedList;

/**
 * Created by Lukasz on 2016-08-28.
 */
public interface Permutation <T>{

    public void generate(int k, LinkedList<T> input, Listener listener);

}
