package eulerproject.level3.problem60;

import eulerproject.tools.subsets.Listener;

import java.util.List;

/**
 * Created by Lukasz on 2016-09-26.
 */
public interface ParralellFixedSubSetProblem60<T> {

    void generate(List<T> list, Listener<T> listener, int minIx , int maxIx, int maxSize);
}
