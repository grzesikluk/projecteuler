package eulerproject.level2.problem42;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.level2.problem42.Solution.*;

/**
 * Created by grzesikl on 26/08/2016.
 */
public class SolutionTest {
    @Test
    public void testIsTriangleNumber() throws Exception {
        Assert.assertTrue(isTriangleNumber(1));
        Assert.assertTrue(isTriangleNumber(3));
        Assert.assertTrue(isTriangleNumber(6));
        Assert.assertTrue(isTriangleNumber(10));
        Assert.assertTrue(isTriangleNumber(55));
        Assert.assertFalse(isTriangleNumber(16));


    }

    @Test
    public void testGetTriangleNumber() throws Exception {

        Assert.assertEquals(1,getTriangleNumber(1));
        Assert.assertEquals(3,getTriangleNumber(2));
        Assert.assertEquals(6,getTriangleNumber(3));
        Assert.assertEquals(10,getTriangleNumber(4));
        Assert.assertEquals(15,getTriangleNumber(5));
        Assert.assertEquals(21,getTriangleNumber(6));
        Assert.assertEquals(28,getTriangleNumber(7));
        Assert.assertEquals(36,getTriangleNumber(8));
        Assert.assertEquals(45,getTriangleNumber(9));
        Assert.assertEquals(55,getTriangleNumber(10));

    }

    @Test
    public void testCheckWord() throws Exception {

    }

    @Test
    public void testNormalizeChar() throws Exception {

        Assert.assertEquals(1,normalizeChar('A'));
        Assert.assertEquals(2,normalizeChar('B'));
        Assert.assertEquals(3,normalizeChar('C'));
    }
    @Test
    public void testegtWordValue() {
        Assert.assertEquals(1,getWordValue("A"));
        Assert.assertEquals(6,getWordValue("ABC"));
        Assert.assertEquals(4,getWordValue("AC"));

    }

}