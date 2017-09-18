package eulerproject.level2.problem49;

import eulerproject.tools.combinatorics.Listener;

import java.util.Collections;
import java.util.List;

/**
 * Created by grzesikl on 09/09/2016.
 */
public class ListenerImplTest<T> implements Listener {
    List<List<T>> testList;

    ListenerImplTest() {
        testList = Collections.emptyList();
    }

    @Override
    public void activate(List list) {
        testList.add(list);
        System.out.println(list);
    }

    @Override
    public List<List<T>> getResults()
    {
        return testList;
    }
}
