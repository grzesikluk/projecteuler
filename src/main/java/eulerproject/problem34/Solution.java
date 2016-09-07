package eulerproject.problem34;

/**
 * Created by Lukasz on 2016-08-25.
 */
public class Solution {

    private static final long[] factorials = new long[10];

    static {

        for(int i=1;i<10;i++) {
            factorials[i] = getFactorial(i);
        }

    }

    public static void main(String[] args) {
        long result = 0L;

        for(long i=3;i<10000000;i++) {
            if (i == getSumOfFactorialsFromDigits(i)) {
                //System.out.println(i);

                result += i;
            }

        }
        System.out.println(result);
    }


    private static long getFactorial(long k) {
        long result=1;

        for(long i=1;i<=k;i++) {
           result*=i;
        }
        return result;
    }


    public static long getSumOfFactorialsFromDigits(long p) {

        String pChar = new Long(p).toString();
        long result = 0;

        for(int i =0;i< pChar.length();i++) {
//            System.out.println(new Long(pChar.charAt(i)-48));
            result+=  getFactorial(new Long(pChar.charAt(i)-48));
        }


        return result;
    }


    static public int getMaximumPower() {
        for(int i=1;i<100;i++) {
            if (getFactorial(9)*i<Math.pow(10,i)) {
                return i;
            }
        }
        return 0;
    }

}
