package eulerproject.newest.problem592;

public class Solution {
    private static final int MODULO = 16;


    public static void main(String[] args) {

        System.out.println(getFactorialHexValue(factorial(20L)));

    }

    public static long factorialModuloRecursive(long s) {

        if(s == 0)
            return 1;

        return multiplyModulo(s, factorialModuloRecursive(s-1));

    }


    public static long factorialModulo(long s) {

        if(s == 0)
            return 1;

        long result = 1;
        for(long i=1;i<=s;i++)
            result = multiplyModulo(result,i);

        return result;
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
        return Long.toHexString(factorialModulo(k)).toUpperCase();
    }


}
