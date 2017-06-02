package eulerproject.level4.problem86;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2017-06-02.
 */
public class SolutionTest {

    
    @Test
    public void testCheck() throws Exception {
        Assert.assertTrue(Solution.check(6,5,3));
        Assert.assertFalse(Solution.check(6,5,2));
        Assert.assertFalse(Solution.check(5,5,2));
        Assert.assertTrue(Solution.check(1,4,12));
        Assert.assertTrue(Solution.check(2,3,12));
        Assert.assertFalse(Solution.check(5,3,9));
        Assert.assertFalse(Solution.check(5,4,8));
        Assert.assertTrue(Solution.check(1,3,3));
    }

    @Test
    public void testCountSolutions() throws  Exception {
        Assert.assertEquals(1975, Solution.countSolutions(99));
        Assert.assertEquals(2060, Solution.countSolutions(100));
    }

}