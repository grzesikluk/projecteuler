package eulerproject.tools.trigonometry;

public class Triangle
{
    public int getA()
    {
        return a;
    }

    public int getB()
    {
        return b;
    }

    public int getC()
    {
        return c;
    }

    public void setA(final int a)
    {
        this.a = a;
    }

    public void setB(final int b)
    {
        this.b = b;
    }

    public void setC(final int c)
    {
        this.c = c;
    }

    private int a;
    private int b;
    private int c;

    public Triangle() {}

    public Triangle(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;

        if (a < 0 || b < 0 || c < 0)
            throw new IllegalArgumentException("Wrong a b c values - sub zero");

        if (a + b <= c || a + c <= b || b + c <= a)
            throw new IllegalArgumentException("Wrong a b c values");
    }

    public int perimeter()
    {
        return a + b + c;
    }

    public double area()
    {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public boolean isAreaInt()
    {
        return (int) area() == area();
    }

    public boolean isAlmostEquillateral()
    {
        return
                a == b && (b == (c + 1) || b == (c - 1)) ||
                        a == c && (c == (b + 1) || c == (b - 1)) ||
                        b == c && (b == (a + 1) || b == (a - 1));
    }

    public Triangle multiply(int k)
    {
        return new Triangle(a * k, b * k, c * k);
    }

    @Override
    public String toString()
    {
        return "a=" + a + " b=" + b + " c=" + c;
    }
}
