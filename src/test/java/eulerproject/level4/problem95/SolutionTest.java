package eulerproject.level4.problem95;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void testGetDivisorsSum() throws Exception {
        Assert.assertEquals(28, Solution.getSumOfProperDivisors(28));
        Assert.assertEquals(284, Solution.getSumOfProperDivisors(220));
        Assert.assertEquals(220, Solution.getSumOfProperDivisors(284));
    }

    @Test(timeout = 100)
    public void testGetDivisorsSum_big() throws Exception {
        Assert.assertEquals(1480437, Solution.getSumOfProperDivisors(1_000_000));
    }

}