package eulerproject.level3.problem97;

public class Solution {
    public static final long MAX = 10000000000L;

    public static void main(String[] args) {
        //28433×2^7830457+1.
        long p = powerModular(MAX, 2, 7830457);
        long r = multiplyModular(MAX, 28433, p);


        System.out.println(addModular(MAX,r, 1));
    }

    public static long addModular(long modulo, long a, long b) {
        return (a + b) % modulo;
    }

    public static long multiplyModular(long modulo, long a, long b) {
        return (a * b) % modulo;
    }

    public static boolean equalsModular(long modulo, long a, long b) {
        return a % modulo == b % modulo;
    }

    public static long powerModular(long modulo, long base, long power) {
        long result = base;

        for (int i = 1; i < power; i++)
            result = multiplyModular(modulo, result, base);

        return result;

    }
}
