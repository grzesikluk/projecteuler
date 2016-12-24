package eulerproject.newest.problem582;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.newest.problem582.Solution.getSolution;

/**
 * Created by Lukasz on 2016-12-23.
 */
public class SolutionTest {

    @Test
    public void testGetSolution_100() throws Exception {

        Assert.assertEquals(42, getSolution(100));
    }

    @Test
    public void testGetSolution_1000() throws Exception {

        Assert.assertEquals(235, getSolution(1000));
    }

    @Test
    public void testGetSolution_10exp5() throws Exception {
        Assert.assertEquals(634, getSolution(100_000));
    }

    @Test
    public void testGetSolution_10exp6() throws Exception {
        Assert.assertEquals(840, getSolution(1_000_000));

    }

    @Test
    public void testGetSolution_10exp8() throws Exception {
        Assert.assertEquals(1245, getSolution(100_000_000));

    }

}