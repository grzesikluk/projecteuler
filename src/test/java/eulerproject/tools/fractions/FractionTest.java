package eulerproject.tools.fractions;

import eulerproject.tools.primes.Primes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by grzesikl on 10/11/2016.
 */
public class FractionTest {

    Primes primes;

    @Before
    public void init() {
        primes = new Primes(1000);
        primes.init();
    }

    @Test
    public void testGetResilentFactor() throws Exception {
        Assert.assertEquals(new Fraction(4,11),new Fraction(1,12).getResilenceFactor(primes.asList()));

    }

    @Test
    public void testIsResilent() throws Exception {
        Assert.assertFalse(new Fraction(2,12).isResilent());
        Assert.assertFalse(new Fraction(3,12).isResilent());
        Assert.assertFalse(new Fraction(4,12).isResilent());
        Assert.assertFalse(new Fraction(10,12).isResilent());

        Assert.assertTrue(new Fraction(5,12).isResilent());
        Assert.assertTrue(new Fraction(7,12).isResilent());
        Assert.assertTrue(new Fraction(11,12).isResilent());
    }

    @Test
    public void testCompareTo() {
        Assert.assertTrue(new Fraction(1,2).compareTo(new Fraction(2,3))<0);
        Assert.assertTrue(new Fraction(2,51).compareTo(new Fraction(2,50))<0);
        Assert.assertTrue(new Fraction(1,2).compareTo(new Fraction(1,2))==0);
        Assert.assertTrue(new Fraction(1,2).compareTo(new Fraction(1,3))>0);
        Assert.assertTrue(new Fraction(1,4).compareTo(new Fraction(2,8))==0);
        Assert.assertTrue(new Fraction(51,50).compareTo(new Fraction(1,1))>0);
        Assert.assertTrue(new Fraction(27102,27102).compareTo(new Fraction(15499, 94744))>0);
        Assert.assertTrue(new Fraction(54432,55030).compareTo(new Fraction(15499, 94744))<0);
    }

    @Test
    public void getHighestCommonFraction() throws Exception {

        Assert.assertEquals(1,new Fraction(2,7).getHighestCommonFactor());
        Assert.assertEquals(2,new Fraction(4,6).getHighestCommonFactor());
        Assert.assertEquals(3,new Fraction(12,27).getHighestCommonFactor());
    }
}