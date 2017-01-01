package eulerproject.newest.problem584;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.newest.problem584.Solution.getSolution;

/**
 * Created by Lukasz on 2017-01-01.
 */
public class SolutionTest {
    @Test
    public void gestGetSolution_Wimwi() throws Exception {
        Assert.assertEquals(5.78688636, getSolution(10,1,3),0.00000001);
    }

    @Test
    public void gestGetSolution_Joka() throws Exception {
        Assert.assertEquals(8.48967364, getSolution(100,7,3),0.00000001);
    }

    @Test
    public void gestGetSolution_Earth() throws Exception {
        Assert.assertEquals(1, getSolution(365,4,7),0.00000001);
    }

}