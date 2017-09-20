package eulerproject.tools.combinatorics;

import java.util.Set;

public interface Combination<T>
{
    void generate(final Set<T> input, final Listener<T> listener);
}
