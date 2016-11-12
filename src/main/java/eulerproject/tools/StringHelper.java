package eulerproject.tools;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lukasz on 2016-11-09.
 */
public class StringHelper {

    public static String findPeriodInSubstring(String input, int start) {
        String s = input.substring(start);
        String result = "";

        Matcher m = Pattern.compile("(\\S+?)(?=(\\1){10,})").matcher(s);

        int maxLen = 0;

        while (m.find()) {

            for (int i = 0; i < m.groupCount(); i++) {
                if (m.group(i).length() > maxLen) {
                    maxLen = m.group(i).length();
                    result = m.group(i);

                }
            }
        }
        return result;

    }



    /**
     * a list must be sorted first!
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isPermutation(List<Character> a, String b) {
        List<Character> aChars =  a;
        List<Character> bChars =  convertToCharList( b.toCharArray());

        bChars.sort((Character l, Character m)->l-m);

        if(aChars.size()!= bChars.size())
            return false;

        for(int i=0;i<aChars.size();i++) {
            if(!aChars.get(i).equals(bChars.get(i)))
                return false;
        }
        return true;

    }


    public static boolean isPermutation(String a, String b) {
        List<Character> aChars =  convertToCharList( a.toCharArray());

        aChars.sort((Character l, Character m)->l-m);

        return isPermutation(aChars,b);

    }

    public static List<Character> convertToCharList(char[] a) {
        List<Character> result = new LinkedList<>();

        for(int i=0;i<a.length;i++)
            result.add(a[i]);
        return result;
    }


}
