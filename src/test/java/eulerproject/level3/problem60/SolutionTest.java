package eulerproject.level3.problem60;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class SolutionTest {
    @Test
    public void isPrimePair() throws Exception {
        Assert.assertTrue(Solution.isPrimePair(3,7));
        Assert.assertTrue(Solution.isPrimePair(109,673));
        Assert.assertTrue(Solution.isPrimePair(3,109));
        Assert.assertTrue(Solution.isPrimePair(673,7));

    }

}