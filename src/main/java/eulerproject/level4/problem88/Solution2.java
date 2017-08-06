package eulerproject.level4.problem88;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Lukasz on 2017-08-06.
 */
public class Solution2 {


    /**
     * @param k - number of compositions of N number.
     */
    public static int generateMinimumFromCompositions(int k) {
        int[] array = new int[k];
        int i = 0;

        IntStream.range(0, k).forEach(s -> array[s] = 1);

        List<Integer> allSolutions = new ArrayList<>();
        getMinimumFromCompositionRecurssion(array, 0, allSolutions);

        return allSolutions.stream().mapToInt(s -> s).min().getAsInt();


    }

    private static void getMinimumFromCompositionRecurssion(final int[] input, final int i, List<Integer> solutions) {
        int[] array = Arrays.copyOf(input, input.length);

        if (getSumOfArray(array) == getMultOfArray(array))
            solutions.add(getMultOfArray(array));

        if (array[i] < array.length)
            array[i]++;
        else
            return;


        getMinimumFromCompositionRecurssion(array, i, solutions);
        if (i < input.length -1 )
            getMinimumFromCompositionRecurssion(array, i + 1, solutions);


    }


    private static int getMultOfArray(int[] array) {
        final int[] sum = {1};

        IntStream.range(0, array.length).forEach(i -> {
                    sum[0] *= array[i];
                }
        );

        return sum[0];
    }

    private static int getSumOfArray(int[] array) {
        return IntStream.range(0, array.length).map(s -> array[s]).sum();
    }
}
