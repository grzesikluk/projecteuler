package projecteuler.problem53;

import java.math.BigInteger;

/**
 * Created by grzesikl on 13/09/2016.
 */
public class Solution {
    public static final int MAX = 100;
    public static final BigInteger THRESH = new BigInteger("1000000");

    public static void main(String[] args) {
        long counter = 0;

        for (int n =1; n<=MAX; n++) {
            for (int r=1; r <=n; r++) {
                if (countCombination(n,r).compareTo(THRESH) == 1)
                    counter++;

            }
        }
        System.out.println(counter);


    }


    public static BigInteger countCombination(int n, int r) {
        BigInteger dividor = new BigInteger("0");
        BigInteger divident = new BigInteger("0");;

        if( r > n-r ) {
            dividor = getProduct(r+1,n);
            divident = getProduct(1,n-r);
        }
        else {
            dividor = getProduct(n-r+1,n);
            divident = getProduct(1,r);
        }


        return dividor.divide(divident);

    }

    public static BigInteger getProduct(int a, int b) {
        BigInteger result = new BigInteger("1");

        for(int i=a;i<=b;i++) {
            BigInteger multiplier = new BigInteger(new Integer(i).toString());
            result = result.multiply(multiplier);
        }
        return result;

    }


}
