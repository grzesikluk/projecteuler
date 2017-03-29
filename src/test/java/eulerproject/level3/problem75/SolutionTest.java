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
        Assert.assertEquals(6, Solution.countNumberOfUniqPythLength(50));
        Assert.assertEquals(11, Solution.countNumberOfUniqPythLength(100));
        Assert.assertEquals(59, Solution.countNumberOfUniqPythLength(500));
        Assert.assertEquals(222, Solution.countNumberOfUniqPythLength(2000));
        Assert.assertEquals(14774, Solution.countNumberOfUniqPythLength(135000));

    }

    @Test
    @Ignore
    public void testCountNumberOfUniqPythLength_1000() throws Exception {
        Assert.assertEquals(118, Solution.countNumberOfUniqPythLength(1000));
    }

    @Test
    @Ignore
    public void testCountNumberOfUniqPythLength_10000() throws Exception {
        Assert.assertEquals(1053, Solution.countNumberOfUniqPythLength(10000));
    }

    @Test
    @Ignore
    public void testCountNumberOfUniqPythLength_100000() throws Exception {
        Assert.assertEquals(9523, Solution.countNumberOfUniqPythLength(100000));
    }

    @Test
    @Ignore
    public void testCountNumberOfUniqPythLength_1000000() throws Exception {
        Assert.assertEquals(1053, Solution.countNumberOfUniqPythLength(1000000));
    }

    @Test
    @Ignore
    public void testCountNumberOfUniqPythLength_1500000() throws Exception {
        Assert.assertEquals(1053, Solution.countNumberOfUniqPythLength(1500000));

    }

    @Test
    public void testCheckIfIsPythLengh_ew() throws Exception {
        Assert.assertTrue(Solution.checkIfIsPythLengh_new(12));
        Assert.assertTrue(Solution.checkIfIsPythLengh_new(24));
        Assert.assertTrue(Solution.checkIfIsPythLengh_new(30));
        Assert.assertTrue(Solution.checkIfIsPythLengh_new(36));
        Assert.assertTrue(Solution.checkIfIsPythLengh_new(40));
        Assert.assertTrue(Solution.checkIfIsPythLengh_new(48));
        Assert.assertTrue(Solution.checkIfIsPythLengh_new(70));
        Assert.assertTrue(Solution.checkIfIsPythLengh_new(150));
        Assert.assertFalse(Solution.checkIfIsPythLengh_new(60));
        Assert.assertFalse(Solution.checkIfIsPythLengh_new(132));
        Assert.assertFalse(Solution.checkIfIsPythLengh_new(120));
        Assert.assertFalse(Solution.checkIfIsPythLengh_new(1200));
        Assert.assertFalse(Solution.checkIfIsPythLengh_new(120000));
    }
    @Test
    public void testCheckIfIsPythLengh_old() throws Exception {
        Assert.assertTrue(Solution.checkIfIsPythLengh(12));
        Assert.assertTrue(Solution.checkIfIsPythLengh(24));
        Assert.assertTrue(Solution.checkIfIsPythLengh(30));
        Assert.assertTrue(Solution.checkIfIsPythLengh(36));
        Assert.assertTrue(Solution.checkIfIsPythLengh(40));
        Assert.assertTrue(Solution.checkIfIsPythLengh(48));
        Assert.assertTrue(Solution.checkIfIsPythLengh(70));
        Assert.assertTrue(Solution.checkIfIsPythLengh(150));
        Assert.assertFalse(Solution.checkIfIsPythLengh(60));
        Assert.assertFalse(Solution.checkIfIsPythLengh(132));
        Assert.assertFalse(Solution.checkIfIsPythLengh(120));
        Assert.assertFalse(Solution.checkIfIsPythLengh(1200));
        Assert.assertFalse(Solution.checkIfIsPythLengh(120000));
    }


}
