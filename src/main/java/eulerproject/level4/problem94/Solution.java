package eulerproject.level4.problem94;

import eulerproject.tools.generators.SquareNumbers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.LongStream;

public class Solution
{
    public static final long MAX =1_000_000_0L;

    public static void main(String[] args)
    {
        Set<Long> squareNumbers = new HashSet<>();
        LongStream.range(0,MAX)
                .forEach(i->squareNumbers
                            .add(SquareNumbers.getNumber(i)));
        final long[] sumOfPerimeters = {0};

        LongStream.range(2,MAX).forEach(i->{
            double areaSqr = getArraySqrt(i,i,i+1);
            double areaSqr2 = getArraySqrt(i,i,i-1);

            if(isInt(areaSqr) && squareNumbers.contains((long)areaSqr)) {
                System.out.println(i + " " + (i + 1) + " " + areaSqr);
                sumOfPerimeters[0] +=getPerimeter(i,i,i+1);
            }

            if(isInt(areaSqr2) && squareNumbers.contains((long)areaSqr2)) {
                System.out.println(i + " " + (i - 1) + " " + areaSqr2);
                sumOfPerimeters[0] +=getPerimeter(i,i,-1);
            }

        });

        System.out.println(sumOfPerimeters[0]);
    }
    public static long getPerimeter(final long a, final long b, final long c) {
        return a+b+c;
    }

    public static double getArraySqrt(final long a, final long b, final long c) {
        double s = getPerimeter(a,b,c)/2.0;
        double result = s*(s-a)*(s-b)*(s-c);
        return result;
    }

    public static boolean isInt(double d) {
        return d == (int)d;
    }



}
