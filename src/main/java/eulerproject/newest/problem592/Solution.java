package eulerproject.newest.problem592;

public class Solution {
    private static final int MODULO = 16;
    private static int[][] moduloCache;


    public static void main(String[] args) {
        System.out.println(getFactorialHexValue(factorial(20L)));
    }

    public static long factorialModulo(long s) {
        long result = 1;
        for (long i = 1; i <= s; i++) {
//            System.out.println((double) i / s);
            if ((i % MODULO) != 0)
                result = multiplyModulo(result, i);
        }

        return result;
    }

    public static long factorial(long s) {
        if (s == 0)
            return 1;

        return s * factorial(s - 1);

    }


    //TODO: Add caching?
    public static long multiplyModulo(long a, long b) {
        long c = a * b;

        while ((c % MODULO) == 0 && c != 0)
            c /= MODULO;

        return c;
    }

    //TODO: Add caching?
    public static long multiplyModuloCached(long a, long b) {
        long c = a * b;

        while ((c % MODULO) == 0 && c != 0)
            c /= MODULO;

        return c;
    }


    public static String getFactorialHexValue(long k) {
        return Long.toHexString(factorialModulo(k)).toUpperCase();
    }


}
