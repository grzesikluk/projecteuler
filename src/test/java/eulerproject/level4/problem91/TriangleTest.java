package eulerproject.level4.problem91;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

public class TriangleTest {

    @Test
    public void testEquals() throws Exception {
        TrianglePoint p1 = new TrianglePoint(0,0);
        TrianglePoint p2 = new TrianglePoint(1,0);
        TrianglePoint p3 = new TrianglePoint(0,2);
        TrianglePoint p4 = new TrianglePoint(0,3);

        Set<TrianglePoint> setOfPoints = new HashSet<>();
        setOfPoints.add(p1);
        setOfPoints.add(p2);
        setOfPoints.add(p3);

        Set<TrianglePoint> setOfPoints2 = new HashSet<>();
        setOfPoints2.add(p3);
        setOfPoints2.add(p2);
        setOfPoints2.add(p1);

        Assert.assertTrue(new Triangle(setOfPoints).equals(new Triangle(setOfPoints2)));


        Set<TrianglePoint> setOfPoints3 = new HashSet<>();
        setOfPoints3.add(p3);
        setOfPoints3.add(p2);
        setOfPoints3.add(p4);

        Assert.assertFalse(new Triangle(setOfPoints).equals(new Triangle(setOfPoints3)));


    }

    @Test
    public void testSymetric() throws Exception {

        Set<TrianglePoint> setOfPoints = new HashSet<>();
        setOfPoints.add(new TrianglePoint(0,0));
        setOfPoints.add(new TrianglePoint(1,0));
        setOfPoints.add(new TrianglePoint(0,1));

        Set<TrianglePoint> setOfPoints2 = new HashSet<>();
        setOfPoints2.add(new TrianglePoint(0,0));
        setOfPoints2.add(new TrianglePoint(1,0));
        setOfPoints2.add(new TrianglePoint(0,1));

        Assert.assertTrue(new Triangle(setOfPoints).getSymmetric().equals(new Triangle(setOfPoints2)));
    }

    @Test
    public void testSymetric2() throws Exception {

        Set<TrianglePoint> setOfPoints = new HashSet<>();
        setOfPoints.add(new TrianglePoint(0,0));
        setOfPoints.add(new TrianglePoint(1,0));
        setOfPoints.add(new TrianglePoint(1,1));

        Set<TrianglePoint> setOfPoints2 = new HashSet<>();
        setOfPoints2.add(new TrianglePoint(0,0));
        setOfPoints2.add(new TrianglePoint(0,1));
        setOfPoints2.add(new TrianglePoint(1,1));

        Assert.assertTrue(new Triangle(setOfPoints).getSymmetric().equals(new Triangle(setOfPoints2)));
    }

    @Test
    public void testRotated() throws Exception {

        Set<TrianglePoint> setOfPoints = new HashSet<>();
        setOfPoints.add(new TrianglePoint(0,0));
        setOfPoints.add(new TrianglePoint(1,0));
        setOfPoints.add(new TrianglePoint(0,1));

        Set<TrianglePoint> setOfPoints2 = new HashSet<>();
        setOfPoints2.add(new TrianglePoint(0,0));
        setOfPoints2.add(new TrianglePoint(0,1));
        setOfPoints2.add(new TrianglePoint(-1,0));

        Assert.assertTrue(new Triangle(setOfPoints).rotate(90).equals(new Triangle(setOfPoints2)));

    }

    @Test
    public void testRotated2() throws Exception {

        Set<TrianglePoint> setOfPoints = new HashSet<>();
        setOfPoints.add(new TrianglePoint(0,0));
        setOfPoints.add(new TrianglePoint(1,0));
        setOfPoints.add(new TrianglePoint(0,1));

        Set<TrianglePoint> setOfPoints3 = new HashSet<>();
        setOfPoints3.add(new TrianglePoint(0,0));
        setOfPoints3.add(new TrianglePoint(0,-1));
        setOfPoints3.add(new TrianglePoint(-1,0));

        Assert.assertTrue(new Triangle(setOfPoints).rotate(180).equals(new Triangle(setOfPoints3)));

    }

    @Test
    public void testYAxisTansformedAndMoved() throws Exception {

        Set<TrianglePoint> setOfPoints = new HashSet<>();
        setOfPoints.add(new TrianglePoint(0,0));
        setOfPoints.add(new TrianglePoint(1,0));
        setOfPoints.add(new TrianglePoint(1,1));

        Set<TrianglePoint> setOfPoints2 = new HashSet<>();
        setOfPoints2.add(new TrianglePoint(0,0));
        setOfPoints2.add(new TrianglePoint(0,1));
        setOfPoints2.add(new TrianglePoint(1,0));

        Assert.assertTrue(new Triangle(setOfPoints).getYAxisTransformedAndMoved().equals(new Triangle(setOfPoints2)));

    }


}