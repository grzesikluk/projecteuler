package eulerproject.level3.problem62;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.level3.problem62.Solution.getNumberOfCubePermutations;

/**
 * Created by Lukasz on 2016-10-31.
 */
public class SolutionTest {
    @Test
    public void testGetNumberOfCubePermutations() throws Exception {
        Assert.assertEquals(3,getNumberOfCubePermutations("41063625"));

    }



}