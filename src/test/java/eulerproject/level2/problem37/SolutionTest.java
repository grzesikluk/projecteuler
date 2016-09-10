package eulerproject.level2.problem37;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static eulerproject.level2.problem37.Solution.*;

/**
 * Created by Lukasz on 2016-08-25.
 */
public class SolutionTest {

    @Test
    public void testIsPrime() throws Exception {
        Assert.assertEquals(true, isPrime(3));
        Assert.assertEquals(false, isPrime(4));
        Assert.assertEquals(true, isPrime(5));
        Assert.assertEquals(true, isPrime(37));
        Assert.assertEquals(true, isPrime(113));
        Assert.assertEquals(true, isPrime(983));

    }

    @Test
    public void testGenerateTruncLeft() throws Exception {

        ArrayList<Integer> testOutput = new ArrayList<Integer>();

        testOutput.add(1234);
        testOutput.add(234);
        testOutput.add(34);
        testOutput.add(4);

        Assert.assertEquals(testOutput, generateTruncLeft(1234));

    }

    @Test
    public void testGenerateTruncRight() throws Exception {

        ArrayList<Integer> testOutput = new ArrayList<Integer>();

        testOutput.add(1234);
        testOutput.add(123);
        testOutput.add(12);
        testOutput.add(1);

        Assert.assertEquals(testOutput, generateTruncRight(1234));

    }

    @Test
    public void testIsTruncatablePrime() throws Exception {

        Assert.assertEquals(true,isTruncatablePrime(3797));
        Assert.assertEquals(false,isTruncatablePrime(155));
    }
}