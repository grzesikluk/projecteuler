package eulerproject.level4.problem91;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Triangle implements Comparable
{
    Set<TrianglePoint> points;

    public Triangle(final Set<TrianglePoint> points)
    {
        if (points.size() != 3)
            throw new IllegalArgumentException("Wrong number of points for triangle");

        this.points = new HashSet<>(points);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        return points != null ? points.equals(triangle.points) : triangle.points == null;
    }

    @Override
    public int hashCode()
    {
        return points != null ? points.hashCode() : 0;
    }

    public Triangle getSymmetric()
    {
        Set<TrianglePoint> transformedPoints = new HashSet<>();

        for (TrianglePoint p : points)
            transformedPoints.add(new TrianglePoint((int) p.getY(), (int) p.getX()));

        return new Triangle(transformedPoints);
    }

    public Triangle getYSymmetric()
    {
        Set<TrianglePoint> transformedPoints = new HashSet<>();

        for (TrianglePoint p : points)
            transformedPoints.add(new TrianglePoint((int) -p.getX(), (int) p.getY()));

        return new Triangle(transformedPoints);
    }

    public Triangle getXSymmetric()
    {
        Set<TrianglePoint> transformedPoints = new HashSet<>();

        for (TrianglePoint p : points)
            transformedPoints.add(new TrianglePoint((int) p.getX(), (int) -p.getY()));

        return new Triangle(transformedPoints);
    }

    public Triangle rotate(int angle)
    {
        Set<TrianglePoint> transformedPoints = new HashSet<>();

        for (TrianglePoint p : points) {

            double angleRad = Math.toRadians(angle);
            double x = (p.getX() * Math.cos(angleRad) - p.getY() * Math.sin(angleRad));
            double y = (p.getX() * Math.sin(angleRad) + p.getY() * Math.cos(angleRad));

            transformedPoints.add(new TrianglePoint((int) x, (int) y));

        }
        return new Triangle(transformedPoints);
    }

    public Triangle move(int vx, int vy)
    {
        Set<TrianglePoint> transformedPoints = new HashSet<>();

        for (TrianglePoint p : points) {
            transformedPoints.add(new TrianglePoint((int) (p.getX() + vx), (int) (p.getY() + vy)));
        }

        return new Triangle(transformedPoints);
    }

    public boolean valid()
    {
        return points.contains(new TrianglePoint(0, 0)) && !hasNegativePoints() && isRightAngle();
    }

    public TrianglePoint getXAxisPoint()
    {
        for (TrianglePoint p : points)
            if (p.getY() == 0 && p.getX() != 0)
                return p;

        return null;
    }

    public Triangle getYAxisTransformedAndMoved()
    {
        TrianglePoint pointXAxis = getXAxisPoint();

        if (pointXAxis != null) {
            Triangle result = getYSymmetric().move((int) pointXAxis.getX(), 0);
            if (result.valid())
                return result;
        }

        return null;
    }

    public Triangle getXAxisTransformedAndMoved()
    {
        TrianglePoint pointXAxis = getXAxisPoint();

        if (pointXAxis != null) {
            Triangle result = getXSymmetric().move(0, (int) pointXAxis.getY());
            if (result.valid())
                return result;
        }

        return null;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for (TrianglePoint p : points.stream().sorted().collect(Collectors.toList()))
            sb.append("(" + (int) p.getX() + "," + (int) p.getY() + ")");
        sb.append("\n");

        return sb.toString();
    }


    public boolean hasNegativePoints()
    {

        for (TrianglePoint p : points) {
            if (p.getX() < 0 || p.getY() < 0)
                return true;
        }
        return false;
    }

    public boolean isRightAngle()
    {
        List<TrianglePoint> trianglePoints = points.stream().collect(Collectors.toList());


        double aSqr = getDistSqr(trianglePoints.get(0), trianglePoints.get(1));
        double bSqr = getDistSqr(trianglePoints.get(1), trianglePoints.get(2));
        double cSqr = getDistSqr(trianglePoints.get(2), trianglePoints.get(0));

        return (aSqr == bSqr + cSqr) || (bSqr == aSqr + cSqr) || (cSqr == bSqr + aSqr);


    }

    private double getDistSqr(Point p1, Point p2)
    {
        return Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2);
    }

    @Override
    public int compareTo(final Object o)
    {

        if (o instanceof Triangle) {
            Triangle other = (Triangle) o;

            List<TrianglePoint> thispoints = points.stream().sorted().collect(Collectors.toList());
            List<TrianglePoint> otherpoints = other.points.stream().sorted().collect(Collectors.toList());

            for (int i = 0; i < thispoints.size(); i++) {
                int res = thispoints.get(i).compareTo(otherpoints.get(i));


                if (res != 0)
                    return res;
            }

            return 0;

        }
        return -1;
    }
}
