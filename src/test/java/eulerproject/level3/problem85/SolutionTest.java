package eulerproject.level3.problem85;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2017-02-23.
 */
public class SolutionTest {
    @Test
    public void testGetNoOfRectangles() throws Exception {
        Assert.assertEquals(18, Solution.getNoOfRectangles(3,2));
        Assert.assertEquals(18, Solution.getNoOfRectangles(2,3));
        Assert.assertEquals(6, Solution.getNoOfRectangles(1,3));
        Assert.assertEquals(36, Solution.getNoOfRectangles(3,3));
        Assert.assertEquals(150, Solution.getNoOfRectangles(5,4));
    }

}