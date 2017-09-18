package eulerproject.level4.problem93;

import eulerproject.tools.combinatorics.Permutation;
import eulerproject.tools.combinatorics.PermutationImpl;

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
        System.out.println(getResultsForDigits(1,2,3,4));
    }

    public static String createEquation(final int equationType, List<String> operators,final int... numbers)
    {
        List<String> digits = IntStream.of(numbers).mapToObj(i -> Integer.toString(i)).collect(Collectors.toList());
        return getEquation(digits, operators, equationType).stream().reduce("", (a, b) -> a + b + " ");
    }

    public static Set<Integer> getResultsForDigits(int... numbers)
    {
        Set<Integer> result = new HashSet<>();
        Set<List<String>> allOrders = generateAllOrders(IntStream.of(numbers).mapToObj(i -> Integer.toString(i)).collect(Collectors.toList()));

        for (List<String> list : allOrders) {
            int[] nums = list.stream().mapToInt(s -> Integer.parseInt(s)).toArray();

//            Set<Integer> set = IntStream.range(0, 5)
//                    .mapToObj(i -> createEquation(i, nums, ))
//                    .mapToInt(expression -> RPNCalculator.calculateExpression(expression))
//                    .filter(i -> i > 0)
//                    .mapToObj(Integer::new)
//                    .collect(Collectors.toSet());
//            result.addAll(set);

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

        Permutation<String> permutation = new PermutationImpl<>();
        Problem93Listener listener = new Problem93Listener(new HashSet<>());
        List<String> linkedList = new LinkedList<>(input);

        permutation.generate(input.size() - 1, linkedList, listener);
        return listener.getSetOfResults();
    }
}
