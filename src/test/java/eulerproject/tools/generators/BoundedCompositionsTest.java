package eulerproject.tools.generators;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lgrzesik on 11/06/17.
 */
public class BoundedCompositionsTest {
    @Test
    public void generateColex() throws Exception {
    }

    @Test
    public void testfindValue() throws Exception {

        BoundedCompositions boundedCompositions = new BoundedCompositions(6, 3) ;

        Assert.assertEquals(-1, boundedCompositions.findValue(4,1, 2));
        Assert.assertEquals(2, boundedCompositions.findValue(4,2, 2));
        Assert.assertEquals(5, boundedCompositions.findValue(10,12, 2));


    }

    @Test
    public void testGenerateMin() throws Exception {

        BoundedCompositions boundedCompositions = new BoundedCompositions(6, 3) ;

        Assert.assertArrayEquals(new int[]{0,1,1,2,2}, boundedCompositions.generateMin(4, 10,2));



    }

}