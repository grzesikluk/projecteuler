package eulerproject.tools;

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
}
