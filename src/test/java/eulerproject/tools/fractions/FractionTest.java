package eulerproject.tools.fractions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by grzesikl on 15/09/2016.
 */
public class FractionTest {

    @Test
    public void testAdd() throws Exception {

        Assert.assertEquals(new Fraction(3, 2), new Fraction(1, 1).add(new Fraction(1, 2)));
        Assert.assertEquals(new Fraction(7, 12), new Fraction(1, 3).add(new Fraction(1, 4)));
        Assert.assertEquals(new Fraction(32, 85), new Fraction(1, 5).add(new Fraction(3, 17)));

    }

    @Test
    public void testSimplifyFraction() throws Exception {
        Assert.assertEquals(new Fraction(1, 10), new Fraction(10, 100).simplifyFraction());
        Assert.assertEquals(new Fraction(1, 2), new Fraction(7, 14).simplifyFraction());
        Assert.assertEquals(new Fraction(5, 1), new Fraction(50, 10).simplifyFraction());
        Assert.assertEquals(new Fraction(51, 145), new Fraction(51, 145).simplifyFraction());

    }

}