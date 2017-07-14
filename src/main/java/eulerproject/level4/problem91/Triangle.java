package eulerproject.level4.problem91;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Triangle
{

    Set<Point> points;

    public Triangle(final Set<Point> points)
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
        Set<Point> transformedPoints = new HashSet<>();

        for (Point p : points)
            transformedPoints.add(new Point((int) p.getY(), (int) p.getX()));

        return new Triangle(transformedPoints);
    }

    public Triangle getYSymmetric()
    {
        Set<Point> transformedPoints = new HashSet<>();

        for (Point p : points)
            transformedPoints.add(new Point((int) -p.getX(), (int) p.getY()));

        return new Triangle(transformedPoints);
    }

    public Triangle getXSymmetric()
    {
        Set<Point> transformedPoints = new HashSet<>();

        for (Point p : points)
            transformedPoints.add(new Point((int) p.getX(), (int) -p.getY()));

        return new Triangle(transformedPoints);
    }

    public Triangle rotate(int angle)
    {
        Set<Point> transformedPoints = new HashSet<>();

        for (Point p : points) {

            double angleRad = Math.toRadians(angle);
            double x = (p.getX() * Math.cos(angleRad) - p.getY() * Math.sin(angleRad));
            double y = (p.getX() * Math.sin(angleRad) + p.getY() * Math.cos(angleRad));

            transformedPoints.add(new Point((int) x, (int) y));

        }
        return new Triangle(transformedPoints);
    }

    public Triangle move(int vx, int vy)
    {
        Set<Point> transformedPoints = new HashSet<>();

        for (Point p : points) {
            transformedPoints.add(new Point((int) (p.getX() + vx), (int) (p.getY() + vy)));
        }

        return new Triangle(transformedPoints);
    }

    public boolean valid()
    {
        return points.contains(new Point(0, 0)) && !hasNegativePoints();
    }

    public Point getXAxisPoint()
    {
        for (Point p : points)
            if (p.getY() == 0 && p.getX() != 0)
                return p;

        return null;
    }

    public Triangle getYAxisTransformedAndMoved()
    {
        Point pointXAxis = getXAxisPoint();

        if (pointXAxis != null) {
            Triangle result = getYSymmetric().move((int) pointXAxis.getX(), 0);
            if (result.valid())
                return result;
        }

        return null;
    }

    public Triangle getXAxisTransformedAndMoved()
    {
        Point pointXAxis = getXAxisPoint();

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

        sb.append("[");
        for (Point p : points)
            sb.append(p);
        sb.append("]\n");

        return sb.toString();
    }

    public boolean hasNegativePoints()
    {

        for (Point p : points) {
            if (p.getX() < 0 || p.getY() < 0)
                return true;
        }
        return false;
    }


}
