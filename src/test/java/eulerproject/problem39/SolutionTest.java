package eulerproject.problem39;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.problem39.Solution.getNoOfRightAngleTriangles;
import static eulerproject.problem39.Solution.isRightAngleTriangle;
import static org.junit.Assert.*;

/**
 * Created by grzesikl on 26/08/2016.
 */
public class SolutionTest {
    @Test
    public void testGetNoOfRightAngleTriangles() throws Exception {
        Assert.assertEquals(3,getNoOfRightAngleTriangles(120));
    }

    @Test
    public void testIsRightAngleTriangle() throws Exception {
        Assert.assertTrue(isRightAngleTriangle(20,48,52));
        Assert.assertTrue(isRightAngleTriangle(24,45,51));
        Assert.assertTrue(isRightAngleTriangle(30,40,50));
        Assert.assertFalse(isRightAngleTriangle(23,46,51));
        Assert.assertFalse(isRightAngleTriangle(30,41,49));
    }

}