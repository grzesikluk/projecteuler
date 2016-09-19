package eulerproject.level3.problem57;

import eulerproject.tools.fractions.BigFraction;
import eulerproject.tools.fractions.Fraction;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

import static eulerproject.level3.problem57.Solution.getBigIteration;
import static eulerproject.level3.problem57.Solution.getIteration;

/**
 * Created by grzesikl on 15/09/2016.
 */
public class SolutionTest {
    @Test
    public void testGetBigIteration() throws Exception {
        Assert.assertEquals(generateBigFraction(3,2),getBigIteration(1));
        Assert.assertEquals(generateBigFraction(7,5),getBigIteration(2));
        Assert.assertEquals(generateBigFraction(17,12),getBigIteration(3));
        Assert.assertEquals(generateBigFraction(41,29),getBigIteration(4));
    }



    @Test
    public void testGetIteration() throws Exception {

        Assert.assertEquals(new Fraction(3,2),getIteration(1));
        Assert.assertEquals(new Fraction(7,5),getIteration(2));
        Assert.assertEquals(new Fraction(17,12),getIteration(3));
        Assert.assertEquals(new Fraction(41,29),getIteration(4));

    }

    private static BigFraction generateBigFraction(int a, int b) {
        return new BigFraction(new BigInteger(new Integer(a).toString()),new BigInteger(new Integer(b).toString()));
    }

}