package eulerproject.level4.problem96;

import java.util.*;

/**
 * Created by Lukasz on 2017-07-02.
 */
public class SudokuSolver {

    private static Set<Integer> allNumbers;

    public SudokuMatrix getInput() {
        return input;
    }

    private SudokuMatrix input;
    private static final int MAX_COUNT = 10000;

    static {
        allNumbers = new HashSet<>();
        allNumbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public SudokuSolver(final SudokuMatrix matrix) {
        input = new SudokuMatrix(matrix);
    }

    public SudokuMatrix solveMatrix() {

        int watchdog = 0;

        
        while (!isSolved()) {
            
            Set<Integer>[][] allMissing = getAllMissing();

            for (int i = 0; i < allMissing.length; i++)
                for (int j = 0; j < allMissing.length; j++) {

                    if (allMissing[i][j] != null) {
                        if (allMissing[i][j].size() == 1) {
                            input.setSudokuArray(i, j, (int) allMissing[i][j].toArray()[0]);
                            allMissing[i][j] = null;
                        } else {

                            //todo implement second part of algo


                        }

                    }

                }

            watchdog++;

            if (watchdog == MAX_COUNT)
                throw new ArithmeticException("Matrix is not solvable");

        }

        return input;
    }

    public Set<Integer>[][] getAllMissing() {
        Set[][] result = new Set[input.getRow(0).length][input.getCol(0).length];

        for (int i = 0; i < input.getRow(0).length; i++) {
            for (int j = 0; j < input.getRow(0).length; j++)
                result[i][j] = getMissingForPosition(i, j);
        }

        return result;

    }


    public int getSolution() {
        SudokuMatrix matrix = solveMatrix();
        return matrix.getRow(0)[0] + matrix.getRow(0)[1] + matrix.getRow(0)[2];
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

    public Set<Integer> getMissingForPosition(int a, int b) {

        if (input.getRow(a)[b] != 0)
            return null;

        Set<Integer> missingRows = missingNumbers(input.getRow(a));
        Set<Integer> missingCols = missingNumbers(input.getCol(b));

        int square_a = b / 3;
        int square_b = a / 3;

        Set<Integer> missingSquare = missingNumbers(input.getSquare(square_a, square_b));

        missingRows.retainAll(missingCols);
        missingRows.retainAll(missingSquare);

        return missingRows;
    }

    public boolean isSolved() {

        for (int i = 0; i < input.getCol(0).length; i++) {
            if (Arrays.stream(input.getRow(i)).filter(s -> s == 0).count() != 0)
                return false;
        }

        return true;
    }


}
