package eulerproject.tools.fractions;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by grzesikl on 15/09/2016.
 */
public class BigFractionTest {
    @Test
    public void testAdd() throws Exception {

        Assert.assertEquals(generateBigFraction(3, 2), generateBigFraction(1, 1).add(generateBigFraction(1, 2)));
        Assert.assertEquals(generateBigFraction(7, 12), generateBigFraction(1, 3).add(generateBigFraction(1, 4)));
        Assert.assertEquals(generateBigFraction(32, 85), generateBigFraction(1, 5).add(generateBigFraction(3, 17)));

    }

    @Test
    public void testSimplifyFraction() throws Exception {
        Assert.assertEquals(generateBigFraction(1, 10), generateBigFraction(10, 100).simplifyFraction());
        Assert.assertEquals(generateBigFraction(1, 2), generateBigFraction(7, 14).simplifyFraction());
        Assert.assertEquals(generateBigFraction(5, 1), generateBigFraction(50, 10).simplifyFraction());
        Assert.assertEquals(generateBigFraction(51, 145), generateBigFraction(51, 145).simplifyFraction());

    }


    @Test (timeout=5000)
    public void testSimplifyFraction_long() throws Exception {
        Assert.assertEquals(generateBigFraction("1311738121", "3166815962"), generateBigFraction("1311738121", "3166815962").simplifyFraction());
    }

    private static BigFraction generateBigFraction(int a, int b) {
        return new BigFraction(new BigInteger(new Integer(a).toString()), new BigInteger(new Integer(b).toString()));
    }

    private static BigFraction generateBigFraction(String a, String b) {
        return new BigFraction(new BigInteger(a), new BigInteger(b));
    }

}