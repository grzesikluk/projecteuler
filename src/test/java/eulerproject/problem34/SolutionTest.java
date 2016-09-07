package eulerproject.problem34;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.problem34.Solution.getMaximumPower;
import static eulerproject.problem34.Solution.getSumOfFactorialsFromDigits;

/**
 * Created by Lukasz on 2016-08-25.
 */
public class SolutionTest {

    @org.junit.Test
    public void testGetSumOfFactorialsFromDigits() throws Exception {

        Assert.assertEquals(1,getSumOfFactorialsFromDigits(1));
        Assert.assertEquals(3,getSumOfFactorialsFromDigits(12));
        Assert.assertEquals(7,getSumOfFactorialsFromDigits(13));
        Assert.assertEquals(121,getSumOfFactorialsFromDigits(15));

        Assert.assertEquals(145,getSumOfFactorialsFromDigits(145));

    }


    @Test
    public void testGetMaximumPower() throws Exception{

        System.out.println(getMaximumPower());
    }
}