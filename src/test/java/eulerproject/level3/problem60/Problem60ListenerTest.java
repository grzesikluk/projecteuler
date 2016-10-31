package eulerproject.level3.problem60;

import eulerproject.tools.primes.PrimesSet;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Lukasz on 2016-10-10.
 */
public class Problem60ListenerTest {
    private static PrimesSet primes;
//    /*The max number strongly depends on the maximum digit returned in our case it is more than 673109 */
//    private static int MAX = 675000;
//
//    @Before
//    public void init() {
//        primes = new PrimesSet(MAX);
//    }

    @Test
    public void testCheck() throws Exception {

        Assert.assertTrue(new Problem60Listener().check(new HashSet(Arrays.asList(3, 7, 109, 673))));
        Assert.assertFalse(new Problem60Listener().check(new HashSet(Arrays.asList(3, 11, 109, 673))));


    }

}