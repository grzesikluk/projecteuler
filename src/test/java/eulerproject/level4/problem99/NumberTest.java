package eulerproject.level4.problem99;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by grzesikl on 22/02/2017.
 */
public class NumberTest {
    @Test
    public void testCompareTo() throws Exception {
        Assert.assertEquals(-1,new Number(2,7).compareTo(new Number(3,8)));
        Assert.assertEquals(1,new Number(632382,518061).compareTo(new Number(519432,525806)));
        Assert.assertEquals(0,new Number(632382,518061).compareTo(new Number(632382,518061)));
        Assert.assertEquals(0,new Number(3,2).compareTo(new Number(9,1)));
    }

}