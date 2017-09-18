package eulerproject.tools.combinatorics;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class PermutationWithRepetitionsImpl<T> implements Permutation<T>
{
    @Override
    public void generate(final List<T> input, final Listener listener)
    {
        int[] indexes = new int[input.size()];
        int total = (int)Math.pow(indexes.length, indexes.length);

        while (total-- > 0) {
            List<T> temp = new LinkedList<>();

            IntStream.range(0, indexes.length).forEach(i-> {temp.add(input.get(indexes[i]));});

            listener.activate(temp);

            for (int i = 0; i < indexes.length; i++) {
                if (indexes[i] >= indexes.length - 1) {
                    indexes[i] = 0;
                } else {
                    indexes[i]++;
                    break;
                }
            }
        }




    }




}
