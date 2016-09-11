package eulerproject.level3.problem51;

import eulerproject.tools.subsets.Listener;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lukasz on 2016-09-11.
 */
public class ListenerProblem51<Integer> implements Listener {

    public Set<Set<Integer>> getResult() {
        return result;
    }

    private Set<Set<Integer>> result = new HashSet<>();

    @Override
    public void activate(Set set) {

        result.add(set);
    }


    @Override
    public String toString() {
        return result.toString();
    }



}
