package eulerproject.level3.problem60;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lukasz on 2017-07-29.
 */
public class PairTest {
    @Test
    public void testGetConcatenatedFirstSecond() throws Exception {
        Assert.assertEquals(123456, new Pair(123,456).getConcatenatedFirstSecond());
        Assert.assertEquals(102, new Pair(10,2).getConcatenatedFirstSecond());
        Assert.assertEquals(21, new Pair(2,1).getConcatenatedFirstSecond());
    }

    @Test
    public void testGetConcatenatedSecondFirst() throws Exception {
        Assert.assertEquals(456123, new Pair(123,456).getConcatenatedSecondFirst());
    }

    @Test
    public void testPowerForNumber() throws Exception {
        Assert.assertEquals(10, Pair.powerForNumber(1));
        Assert.assertEquals(1000, Pair.powerForNumber(135));
        Assert.assertEquals(100, Pair.powerForNumber(99));
    }

}