package eulerproject.level4.problem91;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution
{

    private static int MAX = 50;
    private static List<Point> points;
    private static Set<Triangle> triangles;

    private static void getAllPoints()
    {

        points = new ArrayList<>((MAX + 1) * (MAX + 1));
        for (int i = 0; i <= MAX; i++)
            for (int j = 0; j <= MAX; j++)
                if (!(isZeroPoint(i, j)))
                    points.add(new Point(i, j));

    }

    public static void main(String[] args)
    {

        getAllPoints();
        triangles = new HashSet<>();
        Point zeroPoint = new Point(0, 0);

        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j <= MAX; j++) {

                Point chekPoint = new Point(i, j);

                if (!(isZeroPoint(chekPoint))) { //do not include center of xy axis

                    Line line = new Line(new Point(0, 0), chekPoint).getPerpLine(chekPoint);

                    for (Point p : points) {

                        if (!p.equals(chekPoint)) {

                            if (line.isSolution(p)) {

                                Set<Point> trianglePoints = new HashSet<>();

                                trianglePoints.add(chekPoint);
                                trianglePoints.add(p);
                                trianglePoints.add(zeroPoint);

                                Triangle triangle = new Triangle(trianglePoints);
                                if (triangle.valid())
                                    triangles.add(triangle);

                                Triangle symmetric = triangle.getSymmetric();
                                if (symmetric.valid())
                                    triangles.add(symmetric);

                                Triangle yTransformed = triangle.getYAxisTransformedAndMoved();
                                if (yTransformed != null && yTransformed.valid())
                                    triangles.add(yTransformed);

                                Triangle xTransformed = triangle.getXAxisTransformedAndMoved();
                                if (xTransformed != null && xTransformed.valid())
                                    triangles.add(xTransformed);


                                Triangle symmetricYTransformed = triangle.getSymmetric().getYAxisTransformedAndMoved();
                                if (symmetricYTransformed != null && symmetricYTransformed.valid())
                                    triangles.add(symmetricYTransformed);

                                Triangle symmetricXTransformed = triangle.getSymmetric().getXAxisTransformedAndMoved();
                                if (symmetricXTransformed != null && symmetricXTransformed.valid())
                                    triangles.add(symmetricXTransformed);
                            }

                        }

                    }


                }

            }
        }

        System.out.println(triangles.size());
    }

    public static boolean isZeroPoint(int i, int j)
    {
        return i == 0 && j == 0;
    }

    public static boolean isZeroPoint(Point p)
    {
        return p.getY() == 0 && p.getX() == 0;
    }
}
