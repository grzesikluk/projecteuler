package eulerproject.level3.problem56;

import java.math.BigInteger;

/**
 * Created by Lukasz on 2016-09-13.
 */
public class Solution {
    public static final int MAX = 100;

    public static void main(String[] args) {
        BigInteger maximum = new BigInteger("0");

        for(int i=1;i<MAX;i++)
            for(int j=1;j<MAX;j++) {
                BigInteger temp = sumAllDigits(calculatePower(i,j));
                if(maximum.compareTo(temp) < 0) {
                    maximum = temp;
                }

            }
        System.out.println(maximum);
    }

    public static BigInteger sumAllDigits(BigInteger k) {
        String kStr = k.toString();
        BigInteger result = new BigInteger("0");

        for(int i=0;i<kStr.length();i++) {
            Character c = kStr.charAt(i);
            result = result.add(new BigInteger(c.toString()));

        }

        return result;
    }


    public static BigInteger calculatePower(int a, int b) {
        return new BigInteger(new Integer(a).toString()).pow(b);
    }

}
