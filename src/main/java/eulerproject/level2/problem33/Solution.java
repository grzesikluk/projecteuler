package eulerproject.level2.problem33;

/**
 * Created by grzesikl on 07/09/2016.
 */
public class Solution {
    public static void main(String[] args) {
        int commonA=1, commonB=1;

        for(int i=10;i<99;i++)
            for (int j=10;j<99;j++)
                if (check(i,j)) {
                    System.out.println("Found a/b = " + i + "/" + j);
                    commonA*=i;
                    commonB*=j;
                }
        System.out.println("Common a ="+commonA+" common b = " + commonB);
    }

    public static boolean check(int a, int b) {
        String strA = new Integer(a).toString();
        String strB = new Integer(b).toString();
        String newA, newB;
        Character c;

        if ((a < 10 && a > 99) || (b < 10 && b > 99) || (a==b) || a>=b)
            return false;

        if ((c = findCommonDigit(a, b)) != null && c != '0') {

            newA = replaceOneChar(strA,c);
            newB = replaceOneChar(strB,c);
            Float newFloatA = new Float(newA);
            Float newFloatB = new Float(newB);
            Float floatA = new Float(a);
            Float floatB = new Float(b);



            return ( floatA/floatB == newFloatA/newFloatB);

        } else
            return false;



    }

    public static Character findCommonDigit(int a, int b) {

        if ((a < 10 && a > 99) || (b < 10 && b > 99))
            return null;

        String strA, strB;
        strA = new Integer(a).toString();
        strB = new Integer(b).toString();

        if (strB.contains(strA.substring(0, 1)))
            return strA.charAt(0);

        if (strB.contains(strA.substring(1, 2)))
            return strA.charAt(1);

        return null;
    }

    public static String replaceOneChar(String str, Character c) {
        String result = new String();
        int counter = 0;

        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) != c) {
                result+=str.charAt(i);
            } else {
                if (counter > 0) {
                    result+=str.charAt(i);
                }
                counter++;
            }
        return result;
    }

}
