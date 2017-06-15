package eulerproject.level4.problem88;


import eulerproject.tools.generators.BoundedCompositions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

//        for(int i=3;i<100; i++)
        System.out.println(getAccumulatedMinimumProductSum(5));

    }


    public static int getAccumulatedMinimumProductSum(int max) {
        Set<Integer> result = new HashSet<>();


        for (int i = 2; i <= max; i++)
            result.add(getMinimumProductSum(i));

        return result.stream().mapToInt(s -> s).sum();
    }

    public static int getMinimumProductSum(int k) {


        int i = k + 1;
        int result;

        //todo: this might be optimised no need to generate all compositions
        Set<List<Integer>> listOfCompositions;

        do {
            listOfCompositions = new BoundedCompositions(i, k, 1, i/2+1).generate();
            i++;
        }
        while ((result = checkComposition(listOfCompositions)) == 0);

        return result;
    }

    public static int checkComposition(Set<List<Integer>> inputSet) {

        for (List<Integer> list : inputSet) {

            int s = checkOneComposition(list);
            if (s != 0)
                return s;

        }
        return 0;

    }

    public static int checkOneComposition(List<Integer> list) {

        int sum = 0;
        int product = 1;

        for (Integer i : list) {
            sum += i;
            product *= i;
        }

        if (sum == product)
            return sum;

        else
            return 0;

    }

}
