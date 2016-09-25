package eulerproject.level3.problem59;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class SolutionTest {
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