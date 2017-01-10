package eulerproject.level3.problem66;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

import static eulerproject.level3.problem66.Solution.isThisPairPellsEquationSolution;

/**
 * Created by grzesikl on 09/01/2017.
 */
public class SolutionTest {


    @Test
    public void testBigIntegerSqrt() throws Exception {
        Assert.assertFalse(Solution.isSquare(new BigInteger("110")));
        Assert.assertTrue(Solution.isSquare(new BigInteger("121")));
        Assert.assertFalse(Solution.isSquare(new BigInteger("14210")));
        Assert.assertTrue(Solution.isSquare(new BigInteger("1522756")));


    }


    @Test
    public void testIsThisPairPellsEquationSolution() throws Exception {
        Assert.assertFalse(isThisPairPellsEquationSolution(new Pair<BigInteger, BigInteger>(new BigInteger("2"), new BigInteger("2")), 2));
        Assert.assertTrue(isThisPairPellsEquationSolution(new Pair<BigInteger, BigInteger>(new BigInteger("3"), new BigInteger("2")), 2));
        Assert.assertTrue(isThisPairPellsEquationSolution(new Pair<BigInteger, BigInteger>(new BigInteger("2"), new BigInteger("1")), 3));
        Assert.assertTrue(isThisPairPellsEquationSolution(new Pair<BigInteger, BigInteger>(new BigInteger("24335"), new BigInteger("3588")), 46));
        Assert.assertTrue(isThisPairPellsEquationSolution(new Pair<BigInteger, BigInteger>(new BigInteger("2535751"), new BigInteger("118230")), 460));

    }

    @Test
    public void testGetPellsEquationSolution_withContFraction() throws Exception {

        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("3"), new BigInteger("2")), Solution.getPellsEquationSolution(2));
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("2"), new BigInteger("1")), Solution.getPellsEquationSolution(3));
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("9"), new BigInteger("4")), Solution.getPellsEquationSolution(5));
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("5"), new BigInteger("2")), Solution.getPellsEquationSolution(6));
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("8"), new BigInteger("3")), Solution.getPellsEquationSolution(7));
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("66249"), new BigInteger("9100")), Solution.getPellsEquationSolution(53));
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("24335"), new BigInteger("3588")), Solution.getPellsEquationSolution(46));
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("2535751"), new BigInteger("118230")), Solution.getPellsEquationSolution(460));
    }


    @Test
    public void testGetPellsEquationSolution_withContFraction_long409() throws Exception {
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("25052977273092427986049"),
                new BigInteger("1238789998647218582160")), Solution.getPellsEquationSolution(409));
    }

    @Test
    public void testGetPellsEquationSolution_withContFraction_long421() throws Exception {
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("3879474045914926879468217167061449"),
                new BigInteger("189073995951839020880499780706260")), Solution.getPellsEquationSolution(421));
    }

    @Test
    public void testGetPellsEquationSolution_withContFraction_long541() throws Exception {
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("3707453360023867028800645599667005001"),
                new BigInteger("159395869721270110077187138775196900")), Solution.getPellsEquationSolution(541));
    }

}