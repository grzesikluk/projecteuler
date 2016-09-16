package eulerproject.level3.problem55;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

import static eulerproject.level3.problem55.Solution.isLychrelNumber;
import static eulerproject.level3.problem55.Solution.isPalindrome;
import static eulerproject.level3.problem55.Solution.reverseInt;

/**
 * Created by Lukasz on 2016-09-13.
 */
public class SolutionTest {
    @Test
    public void testIsPalindrome() throws Exception {

        Assert.assertTrue(isPalindrome("123321"));
        Assert.assertTrue(isPalindrome("1236321"));
        Assert.assertFalse(isPalindrome("124321"));
        Assert.assertTrue(isPalindrome("11"));
        Assert.assertTrue(isPalindrome("2"));
    }

    @Test
    public void testReverseInt() throws Exception {
        Assert.assertEquals(new BigInteger("4321"),reverseInt(new BigInteger("1234")));
        Assert.assertEquals(new BigInteger("21"),reverseInt(new BigInteger("12")));
        Assert.assertEquals(new BigInteger("1"),reverseInt(new BigInteger("1")));
    }

    @Test
    public void testIsLychrelNumber() throws Exception {
        Assert.assertFalse(isLychrelNumber(47));
        Assert.assertFalse(isLychrelNumber(349));
        Assert.assertTrue(isLychrelNumber(196));

    }

}
