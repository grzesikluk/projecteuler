package eulerproject.tools.combinatorics;

import java.util.Collections;
import java.util.List;

/**
 * Created by Lukasz on 2016-08-28.
 */
public class ListenerImpl<T> implements Listener<T> {

    List<List<T>> collectedResults;

    ListenerImpl() {
        collectedResults = Collections.emptyList();
    }
    public void activate(List<T> list) {
        collectedResults.add(list);
    }

    @Override
    public List<List<T>> getResults()
    {
        return collectedResults;
    }
}
