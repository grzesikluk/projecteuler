package eulerproject.level4.problem91;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution
{

    private static int MAX = 50;
    private static List<TrianglePoint> points;
    private static Set<Triangle> triangles;

    private static void getAllPoints()
    {
        points = new ArrayList<>((MAX + 1) * (MAX + 1));

        for (int i = 0; i <= MAX; i++)
            for (int j = 0; j <= MAX; j++)
                if (!(isZeroPoint(i, j)))
                    points.add(new TrianglePoint(i, j));
    }

    public static void main(String[] args)
    {

        getAllPoints();
        triangles = new HashSet<>();
        TrianglePoint zeroPoint = new TrianglePoint(0, 0);

        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j <= MAX; j++) {

                TrianglePoint checkPoint = new TrianglePoint(i, j);

                if (!checkPoint.equals(zeroPoint)) { //do not include center of xy axis

                    for (TrianglePoint p : points) {

                        if (!p.equals(checkPoint)) {

                            Triangle triangle = new Triangle(new HashSet<>(Arrays.asList(new TrianglePoint[]{p, checkPoint, zeroPoint})));

                            if (triangle.valid())
                                triangles.add(triangle);
                        }
                    }
                }
            }
        }

        System.out.println(triangles.stream().sorted().collect(Collectors.toList()).size());
    }

    public static boolean isZeroPoint(int i, int j)
    {
        return i == 0 && j == 0;
    }
}
