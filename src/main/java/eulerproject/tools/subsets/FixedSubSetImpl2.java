package eulerproject.tools.subsets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Lukasz on 2016-09-26.
 */
public class FixedSubSetImpl2<T> implements  FixedSubSet<T> {


    @Override
    public void generate(Set<T> set, Listener<T> listener, int k) {

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
            if (resElem.size() == k)
                listener.activate(resElem);
        }


    }
}
