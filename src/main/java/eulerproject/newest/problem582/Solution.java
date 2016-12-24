package eulerproject.newest.problem582;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lukasz on 2016-12-23.
 */
public class Solution {

    private static Set<Factors> allFactors;


    public static void main(String[] args) {
        for (int n = 1; n < 1000000000; n *= 10) {
            int s = getSolution(n);
            System.out.println(n + " " + s + " " + (double) s / n);
        }

    }

    public static int getSolution(int n) {
        int result = 0;
        allFactors = new HashSet<>();

        for (long a = 1; a <= n; a++)
            for (long b = a + 1; (b - a) <= 100; b++) {
                double c = Math.sqrt(((a * a + b * b + a * b)));

                if (c <= n && c % 1 == 0) {
                    result++;
                    allFactors.add(new Factors(new Long(a),new Long(b),new Long((long) c)));
                    System.out.println("[a= "+a+ " b="+b+" c="+c +"]");
                };
            }


        System.out.println(allFactors);
        System.out.println(allFactors.size());

        return result;
    }

}
