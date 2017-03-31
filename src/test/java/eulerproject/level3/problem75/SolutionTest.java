package eulerproject.level3.problem75;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void testCheckIfIsPythLengh() throws Exception {
        int[] testInput = new int[]{12, 24, 30, 36, 40, 48, 56, 70, 72, 80, 96, 108, 112, 126, 140, 150, 154, 156, 160, 176, 182, 192, 198};

        for(int i=0;i<testInput.length;i++)
            Assert.assertTrue("Failed assertion for " + testInput[i], Solution.checkIfIsPythLengh(testInput[i]));


        for(int i=0;i<testInput.length;i++)
            Assert.assertFalse(Solution.checkIfIsPythLengh(testInput[i]+1));


    }

    @Test
    public void testACountNumberOfUniqPythLength() throws Exception {
        Assert.assertEquals(6, Solution.countNumberOfUniqPythLength(48));
        Assert.assertEquals(6, Solution.countNumberOfUniqPythLength(50));
        Assert.assertEquals(11, Solution.countNumberOfUniqPythLength(100));
        Assert.assertEquals(59, Solution.countNumberOfUniqPythLength(500));
        Assert.assertEquals(222, Solution.countNumberOfUniqPythLength(2000));
        Assert.assertEquals(14774, Solution.countNumberOfUniqPythLength(135000));
    }

    @Test
    public void testCountNumberOfUniqPythLength_1000() throws Exception {
        Assert.assertEquals(112, Solution.countNumberOfUniqPythLength(1000));
    }

    @Test
    public void testCountNumberOfUniqPythLength_10000() throws Exception {
        Assert.assertEquals(1120, Solution.countNumberOfUniqPythLength(10000));
    }

    @Test
//    @Ignore
    public void testCountNumberOfUniqPythLength_100000() throws Exception {
        Assert.assertEquals(11013, Solution.countNumberOfUniqPythLength(100000));
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


}
