package eulerproject.level3.problem75;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by grzesikl on 27/03/2017.
 */
public class SolutionTest {
    @Test
    public void testCountNumberOfUniqPythLength() throws Exception {
        Assert.assertEquals(6, Solution.countNumberOfUniqPythLength(48));

    }

    @Test
    public void testCountNumberOfUniqPythLength_1000() throws Exception {
        Assert.assertEquals(118, Solution.countNumberOfUniqPythLength(1000));
    }

    @Test
    public void testCountNumberOfUniqPythLength_10000() throws Exception {
        Assert.assertEquals(1053, Solution.countNumberOfUniqPythLength(10000));
    }

    @Test
    public void testCountNumberOfUniqPythLength_100000() throws Exception {
        Assert.assertEquals(9523, Solution.countNumberOfUniqPythLength(100000));
    }

    @Test
    @Ignore
    public void testCountNumberOfUniqPythLength_1000000() throws Exception {
        Assert.assertEquals(1053, Solution.countNumberOfUniqPythLength(1000000));
    }

    @Test
//    @Ignore
    public void testCountNumberOfUniqPythLength_1500000() throws Exception {
        Assert.assertEquals(1053, Solution.countNumberOfUniqPythLength(1500000));

    }

    @Test
    public void testCheckIfIsPythLengh() throws Exception {
        Assert.assertTrue(Solution.checkIfIsPythLengh(12));
        Assert.assertTrue(Solution.checkIfIsPythLengh(24));
        Assert.assertTrue(Solution.checkIfIsPythLengh(30));
        Assert.assertTrue(Solution.checkIfIsPythLengh(36));
        Assert.assertTrue(Solution.checkIfIsPythLengh(40));
        Assert.assertTrue(Solution.checkIfIsPythLengh(48));
        Assert.assertFalse(Solution.checkIfIsPythLengh(120));
    }

    @Test
    public void testCheckIfIsPythLengh_new() throws Exception {
        Assert.assertTrue(Solution.checkIfIsPythLengh_new(12));
        Assert.assertTrue(Solution.checkIfIsPythLengh_new(24));
        Assert.assertTrue(Solution.checkIfIsPythLengh_new(30));
        Assert.assertTrue(Solution.checkIfIsPythLengh_new(36));
        Assert.assertTrue(Solution.checkIfIsPythLengh_new(40));
        Assert.assertTrue(Solution.checkIfIsPythLengh_new(48));
        Assert.assertFalse(Solution.checkIfIsPythLengh_new(120));
    }
}
