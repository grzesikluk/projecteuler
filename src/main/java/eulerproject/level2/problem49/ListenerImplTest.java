package eulerproject.level2.problem49;

import eulerproject.tools.combinatorics.Listener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grzesikl on 09/09/2016.
 */
public class ListenerImplTest<T> implements Listener {
    List<List<T>> testList;

    ListenerImplTest() {
        testList = new ArrayList<>();
    }

    @Override
    public void activate(List list) {
        testList.add(new ArrayList<>(list));
        System.out.println(list);
    }

    @Override
    public List<List<T>> getResults()
    {
        return testList;
    }
}
