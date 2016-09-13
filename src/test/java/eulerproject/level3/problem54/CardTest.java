package eulerproject.level3.problem54;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by grzesikl on 13/09/2016.
 */
public class CardTest {
    @Test
    public void testToString() throws Exception {
        Assert.assertEquals("4C",new Card("4C").toString());
        Assert.assertEquals("JD",new Card("JD").toString());
        Assert.assertEquals("TS",new Card("TS").toString());
    }

    @Test
    public void testCompareTo() throws Exception {
        Assert.assertTrue(new Card("JS").compareTo(new Card("KD")) < 0);
        Assert.assertTrue(new Card("KS").compareTo(new Card("KD")) < 0);
        Assert.assertTrue(new Card("QS").compareTo(new Card("2D")) > 0);
        Assert.assertTrue(new Card("TS").compareTo(new Card("4D")) > 0);
        Assert.assertTrue(new Card("JS").compareTo(new Card("TD")) > 0);
        Assert.assertTrue(new Card("AS").compareTo(new Card("KD")) > 0);
    }

}