package eulerproject.problem39;

import java.util.HashSet;

/**
 * Created by grzesikl on 26/08/2016.
 * <p>
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
 * <p>
 * {20,48,52}, {24,45,51}, {30,40,50}
 * <p>
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class Solution {

    public static final int MAX_P = 1000;


    public static void main(String[] args) {
        int max = 0;
        int max_p = 0;

        for(int i=3;i<MAX_P;i++) {
            if(getNoOfRightAngleTriangles(i)>max) {
                max = getNoOfRightAngleTriangles(i);
                max_p = i;
            }
        }
        System.out.println(" Max p = " + max_p + " max = " + max);

    }

    public static int getNoOfRightAngleTriangles(int p) {
        HashSet<HashSet<Integer>> result = new HashSet<>();

        for (int i = 1; i < p - 1; i++) {
            for (int j = i; j < p - i; j++)
                if (isRightAngleTriangle(i, j, (p - i - j))) {
                    HashSet<Integer> res = new HashSet<>();
                    res.add(i);
                    res.add(j);
                    res.add(p - i - j);

                    result.add(res);

                }
        }

//        System.out.println(result);
        return result.size();

    }


    public static boolean isRightAngleTriangle(int a, int b, int c) {

        return (a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a);

    }
}
