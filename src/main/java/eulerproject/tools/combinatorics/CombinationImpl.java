package eulerproject.tools.combinatorics;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CombinationImpl<T> implements Combination<T>
{
    @Override
    public void generate(final int size, final List<T> values, final Listener listener)
    {
        List<List<T>> list = generateRecursively(size, values);
        list.stream().forEach(l->listener.activate(l));
    }

    private List<List<T>> generateRecursively(final int size, final List<T> values) {

        if (0 == size || values.isEmpty()) {
            return Collections.emptyList();
        }

        List<List<T>> combination = new LinkedList<>();
        T actual = values.iterator().next();

        List<T> subSet = new LinkedList<T>(values);
        subSet.remove(actual);

        List<List<T>> subSetCombination = generateRecursively(size -1, subSet);

        for (List<T> set : subSetCombination) {
            List<T> newSet = new LinkedList<T>(set);
            newSet.add(0, actual);
            combination.add(newSet);
        }

        combination.addAll(generateRecursively(size, subSet));

        return combination;
    }
}
