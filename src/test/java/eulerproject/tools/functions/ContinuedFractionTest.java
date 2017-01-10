package eulerproject.tools.functions;

import eulerproject.tools.fractions.BigFraction;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static eulerproject.tools.functions.ContinuedFraction.getConvergentsListForEulerConstant;
import static eulerproject.tools.functions.ContinuedFraction.getNextPart;


/**
 * Created by Lukasz on 2017-01-10.
 */
public class ContinuedFractionTest {
    @Test
    public void testGetNextPart0() throws Exception {
        Assert.assertEquals(new BigFraction(new BigInteger("3"),new BigInteger("2")).revertFraction(),getNextPart(1,new BigFraction(new BigInteger("1"),new BigInteger("2"))));
    }

    @Test
    public void testGetNextPart1() throws Exception {
        Assert.assertEquals(new BigFraction(new BigInteger("7"),new BigInteger("5")).revertFraction(),getNextPart(1,getNextPart(2,new BigFraction(new BigInteger("1"),new BigInteger("2")))));
    }

    @Test
    public void testGetNextPart2() throws Exception {
        Assert.assertEquals(new BigFraction(new BigInteger("17"),new BigInteger("12")).revertFraction(),getNextPart(1,getNextPart(2,getNextPart(2,new BigFraction(new BigInteger("1"),new BigInteger("2"))))));
    }

    @Test
    public void testGetNextPart3() throws Exception {
        Assert.assertEquals(new BigFraction(new BigInteger("41"),new BigInteger("29")).revertFraction(),getNextPart(1,getNextPart(2,getNextPart(2,getNextPart(2,new BigFraction(new BigInteger("1"),new BigInteger("2")))))));
    }

    @Test
    public void testGetConvergentsListForEulerConstant() throws Exception {
        List<Integer> list = Arrays.asList(new Integer[]{
                new Integer(2),new Integer(1),new Integer(2),new Integer(1),
                new Integer(1),new Integer(4),new Integer(1),
                new Integer(1),new Integer(6),new Integer(1),
                new Integer(1),new Integer(8),new Integer(1)});

        Assert.assertEquals(list,getConvergentsListForEulerConstant(list.size()));

    }

}