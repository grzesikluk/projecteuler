package eulerproject.tools.generators;

public class SquareNumbers
{
    public static long getNumber(long k) {
        long r = k*k;

        if(r<0)
            throw new IllegalArgumentException("input too big");
        return r;
    }
}
