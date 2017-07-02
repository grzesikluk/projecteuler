package eulerproject.level4.problem96;

import java.util.*;

/**
 * Created by Lukasz on 2017-07-02.
 */
public class SudokuSolver {
    private static Set<Integer> allNumbers;
    private SudokuMatrix input;


    static {
        allNumbers = new HashSet<>();
        allNumbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public SudokuSolver(final SudokuMatrix matrix) {
        input = new SudokuMatrix(matrix);
    }


    public SudokuMatrix solve() {


        return null;
    }


    public int countZeroes(int[] row) {
        int result = 0;

        for (int i = 0; i < row.length; i++)
            if (row[i] == 0)
                result++;

        return result;
    }

    public int countZeroes(int[][] square) {
        int result = 0;

        for (int i = 0; i < square.length; i++)
            result += countZeroes(square[i]);

        return result;
    }

    public Set<Integer> missingNumbers(int[] row) {
        Set<Integer> copyAll = new HashSet<>(allNumbers);

        for (int i = 0; i < row.length; i++)
            copyAll.remove(row[i]);

        return copyAll;
    }

    public Set<Integer> missingNumbers(int[][] square) {
        Set<Integer> copyAll = new HashSet<>(allNumbers);
        Set<Integer> existing = new HashSet<>();

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++)
                copyAll.remove(square[i][j]);
        }

        return copyAll;
    }

    public Map<Integer, Integer> getHistogram() {

        Map<Integer, Integer> histogram = new HashMap<>();

        for (int i = 0; i < input.getCol(0).length; i++) {

            for (int j = 0; j < input.getRow(i).length; j++) {

                int[] row = input.getRow(i);

                if (histogram.containsKey(row[j])) {
                    histogram.replace(row[j], histogram.get(row[j]) + 1);

                } else {
                    histogram.put(row[j], 1);
                }

            }

        }

        histogram.remove(0);

        return histogram;

    }

    public int getNumberToProcess() {

        Map<Integer, Integer> histogram = getHistogram();

        int val = 0;
        int key = 0;

        for (Integer i : histogram.keySet()) {
            int number = histogram.get(i);

            if (number != 9) {
                if (val < number) {
                    val = number;
                    key = i;
                }
            }
        }

        return key;
    }

}
