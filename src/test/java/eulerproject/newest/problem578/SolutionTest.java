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

    private static final long MAX = 10_000_000L;
    private static final long MAX_PRIME = (long) Math.sqrt((double) MAX / 2);

    @Before
    public void init() {
        primes = new Primes((int) MAX_PRIME);
        primes.init();
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

    @Test
    public void countIncreasingFactorsNumbersFromSequence_100() throws Exception {
        Assert.assertEquals(94, Solution.countIncreasingFactorsNumbersFromSequence(100L,primes));
    }

    @Test
    public void countIncreasingFactorsNumbersFromSequence_1000() throws Exception {
        Assert.assertEquals(929, Solution.countIncreasingFactorsNumbersFromSequence(1000L,primes));
    }

    @Test(timeout = 4800)
    @Ignore
    public void countIncreasingFactorsNumbersFromSequence_10_6() throws Exception {
        Assert.assertEquals(922052, Solution.countIncreasingFactorsNumbersFromSequence(1_000_000,primes));

    }

    @Test(timeout = 46*1000)
    @Ignore
    public void countIncreasingFactorsNumbersFromSequence_10_7() throws Exception {
        Assert.assertEquals(9219784, Solution.countIncreasingFactorsNumbersFromSequence(10_000_000,primes));

    }

    @Test(timeout = 400*1000)
    @Ignore
    public void countIncreasingFactorsNumbersFromSequence_10_8() throws Exception {
        Assert.assertEquals(92198782, Solution.countIncreasingFactorsNumbersFromSequence(100_000_000L,primes));
    }

    @Test(timeout = 400*1000)
    @Ignore
    public void countIncreasingFactorsNumbersFromSequence_10_13() throws Exception {
        Assert.assertEquals(92198782, Solution.countIncreasingFactorsNumbersFromSequence(10_000_000_000_000L,primes));
    }

    @Test(timeout = 4800)
    @Ignore
    public void countIncreasingFactorsNumbersFromSequence_10_5_print() throws Exception {
        System.out.println(Solution.countIncreasingFactorsNumbersFromSequence(1_00_000,primes));

    }

}