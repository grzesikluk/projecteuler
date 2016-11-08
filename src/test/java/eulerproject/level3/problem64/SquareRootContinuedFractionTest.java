package eulerproject.level3.problem64;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grzesikl on 08/11/2016.
 */
public class SquareRootContinuedFractionTest {

    @Test
    public void testGetNextFractionFactor0() throws Exception {

        SquareRootContinuedFraction sFactor     = new SquareRootContinuedFraction(0,23,1,4);
        SquareRootContinuedFraction sFactorNext = new SquareRootContinuedFraction(4,23,7,1);

        Assert.assertEquals(sFactorNext,sFactor.getNextFractionFactor());
    }

    @Test
    public void testGenerateFractionFactor() throws Exception {
        int square = 23;
        int s = (int)Math.floor(Math.sqrt(square));

        SquareRootContinuedFraction sFactor     = new SquareRootContinuedFraction(0,square,1,s);

        Assert.assertEquals(4,sFactor.getA());
        sFactor = sFactor.getNextFractionFactor();
        Assert.assertEquals(1,sFactor.getA());
        sFactor = sFactor.getNextFractionFactor();
        Assert.assertEquals(3,sFactor.getA());
        sFactor = sFactor.getNextFractionFactor();
        Assert.assertEquals(1,sFactor.getA());
        sFactor = sFactor.getNextFractionFactor();
        Assert.assertEquals(8,sFactor.getA());
        sFactor = sFactor.getNextFractionFactor();
        Assert.assertEquals(1,sFactor.getA());
        sFactor = sFactor.getNextFractionFactor();
        Assert.assertEquals(3,sFactor.getA());
        sFactor = sFactor.getNextFractionFactor();
        Assert.assertEquals(1,sFactor.getA());
        sFactor = sFactor.getNextFractionFactor();
        Assert.assertEquals(8,sFactor.getA());
    }

    @Test
    public void testGetFactors1() {
        int square = 2;
        int s = (int)Math.floor(Math.sqrt(square));

        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(1);
        expectedResult.add(2);
        expectedResult.add(2);
        expectedResult.add(2);

        Assert.assertEquals(expectedResult,new SquareRootContinuedFraction(0,square,1,s).getFactors(4));

    }


    @Test
    public void testGetFactors2() {
        int square = 13;
        int s = (int)Math.floor(Math.sqrt(square));

        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(3);
        expectedResult.add(1);
        expectedResult.add(1);
        expectedResult.add(1);
        expectedResult.add(1);
        expectedResult.add(6);
        expectedResult.add(1);
        expectedResult.add(1);
        expectedResult.add(1);
        expectedResult.add(1);
        expectedResult.add(6);

        Assert.assertEquals(expectedResult,new SquareRootContinuedFraction(square).getFactors(expectedResult.size()));

    }

}