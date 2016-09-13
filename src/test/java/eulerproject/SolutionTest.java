package projecteuler.problem53;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;
import static projecteuler.problem53.Solution.THRESH;
import static projecteuler.problem53.Solution.countCombination;
import static projecteuler.problem53.Solution.getProduct;

/**
 * Created by grzesikl on 13/09/2016.
 */
public class SolutionTest {
    @Test
    public void testCountCombination() throws Exception {
        Assert.assertEquals(new BigInteger("10"),countCombination(5,3));
        Assert.assertEquals(new BigInteger("1144066"),countCombination(23,10));
        Assert.assertEquals(new BigInteger("100891344545564193334812497256"),countCombination(100,50));
    }

    @Test
    public void testGetProduct() throws Exception {
        Assert.assertEquals(new BigInteger("6"),getProduct(1,3));
        Assert.assertEquals(new BigInteger("120"),getProduct(1,5));

    }

    @Test
    public void testComparison() throws Exception {

        Assert.assertTrue(countCombination(23,10).compareTo(THRESH)== 1);
    }

}