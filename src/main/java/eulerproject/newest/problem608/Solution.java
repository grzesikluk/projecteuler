package eulerproject.newest.problem608;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lgrzesik on 03/08/2017.
 */
public class Solution
{

    public static void main(String[] args)
    {
//        System.out.println(getFactorial(200));
        System.out.println(getDivisors(getFactorial(200)));
    }

    public static BigInteger getFactorial(final int k)
    {
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= k; i++)
            result = result.multiply(BigInteger.valueOf(i));

        return result;
    }

    public static List<BigInteger> getDivisors(BigInteger k)
    {
        BigInteger i = BigInteger.ONE;
        BigInteger last = k.divide(BigInteger.valueOf(2));
        List<BigInteger> result = new ArrayList<>();

        while (i.compareTo(last) < 0) {

            if(k.mod(i).equals(BigInteger.ZERO))
                result.add(i);
            i = i.add(BigInteger.ONE);
        }
        result.add(k);

        return result;

    }
}
