package eulerproject.level4.problem95;

import eulerproject.tools.primes.Primes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionTest
{
    private Primes primesSeed;
    int[] primes;
    private final int MAX = 10000000;

    @Before
    public void init() {
        primesSeed = new Primes(MAX);
        primesSeed.init();
        primes = primesSeed.asList();
        System.out.println("Init finished");

    }
    @Test
    public void testGetDivisorsSum() throws Exception
    {
        Assert.assertEquals(28, Solution.getSumOfProperDivisors(28, primes));
        Assert.assertEquals(284, Solution.getSumOfProperDivisors(220, primes));
        Assert.assertEquals(220, Solution.getSumOfProperDivisors(284, primes));
    }

    @Test(timeout = 100)
    public void testGetDivisorsSum_big() throws Exception
    {
        Assert.assertEquals(1480437, Solution.getSumOfProperDivisors(1000_000, primes));
    }

    @Test
    public void testGetChain() throws Exception
    {
        Solution.setValueSet(new HashSet<>(IntStream.range(2, 100_000).mapToObj(s -> s).collect(Collectors.toList())));
        Assert.assertEquals(Arrays.asList(220, 284), Solution.getChain(220,primes).getKey());
        Assert.assertEquals(Arrays.asList(284, 220), Solution.getChain(284, primes).getKey());
        Assert.assertEquals(Arrays.asList(28), Solution.getChain(28, primes).getKey());
        Assert.assertEquals(Arrays.asList(12496 , 14288 , 15472 , 14536 , 14264 ), Solution.getChain(12496, primes).getKey());
    }
}