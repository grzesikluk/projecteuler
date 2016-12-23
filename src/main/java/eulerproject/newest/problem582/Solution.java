package eulerproject.newest.problem582;

/**
 * Created by Lukasz on 2016-12-23.
 */
public class Solution {

    public static void main(String[] args) {
        for(int n=1;n<1000000000;n*=10)  {
            int s = getSolution(n);
            System.out.println(n   + " " + s + " "+ (double)s/n);
        }

    }

    public static int getSolution(int n) {
        int result = 0;

        for (long a = 1; a <= n; a++)
            for (long b = a + 1; (b - a) <= 100; b++) {
                double c = Math.sqrt(((a * a + b * b + a * b)));

                if (c <= n && c%1 == 0)
                    result++;
            }


        return result;
    }

}
