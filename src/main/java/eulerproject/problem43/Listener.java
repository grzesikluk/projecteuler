package eulerproject.problem43;

import java.util.LinkedList;

/**
 * Created by Lukasz on 2016-08-28.
 */
public interface Listener<T> {

    public void activate(LinkedList<T> list);
}
