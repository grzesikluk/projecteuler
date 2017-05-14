package eulerproject.tools.sequences;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lukasz on 2017-03-31.
 */
public class SequenceGeneratorImplCachedA000607Test {

    public final long MAX = 10000L;
    SequenceGenerator sg;

    @Before
    public void init() {
        sg = new SequenceGeneratorImplCachedA000607();
        sg.init(MAX);
    }

    @Test
    public void getNumber_quick() throws Exception {
        int[] checkArray = new int[]{1, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 9, 10, 12, 14, 17, 19, 23, 26, 30, 35, 40};

        for (int i = 0; i < checkArray.length; i++)
            Assert.assertEquals(" Violation by " + i, checkArray[i], sg.getNumber(i));
    }

    @Test
    public void getNumber_20() {
        Assert.assertEquals(26, sg.getNumber(20));
    }

    @Test
    public void getNumber_25() {
        Assert.assertEquals(52, sg.getNumber(25));
    }


    @Test(timeout = 50 * 1000)
    public void getNumber_30() {
        Assert.assertEquals(98, sg.getNumber(30));
    }

    @Test
    public void getNumber_40() {
        Assert.assertEquals(302, sg.getNumber(40));
    }

}