package eulerproject.level4.problem91;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lgrzesik on 06/07/17.
 */
public class Solution {

    private static int MAX = 3;
    private static List<Point> allPoints;

    private static void getAllPoints() {

        allPoints = new ArrayList<>((MAX + 1) * (MAX + 1));
        for (int i = 0; i <= MAX; i++)
            for (int j = 0; j <= MAX; j++)
                if (!(isZeroPoint(i, j)))
                    allPoints.add(new Point(i, j));

    }

    public static void main(String[] args) {

        getAllPoints();

        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j <= MAX; j++) {

                Point chekPoint = new Point(i, j);

                if (!(isZeroPoint(chekPoint))) { //do not include center of xy axis

                    Line line = new Line(new Point(0, 0), chekPoint).getPerpLine(chekPoint);

                    for (Point p : allPoints) {

                        if (!p.equals(chekPoint)) {

                            if (line.isSolution(p)) {
                                System.out.println(p + " " + chekPoint);
                            }

                        }

                    }


                }

            }
        }

    }

    public static boolean isZeroPoint(int i, int j) {
        return i == 0 && j == 0;
    }

    public static boolean isZeroPoint(Point p) {
        return p.getY() == 0 && p.getX() == 0;
    }
}
