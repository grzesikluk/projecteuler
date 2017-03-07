package eulerproject.level4.problem80;

import eulerproject.tools.functions.Squares;
import eulerproject.tools.functions.SquaresBigIntImpl;
import javafx.util.Pair;

import java.util.List;
import java.util.Set;

public class Solution {
    private static final int MAX = 100;

    public static void main(String[] args) {

        Squares squaresAlgo = new SquaresBigIntImpl();
        Set<Integer> squareNumbers = squaresAlgo.getIrrationalSquares(MAX);

        long result = 0;
        for (Integer i : squareNumbers)
            result += Solution.getSumOfAllDigits(squaresAlgo.getSquareRootDigits(i, MAX));

        System.out.println(result);

    }


    public static long getSumOfAllDigits(Pair<List<Integer>, List<Integer>> digits) {

        long result = 0;

        for (Integer i : digits.getKey())
            result += i;

        for (Integer j : digits.getValue())
            result += j;

        return result;

    }
}
