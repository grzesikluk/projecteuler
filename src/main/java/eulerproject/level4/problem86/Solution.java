package eulerproject.level4.problem86;

import eulerproject.tools.PythagoreanTriple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {

        System.out.println(countSolutions(6));


    }


    public static int countSolutions(int M) {
        Set<LongTriple> resultSet = new HashSet<>();

        int n = 1;

        while (true) { //endless loop? no!

            for (int m = n + 1; ; m++) {
                PythagoreanTriple pythagoreanTriple = new PythagoreanTriple(m, n);

                long a = pythagoreanTriple.getA();
                long b = pythagoreanTriple.getB();
                long c = pythagoreanTriple.getC();

                if (c > 5 * M * M) {   //end conditions
                    System.out.println(resultSet);
                    return resultSet.size();
                }

                if (a <= M && b <= M) {
                    for (int i = 1; i <= a / 2; i++) {
                        LongTriple triple = new LongTriple(i, a - i, b);

                        if (check(triple))
                            resultSet.add(triple);
                    }
                    for (int i = 1; i <= b / 2; i++) {
                        LongTriple triple = new LongTriple(i, b - i, a);

                        if (check(triple))
                            resultSet.add(triple);
                    }


                } else if (a <= M && (b > M && b <= 2 * M)) {

                    for (int i = 1; i <= b / 2; i++) {

                        if ((i <= M) && (b - i) <= M) {
                            LongTriple triple = new LongTriple(i, b - i, a);

                            if (check(triple))
                                resultSet.add(triple);
                        }
                    }
                } else if (b <= M && (a > M && b <= 2 * M)) {

                    for (int i = 1; i <= a / 2; i++) {
                        if ((i <= M) && (a - i) <= M) {
                            LongTriple triple = new LongTriple(i, a - i, b);

                            if (check(triple))
                                resultSet.add(triple);
                        }


                    }
                } else {
                    break;
                }


            }

            n++;


        }


    }

    public static boolean check(long a, long b, long c) {

        long[] array = new long[3];

        array[0] = a * a + (c + b) * (c + b);
        array[1] = b * b + (c + a) * (c + a);
        array[2] = c * c + (a + b) * (a + b);

        Arrays.sort(array);
        return isIntegerSqrt(array[0]);

    }

    public static boolean check(LongTriple triple) {
        return check(triple.getA(), triple.getB(), triple.getC());
    }

    private static boolean isIntegerSqrt(long k) {
        long i = 1;

        while (i * i < k)
            i++;

        return i * i == k;
    }


}
