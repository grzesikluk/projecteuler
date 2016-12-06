package eulerproject.level3.problem60;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by grzesikl on 30/11/2016.
 */
public class PairTest {
    @Test
    public void getConcatenatedOfTwoPairs() throws Exception {
        Assert.assertArrayEquals(new int[]{13,31,24,42,14,32,23,41}, new Pair(1,2).getConcatenatedOfTwoPairs(new Pair(3,4)));
    }

}
