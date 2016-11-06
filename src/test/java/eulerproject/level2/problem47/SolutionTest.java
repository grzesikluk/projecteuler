package eulerproject.level2.problem47;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static eulerproject.level2.problem47.Solution.checkCondition;
import static eulerproject.level2.problem47.Solution.getNumberOfDistinctPrimes;

/**
 * Created by grzesikl on 09/09/2016.
 */
public class SolutionTest {
    @Test
    public void testCheckCondition() throws Exception {

        Assert.assertTrue(checkCondition(14,2,2));
        Assert.assertTrue(checkCondition(644,3,3));

    }

    @Test
    public void testGetNumberOfDistinctPrimes() throws Exception {
        Assert.assertEquals(2,getNumberOfDistinctPrimes(14));
        Assert.assertEquals(3,getNumberOfDistinctPrimes(644));
        Assert.assertEquals(3,getNumberOfDistinctPrimes(645));
        Assert.assertEquals(3,getNumberOfDistinctPrimes(646));

    }

}