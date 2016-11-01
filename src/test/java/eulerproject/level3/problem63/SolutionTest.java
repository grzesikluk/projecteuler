package eulerproject.level3.problem63;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.level3.problem63.Solution.isCheckValid;

/**
 * Created by Lukasz on 2016-11-01.
 */
public class SolutionTest {
    @Test
    public void testIsCheckValid1() throws Exception {
        Assert.assertEquals(0,isCheckValid(60));
    }

    @Test
    public void testIsCheckValid2() throws Exception {
        Assert.assertEquals(10,isCheckValid(8));
    }

    @Test
    public void testIsCheckValid3() throws Exception {
        Assert.assertEquals(6,isCheckValid(7));
    }

}