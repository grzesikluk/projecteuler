package eulerproject.level2.problem38;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by grzesikl on 26/08/2016.
 */
public class Solution {

    private static final long MAX_INT = 987654321*2/11;
    private static final int MAX_N = 5;

    public static void main(String[] args) {


        for (int i=1;i<MAX_INT;i++) {
            for(int j = 1;j<MAX_N;j++) {
                if (checkPandigits(i,j))
                    System.out.println("Pandigit is k= "+i+" f= "+j+" value "+ concatenateNumbers(generateNumbers(i,j)));
            }
        }

    }

    /**
     * Generate numbers k*i where i in {1 .. f}
     * @param k
     * @param f
     * @return
     */
    public static ArrayList<Long> generateNumbers(long k, int f) {
        ArrayList<Long> result = new ArrayList<>();

        for(int i = 1;i<=f;i++) {
            result.add(k*i);
        }
        return result;
    }

    public static String concatenateNumbers(ArrayList<Long> arr) {
        String number = new String();

        for(Long i:arr) {
            number= number + i.toString();
        }
        return number;

    }

    public static boolean isPandigital(String k) {

        String str = k;
        HashMap<Character, Integer> count = new HashMap<>();

        count.put('1', 0);
        count.put('2', 0);
        count.put('3', 0);
        count.put('4', 0);
        count.put('5', 0);
        count.put('6', 0);
        count.put('7', 0);
        count.put('8', 0);
        count.put('9', 0);
        count.put('0', 0);

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '1':
                    count.replace('1', count.get('1') + 1);
                    break;
                case '2':
                    count.replace('2', count.get('2') + 1);
                    break;
                case '3':
                    count.replace('3', count.get('3') + 1);
                    break;
                case '4':
                    count.replace('4', count.get('4') + 1);
                    break;
                case '5':
                    count.replace('5', count.get('5') + 1);
                    break;
                case '6':
                    count.replace('6', count.get('6') + 1);
                    break;
                case '7':
                    count.replace('7', count.get('7') + 1);
                    break;
                case '8':
                    count.replace('8', count.get('8') + 1);
                    break;
                case '9':
                    count.replace('9', count.get('9') + 1);
                    break;
                case '0':
                    count.replace('0', count.get('0') + 1);
                    break;
            }
        }

        if (count.get('0') != 0) return false;

        count.replace('0',1); /*Trick to simplify further checking*/

        for (Character c : count.keySet())
            if (count.get(c) != 1) return false;

        return true;

    }


    public static boolean checkPandigits(long k, int f) {
        return isPandigital(concatenateNumbers(generateNumbers(k,f)));
    }


}
