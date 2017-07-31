package eulerproject.level3.problem60;

import eulerproject.tools.primes.Primes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class SolutionTest
{

    private Primes primes;
    private static final int MAX = 1000000;
    private static Solution solution;

    @Before
    public void init()
    {
        primes = new Primes(MAX);
        primes.init();
        solution = new Solution();
        solution.setSetOfPrimes(primes);
    }

    @Test
    public void isPrimePair_one() throws Exception
    {
        Assert.assertTrue(solution.isPrimePair(new Pair(3, 7)));
        Assert.assertTrue(solution.isPrimePair(new Pair(109, 673)));
        Assert.assertTrue(solution.isPrimePair(new Pair(3, 109)));
        Assert.assertTrue(solution.isPrimePair(new Pair(673, 7)));
    }

    @Test
    public void isChainedPrime() throws Exception
    {
        Assert.assertTrue(solution.isChainedPrime(3, Arrays.asList(7, 109, 673)));
        Assert.assertTrue(solution.isChainedPrime(7, Arrays.asList(3, 109, 673)));
        Assert.assertTrue(solution.isChainedPrime(109, Arrays.asList(3, 7, 673)));
        Assert.assertTrue(solution.isChainedPrime(673, Arrays.asList(3, 7, 109)));
        Assert.assertFalse(solution.isChainedPrime(674, Arrays.asList(3, 7, 109)));
    }

    @Test
    public void isChainedPrime2() throws Exception
    {
        Assert.assertTrue(solution.isChainedPrime(149, Arrays.asList(173, 35363, 35447, 40151)));
        Assert.assertTrue(solution.isChainedPrime(173, Arrays.asList(149, 35363, 35447, 40151)));
        Assert.assertTrue(solution.isChainedPrime(35363, Arrays.asList(149, 173, 35447, 40151)));
        Assert.assertTrue(solution.isChainedPrime(35447, Arrays.asList(149, 173, 35363, 40151)));
        Assert.assertTrue(solution.isChainedPrime(40151, Arrays.asList(149, 173, 35363, 35447)));
        Assert.assertFalse(solution.isChainedPrime(40152, Arrays.asList(149, 173, 35363, 35447)));
    }

    @Test
    public void isChainedPrime3() throws Exception
    {
        Solution solution = new Solution();

        Assert.assertTrue(solution.isChainedPrime(10037, Arrays.asList( 11003, 21737, 21839, 22037)));
        Assert.assertTrue(solution.isChainedPrime(11003, Arrays.asList(10037,  21737, 21839, 22037)));
        Assert.assertTrue(solution.isChainedPrime(21737, Arrays.asList(10037, 11003,  21839, 22037)));
        Assert.assertTrue(solution.isChainedPrime(21839, Arrays.asList(10037, 11003, 21737,  22037)));
        Assert.assertTrue(solution.isChainedPrime(22037, Arrays.asList(10037, 11003, 21737, 21839)));
        Assert.assertFalse(solution.isChainedPrime(22038, Arrays.asList(10037, 11003, 21737, 21839)));
    }

    @Test
    public void isChainedPrime4() throws Exception
    {
        Solution solution = new Solution();

        Assert.assertTrue(solution.isChainedPrime(109, Arrays.asList(673)));
    }

}
