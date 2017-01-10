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

        Assert.assertEquals(list,getConvergentsListForEulerConstant(list.size()));

    }


    @Test
    public void testGetConvergentsForNSqrt_2() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(2));

        Assert.assertEquals(list, getConvergentsForNSqrt(2,5));

    }

    @Test
    public void testGetConvergentsForNSqrt_4() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(new Integer(2));

        Assert.assertEquals(list, getConvergentsForNSqrt(4,5));

    }

    @Test
    public void testGetConvergentsForNSqrt_5() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        list.add(new Integer(4));
        list.add(new Integer(4));

        Assert.assertEquals(list, getConvergentsForNSqrt(5,5));

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

        Assert.assertEquals(list, getConvergentsForNSqrt(19,13));

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

        Assert.assertEquals(list, getConvergentsForNSqrt(23,8));

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

        Assert.assertEquals(list, getConvergents(Math.PI,12));

    }


    @Test
    public void testGetConvergentValue() throws Exception {
        List<Integer> convs = getConvergentsForNSqrt(2,50);

        Assert.assertEquals(new BigFraction(new BigInteger("3"),new BigInteger("2")),getConvergentValue(convs,1));
        Assert.assertEquals(new BigFraction(new BigInteger("7"),new BigInteger("5")),getConvergentValue(convs,2));
        Assert.assertEquals(new BigFraction(new BigInteger("17"),new BigInteger("12")),getConvergentValue(convs,3));
        Assert.assertEquals(new BigFraction(new BigInteger("41"),new BigInteger("29")),getConvergentValue(convs,4));


    }

    @Test(timeout = 1000)
    public void testGetFactors_Integer() {
        System.out.println(getConvergentsForNSqrt(13,1000000));

    }




}
