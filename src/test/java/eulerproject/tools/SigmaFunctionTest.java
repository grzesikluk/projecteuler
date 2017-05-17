package eulerproject.tools.functions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SigmaFunctionTest {


    SigmaFunction sigmaFunction;

    @Before
    public void init() {
        sigmaFunction = new SigmaFunction();

    }

    @Test
    public void getValue() throws Exception {
        Assert.assertEquals(1, sigmaFunction.getValue(1, 1));

        Assert.assertEquals(2, sigmaFunction.getValue(2, 0));
        Assert.assertEquals(3, sigmaFunction.getValue(2, 1));

        Assert.assertEquals(2, sigmaFunction.getValue(3, 0));
        Assert.assertEquals(4, sigmaFunction.getValue(3, 1));

        Assert.assertEquals(12, sigmaFunction.getValue(140, 0));
        Assert.assertEquals(336, sigmaFunction.getValue(140, 1));
        Assert.assertEquals(27300, sigmaFunction.getValue(140, 2));
        Assert.assertEquals(3164112, sigmaFunction.getValue(140, 3));
    }


    @Test
    public void getValueModular() throws Exception {
        Assert.assertEquals(1, sigmaFunction.getValueModular(1, 1, 1000));

        Assert.assertEquals(2, sigmaFunction.getValueModular(2, 0, 1000));
        Assert.assertEquals(3, sigmaFunction.getValueModular(2, 1, 1000));

        Assert.assertEquals(2, sigmaFunction.getValueModular(3, 0, 1000));
        Assert.assertEquals(4, sigmaFunction.getValueModular(3, 1, 1000));

        Assert.assertEquals(12, sigmaFunction.getValueModular(140, 0, 1000));
        Assert.assertEquals(36, sigmaFunction.getValueModular(140, 1, 300));
        Assert.assertEquals(0, sigmaFunction.getValueModular(140, 2, 100));
        Assert.assertEquals(164112, sigmaFunction.getValueModular(140, 3, 1000000));
    }

}
