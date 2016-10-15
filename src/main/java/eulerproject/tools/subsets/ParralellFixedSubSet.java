package eulerproject.tools.subsets;

import java.util.Set;

/**
 * Created by Lukasz on 2016-09-26.
 */
public interface ParralellFixedSubSet<T> {
    /**
     * generate subsets from set with k amount of elements and report it to listener.
     *
     * @param set
     * @param listener
     * @param k
     */
    void generate(Set<T> set, Listener<T> listener, int minIx ,int maxIx, int maxSize);
}
