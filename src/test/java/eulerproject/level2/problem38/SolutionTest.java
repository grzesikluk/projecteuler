package eulerproject.level2.problem38;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.level2.problem38.Solution.*;

/**
 * Created by grzesikl on 26/08/2016.
 */
public class SolutionTest {
    @Test
    public void testConcatenateNumbers() throws Exception {
        Assert.assertEquals("192384576",concatenateNumbers(generateNumbers(192L,3)));
        Assert.assertEquals("918273645",concatenateNumbers(generateNumbers(9L,5)));
    }

    @Test
    public void testIsPandigital() throws Exception {
        Assert.assertTrue(isPandigital("321654987"));
        Assert.assertTrue(isPandigital("312645789"));
        Assert.assertFalse(isPandigital("311654987"));
        Assert.assertFalse(isPandigital("201675497"));
    }

}