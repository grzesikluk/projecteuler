package eulerproject.tools;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lukasz on 2016-11-09.
 */
public class StringHelper {

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
