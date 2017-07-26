package eulerproject.level4.problem100;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.IntStream;

import static org.junit.Assert.*;


public class SolutionTest {
    @Test
    public void testSqrt() throws Exception {
        Assert.assertEquals(new BigInteger("3"), Solution.sqrt(new BigInteger("9")));
        Assert.assertEquals(new BigInteger("4"), Solution.sqrt(new BigInteger("16")));
        Assert.assertEquals(new BigInteger("10"), Solution.sqrt(new BigInteger("100")));
        Assert.assertEquals(new BigInteger("0"), Solution.sqrt(new BigInteger("10")));
    }


    @Test
    public void testGetBlueDiscNumber2() throws Exception {
        Assert.assertEquals(new BigInteger("15"),Solution.getBlueDiscNumber(new BigInteger("21")));
        Assert.assertEquals(new BigInteger("85"),Solution.getBlueDiscNumber(new BigInteger("120")));
        Assert.assertEquals(BigInteger.ZERO,Solution.getBlueDiscNumber(new BigInteger("121")));
    }


}