package eulerproject.tools.fractions;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static eulerproject.tools.fractions.ContinuedFraction.*;


/**
 * Created by Lukasz on 2017-01-10.
 */
public class ContinuedFractionTest {

    @Test
    public void testGetConvergentsListForEulerConstant() throws Exception {
        List<Integer> list = Arrays.asList(new Integer[]{
                new Integer(2),new Integer(1),new Integer(2),new Integer(1),
                new Integer(1),new Integer(4),new Integer(1),
                new Integer(1),new Integer(6),new Integer(1),
                new Integer(1),new Integer(8),new Integer(1)});

        Assert.assertEquals(list, getPartialQuotientsForEulerConstant(list.size()));

    }


    @Test
    public void testGetConvergentsForNSqrt_2() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(2));

        Assert.assertEquals(list, getPartialQuotientsForQuadraticSurd(2,5));

    }

    @Test
    public void testGetConvergentsForNSqrt_4() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(new Integer(2));

        Assert.assertEquals(list, getPartialQuotientsForQuadraticSurd(4,5));

    }

    @Test
    public void testGetConvergentsForNSqrt_5() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        list.add(new Integer(4));
        list.add(new Integer(4));

        Assert.assertEquals(list, getPartialQuotientsForQuadraticSurd(5,5));

    }

    @Test
    public void testGetConvergentsForNSqrt_19() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(new Integer(4));
        list.add(new Integer(2));
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(8));
        list.add(new Integer(2));
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(8));

        Assert.assertEquals(list, getPartialQuotientsForQuadraticSurd(19,13));

    }

    @Test
    public void testGetConvergentsForNSqrt_23() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(new Integer(4));
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(1));
        list.add(new Integer(8));
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(1));

        Assert.assertEquals(list, getPartialQuotientsForQuadraticSurd(23,8));

    }

    @Test
    public void testGetConvergentsForPi() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(new Integer(3));
        list.add(new Integer(7));
        list.add(new Integer(15));
        list.add(new Integer(1));
        list.add(new Integer(292));
        list.add(new Integer(1));
        list.add(new Integer(1));
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(1));

        Assert.assertEquals(list, getPartialQuotientsForNumber(Math.PI,12));

    }


    @Test
    public void testGetConvergentValue() throws Exception {
        List<Integer> convs = getPartialQuotientsForQuadraticSurd(2,50);
        Assert.assertEquals(new BigFraction(new BigInteger("3"),new BigInteger("2")), getConvergent(convs,1));
        Assert.assertEquals(new BigFraction(new BigInteger("7"),new BigInteger("5")), getConvergent(convs,2));
        Assert.assertEquals(new BigFraction(new BigInteger("17"),new BigInteger("12")), getConvergent(convs,3));
        Assert.assertEquals(new BigFraction(new BigInteger("41"),new BigInteger("29")), getConvergent(convs,4));
    }

    @Test(timeout = 2000)
    public void testGetFactors_Integer() {
        getPartialQuotientsForQuadraticSurd(13,1000000);

    }



}
