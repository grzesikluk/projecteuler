package eulerproject.level4.problem93;

import eulerproject.tools.combinatorics.Listener;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Problem93Listener<T> implements Listener<T>
{
    Set<List<T>> setToReturn;

    Problem93Listener(Set<List<T>> set)
    {
        setToReturn = set;
    }

    @Override
    public void activate(final List<T> list)
    {
        setToReturn.add(new LinkedList<>(list));
    }

    public Set<List<T>> getResults() {
        return setToReturn;
    }
}
