package eulerproject.level4.problem87;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2017-02-25.
 */
public class SolutionTest {

    @Test
    public void testGetValue() throws Exception {
        Assert.assertEquals(28, Solution.getValue(2,2,2));
        Assert.assertEquals(33, Solution.getValue(3,2,2));
        Assert.assertEquals(49, Solution.getValue(5,2,2));
        Assert.assertEquals(47, Solution.getValue(2,3,2));

    }

}