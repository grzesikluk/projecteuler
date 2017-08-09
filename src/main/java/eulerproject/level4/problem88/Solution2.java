package eulerproject.level4.problem88;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Lukasz on 2017-08-06.
 */
public class Solution2 {

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
        if (i < input.length - 1)
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

    public static int[] generateMinimum(int n) {
        int maxP = getPowerTwo(n);
        int[] tab = new int[maxP +1 ];
        IntStream.range(0, tab.length).forEach(i -> tab[i] = Integer.MAX_VALUE);



        for (int p = 2; p <= n; p++) {
            //construct the array
            int[] pArray = new int[p];
            IntStream.range(0, p).forEach(i -> pArray[i] = 2);

            int ix = 0;

            do {
                int mul = getMultOfArray(pArray);
                int sum = getSumOfArray(pArray);
                int k = mul - sum + p;
                updateBigArray(tab, k - 1, mul);

            } while ((ix = increaseArrayAndReturnIndex(pArray, ix, p + 1)) != -1);

        }
        return tab;
    }


    private static int increaseArrayAndReturnIndex(int array[], int i, int p) {

        if (array[i] < p) {
            array[i]++;
        } else {
            if (i < array.length - 1) {
                i++;
                increaseArrayAndReturnIndex(array, i, p);
            } else
                return -1;
        }


        return i;


    }

    private static void updateBigArray(int[] bigArray, int k, int v) {
        if (bigArray.length > k && bigArray[k] > v)
            bigArray[k] = v;
    }

    private static int getPowerTwo(int k) {
        int result = 1;

        while ((k = k / 2) != 0)
            result++;
        return result;

    }

}
