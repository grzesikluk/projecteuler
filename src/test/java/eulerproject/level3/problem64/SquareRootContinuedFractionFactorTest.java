package eulerproject.level3.problem64;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by grzesikl on 08/11/2016.
 */
public class SquareRootContinuedFractionFactorTest {

    @Test
    public void testGetNextFractionFactor() throws Exception {

        SquareRootContinuedFractionFactor sFactor     = new SquareRootContinuedFractionFactor(4,23,1,-4);
        SquareRootContinuedFractionFactor sFactorNext = new SquareRootContinuedFractionFactor(1,23,7,-3);

        Assert.assertEquals(sFactorNext,sFactor.getNextFractionFactor());


    }

    @Test
    public void testGetNextFractionFactor1() throws Exception {
        SquareRootContinuedFractionFactor sFactor = new SquareRootContinuedFractionFactor(1,23,7,-3);
        SquareRootContinuedFractionFactor sFactorNext = new SquareRootContinuedFractionFactor(3,23,2,-3);
        Assert.assertEquals(sFactorNext,sFactor.getNextFractionFactor());

    }

    @Test
    public void testGetNextFractionFactor2() throws Exception {
        SquareRootContinuedFractionFactor sFactor = new SquareRootContinuedFractionFactor(3,23,2,-3);
        SquareRootContinuedFractionFactor sFactorNext = new SquareRootContinuedFractionFactor(1,23,7,-4);
        Assert.assertEquals(sFactorNext,sFactor.getNextFractionFactor());

    }

    @Test
    public void testGetNextFractionFactor3() throws Exception {
        SquareRootContinuedFractionFactor sFactor = new SquareRootContinuedFractionFactor(1,23,7,-4);
        SquareRootContinuedFractionFactor sFactorNext = new SquareRootContinuedFractionFactor(8,23,1,-4);

        Assert.assertEquals(sFactorNext,sFactor.getNextFractionFactor());

    }

    @Test
    public void testGetNextFractionFactor4() throws Exception {
        SquareRootContinuedFractionFactor sFactor = new SquareRootContinuedFractionFactor(8,23,1,-4);
        SquareRootContinuedFractionFactor sFactorNext = new SquareRootContinuedFractionFactor(1,23,7,-3);
        Assert.assertEquals(sFactorNext,sFactor.getNextFractionFactor());

    }


    @Test
    public void testGetNextFractionFactor5() throws Exception {
        SquareRootContinuedFractionFactor sFactor = new SquareRootContinuedFractionFactor(1,23,7,-3);
        SquareRootContinuedFractionFactor sFactorNext = new SquareRootContinuedFractionFactor(3,23,2,-3);
        SquareRootContinuedFractionFactor sFactorNext7 = new SquareRootContinuedFractionFactor(1,23,7,-4);

        Assert.assertEquals(sFactorNext,sFactor.getNextFractionFactor());

    }

    @Test
    public void testGetNextFractionFactor6() throws Exception {
        SquareRootContinuedFractionFactor sFactor = new SquareRootContinuedFractionFactor(3,23,2,-3);
        SquareRootContinuedFractionFactor sFactorNext = new SquareRootContinuedFractionFactor(1,23,7,-4);

        Assert.assertEquals(sFactorNext,sFactor.getNextFractionFactor());

    }
}