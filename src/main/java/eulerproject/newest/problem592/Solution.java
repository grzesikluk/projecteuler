package eulerproject.newest.problem592;

public class Solution {
    private static final int MODULO = 16;


    public static void main(String[] args) {

        System.out.println(getFactorialHexValue(factorial(20L)));

    }

    public static long factorialModulo(long s) {

        if(s == 0)
            return 1;

        return multiplyModulo(s, factorialModulo(s-1));

    }

    public static long factorial(long s) {

        if(s == 0)
            return 1;

        return s * factorial(s-1);

    }


    public static long multiplyModulo(long a, long b) {
        long c = a * b;

        while ((c % MODULO) == 0)
            c /= MODULO;

        return c;
    }

    public static String getFactorialHexValue(long k) {
        return Long.toHexString(factorialModulo(20L)).toUpperCase();
    }


}
