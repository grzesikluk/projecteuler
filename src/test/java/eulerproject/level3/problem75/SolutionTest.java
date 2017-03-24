package eulerproject.level3.problem75;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testGetNumberOfEuclides_48() throws Exception {
        Assert.assertEquals(6, Solution.getNumberOfEuclides(48, 1));
    }


    @Test
    public void testGetNumberOfEuclides_100() throws Exception {
        Assert.assertEquals(14, Solution.getNumberOfEuclides(100, 1));
    }


    @Test
    public void testGetNumberOfEuclides_10000() throws Exception {
        Assert.assertEquals(2115, Solution.getNumberOfEuclides(10000, 1));
    }

    @Test
    public void testGetNumberOfEuclides_100000() throws Exception {
        Assert.assertEquals(22533, Solution.getNumberOfEuclides(100000, 1));
    }

    @Test
    @Ignore
    public void testGetNumberOfEuclides_1500000() throws Exception {
        Assert.assertEquals(22533, Solution.getNumberOfEuclides(1500000, 1));
    }
}