package eulerproject.tools.fractions;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by grzesikl on 10/11/2016.
 */
public class BigFractionTest {
    @Test
    public void testIsResilent() throws Exception {
        Assert.assertTrue(new BigFraction(new BigInteger("1"),new BigInteger("3")).isResilent());
        Assert.assertTrue(new BigFraction(new BigInteger("2"),new BigInteger("3")).isResilent());
        Assert.assertFalse(new BigFraction(new BigInteger("2"),new BigInteger("4")).isResilent());
    }

    @Test
    public void testGetResilenceFactor() throws Exception {
        Assert.assertEquals(new BigFraction(new BigInteger("4"), new BigInteger("11")),
                new BigFraction(new BigInteger("1"),new BigInteger("12")).getResilenceFactor());
    }

    @Test
    public void testCompareTo() {
        Assert.assertTrue(new BigFraction(new BigInteger("1"),new BigInteger("2")).compareTo(new BigFraction(new BigInteger("2"),new BigInteger("3")))<0);
        Assert.assertTrue(new BigFraction(new BigInteger("2"),new BigInteger("51")).compareTo(new BigFraction(new BigInteger("2"),new BigInteger("50")))<0);
        Assert.assertTrue(new BigFraction(new BigInteger("1"),new BigInteger("2")).compareTo(new BigFraction(new BigInteger("1"),new BigInteger("2")))==0);
        Assert.assertTrue(new BigFraction(new BigInteger("1"),new BigInteger("4")).compareTo(new BigFraction(new BigInteger("2"),new BigInteger("8")))==0);
        Assert.assertTrue(new BigFraction(new BigInteger("51"),new BigInteger("50")).compareTo(new BigFraction(new BigInteger("1"),new BigInteger("1")))>0);

    }


}