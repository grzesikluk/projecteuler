package eulerproject.level3.problem66;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

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
    public void testGetPellsEquationSolution() throws Exception {

        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("3"), new BigInteger("2")),Solution.getPellsEquationSolution(2));
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("2"), new BigInteger("1")),Solution.getPellsEquationSolution(3));
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("9"), new BigInteger("4")),Solution.getPellsEquationSolution(5));
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("5"), new BigInteger("2")),Solution.getPellsEquationSolution(6));
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("8"), new BigInteger("3")),Solution.getPellsEquationSolution(7));
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("66249"), new BigInteger("9100")),Solution.getPellsEquationSolution(53));
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("24335"), new BigInteger("3588")),Solution.getPellsEquationSolution(46));
        Assert.assertEquals(new Pair<BigInteger, BigInteger>(new BigInteger("2535751"), new BigInteger("118230")),Solution.getPellsEquationSolution(460));
    }

}