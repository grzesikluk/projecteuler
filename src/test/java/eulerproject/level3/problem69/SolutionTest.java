package eulerproject.level3.problem69;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.level3.problem69.Solution.eulersTotientFunction;
import static org.junit.Assert.*;

/**
 * Created by Lukasz on 2016-11-12.
 */
public class SolutionTest {
    @Test
    public void testEulersTotientFunction() throws Exception {
        Assert.assertEquals(1,eulersTotientFunction(2));
        Assert.assertEquals(2,eulersTotientFunction(3));
        Assert.assertEquals(4,eulersTotientFunction(5));
        Assert.assertEquals(6,eulersTotientFunction(7));
        Assert.assertEquals(6,eulersTotientFunction(9));
    }

}