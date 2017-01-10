package eulerproject.tools.fractions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grzesikl on 08/11/2016.
 */
public class SquareRootContinuedFractionTest {


    @Test
    public void testGetFactors1() {
        int square = 2;
        int s = (int)Math.floor(Math.sqrt(square));

        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(1);
        expectedResult.add(2);
        expectedResult.add(2);
        expectedResult.add(2);

        Assert.assertEquals(expectedResult,new SquareRootContinuedFraction(2).getFactors(4));

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


    @Test(timeout=2000)
    public void testGetFactors_long() {
        new SquareRootContinuedFraction(131234).getFactors(10000000);

    }

    @Test(timeout=1000)
    public void testGetFactors_short() {
        new SquareRootContinuedFraction(131234).getFactors(10000000);

    }
}