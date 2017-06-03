package eulerproject.level4.problem86;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2017-06-02.
 */
public class SolutionTest {


    @Test
    public void getNextStep() throws Exception {
        Assert.assertEquals(100, Solution.getNextStep(50, false));
        Assert.assertEquals(-25, Solution.getNextStep(50, true));
        Assert.assertEquals(-50, Solution.getNextStep(-50, true));
        Assert.assertEquals(25, Solution.getNextStep(-50, false));


    }

    @Test
    public void isIntegerSqrt() throws Exception {

        Assert.assertTrue(Solution.isIntegerSqrt(9));
        Assert.assertFalse(Solution.isIntegerSqrt(10));

    }


    @Test
    public void testCheck() throws Exception {
        Assert.assertTrue(Solution.check(6,5,3));
        Assert.assertFalse(Solution.check(6,5,2));
        Assert.assertFalse(Solution.check(5,5,2));
        Assert.assertTrue(Solution.check(1,4,12));
        Assert.assertTrue(Solution.check(2,3,12));
        Assert.assertFalse(Solution.check(5,3,9));
        Assert.assertFalse(Solution.check(5,4,8));
        Assert.assertTrue(Solution.check(1,3,3));
    }

    @Test
    public void testCountSolutions() throws  Exception {
        Assert.assertEquals(1975, Solution.countSolutions(99));
        Assert.assertEquals(2060, Solution.countSolutions(100));
    }



    @Test(timeout =  2000)
    public void testCountSolutions_big() throws  Exception {
        Assert.assertEquals(281334, Solution.countSolutions(1000));
    }

    @Test (timeout =  3000)
    public void testCountSolutions_big2() throws  Exception {
        Assert.assertEquals(418383, Solution.countSolutions(1200));
    }


    @Test (timeout =  6000)
    public void testCountSolutions_big3() throws  Exception {
        Assert.assertEquals(669073, Solution.countSolutions(1500));
    }


    @Test (timeout =  10000)
    public void testCountSolutions_big4() throws  Exception {
        Assert.assertEquals(986995, Solution.countSolutions(1800));
    }

    @Test (timeout =  12000)
    public void testCountSolutions_big5() throws  Exception {
        Assert.assertEquals(1046725, Solution.countSolutions(1820));
    }
}