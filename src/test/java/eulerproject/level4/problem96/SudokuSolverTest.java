package eulerproject.level4.problem96;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lukasz on 2017-07-02.
 */
public class SudokuSolverTest {

    private static String FILE = "src\\test\\java\\eulerproject\\level4\\problem96\\testfile.txt";
    private SudokuMatrix sudokuMatrix1;
    private SudokuMatrix sudokuMatrix2;

    @Before
    public void init() throws IOException {
        FileReader fr = new FileReader(FILE);
        fr.read();
        sudokuMatrix1 = fr.getNext();
        sudokuMatrix2 = fr.getNext();

    }

    @Test
    public void solve() throws Exception {
    }

    @Test
    public void testCountZeroes() throws Exception {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix1);

        Assert.assertEquals(6, sudokuSolver.countZeroes(sudokuMatrix1.getRow(0)));
        Assert.assertEquals(5, sudokuSolver.countZeroes(sudokuMatrix1.getRow(1)));

    }

    @Test
    public void testCountZeroes1() throws Exception {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix1);

        Assert.assertEquals(6, sudokuSolver.countZeroes(sudokuMatrix1.getSquare(0,0)));
        Assert.assertEquals(5, sudokuSolver.countZeroes(sudokuMatrix1.getSquare(1,1)));

    }

    @Test
    public void testMissingNumbers() throws Exception {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix1);
        Set<Integer> expected = new HashSet<>();
        expected.addAll(Arrays.asList(1,4,5,7,8,9));

        Assert.assertEquals(expected, sudokuSolver.missingNumbers(sudokuMatrix1.getRow(0)));
    }

    @Test
    public void testMissingNumbers1() throws Exception {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix1);
        Set<Integer> expected = new HashSet<>();
        expected.addAll(Arrays.asList(2,4,5,6,7,8));

        Assert.assertEquals(expected, sudokuSolver.missingNumbers(sudokuMatrix1.getSquare(0,0)));


        expected.clear();
        expected.addAll(Arrays.asList(1,2,4,6,7,8));

        Assert.assertEquals(expected, sudokuSolver.missingNumbers(sudokuMatrix1.getSquare(2,2)));
    }

    @Test
    public void testGetHistogram() throws Exception {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix1);

        System.out.println(sudokuSolver.getHistogram());


    }

    @Test
    public void testGetNumberToProcess() throws Exception {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix1);

        Assert.assertEquals(2,sudokuSolver.getNumberToProcess());


    }

}