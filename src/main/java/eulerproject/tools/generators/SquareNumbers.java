package eulerproject.tools.generators;

import java.math.BigInteger;

public class SquareNumbers
{
    public static long getNumber(long k)
    {
        long r = k * k;
        if (r < 0)
            throw new IllegalArgumentException("input too big");
        return r;
    }


    public static BigInteger getNumber(BigInteger k) {
        return k.multiply(k);
    }

}
