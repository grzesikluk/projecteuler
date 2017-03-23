package eulerproject.level3.problem75;

/**
 * Created by Lukasz on 2017-03-23.
 */
public class Solution {
    private static final int MAX = 100;
    private static final int MAX_LEN = 50;

    public static void main(String[] args) {

        int[] tabOfCounts = new int[MAX_LEN];

        for (int n = 1; n < MAX; n++) {
            for (int m = n + 1; m < MAX; m++) {
                int a = m * m - n * n;
                int b = 2 * m * n;
                int c = m * m + n * n;

                int len = a+ b+ c;
                if (len < MAX_LEN) {
                    tabOfCounts[len]++;
                    System.out.println( a+ " " + b + " " + c + " " + len);
                }

            }
        }

        int counter = 0;
        for (int i = 1; i < tabOfCounts.length; i++) {
            if (tabOfCounts[i] == 1) {
                System.out.println(i);

                counter++;
            }
        }

        System.out.println(counter);

    }

}
