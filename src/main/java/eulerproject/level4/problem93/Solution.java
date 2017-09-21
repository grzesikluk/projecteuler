package eulerproject.level4.problem93;

import eulerproject.tools.arithmetic.RPNCalculator;
import eulerproject.tools.combinatorics.Combination;
import eulerproject.tools.combinatorics.CombinationWithoutRepetitionImpl;
import eulerproject.tools.combinatorics.Listener;
import eulerproject.tools.combinatorics.Permutation;
import eulerproject.tools.combinatorics.PermutationWithRepetitionsImpl;
import eulerproject.tools.combinatorics.PermutationWithoutRepetitionsImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution
{

    public static void main(String[] args)
    {
        final Combination<Integer> combination = new CombinationWithoutRepetitionImpl<>(4);
        final Set<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9).stream().collect(Collectors.toSet());
        final Set<List<Integer>> allNumbersVariants = new HashSet<>();
        final Listener<Integer> listener = new Problem93Listener<>(allNumbersVariants);

        combination.generate(numbers,listener);

        int max = 0;
        List<Integer> numbersFound = null;

        for(List<Integer> numbersList:allNumbersVariants) {
            int s = consecutiveLengthOfIntegers(0,getResultsForDigits(numbersList.stream().mapToInt(i->i).toArray()));

            if(max < s) {
                numbersFound = numbersList;
                max = s;
            }

        }
        System.out.println(numbersFound + " " + max);
    }

    public static Set<Double> getResultsForDigits(final int... inputNumbers)
    {
        final Set<Double> result = new HashSet<>();
        final Set<List<String>> numbersVariants = generateAllOrders(IntStream.of(inputNumbers).mapToObj(i -> Integer.toString(i)).collect(Collectors.toList()));
        final Set<List<String>> operatorVariants = generateAllOrdersWithRepetitions(Arrays.asList("+", "-", "/", "*"));

        final List<List<String>> allEquations = new ArrayList<>();

        for (List<String> numbers : numbersVariants) {
            for (List<String> operators : operatorVariants) {
                Arrays.stream(EquationType.values())
                        .forEach(equationType -> allEquations.add(EquationType.getEquation(equationType,numbers, operators)));
            }
        }

        for (List<String> equation : allEquations) {
            try {
                double res = RPNCalculator.calculateExpression(equation);
                if (res > 0)
                    result.add(res);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return result;
    }


    public static Set<List<String>> generateAllOrders(final List<String> input)
    {

        final Permutation<String> permutation = new PermutationWithoutRepetitionsImpl<>();
        final Problem93Listener listener = new Problem93Listener(new HashSet<>());
        final List<String> linkedList = new LinkedList<>(input);

        permutation.generate(linkedList, listener);
        return listener.getSetOfResults();
    }

    public static Set<List<String>> generateAllOrdersWithRepetitions(final List<String> input)
    {

        final Permutation<String> permutation = new PermutationWithRepetitionsImpl<>(3);
        final Problem93Listener listener = new Problem93Listener(new HashSet<>());
        final List<String> linkedList = new LinkedList<>(input);

        permutation.generate(linkedList, listener);
        return listener.getSetOfResults();
    }

    public static int consecutiveLengthOfIntegers(final int start, final Set<Double> inputSet)
    {
        if (start > inputSet.size())
            throw new IllegalArgumentException("Start point wrong");

        final double[] list = inputSet
                .stream()
                .mapToDouble(d->d)
                .filter(d->d == (int)d)
                .sorted().toArray();

        int k = start + 1;
        while (k < list.length && list[k] == (list[k - 1] + 1))
            k++;
        return k;
    }
}
