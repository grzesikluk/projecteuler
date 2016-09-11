package eulerproject.tools.subsets;

import java.util.*;

/**
 * Created by Lukasz on 2016-09-11.
 */
public class SubSetsImpl<T> implements SubSets<T> {

    @Override
    public void generate(Set<T> set, Listener<T> listener) {

        Iterator<T> iterator = set.iterator();
        T element;

        if (set.isEmpty())
            return;

        Set<Set<T>> subsetResult = new HashSet<>();


        while(iterator.hasNext()) {
            element = iterator.next();

            Set<Set<T>> temp = new HashSet<>();

            for (Set<T> a:subsetResult) {
                temp.add(new HashSet<T>(a));
            }

            for (Set<T> a:temp) {
                a.add(element);
            }

            Set<T> single = new HashSet<>();
            single.add(element);
            temp.add(single);


            subsetResult.addAll(temp);
        }
        for(Set<T> resElem :subsetResult ) {
            listener.activate(resElem);
        }


    }

}
