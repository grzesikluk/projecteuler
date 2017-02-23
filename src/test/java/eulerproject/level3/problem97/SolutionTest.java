package eulerproject.level3.problem97;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2017-02-23.
 */
public class SolutionTest {
    @Test
    public void testPowerModular() throws Exception {
        Assert.assertEquals(4, Solution.powerModular(10,2,26));

    }

    @Test
    public void testEqualsModular() throws Exception {
        Assert.assertTrue(Solution.equalsModular(10, 23, 3));
        Assert.assertFalse(Solution.equalsModular(10, 113, 2));
    }

    @Test
    public void testMultiplyModular() throws Exception {
        Assert.assertEquals(2, Solution.multiplyModular(10,2,26));

    }

}