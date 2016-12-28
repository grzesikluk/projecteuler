package eulerproject.newest.problem583;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.newest.problem583.Solution.getSolution;

/**
 * Created by grzesikl on 28/12/2016.
 */
public class SolutionTest {
    @Test
    public void testGetSolution_10() throws Exception {
        Assert.assertEquals(0,getSolution(10));
    }

    @Test
    public void testGetSolution_100() throws Exception {
        Assert.assertEquals(0,getSolution(100));
    }
    @Test
    public void testGetSolution_1000() throws Exception {
        Assert.assertEquals(5386,getSolution(1000));
    }
    @Test
    public void testGetSolution_10000() throws Exception {
        Assert.assertEquals(884680,getSolution(10_000));
    }

}
