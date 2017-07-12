package eulerproject.level4.problem91;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void testEquals() throws Exception {
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,0);
        Point p3 = new Point(0,2);
        Point p4 = new Point(0,2);

        Set<Point> setOfPoints = new HashSet<>();
        setOfPoints.add(p1);
        setOfPoints.add(p2);
        setOfPoints.add(p3);

        Set<Point> setOfPoints2 = new HashSet<>();
        setOfPoints2.add(p3);
        setOfPoints2.add(p2);
        setOfPoints2.add(p1);

        Assert.assertTrue(new Triangle(setOfPoints).equals(new Triangle(setOfPoints2)));



    }

    @Test
    public void testSymetric() throws Exception {

        Set<Point> setOfPoints = new HashSet<>();
        setOfPoints.add(new Point(0,0));
        setOfPoints.add(new Point(1,0));
        setOfPoints.add(new Point(0,1));

        Set<Point> setOfPoints2 = new HashSet<>();
        setOfPoints2.add(new Point(0,0));
        setOfPoints2.add(new Point(1,0));
        setOfPoints2.add(new Point(0,1));

        Assert.assertTrue(new Triangle(setOfPoints).getSymmetric().equals(new Triangle(setOfPoints2)));
    }

    @Test
    public void testSymetric2() throws Exception {

        Set<Point> setOfPoints = new HashSet<>();
        setOfPoints.add(new Point(0,0));
        setOfPoints.add(new Point(1,0));
        setOfPoints.add(new Point(1,1));

        Set<Point> setOfPoints2 = new HashSet<>();
        setOfPoints2.add(new Point(0,0));
        setOfPoints2.add(new Point(0,1));
        setOfPoints2.add(new Point(1,1));

        Assert.assertTrue(new Triangle(setOfPoints).getSymmetric().equals(new Triangle(setOfPoints2)));
    }

    @Test
    public void testRotated() throws Exception {

        Set<Point> setOfPoints = new HashSet<>();
        setOfPoints.add(new Point(0,0));
        setOfPoints.add(new Point(1,0));
        setOfPoints.add(new Point(0,1));

        Set<Point> setOfPoints2 = new HashSet<>();
        setOfPoints2.add(new Point(0,0));
        setOfPoints2.add(new Point(0,1));
        setOfPoints2.add(new Point(-1,0));

        Assert.assertTrue(new Triangle(setOfPoints).rotate(90).equals(new Triangle(setOfPoints2)));

    }

    @Test
    public void testRotated2() throws Exception {

        Set<Point> setOfPoints = new HashSet<>();
        setOfPoints.add(new Point(0,0));
        setOfPoints.add(new Point(1,0));
        setOfPoints.add(new Point(0,1));

        Set<Point> setOfPoints3 = new HashSet<>();
        setOfPoints3.add(new Point(0,0));
        setOfPoints3.add(new Point(0,-1));
        setOfPoints3.add(new Point(-1,0));

        Assert.assertTrue(new Triangle(setOfPoints).rotate(180).equals(new Triangle(setOfPoints3)));

    }

    @Test
    public void testYAxisTansformedAndMoved() throws Exception {

        Set<Point> setOfPoints = new HashSet<>();
        setOfPoints.add(new Point(0,0));
        setOfPoints.add(new Point(1,0));
        setOfPoints.add(new Point(1,1));

        Set<Point> setOfPoints2 = new HashSet<>();
        setOfPoints2.add(new Point(0,0));
        setOfPoints2.add(new Point(0,1));
        setOfPoints2.add(new Point(1,0));

        Assert.assertTrue(new Triangle(setOfPoints).getYAxisTransformedAndMoved().equals(new Triangle(setOfPoints2)));

    }


}