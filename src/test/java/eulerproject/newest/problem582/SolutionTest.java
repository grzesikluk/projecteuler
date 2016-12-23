package eulerproject.newest.problem582;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.newest.problem582.Solution.getSolution;

/**
 * Created by Lukasz on 2016-12-23.
 */
public class SolutionTest {
    @Test
    public void testGetSolution() throws Exception {

        Assert.assertEquals(235,getSolution(1000));
        Assert.assertEquals(1245,getSolution(1000_000_000));

    }

}