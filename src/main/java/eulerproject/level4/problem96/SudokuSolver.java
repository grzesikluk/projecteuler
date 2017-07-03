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

    public SudokuMatrix solveMatrix() throws InterruptedException {

        int watchdog = 0;


        while (!isSolved()) {
            Set<Integer>[][] allMissing = getAllPossible();

            outerloop:
            for (int i = 0; i < allMissing.length; i++)
                for (int j = 0; j < allMissing.length; j++) {

                    if (allMissing[i][j] != null) {

//                        if (allMissing[i][j].size() == 1) {
//                            //first case - trivial to solve
//                            System.out.println("TRIV: Updating [" + i + " " + j + "] " + (int) allMissing[i][j].toArray()[0] );
//                            input.setSudokuArray(i, j, (int) allMissing[i][j].toArray()[0]);
//                            break outerloop;
//
//                        } else {

                            Set<Integer> remaining = getRemainingPositionsForColumn(i, j, allMissing);

                            if (remaining.size() == 1) {
                                System.out.println("COL: Updating [" + i + " " + j + "] " + (int) remaining.toArray()[0] );
                                input.setSudokuArray(i, j, (int) remaining.toArray()[0]);
                                break outerloop;
                            }

                            remaining = getRemainingPositionsForRow(i, j, allMissing);

                            if (remaining.size() == 1) {
                                System.out.println("ROW: Updating [" + i + " " + j + "] " + (int) remaining.toArray()[0] );
                                input.setSudokuArray(i, j, (int) remaining.toArray()[0]);
                                break outerloop;
                            }
                            
                            remaining = getRemainingPositionsForSquare(i, j, allMissing);

                            if (remaining.size() == 1) {
                                System.out.println("SQR: Updating [" + i + " " + j + "] " + (int) remaining.toArray()[0] );
                                input.setSudokuArray(i, j, (int) remaining.toArray()[0]);
                                break outerloop;
                            }

//                        }

                    }

                }

            watchdog++;

            if (watchdog == MAX_COUNT)
                throw new ArithmeticException("Matrix is not solvable" + input  );

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


    public int getSolution() throws InterruptedException {
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

    public boolean isSolved() {

        for (int i = 0; i < input.getCol(0).length; i++) {
            if (Arrays.stream(input.getRow(i)).filter(s -> s == 0).count() != 0)
                return false;
        }

        return true;
    }

    public Set<Integer> getRemainingPositionsForColumn(int a, int b, Set<Integer>[][] allMissing) {
        if (allMissing[a][b] == null)
            return null;

        Set<Integer> missingForField = new HashSet<>(allMissing[a][b]);

        for (int i = 0; i < allMissing.length; i++) {
            if (i != a && allMissing[i][b] != null)
                missingForField.removeAll(allMissing[i][b]);

            if (missingForField.size() == 0 )
                break;
        }

        return missingForField;

    }

    public Set<Integer> getRemainingPositionsForRow(int a, int b, Set<Integer>[][] allMissing) {

        if (allMissing[a][b] == null)
            return null;

        Set<Integer> missingForField = new HashSet<>(allMissing[a][b]);

        for (int i = 0; i < allMissing.length; i++) {
            if (i != b && allMissing[a][i] != null)
                missingForField.removeAll(allMissing[a][i]);

            if (missingForField.size() == 0 )
                break;
        }

        return missingForField;

    }

    public Set<Integer> getRemainingPositionsForSquare(int a, int b, Set<Integer>[][] allMissing) {

        if (allMissing[a][b] == null)
            return null;
        
        Set<Integer> missingForField = new HashSet<>(allMissing[a][b]);

        int start_y = a / 3;
        int start_x = b / 3;

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++)


                if (!((x + start_x) == a && (y + start_y) == b) && allMissing[y + start_y*3][x + start_x*3] != null) {

                    missingForField.removeAll(allMissing[y + start_y*3][x + start_x*3]);

                    if (missingForField.size() == 0 )
                        return missingForField;
                }

            }

        return missingForField;

    }
}
