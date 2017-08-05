package eulerproject.tools.fractions;

import eulerproject.tools.primes.Primes;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by grzesikl on 10/11/2016.
 */
public class BigFractionTest {

    @Test
    public void testIsResilent1() throws Exception {
        Assert.assertTrue(new BigFraction(new BigInteger("125"), new BigInteger("333")).isResilent());
    }

    @Test
    public void testIsResilent2() throws Exception {
        Assert.assertTrue(new BigFraction(new BigInteger("2"), new BigInteger("3")).isResilent());
    }

    @Test
    public void testIsResilent3() throws Exception {

        Assert.assertFalse(new BigFraction(new BigInteger("2"), new BigInteger("123456")).isResilent());
    }

    @Test
    public void testIsResilent4() throws Exception {

        Assert.assertFalse(new BigFraction(new BigInteger("22341234"), new BigInteger("1123423456")).isResilent());
    }

    @Test
    public void testCompareTo1() {
        Assert.assertTrue(new BigFraction(BigInteger.ONE, new BigInteger("2")).compareTo(new BigFraction(new BigInteger("2"), new BigInteger("3"))) < 0);
    }

    @Test
    public void testCompareTo2() {
        Assert.assertTrue(new BigFraction(new BigInteger("2"), new BigInteger("51")).compareTo(new BigFraction(new BigInteger("2"), new BigInteger("50"))) < 0);
    }

    @Test
    public void testCompareTo3() {
        Assert.assertTrue(new BigFraction(BigInteger.ONE, new BigInteger("2")).compareTo(new BigFraction(BigInteger.ONE, new BigInteger("2"))) == 0);
    }

    @Test
    public void testCompareTo4() {
        Assert.assertTrue(new BigFraction(BigInteger.ONE, new BigInteger("4")).compareTo(new BigFraction(new BigInteger("2"), new BigInteger("8"))) == 0);
    }

    @Test
    public void testCompareTo5() {
        Assert.assertTrue(new BigFraction(new BigInteger("51"), new BigInteger("50")).compareTo(new BigFraction(BigInteger.ONE, BigInteger.ONE)) > 0);
    }

    @Test
    public void testGetResilenceFactor1() throws Exception {
        Primes primes = new Primes(100);

        Assert.assertEquals(new BigFraction(new BigInteger("4"), new BigInteger("11")),
                new BigFraction(BigInteger.ONE, new BigInteger("12")).getResilenceFactor(primes.toArray()));
    }

    @Test
    public void testGetResilenceFactor2() throws Exception {
        Primes primes = new Primes(100);

        Assert.assertEquals(new BigFraction(BigInteger.ONE, BigInteger.ONE),
                new BigFraction(BigInteger.ONE, new BigInteger("2")).getResilenceFactor(primes.toArray()));
    }


    @Test
    public void testSimplifyFraction_1() throws Exception {

        Assert.assertEquals(new BigFraction(new BigInteger("123123412341166123412341234357"), new BigInteger("123123412341166123412341234357135125")),
                new BigFraction(new BigInteger("123123412341166123412341234357"), new BigInteger("123123412341166123412341234357135125")).simplifyFraction());
    }
}


