package eulerproject.problem49;

import eulerproject.tools.Listener;

import java.util.LinkedList;

/**
 * Created by grzesikl on 09/09/2016.
 */
public class ListenerImplTest implements Listener {
    @Override
    public void activate(LinkedList list) {
        System.out.println(list);
    }
}
