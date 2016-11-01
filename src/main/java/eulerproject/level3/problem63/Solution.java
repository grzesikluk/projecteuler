package eulerproject.level3.problem63;

/**
 * Created by Lukasz on 2016-11-01.
 */
public class Solution {


    public static void main(String[] args) {

    }


    /**
     * Check if Nth power is length of N.
     * @return
     */
    public static boolean isCheckValid(long k) {
        long powerNumber = 1*k;
        int powerIx = 1;
        int length = new Long(powerNumber).toString().length();

        while( length  !=  powerIx) {
            powerNumber *=k;
            powerIx++;
            length = new Long(powerNumber).toString().length();
            if(length < powerIx )
                return false;
        }
        return true;

    }





}
