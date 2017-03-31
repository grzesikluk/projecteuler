package eulerproject.level3.problem75;

/**
 * Created by Lukasz on 2017-03-23.
 */
public class Solution {
    private static final int MAX_LEN = 1_500_000;
    private static int[] array = new int[MAX_LEN + 1];

    public static void main(String[] args) {
        System.out.println(countNumberOfUniqPythLength(MAX_LEN));

    }

    public static void transform(int a, int b, int c, int[] countArray) {
        int len = a + b + c;
        if (len > MAX_LEN) return;

        for (int l = len; l <= MAX_LEN; l += len) countArray[l]++;

        transform(a - 2 * b + 2 * c, 2 * a - b + 2 * c, 2 * a - 2 * b + 3 * c, countArray);
        transform(a + 2 * b + 2 * c, 2 * a + b + 2 * c, 2 * a + 2 * b + 3 * c, countArray);
        transform(-a + 2 * b + 2 * c, -2 * a + b + 2 * c, -2 * a + 2 * b + 3 * c, countArray);

    }

    private static void clearArray() {
        for (int i=0;i<MAX_LEN;i++)
            array[i]=0;
    }

    public static int countNumberOfUniqPythLength(long maxLength) {
        int count = 0;
        clearArray();
        transform(3, 4, 5, array);

        for (int i = 1; i <= maxLength; i++) {
            if (array[i] == 1)
                count++;

        }

        return count;
    }

}
