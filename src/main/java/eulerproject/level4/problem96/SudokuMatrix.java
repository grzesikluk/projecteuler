package eulerproject.level4.problem96;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lukasz on 2017-07-02.
 */
public class SudokuMatrix {

    private static int MAX = 9;
    private static int MAX_SQUARE = 3;

    private int[][] sudokuArray;
    private String name;

    public SudokuMatrix(List<String> input) {

        if (input.size() != MAX + 1)
            throw new IllegalArgumentException("Wrong input list length");

        name = input.get(0);

        sudokuArray = new int[MAX][];

        for (int i = 1; i <= MAX; i++)
            addIntRow(i - 1, input.get(i));

    }

    public SudokuMatrix(SudokuMatrix matrix) {

        name = matrix.name;
        sudokuArray = new int[MAX][MAX];

        for (int i = 0; i < MAX; i++)
            for (int j = 0; j < MAX; j++)
                sudokuArray[i][j] = matrix.sudokuArray[i][j];

    }

    private int[] getIntRow(String line) {
        int[] result = new int[MAX];

        if (line.length() != MAX)
            throw new IllegalArgumentException("Line size is wrong");

        int i = 0;
        for (Character c : line.toCharArray()) {

            if (c.charValue() < 48 || c.charValue() > 58)
                throw new IllegalArgumentException("Wrong character in string");

            result[i] = c.charValue() - 48;
            i++;
        }

        return result;
    }

    private void addIntRow(int a, String line) {
        sudokuArray[a] = getIntRow(line);
    }

    public int[][] getSquare(int a, int b) {

        if (a >= MAX_SQUARE || b >= MAX_SQUARE || a < 0 || b < 0)
            throw new IllegalArgumentException("Wrong input index value");

        int start_x = a * MAX_SQUARE;
        int start_y = b * MAX_SQUARE;

        int[][] result = new int[MAX_SQUARE][MAX_SQUARE];

        for (int x = 0; x < MAX_SQUARE; x++)
            for (int y = 0; y < MAX_SQUARE; y++) {
                result[y][x] = sudokuArray[y + start_y][x + start_x];
            }

        return result;
    }

    public int getSquareSum(int a, int b) {
        return getArraySum(getSquare(a, b));
    }

    private int getArraySum(int[][] array) {
        int result = 0;

        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++)
                result += array[i][j];

        return result;

    }

    public int[] getCol(int a) {

        if (a > MAX - 1)
            throw new IndexOutOfBoundsException("index is exceeding the maximum of sudoku (0-8) allowed");

        int[] result = new int[MAX];

        for (int i = 0; i < MAX; i++)
            result[i] = sudokuArray[i][a];

        return result;
    }

    public int[] getRow(int a) {

        if (a > MAX - 1)
            throw new IndexOutOfBoundsException("index is exceeding the maximum of sudoku (0-8) allowed");


        int[] result = Arrays.copyOf(sudokuArray[a], MAX);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(name + "\n");

        for (int i = 0; i < MAX; i++) {
            sb.append("[");
            for (int j = 0; j < MAX; j++) {
                sb.append(sudokuArray[i][j] + " ");
            }
            sb.append("]\n");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuMatrix that = (SudokuMatrix) o;

        if (!Arrays.deepEquals(sudokuArray, that.sudokuArray)) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(sudokuArray);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public void setSudokuArray(int a, int b, int val) {
        if (val < 0 || val > MAX || a < 0 || b < 0 || a >= MAX || b >= MAX)
            throw new IllegalArgumentException("Wrong indexes or value a= " +a+ " b= "+b+" val ="+val);

        sudokuArray[a][b] = val;
    }

    public int sum() {
        return getArraySum(sudokuArray);
    }

    public boolean isSolved() {

        for (int i = 0; i < getCol(0).length; i++) {
            if (Arrays.stream(getRow(i)).filter(s -> s == 0).count() != 0)
                return false;
        }

        return true;
    }

    private int getUniqueArrayIx(int[] array) {
        int val = 0;
        int ix  = -1;

        for (int i = 0; i < MAX; i++) {
            if (array[i] != 0) {

                if (val == 0) {
                    ix = i;
                    val = array[i];

                }
                else {
                    return -1;
                }

            }

        }

        return ix;
    }

    public int getUniqueRowIx(int a) {
        return getUniqueArrayIx(getRow(a));
    }

    public int getUniqueColIx(int a) {
        return getUniqueArrayIx(getCol(a));
    }


}
