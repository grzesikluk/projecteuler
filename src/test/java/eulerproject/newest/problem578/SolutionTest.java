package eulerproject.newest.problem578;

import eulerproject.tools.primes.Primes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Lukasz on 2016-11-21.
 */
public class SolutionTest {

    private static Primes primes;

    private static final long MAX = 10000000L;
    private static final long MAX_PRIME = (long) Math.sqrt((double) MAX / 2);

    @Before
    public void init() {
        primes = new Primes((int) MAX_PRIME);
        primes.generatePrimes();

    }

    @Test
    @Ignore
    public void countIncreasingFactorized_100() throws Exception {
        Assert.assertEquals(94, Solution.countIncreasingFactorsNumbers(100L,primes));
    }

    @Test
    @Ignore
    public void countIncreasingFactorized_1000() throws Exception {
        Assert.assertEquals(929, Solution.countIncreasingFactorsNumbers(1000L,primes));
    }

    @Test(timeout = 1000*160)
    @Ignore
    public void countIncreasingFactorized_10_6() throws Exception {
        Assert.assertEquals(922052, Solution.countIncreasingFactorsNumbers(1000000,primes));

    }




    @Test(timeout = 1000*80)
    @Ignore
    public void countIncreasingFactorized_10_7() throws Exception {
        Assert.assertEquals(9219784, Solution.countIncreasingFactorsNumbers(MAX,primes));

    }
}