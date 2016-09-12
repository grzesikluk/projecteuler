package eulerproject.level3.problem52;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lukasz on 2016-09-12.
 */
public class Solution {
    public static final int MAX = 1000000;

    public static void main(String[] args) {
        for (int i=1;i<MAX;i++) {

            if (checkCondition(i)) {
                System.out.println(i);
                System.exit(0);

            }


        }

    }


    public static boolean checkCondition(int k) {

        return containSameDigits(k,2) &&
                containSameDigits(k,3) &&
                containSameDigits(k,4) &&
                containSameDigits(k,5) &&
                containSameDigits(k,6) ;

    }

    public static boolean containSameDigits(int number, int multiplier) {
        String strK = new Integer(number).toString();
        String str2K = new Integer(multiplier*number).toString();

        Set<Character> setK = new HashSet<>();
        Set<Character> set2K = new HashSet<>();

        for (int i=0;i<strK.length();i++)
            setK.add(strK.charAt(i));

        for (int i=0;i<str2K.length();i++)
            set2K.add(str2K.charAt(i));

        for (Character c:setK) {
            if(!str2K.contains(c.toString()))
                return false;
        }
        for (Character c:set2K) {
            if(!strK.contains(c.toString()))
                return false;
        }

        return true;


    }
}
