package eulerproject.level4.problem91;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by lgrzesik on 07/07/17.
 */
public class LineTest {

    @Test
    public void testConstructor() throws Exception {
        Assert.assertEquals("y = 1.0x +0.0", new Line(1,0).toString());
        Assert.assertEquals("y = 1.0x +0.0", new Line(new Point(0,0), new Point(1,1)).toString());
        Assert.assertEquals("y = 2.5x -6.5", new Line(new Point(5,6), new Point(7,11)).toString());
    }

    @Test
    public void testPerpLine() throws Exception {

        Line perp = new Line(1,0).getPerpLine(new Point(1,1));


        Assert.assertEquals(-1.0, perp.getA(), 0.0);
        Assert.assertEquals(2.0, perp.getB(), 0.0);

    }


    @Test
    public void testIsSolution() throws Exception {
        Line line = new Line(-1.0,2);
        Assert.assertTrue(line.isSolution(new Point(1,1)));
        Assert.assertTrue(line.isSolution(new Point(2,0)));
    }

    @Test
    public void testIsSolution2() throws Exception {
        Line line = new Line( new Point(0,0), new Point(2,2));
        Assert.assertTrue(line.isSolution(new Point(1,1)));
        Assert.assertTrue(line.isSolution(new Point(3,3)));
    }

}