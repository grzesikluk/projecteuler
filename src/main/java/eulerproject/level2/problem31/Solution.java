package eulerproject.level2.problem31;

/**
 * Created by Lukasz on 2016-08-22.
 */
public class Solution {
    private static final int COINS_AMOUNT = 8;

    private static final int coinValues[] = {1, 2, 5, 10, 20, 50, 100, 200};
    private static final int VALUE_TO_CHECK = 200;

    public static void main(String[] args) {
        int count=0;
        for (int i = 0; i <= VALUE_TO_CHECK / coinValues[0]; i++)
            for (int j = 0; j <= VALUE_TO_CHECK / coinValues[1]; j++)
                for (int k = 0; k <= VALUE_TO_CHECK / coinValues[2]; k++)
                    for (int l = 0; l <= VALUE_TO_CHECK / coinValues[3]; l++)
                        for (int m = 0; m <= VALUE_TO_CHECK / coinValues[4]; m++)
                            for (int n = 0; n <= VALUE_TO_CHECK / coinValues[5]; n++)
                                for (int o = 0; o <= VALUE_TO_CHECK / coinValues[6]; o++)
                                    for (int p = 0; p <= VALUE_TO_CHECK / coinValues[7]; p++)
                                        if (checkCoin(new int[]{i, j, k, l, m, n, o, p})){     count++;}
        System.out.println(count);
        //

    }

    public static boolean checkCoin(int[] factors) {
        int sum = 0;

        for (int i = 0; i < COINS_AMOUNT; i++) {
            sum += factors[i] * coinValues[i];
        }


        return sum == VALUE_TO_CHECK;
    }

}

