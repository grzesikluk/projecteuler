package eulerproject.level2.problem49;

import eulerproject.tools.combinatorics.Listener;

import java.util.List;

/**
 * Created by grzesikl on 09/09/2016.
 */
public class ListenerImplTest implements Listener {
    @Override
    public void activate(List list) {
        System.out.println(list);
    }
}
