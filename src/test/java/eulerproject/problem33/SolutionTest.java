package eulerproject.problem33;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.problem33.Solution.check;
import static eulerproject.problem33.Solution.findCommonDigit;
import static eulerproject.problem33.Solution.replaceOneChar;
import static org.junit.Assert.*;

/**
 * Created by grzesikl on 07/09/2016.
 */
public class SolutionTest {
    @Test
    public void testReplaceOneChar() throws Exception {
        Assert.assertEquals("1233",replaceOneChar("12333",'3'));
        Assert.assertEquals("1244",replaceOneChar("12344",'3'));
    }

    @Test
    public void testFindCommonDigit() throws Exception {
        Assert.assertEquals(new Character('1'), findCommonDigit(12,41));
        Assert.assertEquals(new Character('4'), findCommonDigit(42,41));
        Assert.assertEquals(new Character('2'), findCommonDigit(22,42));

    }

    @Test
    public void testCheck() throws Exception {

        Assert.assertTrue(check(49,98));
        Assert.assertFalse(check(48,98));

    }

}