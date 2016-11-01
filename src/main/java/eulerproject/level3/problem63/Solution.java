package eulerproject.level3.problem63;

import java.math.BigInteger;

/**
 * Created by Lukasz on 2016-11-01.
 */
public class Solution {

    public static final long MAX = 200000000;
    public static long counter =0;

    public static void main(String[] args) {


        for(long i =1;i< MAX;i++)  {
            if(isCheckValid(i) < 0)
                counter++;
        }
        System.out.println(counter);


    }


    /**
     * Check if Nth power is length of N.
     * @return
     */
    public static int isCheckValid(long k) {
        System.out.println(" isCheckValid k= " + k );

        BigInteger powerNumber = new BigInteger(new Long(k).toString());
        BigInteger number = new BigInteger(new Long(k).toString());
        int powerIx = 1;
        int length = powerNumber.toString().length();

        while( length  !=  powerIx) {

            if( length > powerIx + 10)    //this condition must be udpated.
                return 0;

            System.out.println(" len of number " + length + " power no: " + powerNumber+  " power ix " + powerIx);

            //next iteration
            powerIx++;
            powerNumber = powerNumber.multiply(number);
            length = powerNumber.toString().length();

        }

        System.out.println(" k= " + k + " power" + powerNumber);

        return powerIx;

    }







}
