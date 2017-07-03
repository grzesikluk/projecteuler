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
    private SudokuMatrix sudokuMatrix3;
    private SudokuMatrix sudokuMatrix4;

    @Before
    public void init() throws IOException {
        FileReader fr = new FileReader(FILE);
        fr.read();
        sudokuMatrix1 = fr.getNext();
        sudokuMatrix2 = fr.getNext();
        sudokuMatrix3 = fr.getNext();
        sudokuMatrix4 = fr.getNext();
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

    @Test
    public void testGetMissingForPosition() throws Exception {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix1);
        Set<Integer> expected = new HashSet<>();

        expected.addAll(Arrays.asList(4,5));
        Assert.assertEquals(expected,sudokuSolver.getPossibleForPosition(0,0));

        Assert.assertNull(sudokuSolver.getPossibleForPosition(2,2));

        expected.clear();
        expected.addAll(Arrays.asList(5,7));
        Assert.assertEquals(expected,sudokuSolver.getPossibleForPosition(0,8));

    }


    @Test
    public void testGetSolution() throws InterruptedException {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix3);
        Assert.assertEquals(15, sudokuSolver.getSolution());
    }

    @Test
//    @Ignore
    public void testGetSolution2() throws InterruptedException {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix4);
        Assert.assertEquals(11, sudokuSolver.getSolution());
    }


    @Test
    public void getRemainingPositionsForColumn() throws Exception {

        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix4);

        Set<Integer> expected = new HashSet<>();
        expected.addAll(Arrays.asList(4));

        Assert.assertEquals(expected, sudokuSolver.getRemainingPositionsForColumn(0,1,sudokuSolver.getAllPossible()));
    }


    @Test
    public void getRemainingPositionsForSquare() throws Exception {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix4);

        Set<Integer> expected = new HashSet<>();
        expected.addAll(Arrays.asList(4));

        Assert.assertEquals(expected, sudokuSolver.getRemainingPositionsForSquare(0,7,sudokuSolver.getAllPossible()));
    }

}