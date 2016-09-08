package eulerproject.problem44;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static eulerproject.problem44.Solution.getPentagon;
import static eulerproject.problem44.Solution.isPentagon;

/**
 * Created by Lukasz on 2016-08-28.
 */
public class SolutionTest {

    @Before
    public void init() {
        System.out.println();
    }

    @Test
    public void testIsPentagon() throws Exception {

        Assert.assertTrue(isPentagon(1));
        Assert.assertTrue(isPentagon(5));
        Assert.assertTrue(isPentagon(12));
        Assert.assertTrue(isPentagon(22));
        Assert.assertTrue(isPentagon(35));
        Assert.assertTrue(isPentagon(51));

        Assert.assertFalse(isPentagon(2));
        Assert.assertFalse(isPentagon(6));
        Assert.assertFalse(isPentagon(13));
        Assert.assertFalse(isPentagon(23));
        Assert.assertFalse(isPentagon(36));


    }

    @Ignore
    @Test
    public void testGetPentagon() throws Exception {
        for (int i = 1; i < 500; i++) {
            System.out.println(i+ " ty wyraz roznica =" + (getPentagon(i + 1) - getPentagon(i)));
        }
    }
}