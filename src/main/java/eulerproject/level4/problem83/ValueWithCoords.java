package eulerproject.level4.problem83;

public class ValueWithCoords implements Comparable
{

    public int getX()
    {
        return x;
    }

    public void setX(final int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(final int y)
    {
        this.y = y;
    }

    public int getVal()
    {
        return val;
    }

    public void setVal(final int val)
    {
        this.val = val;
    }

    public ValueWithCoords(final int x, final int y, final int val)
    {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    private int x;
    private int y;
    private int val;

    @Override
    public int compareTo(final Object o)
    {
        if (o instanceof ValueWithCoords) {
            ValueWithCoords other = (ValueWithCoords) o;
            return getVal() - other.getVal();
        }
        return -1;
    }
}
