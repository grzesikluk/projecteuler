package eulerproject.tools.functions;

import eulerproject.tools.primes.Primes;
import org.junit.Assert;
import org.junit.Test;

import static eulerproject.tools.functions.EulersTotient.eulersTotientFunction;
import static eulerproject.tools.functions.EulersTotient.sumOfEulersTotientFunction;

/**
 * Created by Lukasz on 2016-11-12.
 */
public class EulersTotientTest {

    @Test
    public void testSumOfEulersTotientFunction_Big() throws Exception {
        int[] primes = new Primes(1000000).toArray();

        Assert.assertEquals(303963152392L,sumOfEulersTotientFunction(1000000, primes));
    }

    @Test
    public void testSumOfEulersTotientFunction() throws Exception {
        int[] primes = {2,3,5,7,11,13,17,19,23};

        Assert.assertEquals(0,sumOfEulersTotientFunction(1, primes));
        Assert.assertEquals(1,sumOfEulersTotientFunction(2, primes));
        Assert.assertEquals(2,sumOfEulersTotientFunction(3, primes));
        Assert.assertEquals(4,sumOfEulersTotientFunction(4, primes));
        Assert.assertEquals(6,sumOfEulersTotientFunction(5, primes));
        Assert.assertEquals(10,sumOfEulersTotientFunction(6, primes));
        Assert.assertEquals(12,sumOfEulersTotientFunction(7, primes));
        Assert.assertEquals(18,sumOfEulersTotientFunction(8, primes));
    }

    @Test
    public void testEulersTotientFunction() throws Exception {
        Assert.assertEquals(1,eulersTotientFunction(2));
        Assert.assertEquals(2,eulersTotientFunction(3));
        Assert.assertEquals(4,eulersTotientFunction(5));
        Assert.assertEquals(6,eulersTotientFunction(7));
        Assert.assertEquals(6,eulersTotientFunction(9));
    }


    @Test
    public void testEulersTotientFunction2() throws Exception {
        Assert.assertEquals(eulersTotientFunction(4*7),eulersTotientFunction(4)*eulersTotientFunction(7));
    }

    @Test
    public void testEulersTotientFunction3() throws Exception {
        int[] primes = {2,3,5,7,11,13};


        Assert.assertEquals(1,eulersTotientFunction(1, primes));
        Assert.assertEquals(1,eulersTotientFunction(2, primes));
        Assert.assertEquals(2,eulersTotientFunction(3, primes));
        Assert.assertEquals(2,eulersTotientFunction(4, primes));
        Assert.assertEquals(4,eulersTotientFunction(5, primes));
        Assert.assertEquals(2,eulersTotientFunction(6, primes));
        Assert.assertEquals(6,eulersTotientFunction(7, primes));
        Assert.assertEquals(4,eulersTotientFunction(8, primes));
        Assert.assertEquals(6,eulersTotientFunction(9, primes));
        Assert.assertEquals(4,eulersTotientFunction(10, primes));
        Assert.assertEquals(10,eulersTotientFunction(11, primes));
        Assert.assertEquals(4,eulersTotientFunction(12, primes));
    }

}