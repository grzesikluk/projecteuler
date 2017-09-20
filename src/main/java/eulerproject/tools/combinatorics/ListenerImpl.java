package eulerproject.tools.combinatorics;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lukasz on 2016-08-28.
 */
public class ListenerImpl<T> implements Listener<T> {

    List<List<T>> collectedResults;

    ListenerImpl() {
        collectedResults = new LinkedList<>();
    }
    public void activate(final List<T> list) {
        collectedResults.add(new LinkedList<>(list));
    }

    @Override
    public List<List<T>> getResults()
    {
        return collectedResults;
    }
}
