package eulerproject.level4.problem88;

import eulerproject.tools.generators.ListenedBoundedCompositions;
import eulerproject.tools.combinatorics.Listener;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class Solution
{

    public static void main(String[] args)
    {
        System.out.println(getAccumulatedMinimumProductSumRecursive(30).stream().mapToInt(s -> s).sum());
    }

    public static int getAccumulatedMinimumProductSum(int max)
    {
        Set<Integer> result = new HashSet<>();

        for (int i = 2; i <= max; i++)
            result.add(getMinimumProductSum(i));

        return result.stream().mapToInt(s -> s).sum();
    }

    public static Set<Integer> getAccumulatedMinimumProductSumRecursive(int max)
    {
        Set<Integer> set;

        if (max == 2) {
            set = new HashSet<>();
            set.add(4);
            return set;
        } else {
            set = getAccumulatedMinimumProductSumRecursive(max - 1);
            set.add(getMinimumProductSum(max));

            return set;
        }
    }

    public static int getMinimumProductSum(int k)
    {
        int i = k + 1;
        int result;

        Set<List<Integer>> listOfCompositions;

        do {
            Listener<Integer> listener = new Listener<Integer>()
            {
                @Override
                public void activate(List<Integer> list)
                {
                    //do nothing;
                }

                @Override
                public List<List<Integer>> getResults()
                {
                    return null;
                }
            };

            Predicate<List<Integer>> predicate = new Predicate<List<Integer>>()
            {
                @Override
                public boolean test(List<Integer> integers)
                {
                    return checkOneComposition(integers) != 0;
                }
            };

            ListenedBoundedCompositions listenedBoundedCompositions = new ListenedBoundedCompositions(i, k, 1, i / 2 + 1, listener, predicate);
            listOfCompositions = listenedBoundedCompositions.generate();
            i++;
        }
        while ((result = checkComposition(listOfCompositions)) == 0);

        return result;
    }

    public static int checkComposition(Set<List<Integer>> inputSet)
    {
        for (List<Integer> list : inputSet) {
            int s = checkOneComposition(list);
            if (s != 0)
                return s;
        }
        return 0;
    }

    public static int checkOneComposition(List<Integer> list)
    {
        int sum = 0;
        int product = 1;

        for (Integer i : list) {
            sum += i;
            product *= i;
        }

        return (sum == product)? sum: 0;
    }
}
