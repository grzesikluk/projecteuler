package eulerproject.level3.problem75;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by grzesikl on 27/03/2017.
 */
public class SolutionTest {

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
    public void testCountNumberOfUniqPythLength_100000() throws Exception {
        Assert.assertEquals(11013, Solution.countNumberOfUniqPythLength(100000));
    }

    @Test
    public void testCountNumberOfUniqPythLength_1000000() throws Exception {
        Assert.assertEquals(107876, Solution.countNumberOfUniqPythLength(1000000));
    }

    @Test
    public void testCountNumberOfUniqPythLength_1500000() throws Exception {
        Assert.assertEquals(161667, Solution.countNumberOfUniqPythLength(1500000));

    }


}
