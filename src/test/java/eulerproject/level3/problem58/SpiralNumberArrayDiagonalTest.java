package eulerproject.level3.problem58;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2016-09-21.
 */
public class SpiralNumberArrayDiagonalTest {
    @Test
    public void testGetPrimeRatioOnDiagonals() throws Exception {
        Assert.assertEquals((double)3/5,new SpiralNumberArrayDiagonal(15).getPrimeRatioOnDiagonals(3),0.01);
        Assert.assertEquals((double)8/13,new SpiralNumberArrayDiagonal(15).getPrimeRatioOnDiagonals(7),0.01);

    }

    SpiralNumberArrayDiagonal testSpiralArray = new SpiralNumberArrayDiagonal(3);

    @Test
    public void initTest() {
        Assert.assertArrayEquals(new int[]{1,3,5,7,9},testSpiralArray.getDiagonal());
        Assert.assertArrayEquals(new int[]{1,3,5,7,9,13,17,21,25}, new SpiralNumberArrayDiagonal(5).getDiagonal());
        Assert.assertArrayEquals(new int[]{1,3,5,7,9,13,17,21,25,31,37,43,49}, new SpiralNumberArrayDiagonal(7).getDiagonal());

    }

}