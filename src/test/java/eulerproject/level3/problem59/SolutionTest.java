package eulerproject.level3.problem59;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class SolutionTest {
    @Test
    public void testGetNextKey() throws Exception {
        Assert.assertArrayEquals(new char[]{'a','a','b'},Solution.getNextKey(new char[]{'a','a','a'}));
        Assert.assertArrayEquals(new char[]{'a','b','a'},Solution.getNextKey(new char[]{'a','a','z'}));
        Assert.assertArrayEquals(new char[]{'b','a','a'},Solution.getNextKey(new char[]{'a','z','z'}));
        Assert.assertNull(Solution.getNextKey(new char[]{'z','z','z'}));
    }

    @Before
    public void init() throws IOException {
        Solution.readAllFiles();
    }


    // 'a'=97
    @Test
    public void testDecodeMesage() throws Exception {
        Assert.assertArrayEquals(new char[]{'a','b','c','d','e','f'},Solution.decodeMesage(new char[]{'a','b'},new int[] {0,0,2,6,4,4}));
    }

    @Test
    public void testCheckIfDecodedProperly() throws Exception {
        Assert.assertFalse(Solution.checkIfDecodedProperly("I am a very stylish girl".toCharArray()));
        Assert.assertTrue(Solution.checkIfDecodedProperly("I am my good take give".toCharArray()));

    }

}