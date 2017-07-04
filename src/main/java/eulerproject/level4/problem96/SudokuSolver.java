package eulerproject.level4.problem96;

import javafx.util.Pair;

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

    public SudokuMatrix solveMatrix() throws InterruptedException {

        int watchdog = input.sum();
        System.out.println(input);

        while (!input.isSolved()) {

            for (int number = 1; number <= 9; number++) {

                Set<Integer>[][] allPossible = getAllPossible();

                SudokuMatrix numberMatrix = getAllPossibleForNumber(number, allPossible);

                if (numberMatrix.sum() != 0) {

                    Set<Pair<Integer, Integer>> pairsToSuppress = getPositionsToSupress(numberMatrix);

                    System.out.println(numberMatrix);

                    for (Pair<Integer, Integer> p : pairsToSuppress)
                        numberMatrix.setSudokuArray(p.getValue(), p.getKey(), 0);

                    System.out.println(numberMatrix);

                    Set<Pair<Integer, Integer>> pairsToUpdate = getPositionsToUpdate(numberMatrix);

                    for (Pair<Integer, Integer> p : pairsToUpdate) {
                        input.setSudokuArray(p.getValue(), p.getKey(), number);
                        System.out.println("Setting x="+p.getKey()+" y="+p.getValue()+"  val="+number);
                    }

                }

            }

            if (watchdog == input.sum())
                throw new ArithmeticException("Matrix is not solvable" + input);
            else {
                watchdog = input.sum();
                System.out.println(input);
            }

        }

        return input;
    }

    public Set<Integer>[][] getAllPossible() {
        Set[][] result = new Set[input.getRow(0).length][input.getCol(0).length];

        for (int i = 0; i < input.getRow(0).length; i++) {
            for (int j = 0; j < input.getRow(0).length; j++)
                result[i][j] = getPossibleForPosition(i, j);
        }

        return result;

    }

    public SudokuMatrix getAllPossibleForNumber(int number, Set<Integer>[][] allPossible) {
        String[] arrayAsString = new String[10];
        arrayAsString[0] = "Table with possible numbers for " + number;

        for (int i = 0; i < allPossible.length; i++) {

            StringBuilder line = new StringBuilder();
            for (int j = 0; j < allPossible.length; j++)

                if (allPossible[i][j] != null && allPossible[i][j].contains(number))
                    line.append(number);
                else
                    line.append("0");

            arrayAsString[i + 1] = line.toString();
        }

        return new SudokuMatrix(Arrays.asList(arrayAsString));

    }

    public int getSolution() throws InterruptedException {
        SudokuMatrix matrix = solveMatrix();
        return matrix.getRow(0)[0] * 100 + matrix.getRow(0)[1] * 10 + matrix.getRow(0)[2];
    }

    public Set<Integer> missingNumbers(int[] row) {
        Set<Integer> copyAll = new HashSet<>(allNumbers);

        for (int i = 0; i < row.length; i++)
            copyAll.remove(row[i]);

        return copyAll;
    }

    public Set<Integer> missingNumbers(int[][] square) {
        Set<Integer> copyAll = new HashSet<>(allNumbers);

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

    public Set<Integer> getPossibleForPosition(int y, int x) {
        Set<Integer> missing = new HashSet<>();

        if (input.getRow(y)[x] != 0)
            return null;

        Set<Integer> missingRows = missingNumbers(input.getRow(y));
        Set<Integer> missingCols = missingNumbers(input.getCol(x));

        int square_x = x / 3;
        int square_y = y / 3;

        Set<Integer> missingSquare = missingNumbers(input.getSquare(square_x, square_y));


        missing.addAll(missingRows);
        missing.retainAll(missingCols);
        missing.retainAll(missingSquare);

        return missing;
    }

    public Set<Pair<Integer, Integer>> getPositionsToUpdate(SudokuMatrix positionsForNumber) {

        Set<Pair<Integer, Integer>> result = new HashSet<>();

        if (positionsForNumber.sum() != 0) {


            for (int i = 0; i < 9; i++) {

                int k = positionsForNumber.getUniqueRowIx(i);

                if (k != -1)
                    result.add(new Pair<>(k, i));

                k = positionsForNumber.getUniqueColIx(i);

                if (k != -1)
                    result.add(new Pair<>(i, k));


            }


        }
        return result;


    }


    public Set<Pair<Integer, Integer>> getPositionsToSupress(SudokuMatrix positionsForNumber) {
        Set<Pair<Integer, Integer>> result = new HashSet<>();

        if (positionsForNumber.sum() != 0) {

            for (int x = 0; x < 3; x++)
                for (int y = 0; y < 3; y++) {
                    //for each square
                    int col = getColWithOnlyValues(positionsForNumber.getSquare(x, y));
                    int row = getRowWithOnlyValues(positionsForNumber.getSquare(x, y));

                    if (col != -1) {
                        col = x * 3 + col;

                        for (int r = 0; r < positionsForNumber.getRow(0).length; r++) {
                            if ((r < y * 3 || r >= (y + 1) * 3) && positionsForNumber.getCol(col)[r] != 0)
                                result.add(new Pair<>(col, r));
                        }


                    }

                    if (row != -1) {
                        row = y * 3 + row;

                        for (int c = 0; c < positionsForNumber.getRow(0).length; c++) {
                            if (((c < x * 3 || c >= (x + 1) * 3)) && positionsForNumber.getRow(row)[c] != 0)
                                result.add(new Pair<>(c, row));
                        }

                    }


                }


        }
        return result;
    }

    private int getColWithOnlyValues(int[][] square) {
        int arraySum = getArraySum(square);

        if (arraySum != 0)
            for (int i = 0; i < square.length; i++)
                if (arraySum == getColSum(i, square))
                    return i;

        return -1;
    }

    private int getRowWithOnlyValues(int[][] square) {
        int arraySum = getArraySum(square);

        if (arraySum != 0)
            for (int i = 0; i < square.length; i++)
                if (arraySum == getRowSum(i, square))
                    return i;

        return -1;
    }

    private int getArraySum(int[][] array) {
        int result = 0;

        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++)
                result += array[i][j];

        return result;

    }

    private int getRowSum(int row, int[][] array) {
        int result = 0;

        for (int j = 0; j < array.length; j++)
            result += array[row][j];

        return result;

    }

    private int getColSum(int col, int[][] array) {
        int result = 0;

        for (int i = 0; i < array.length; i++)
            result += array[i][col];

        return result;

    }

}
