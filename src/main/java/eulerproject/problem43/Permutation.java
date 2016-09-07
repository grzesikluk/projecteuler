package eulerproject.problem43;

import java.util.LinkedList;

/**
 * Created by Lukasz on 2016-08-28.
 */
interface Permutation <T>{

    public void generate(int k, LinkedList<T> input, Listener listener);

}
