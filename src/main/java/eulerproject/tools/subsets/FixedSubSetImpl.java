package eulerproject.tools.subsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-09-26.
 */
public class FixedSubSetImpl<T> implements  FixedSubSet<T> {


    @Override
    public void generate(Set<T> set, Listener<T> listener, int k) {
        List<Boolean> used = new ArrayList<>(set.size());
        set.forEach(a->used.add(false));

        subset(set.stream().collect(Collectors.toList()), k, 0, 0,used,listener);

    }


    private void subset(List<T> inputSet, int k, int start, int currLen, List<Boolean> used, Listener<T> listener) {

        if (currLen == k) {
            Set<T> subSet = new HashSet<T>();

            for (int i = 0; i < inputSet.size(); i++) {
                if (used.get(i) == true) {
                    subSet.add(inputSet.get(i));
                }
            }
            listener.activate(subSet);

            return;
        }
        if (start == inputSet.size()) {
            return;
        }

        used.set(start,true);
        subset(inputSet, k, start + 1, currLen + 1, used,listener);

        used.set(start,false);
        subset(inputSet, k, start + 1, currLen, used,listener);
    }
}
