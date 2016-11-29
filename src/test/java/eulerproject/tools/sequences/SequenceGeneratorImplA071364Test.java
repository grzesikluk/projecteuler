package eulerproject.tools.sequences;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by grzesikl on 29/11/2016.
 */
public class SequenceGeneratorImplA071364Test {
    public final long MAX = 10_000_000_000_000L;
    SequenceGenerator sg;

    @Before
    public void init() {
        sg = new SequenceGeneratorImplA071364(MAX);
    }

    @Test
    public void getNumber() throws Exception {
        Assert.assertEquals(1,sg.getNumber(1));
        Assert.assertEquals(2,sg.getNumber(2));
        Assert.assertEquals(2,sg.getNumber(5));
        Assert.assertEquals(6,sg.getNumber(6));
        Assert.assertEquals(12,sg.getNumber(12));
        Assert.assertEquals(18,sg.getNumber(18));
        Assert.assertEquals(60,sg.getNumber(60));
        Assert.assertEquals(2,sg.getNumber(61));
        Assert.assertEquals(30,sg.getNumber(70));
        Assert.assertEquals(2,sg.getNumber(71));
        Assert.assertEquals(24,sg.getNumber(88));
    }

    @Test(timeout = 1000)
    public void getNumber_long() throws Exception {
        Assert.assertEquals(13060694016L,sg.getNumber(10_000_000_000_000L));
    }

}