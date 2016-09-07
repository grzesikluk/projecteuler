package eulerproject.problem49;

import eulerproject.problem43.Listener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lukasz on 2016-09-06.
 */
public class PermListenerImpl<C> implements Listener<Character> {

    private List<Integer> list;

    public PermListenerImpl() {
        list = new ArrayList<Integer>();
    }

    public void clear() {
        list.clear();
    }

    public void activate(LinkedList<Character> list) {

        System.out.println(list);

        //TODO:
        //convert to Integer
        //add to list

    }

    public List<Integer> getList() {
        return list;
    }

}
