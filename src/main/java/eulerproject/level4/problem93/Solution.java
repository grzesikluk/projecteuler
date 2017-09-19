package eulerproject.level4.problem93;

import eulerproject.tools.arithmetic.RPNCalculator;
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
        System.out.println(getResultsForDigits(1, 2, 3, 4));
    }

    public static String createEquation(final int equationType, List<String> operators, final int... numbers)
    {
        List<String> digits = IntStream.of(numbers).mapToObj(i -> Integer.toString(i)).collect(Collectors.toList());
        return getEquation(digits, operators, equationType).stream().reduce("", (a, b) -> a + b + " ");
    }

    public static Set<Integer> getResultsForDigits(int... inputNumbers)
    {
        Set<Integer> result = new HashSet<>();
        Set<List<String>> numbersVariants = generateAllOrders(IntStream.of(inputNumbers).mapToObj(i -> Integer.toString(i)).collect(Collectors.toList()));
        Set<List<String>> operatorVariants = generateAllOrdersWithRepetitions(Arrays.asList("+", "-", "/", "*"));

        List<List<String>> allEquations = new ArrayList<>();

        for (List<String> numbers : numbersVariants) {
            for (List<String> operators : operatorVariants) {
                IntStream.range(0, 5).forEach(equationType -> allEquations.add(getEquation(numbers, operators, equationType)));
            }
        }

        for (List<String> equation : allEquations) {
            try {
                int res = RPNCalculator.calculateExpression(equation);
                if (res > 0)
                    result.add(res);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return result;
    }

    private static List<String> getEquation(List<String> digits, List<String> operators, int equationType)
    {
        List<String> equation = new LinkedList<>();

        switch (equationType) {
            case 0: { //DDODODO
                equation.add(digits.get(0));
                equation.add(digits.get(1));
                equation.add(operators.get(0));
                equation.add(digits.get(2));
                equation.add(operators.get(1));
                equation.add(digits.get(3));
                equation.add(operators.get(2));
                break;
            }
            case 1: { //DDDODOO
                equation.add(digits.get(0));
                equation.add(digits.get(1));
                equation.add(digits.get(2));
                equation.add(operators.get(0));
                equation.add(digits.get(3));
                equation.add(operators.get(1));
                equation.add(operators.get(2));
                break;
            }
            case 2: { //DDODDOO
                equation.add(digits.get(0));
                equation.add(digits.get(1));
                equation.add(operators.get(0));
                equation.add(digits.get(2));
                equation.add(digits.get(3));
                equation.add(operators.get(1));
                equation.add(operators.get(2));
                break;
            }
            case 3: { //DDDDOOO
                equation.add(digits.get(0));
                equation.add(digits.get(1));
                equation.add(digits.get(2));
                equation.add(digits.get(3));
                equation.add(operators.get(0));
                equation.add(operators.get(1));
                equation.add(operators.get(2));
                break;
            }
            case 4: {  //DDDOODO
                equation.add(digits.get(0));
                equation.add(digits.get(1));
                equation.add(digits.get(2));
                equation.add(operators.get(0));
                equation.add(operators.get(1));
                equation.add(digits.get(3));
                equation.add(operators.get(2));
                break;
            }
        }

        return equation;
    }

    public static Set<List<String>> generateAllOrders(List<String> input)
    {

        Permutation<String> permutation = new PermutationWithoutRepetitionsImpl<>();
        Problem93Listener listener = new Problem93Listener(new HashSet<>());
        List<String> linkedList = new LinkedList<>(input);

        permutation.generate(linkedList, listener);
        return listener.getSetOfResults();
    }

    public static Set<List<String>> generateAllOrdersWithRepetitions(List<String> input)
    {

        Permutation<String> permutation = new PermutationWithRepetitionsImpl<>(3);
        Problem93Listener listener = new Problem93Listener(new HashSet<>());
        List<String> linkedList = new LinkedList<>(input);

        permutation.generate(linkedList, listener);
        return listener.getSetOfResults();
    }

    public static int consecutiveLengthOfIntegers(int start, Set<Integer> inputSet)
    {
        if (start > inputSet.size())
            throw new IllegalArgumentException("Start point wrong");

        List<Integer> list = inputSet.stream().sorted().collect(Collectors.toList());

        int k = start + 1;
        while (k < list.size() && list.get(k).equals(list.get(k - 1) + 1))
            k++;
        return k;
    }
}
