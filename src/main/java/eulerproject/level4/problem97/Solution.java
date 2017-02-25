package eulerproject.level4.problem97;

import eulerproject.tools.functions.ModularNumber;

public class Solution {
    public static final long MAX = 10000000000L;

    public static void main(String[] args) {

        ModularNumber p = new ModularNumber(MAX,2);
        p = p.powerModular(7830457).multiplyModular(28433).addModular(1);

        System.out.println(p.getValue());
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
