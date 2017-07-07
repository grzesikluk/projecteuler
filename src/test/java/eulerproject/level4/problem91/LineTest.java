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

}