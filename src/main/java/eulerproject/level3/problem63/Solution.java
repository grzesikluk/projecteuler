package eulerproject.level3.problem63;

import java.math.BigInteger;

/**
 * Created by Lukasz on 2016-11-01.
 */
public class Solution {

    public static final long MAX = 100;
    public static long counter = 0;

    public static void main(String[] args) {

        for(long i =1;i< MAX;i++)  {
            counter+= isCheckValid(i);
        }
        System.out.println(counter);
    }


    /**
     * Check if Nth power is length of N.
     * @return
     */
    public static int isCheckValid(long k) {
        BigInteger powerNumber = new BigInteger(new Long(k).toString());
        BigInteger number = new BigInteger(new Long(k).toString());
        int length = powerNumber.toString().length();
        int powerIx = 1;
        int counter = 0;
        int watchdog = 100;

        while( Math.abs(length - powerIx) < 2 && watchdog>0) {

            if(length == powerIx)
                counter++;

            powerIx++;
            powerNumber = powerNumber.multiply(number);
            length = powerNumber.toString().length();
            watchdog--;
        }

        return counter;
    }







}
