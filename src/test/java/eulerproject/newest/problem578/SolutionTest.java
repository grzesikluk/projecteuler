package eulerproject.newest.problem578;

import eulerproject.tools.primes.Primes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lukasz on 2016-11-21.
 */
public class SolutionTest {

    private static Primes primes;

    @Before
    public void init() {
        primes = new Primes(1000);
        primes.generatePrimes();

    }

    @Test
    public void countDecreasingFactorized() throws Exception {
        Assert.assertEquals(94, Solution.countDecreasingFactorized(100,primes));
        Assert.assertEquals(922052, Solution.countDecreasingFactorized(1000000,primes));

    }


    @Test
    public void isDecreasingFactorized() throws Exception {
        Assert.assertTrue(Solution.isDecreasingFactorized(10, primes));
        Assert.assertTrue(Solution.isDecreasingFactorized(91, primes));
        Assert.assertTrue(Solution.isDecreasingFactorized(19, primes));
        Assert.assertTrue(Solution.isDecreasingFactorized(60, primes));
    }
    @Test
    public void isDecreasingFactorized2() throws Exception {
        Assert.assertFalse(Solution.isDecreasingFactorized(18,primes));
        Assert.assertFalse(Solution.isDecreasingFactorized(50,primes));
        Assert.assertFalse(Solution.isDecreasingFactorized(54,primes));
        Assert.assertFalse(Solution.isDecreasingFactorized(75,primes));
        Assert.assertFalse(Solution.isDecreasingFactorized(90,primes));
        Assert.assertFalse(Solution.isDecreasingFactorized(98,primes));

    }

}