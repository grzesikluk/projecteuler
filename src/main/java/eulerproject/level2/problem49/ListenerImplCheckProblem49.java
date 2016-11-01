package eulerproject.level2.problem49;

import eulerproject.tools.permutation.Listener;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by grzesikl on 09/09/2016.
 */
public class ListenerImplCheckProblem49<T> implements Listener<T> {
    private Set<Integer> setOfConvertedResults = new HashSet<>();

    public void activate(List<T> list) {
        setOfConvertedResults.add(toNumber((LinkedList<Character>) list));
    }

    public Set<Integer> getResults() {

        return setOfConvertedResults;
    }

    public static int toNumber(List<Character> list) {
        String tempStr = "";
        String resString;

        for (Character c : list) {
            tempStr += c;
        }

        resString = tempStr.replaceFirst ("^0*", "");


        return new Integer(resString);
    }

}