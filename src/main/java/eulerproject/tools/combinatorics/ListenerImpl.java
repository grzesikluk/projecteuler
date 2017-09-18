package eulerproject.tools.combinatorics;

import java.util.List;

/**
 * Created by Lukasz on 2016-08-28.
 */
public class ListenerImpl<T> implements Listener<T> {

    public void activate(List<T> list) {
        System.out.println(list);
    }
}
