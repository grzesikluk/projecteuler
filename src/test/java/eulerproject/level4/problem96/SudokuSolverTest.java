package eulerproject.level4.problem96;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * Created by Lukasz on 2017-07-02.
 */
public class SudokuSolverTest {
    private static String FILE = "src\\test\\java\\eulerproject\\level4\\problem96\\testfile.txt";
    private SudokuMatrix[] sudokuMatrix;

    @Before
    public void init() throws IOException {
        FileReader fr = new FileReader(FILE);
        fr.read();

        sudokuMatrix = new SudokuMatrix[10];

        int i=0;
        while ((sudokuMatrix[i] = fr.getNext()) != null) i++;
    }

    @Test
    public void solve() throws Exception {
    }

    @Test
    public void testMissingNumbers() throws Exception {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix[0]);
        Set<Integer> expected = new HashSet<>();
        expected.addAll(Arrays.asList(1, 4, 5, 7, 8, 9));

        Assert.assertEquals(expected, sudokuSolver.missingNumbers(sudokuMatrix[0].getRow(0)));
    }

    @Test
    public void testMissingNumbers1() throws Exception {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix[0]);
        Set<Integer> expected = new HashSet<>();
        expected.addAll(Arrays.asList(2, 4, 5, 6, 7, 8));

        Assert.assertEquals(expected, sudokuSolver.missingNumbers(sudokuMatrix[0].getSquare(0, 0)));


        expected.clear();
        expected.addAll(Arrays.asList(1, 2, 4, 6, 7, 8));

        Assert.assertEquals(expected, sudokuSolver.missingNumbers(sudokuMatrix[0].getSquare(2, 2)));
    }

    @Test
    public void testGetMissingForPosition() throws Exception {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix[0]);
        Set<Integer> expected = new HashSet<>();

        expected.addAll(Arrays.asList(4, 5));
        Assert.assertEquals(expected, sudokuSolver.getPossibleForPosition(0, 0));

        Assert.assertNull(sudokuSolver.getPossibleForPosition(2, 2));

        expected.clear();
        expected.addAll(Arrays.asList(5, 7));
        Assert.assertEquals(expected, sudokuSolver.getPossibleForPosition(0, 8));

    }


    @Test
    public void testGetSolution() throws InterruptedException {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix[2]);
        Assert.assertEquals(483, sudokuSolver.getSolution());
    }

    @Test
    public void testGetSolution2() throws InterruptedException {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix[3]);
        Assert.assertEquals(245, sudokuSolver.getSolution());
    }


    @Test
    public void testGetPossibleForNumber() {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix[1]);

        List<String> expectedStrings = new ArrayList<>();
        expectedStrings.add("Table with possible numbers for 4");
        expectedStrings.add("040404000");
        expectedStrings.add("000000000");
        expectedStrings.add("000004000");
        expectedStrings.add("000000000");
        expectedStrings.add("000404000");
        expectedStrings.add("000000000");
        expectedStrings.add("000000000");
        expectedStrings.add("000000000");
        expectedStrings.add("000000000");

        SudokuMatrix expected = new SudokuMatrix(expectedStrings);

        Assert.assertEquals(expected,sudokuSolver.getAllPossibleForNumber(4,sudokuSolver.getAllPossible()));

    }


    @Test
    public void testGetPositionsToSupress() throws Exception {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix[1]);

        Set<Pair<Integer, Integer>> expected = new HashSet<>();
        expected.add(new Pair<>(5,0));
        expected.add(new Pair<>(3,0));

        Assert.assertEquals(expected, sudokuSolver.getPositionsToSupress(sudokuSolver.getAllPossibleForNumber(4,sudokuSolver.getAllPossible())));
    }


    @Test
    public void testBug_1() throws Exception {
        Assert.assertTrue(new SudokuSolver(sudokuMatrix[2]).solveMatrix().isSolved());
    }

    @Test
    public void testBug2() throws Exception {
        Assert.assertTrue(new SudokuSolver(sudokuMatrix[4]).solveMatrix().isSolved());
    }

    @Test
    public void testBug3() throws Exception {
        Assert.assertTrue(new SudokuSolver(sudokuMatrix[5]).solveMatrix().isSolved());
    }
}