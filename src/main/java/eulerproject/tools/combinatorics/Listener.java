package eulerproject.tools.combinatorics;

import java.util.List;

/**
 * Created by Lukasz on 2016-08-28.
 */
public interface Listener<T> {
    void activate(List<T> list);
    List<List<T>> getResults();
}
