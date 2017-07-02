package eulerproject.level4.problem96;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lukasz on 2017-07-02.
 */
public class SudokuMatrixTest {

    private static List<String> testArray =
            Arrays.asList("Test Array",
                    "100123456",
                    "200123456",
                    "300123456",
                    "400123456",
                    "500123456",
                    "600123456",
                    "700123456",
                    "800123456",
                    "900123456");

    @Test
    public void testGetSquare_test1() throws Exception {
        SudokuMatrix sudokuMatrix = new SudokuMatrix(testArray);

        int[][] expected = new int[3][];
        expected[0] = new int[]{1,0,0};
        expected[1] = new int[]{2,0,0};
        expected[2] = new int[]{3,0,0};

        Assert.assertArrayEquals(expected, sudokuMatrix.getSquare(0,0));
    }

    @Test
    public void testGetSquare_test2() throws Exception {
        SudokuMatrix sudokuMatrix = new SudokuMatrix(testArray);

        int[][] expected = new int[3][];
        expected[0] = new int[]{1,2,3};
        expected[1] = new int[]{1,2,3};
        expected[2] = new int[]{1,2,3};

        Assert.assertArrayEquals(expected, sudokuMatrix.getSquare(1,1));
    }

    @Test
    public void testGetSquare_test3() throws Exception {
        SudokuMatrix sudokuMatrix = new SudokuMatrix(testArray);

        int[][] expected = new int[3][];
        expected[0] = new int[]{7,0,0};
        expected[1] = new int[]{8,0,0};
        expected[2] = new int[]{9,0,0};

        Assert.assertArrayEquals(expected, sudokuMatrix.getSquare(0,2));
    }

    @Test
    public void testGetSquare_test4() throws Exception {
        SudokuMatrix sudokuMatrix = new SudokuMatrix(testArray);

        int[][] expected = new int[3][];
        expected[0] = new int[]{4,5,6};
        expected[1] = new int[]{4,5,6};
        expected[2] = new int[]{4,5,6};

        Assert.assertArrayEquals(expected, sudokuMatrix.getSquare(2,2));
    }

    @Test
    public void testGetCol() throws Exception {
        SudokuMatrix sudokuMatrix = new SudokuMatrix(testArray);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, sudokuMatrix.getCol(0));
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}, sudokuMatrix.getCol(1));
    }

    @Test
    public void testGetRow() throws Exception {
        SudokuMatrix sudokuMatrix = new SudokuMatrix(testArray);
        Assert.assertArrayEquals(new int[]{1, 0, 0, 1, 2, 3, 4, 5, 6}, sudokuMatrix.getRow(0));
        Assert.assertArrayEquals(new int[]{9, 0, 0, 1, 2, 3, 4, 5, 6}, sudokuMatrix.getRow(8));
    }


}