package projecteuler.problem49;

import projecteuler.problem43.Listener;
import projecteuler.problem50.Primes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by grzesikl on 09/09/2016.
 */
public class ListenerImplCheckProblem49<T> implements Listener<T> {
    private Set<Integer> setOfConvertedResults = new HashSet<>();

    public void activate(LinkedList<T> list) {
        setOfConvertedResults.add(toNumber((LinkedList<Character>) list));
    }

    public Set<Integer> getResults() {

        return setOfConvertedResults;
    }

    public static int toNumber(LinkedList<Character> list) {
        String tempStr = "";
        String resString;

        for (Character c : list) {
            tempStr += c;
        }

        resString = tempStr.replaceFirst ("^0*", "");


        return new Integer(resString);
    }

}