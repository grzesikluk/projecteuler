package eulerproject.level3.problem52;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.level3.problem52.Solution.containSameDigits;

/**
 * Created by Lukasz on 2016-09-12.
 */
public class SolutionTest {

    @Test
    public void testContainSameDigits() throws Exception {

        Assert.assertTrue(containSameDigits(125874,2));
    }
}