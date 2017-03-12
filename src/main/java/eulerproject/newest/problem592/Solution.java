package eulerproject.newest.problem592;

import java.math.BigInteger;

public class Solution {
    private static final int MODULO = 16;

    public static void main(String[] args) {
        System.out.println(getFactorialHexValue(factorial(20L)));
    }

    static {

    }

    public static long factorialModulo(long s) {
        long result = 1;

        for (long i = 1; i <= s; i++) {
            if ((i % MODULO) != 0) {
                result = multiplyModulo(result, getSimplified(i));
                if (result < 0)
                    throw new ArithmeticException("Wrong result vaule " + result);
            }
        }

        return result;
    }


    public static long factorial(long s) {
        if (s == 0)
            return 1;

        return s * factorial(s - 1);

    }

    public static long multiplyModulo(long a, long b) {
        return getSimplified(a * b);
    }

    public static String getFactorialHexValue(long k) {
        return Long.toHexString(factorialModulo(k)).toUpperCase();
    }

    private static long getSimplified(long k) {
        long result = k;
        while ((result % MODULO) == 0 && result != 0)
            result /= MODULO;
        return result;
    }


    private static BigInteger getSimplified(BigInteger k) {
        BigInteger result = new BigInteger(k.toString());

        while(result.mod(new BigInteger("16")).equals(BigInteger.ZERO))
            result = result.divide(new BigInteger("16"));
        return result;
    }


}
