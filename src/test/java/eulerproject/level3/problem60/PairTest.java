package eulerproject.level3.problem60;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by grzesikl on 30/11/2016.
 */
public class PairTest {
    @Test
    public void getConcatenatedOfTwoPairs() throws Exception {
        Assert.assertArrayEquals(new int[]{13,31,24,42,14,32,23,41}, new Pair(1,2).getConcatenatedOfTwoPairs(new Pair(3,4)));
    }

    @Test
    public void isOneDigitSame() throws Exception {

        Assert.assertTrue(new Pair(234,533).isOneDigitSame(new Pair(533,21)));
        Assert.assertFalse(new Pair(214,513).isOneDigitSame(new Pair(533,21)));
        Assert.assertFalse(new Pair(234,533).isOneDigitSame(new Pair(53,1)));
        Assert.assertTrue(new Pair(234,234).isOneDigitSame(new Pair(234,234)));

    }

}
