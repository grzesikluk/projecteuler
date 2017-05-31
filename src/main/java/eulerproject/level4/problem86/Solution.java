package eulerproject.level4.problem86;

import eulerproject.level3.problem75.PythagoreanTriple;

public class Solution {


    public static void main(String[] args) {


        PythagoreanTriple pythagoreanTriple = new PythagoreanTriple(2,1);

        System.out.println(pythagoreanTriple);

        System.out.println(check(6,5,3));
        System.out.println(check(6,5,2));
        System.out.println(check(5,5,2));



    }

    public static boolean check(int a, int b, int c) {

        int l1 = a*a + (c+b)*(c+b);
        int l2 = b*b + (c+a)*(c+a);
        int l3 = c*c + (a+b)*(a+b);

        return isIntegerSqrt(l1) || isIntegerSqrt(l2) || isIntegerSqrt(l3);

    }

    private static boolean isIntegerSqrt(int k) {
        int i = 1;

        while(i*i < k)
            i++;

        return i*i == k;
    }


}
