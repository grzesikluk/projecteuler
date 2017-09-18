package eulerproject.tools.combinatorics;

import java.util.List;

public interface Combination<T>
{
    void generate(int size, List<T> input, Listener listener);

}
