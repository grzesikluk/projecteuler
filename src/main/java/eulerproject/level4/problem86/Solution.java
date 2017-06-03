package eulerproject.level4.problem86;

import eulerproject.tools.PythagoreanTriple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int MAX = 1_000_000;


    public static void main(String[] args) {

        int step = 1;
        int position = 1;
        while (step != 0) {
            step = getNextStep(step, countSolutions(position) > MAX);
            position += step;
            System.out.println(position);
        }
        System.out.println(position);


    }

    //progress forward to exceed the condition

    public static int getNextStep(int previousStep, boolean condition) {

        int nextStep = previousStep;

        if (previousStep > 0) {
            if (!condition) {
                nextStep = 2 * previousStep;
            } else {
                nextStep = -previousStep / 2;
            }

        } else {

            if (!condition) {
                nextStep = -previousStep / 2;
            } else {
                nextStep = previousStep / 2;
            }

        }

        return nextStep;


    }


    private static boolean isPythTriangleEligible(PythagoreanTriple triple, int M) {
        return (triple.getC() * triple.getC() <= 5 * M * M);
    }

    public static int countSolutions(int M) {

        Set<LongTriple> resultSet = new HashSet<>();
        boolean previousNotEligible = false;

        for (int n = 1; ; n++) {

            for (int m = n + 1; ; m++) {
                PythagoreanTriple pythagoreanTriple = new PythagoreanTriple(m, n);

                if (!isPythTriangleEligible(pythagoreanTriple, M)) {

                    if (!previousNotEligible) {
                        previousNotEligible = true;
                        break; //skip to next n

                    } else {
                        return resultSet.size();
                    }

                } else {
                    previousNotEligible = false;

                }

                PythagoreanTriple pythagoreanTripleNext = pythagoreanTriple.getNext(1);

                int j = 1;

                while (isPythTriangleEligible(pythagoreanTripleNext, M)) { //loop through all pyth next triangles

                    long a = pythagoreanTripleNext.getA();
                    long b = pythagoreanTripleNext.getB();

                    if (a <= M && b <= M) {

                        updateResultSet(resultSet, a, b, M);
                        updateResultSet(resultSet, b, a, M);


                    } else if (a <= M && (b > M && b <= 2 * M)) {
                        updateResultSet(resultSet, b, a, M);

                    } else if (b <= M && (a > M && b <= 2 * M)) {
                        updateResultSet(resultSet, a, b, M);

                    } else {
                        break;
                    }


                    j++;
                    pythagoreanTripleNext = pythagoreanTriple.getNext(j);
                }


            }

        }

    }

    private static void updateResultSet(Set<LongTriple> resultSet, long x, long y, long M) {

        for (int i = 1; i <= x / 2; i++) {
            if ((i <= M) && (x - i) <= M) {
                LongTriple triple = new LongTriple(i, x - i, y);

                if (check(triple))
                    resultSet.add(triple);
            }


        }

    }


    public static boolean check(long a, long b, long c) {

        long[] array = new long[3];

        array[0] = a * a + (c + b) * (c + b);
        array[1] = b * b + (c + a) * (c + a);
        array[2] = c * c + (a + b) * (a + b);

        Arrays.sort(array);
        return isIntegerSqrt(array[0]);   //shortest

    }

    public static boolean check(LongTriple triple) {
        return check(triple.getA(), triple.getB(), triple.getC());
    }

    public static boolean isIntegerSqrt(long k) {
        long i = 1;

        while (i * i < k)
            i++;

        return i * i == k;
    }


}
