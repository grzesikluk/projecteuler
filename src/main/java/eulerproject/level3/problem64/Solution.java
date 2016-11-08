package eulerproject.level3.problem64;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lukasz on 2016-11-02.
 */
public class Solution {

    public static void main(String[] args) {



    }


    public static String findPeriodInSubstring(String input,int start) {
        String s = input.substring(start);

        Matcher m = Pattern.compile("(\\S+)(?=.*?\\1)").matcher(s);
        while (m.find())
        {
            for (int i = 1; i <= m.groupCount(); i++)
            {
                System.out.println(m.group(i));
            }
        }


        return "";

    }

}