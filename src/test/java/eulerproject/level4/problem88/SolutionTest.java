package eulerproject.level4.problem88;

import eulerproject.tools.generators.BoundedCompositions;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Lukasz on 2017-06-12.
 */
public class SolutionTest {


    @Test
    public void testGetAccumulatedMinimumProductSum() throws Exception {

        Assert.assertEquals(30, Solution.getAccumulatedMinimumProductSum(6));
        Assert.assertEquals(61, Solution.getAccumulatedMinimumProductSum(12));

    }

    @Test
    public void getAccumulatedMinimumProductSumRecursive() throws Exception {

        Assert.assertEquals(30, Solution.getAccumulatedMinimumProductSumRecursive(6).stream().mapToInt(s->s).sum());
        Assert.assertEquals(61, Solution.getAccumulatedMinimumProductSumRecursive(12).stream().mapToInt(s->s).sum());
    }

    @Test(timeout = 1000)
    public void testGetAccumulatedMinimumProductSum_medium() throws Exception {

        Assert.assertEquals(61, Solution.getAccumulatedMinimumProductSum(10));

    }

    @Test(timeout = 4000)
    public void testGetAccumulatedMinimumProductSum_medium2() throws Exception {

        Assert.assertEquals(123, Solution.getAccumulatedMinimumProductSum(15));

    }

    @Test(timeout = 20000)
    public void testGetAccumulatedMinimumProductSum_large() throws Exception {

        Assert.assertEquals(151, Solution.getAccumulatedMinimumProductSum(20));

    }

    @Test
    public void testCheckComposition() throws Exception {

        BoundedCompositions boundedCompositions = new BoundedCompositions(4, 2, 1, 2);

        Assert.assertEquals(4, Solution.checkComposition(new BoundedCompositions(4, 2, 1, 2).generate()));
        Assert.assertEquals(6, Solution.checkComposition(new BoundedCompositions(6, 3, 1, 3).generate()));
        Assert.assertEquals(8, Solution.checkComposition(new BoundedCompositions(8, 4, 1, 4).generate()));
        Assert.assertEquals(8, Solution.checkComposition(new BoundedCompositions(8, 5, 1, 4).generate()));
        Assert.assertEquals(12, Solution.checkComposition(new BoundedCompositions(12, 6, 1, 6).generate()));

    }

    @Test
    public void testCheckOneComposition() throws Exception {
        Assert.assertEquals(4, Solution.checkOneComposition(Arrays.asList(2,2)));
        Assert.assertEquals(0, Solution.checkOneComposition(Arrays.asList(2,3)));
        Assert.assertEquals(6, Solution.checkOneComposition(Arrays.asList(1,2,3)));
        Assert.assertEquals(0, Solution.checkOneComposition(Arrays.asList(1,3,3)));
        Assert.assertEquals(8, Solution.checkOneComposition(Arrays.asList(1,1,2,2,2)));
        Assert.assertEquals(0, Solution.checkOneComposition(Arrays.asList(1,1,2,2,3)));

    }

    @Test
    public void testGetMinimumProductSum() throws Exception {
        Assert.assertEquals(4, Solution.getMinimumProductSum(2));
        Assert.assertEquals(6, Solution.getMinimumProductSum(3));
        Assert.assertEquals(8, Solution.getMinimumProductSum(4));
        Assert.assertEquals(8, Solution.getMinimumProductSum(5));
        Assert.assertEquals(12, Solution.getMinimumProductSum(6));

    }

}