package eulerproject.level3.problem55;

/**
 * Created by Lukasz on 2016-09-13.
 */
public class Solution {
    public static final int MAX = 10000;
    public static final int MAX_ITER = 50;

    public static void main(String[] args) {
        int k=1;
        int counter=0;

        while(k<MAX) {
            if (isLychrelNumber(k))
                counter++;
            k++;
        }
        System.out.println(counter);

    }


    public static boolean isPalindrome(String s) {

        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;

        return true;
    }

    public static BigInteger reverseInt(BigInteger k) {
        String reversed = "";
        String original = k.toString();

        for (int i = original.length() - 1; i >= 0; i--)
            reversed += original.charAt(i);

        return new BigInteger(reversed);
    }


    public static BigInteger addNumberToItsReverse(BigInteger k) {
        BigInteger result = new BigInteger(k.toString());

        return result.add(reverseInt(k));
    }

    public static boolean isLychrelNumber(int k) {
        BigInteger bigK = new BigInteger(new Integer(k).toString());
        BigInteger temp = new BigInteger(bigK.toString());

        for (int iteration = 1; iteration < MAX_ITER; iteration++) {
            temp = addNumberToItsReverse(temp);

            if (isPalindrome(temp.toString()))
                return false;
        }
        return true;


    }


}
