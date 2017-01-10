package eulerproject.tools.functions;

import eulerproject.tools.fractions.BigFraction;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static eulerproject.tools.functions.ContinuedFraction.*;


/**
 * Created by Lukasz on 2017-01-10.
 */
public class ContinuedFractionTest {

    @Test
    public void testGetNextPart_sqrt_2_0() throws Exception {
        Assert.assertEquals(new BigFraction(new BigInteger("3"),new BigInteger("2")).revertFraction(),
                getNextPart(1,new BigFraction(new BigInteger("1"),new BigInteger("2"))));
    }

    @Test
    public void testGetNextPart_sqrt_2_1() throws Exception {
        Assert.assertEquals(new BigFraction(new BigInteger("7"),new BigInteger("5")).revertFraction(),
                getNextPart(1,getNextPart(2,new BigFraction(new BigInteger("1"),new BigInteger("2")))));
    }

    @Test
    public void testGetNextPart_sqrt_2_2() throws Exception {
        Assert.assertEquals(new BigFraction(new BigInteger("17"),new BigInteger("12")).revertFraction(),
                getNextPart(1,getNextPart(2,getNextPart(2,new BigFraction(new BigInteger("1"),new BigInteger("2"))))));
    }

    @Test
    public void testGetNextPart_sqrt_2_3() throws Exception {
        Assert.assertEquals(new BigFraction(new BigInteger("41"),new BigInteger("29")).revertFraction(),
                getNextPart(1,getNextPart(2,getNextPart(2,getNextPart(2,new BigFraction(new BigInteger("1"),new BigInteger("2")))))));
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


    @Test
    public void testGetConvergentsForNSqrt_2() throws Exception {
        List<Long> list = new ArrayList<>();
        list.add(new Long(1));
        list.add(new Long(2));
        list.add(new Long(2));
        list.add(new Long(2));
        list.add(new Long(2));

        Assert.assertEquals(list, getConvergentsForNSqrt(2,5));

    }

    @Test
    public void testGetConvergentsForNSqrt_4() throws Exception {
        List<Long> list = new ArrayList<>();
        list.add(new Long(2));

        Assert.assertEquals(list, getConvergentsForNSqrt(4,5));

    }

    @Test
    public void testGetConvergentsForNSqrt_5() throws Exception {
        List<Long> list = new ArrayList<>();
        list.add(new Long(2));
        list.add(new Long(4));
        list.add(new Long(4));
        list.add(new Long(4));
        list.add(new Long(4));

        Assert.assertEquals(list, getConvergentsForNSqrt(5,5));

    }

    @Test
    public void testGetConvergentsForNSqrt_19() throws Exception {
        List<Long> list = new ArrayList<>();
        list.add(new Long(4));
        list.add(new Long(2));
        list.add(new Long(1));
        list.add(new Long(3));
        list.add(new Long(1));
        list.add(new Long(2));
        list.add(new Long(8));
        list.add(new Long(2));
        list.add(new Long(1));
        list.add(new Long(3));
        list.add(new Long(1));
        list.add(new Long(2));
        list.add(new Long(8));

        Assert.assertEquals(list, getConvergentsForNSqrt(19,13));

    }

    @Test
    public void testGetConvergentsForNSqrt_23() throws Exception {
        List<Long> list = new ArrayList<>();
        list.add(new Long(4));
        list.add(new Long(1));
        list.add(new Long(3));
        list.add(new Long(1));
        list.add(new Long(8));
        list.add(new Long(1));
        list.add(new Long(3));
        list.add(new Long(1));

        Assert.assertEquals(list, getConvergentsForNSqrt(23,8));

    }

    @Test
    public void testGetConvergentsForPi() throws Exception {
        List<Long> list = new ArrayList<>();
        list.add(new Long(3));
        list.add(new Long(7));
        list.add(new Long(15));
        list.add(new Long(1));
        list.add(new Long(292));
        list.add(new Long(1));
        list.add(new Long(1));
        list.add(new Long(1));
        list.add(new Long(2));
        list.add(new Long(1));
        list.add(new Long(3));
        list.add(new Long(1));

        Assert.assertEquals(list, getConvergents(Math.PI,12));

    }

}
