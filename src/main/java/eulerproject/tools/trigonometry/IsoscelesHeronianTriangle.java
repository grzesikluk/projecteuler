package eulerproject.tools.trigonometry;

public class IsoscelesHeronianTriangle extends HeronianTriangle
{

    public IsoscelesHeronianTriangle(int u, int v, int k)
    {
        setA(2 * k * (u * u - v * v));
        setB(k * (u * u + v * v));
        setC(k * (u * u + v * v));
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
