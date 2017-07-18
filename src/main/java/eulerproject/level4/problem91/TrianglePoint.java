package eulerproject.level4.problem91;

import java.awt.*;

public class TrianglePoint extends Point implements Comparable
{

    public TrianglePoint(int x, int y) {
        super(x,y);
    }

    @Override
    public int compareTo(final Object o)
    {
        if (o instanceof TrianglePoint) {

            TrianglePoint other = (TrianglePoint) o;

            if (x > other.x)
                return 1;
            else if (x < other.x)
                return -1;
            else {
                if (y > other.y)
                    return 1;
                else if (y < other.y)
                    return -1;
                else
                    return 0;
            }

        } else
            return -1;
    }
}
