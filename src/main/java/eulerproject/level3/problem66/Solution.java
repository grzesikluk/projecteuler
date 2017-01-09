package eulerproject.level3.problem66;

import javafx.util.Pair;

import java.math.BigInteger;

/**
 * Created by grzesikl on 09/01/2017.
 */
public class Solution {
    //    private static Set<BigInteger> setSquares;
    private static final String BIG_INT_MAX = "10000000000000";
    private static final BigInteger BIG_MAX = new BigInteger(BIG_INT_MAX);
//
//    static {
//
//        System.out.println("Init started.");
//        BigInteger i = BigInteger.ONE;
//        setSquares = new HashSet<>();
//
//        while (i.compareTo(BIG_MAX) < 0) {
//            setSquares.add(i.pow(2));
//            i = i.add(BigInteger.ONE);
//        }
//        System.out.println("Init finished.");
//
//
//    }


    public static void main(String[] args) {
        System.out.println(getSolution(1000));
    }

    public static Pair<BigInteger, BigInteger> getPellsEquationSolution(int D) {
        BigInteger i = BigInteger.ONE;
        BigInteger bigD = new BigInteger(Integer.toString(D));

        while (i.compareTo(BIG_MAX) < 0) {
            BigInteger k = BigInteger.ONE.add(bigD.multiply(i.pow(2)));
//            if (setSquares.contains(k))
            if (isSquare(k))
                return new Pair<>(bigIntegerSqrt(k), i);

            i = i.add(BigInteger.ONE);
        }

        return null;

    }

    public static BigInteger bigIntegerSqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength() / 2);
        BigInteger div2 = div;
        for (; ; ) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }

    public static int getSolution(int maxD) {
        BigInteger tempX = BigInteger.ZERO;
        int result = 1;

        for (int i = 2; i <= maxD; i++) {

//            if(!setSquares.contains(new BigInteger(Integer.toString(i)))){
            if (!isSquare(new BigInteger(Integer.toString(i)))) {
                System.out.println("Checking no: "+i);
                Pair<BigInteger, BigInteger> pair = getPellsEquationSolution(i);

                if (pair == null)
//                    throw new ArithmeticException("Pair returned null for " + i);
                    System.out.println("didnt found solution for i="+i);
                else {
                    BigInteger x = pair.getKey();

                    if (x.compareTo(tempX) > 0) {
                        System.out.println(pair.getKey() + " " + pair.getValue() + " " + i);
                        tempX = x;
                        result = i;
                    }
                }
            }

        }

        return result;

    }

    public static boolean isSquare(BigInteger i) {
        return i.equals(bigIntegerSqrt(i).pow(2));
    }

}


