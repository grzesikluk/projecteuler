package eulerproject.level3.problem72;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2017-03-07.
 */
public class SolutionTest {
    @Test
    public void testInitFractionArray() throws Exception {
        Assert.assertEquals(21,Solution.initFractionArray(8).size());
        Assert.assertEquals(1965,Solution.initFractionArray(80).size());


    }

}