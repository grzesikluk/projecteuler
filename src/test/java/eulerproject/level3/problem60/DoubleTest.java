package eulerproject.level3.problem60;

import org.junit.Assert;
import org.junit.Test;

import java.lang.*;

/**
 * Created by Lukasz on 2016-10-16.
 */
public class DoubleTest {
    @Test
    public void testIsConcPrime() throws Exception {
        Assert.assertTrue(new Dublet(3,7).isConcPrime());
        Assert.assertTrue(new Dublet(109,673).isConcPrime());
    }

    @Test
    public void testContains() throws Exception {
        Assert.assertTrue(new Dublet(3,7).contains(3));
        Assert.assertTrue(new Dublet(109,673).contains(109));

    }

}