package eulerproject.tools.trigonometry;

public class HeronianTriangle extends Triangle
{
    private int m;
    private int n;
    private int k;

    public HeronianTriangle(){}

    public HeronianTriangle(int m, int n, int k)
    {
        super(n * (m * m + k * k), m * (n * n + k * k), (m + n) * (m * n - k * k));
    }

    public int integerArea()
    {
        return m * n * k * (m + n) * (m * n - k * k);
    }

    public int getGCD() {
        return gcd(getA(), getB(),getC());
    }

    public void reduce() {
        int gcd = getGCD();
        setA(getA()/gcd);
        setB(getB()/gcd);
        setC(getC()/gcd);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    public static int gcd(int a,int b) {
        int hcf;

        if (a > b)
            hcf = b;
        else
            hcf = a;

        for (; hcf > 0; hcf--)
            if ((a % hcf == 0) && (b % hcf == 0))
                break;

        return hcf;
    }

    public static int gcd(int a, int b, int c) {
        return gcd(a, gcd(b,c));
    }

}
