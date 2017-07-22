package eulerproject.level4.problem95;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionTest
{

    @Test
    public void testGetDivisorsSum() throws Exception
    {
        Assert.assertEquals(28, Solution.getSumOfProperDivisors(28));
        Assert.assertEquals(284, Solution.getSumOfProperDivisors(220));
        Assert.assertEquals(220, Solution.getSumOfProperDivisors(284));
    }

    @Test(timeout = 100)
    public void testGetDivisorsSum_big() throws Exception
    {
        Assert.assertEquals(1480437, Solution.getSumOfProperDivisors(1_000_000));
    }

    @Test
    public void testGetChain() throws Exception
    {
        Solution.setValArray(new PriorityQueue<>(IntStream.range(2, 100000).mapToObj(s -> s).collect(Collectors.toList())));
        Assert.assertEquals(Arrays.asList(220, 284), Solution.getChain(220).getKey());
        Assert.assertEquals(Arrays.asList(284, 220), Solution.getChain(284).getKey());
        Assert.assertEquals(Arrays.asList(28), Solution.getChain(28).getKey());
        Assert.assertEquals(Arrays.asList(12496 , 14288 , 15472 , 14536 , 14264 ), Solution.getChain(12496).getKey());
    }
}