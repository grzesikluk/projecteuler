package eulerproject.level4.problem88;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lukasz on 2017-08-06.
 */
public class Solution2Test {
    @Test
    public void testGenerateMinimumFromCompositions() throws Exception {

        Assert.assertEquals(4, Solution2.generateMinimumFromCompositions(2));
        Assert.assertEquals(6, Solution2.generateMinimumFromCompositions(3));
        Assert.assertEquals(8, Solution2.generateMinimumFromCompositions(4));
        Assert.assertEquals(8, Solution2.generateMinimumFromCompositions(5));
        Assert.assertEquals(12, Solution2.generateMinimumFromCompositions(6));
        Assert.assertEquals(12, Solution2.generateMinimumFromCompositions(7));
        Assert.assertEquals(12, Solution2.generateMinimumFromCompositions(8));
        Assert.assertEquals(15, Solution2.generateMinimumFromCompositions(9));
//        Assert.assertEquals(12, Solution2.generateMinimumFromCompositions(10));

    }

}