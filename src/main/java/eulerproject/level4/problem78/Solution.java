import eulerproject.tools.generators.PolygonalNumbers;

public class Solution {

    public static final int MAX = 10000000;
    public static final int MODULO = 1000000;


     public static void main(String[] args) {
        int[] results = new int[MAX];
        results[0] = 1;
        int n = 1;

        while (true) {

            int i = 0;
            int pentagonalNumber = 1;

            while (pentagonalNumber <= n) {
                results[n] += getSign(i) * results[n - pentagonalNumber];
                results[n] %= MODULO;

                i++;
                pentagonalNumber = PolygonalNumbers.getPentagonalNumber(getI(i));

            }
            if (results[n] == 0) {
                System.out.println(n);
                break;
            }
            n++;
        }

    }


    private static int getSign(int i) {
        return (i % 4 > 1) ? -1 : 1;
    }

    private static int getI(int i) {
        return (i % 2 == 0) ? i / 2 + 1 : -(i / 2 + 1);
    }
}
