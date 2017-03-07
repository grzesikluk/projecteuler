package eulerproject.level3.problem72;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2017-03-07.
 */
public class SolutionTest {
    @Test
    public void testInitFractionArray_21() throws Exception {
        Assert.assertEquals(21, Solution.initFractionArray(8).size());
    }

    @Test
    public void testInitFractionArray_80() throws Exception {
        Assert.assertEquals(1965, Solution.initFractionArray(80).size());
    }

    @Test
    public void testInitFractionArray_10000() throws Exception {
        Assert.assertEquals(30397485, Solution.initFractionArray(10000).size());
    }

}