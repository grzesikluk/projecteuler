package eulerproject.level4.problem80;

import javafx.util.Pair;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by grzesikl on 06/03/2017.
 * (2x + r)*r ≤	a − x^2
 */
public class Solution {


    /**
     * Key value of pair is the first list of digits before point, value is
     * list of digits after dot.
     *
     * @param k
     * @param maxLength
     * @return
     */
    public static Pair<List<Integer>, List<Integer>> getSquareRoot(int k, int maxLength) {

        List<Pair<Integer, Integer>> dubles = getDublesFromNumber(k);
        int prefix = 0;
        int temp = 0;
        int result = 0;
        int value = 0;
        int counter = 0;

        for (Pair<Integer, Integer> duble : dubles) {
            value = value * 100 + dubleToInt(duble);
            temp = findDigitValue(prefix, value);
            value -= getValueForDigit(prefix, temp);
            result = result * 10 + temp;
            prefix = result * 2;

            counter++;
            if (counter > maxLength)
                break;

        }

        while (value != 0 && counter <= maxLength) {
            value = value * 100;
            temp = findDigitValue(prefix, value);
            value -= getValueForDigit(prefix, temp);
            result = result * 10 + temp;
            prefix = result * 2;

        }


        return null;
    }

    public static List<Pair<Integer, Integer>> getDublesFromNumber(int k) {
        String strK = Integer.toString(k);
        List<Pair<Integer, Integer>> result = new LinkedList<>();

        for (int i = strK.length() - 1; i >= 0; i -= 2) {

            if (i - 1 < 0) {
                result.add(new Pair<>(0, strK.charAt(i) - 48));

            } else {
                result.add(new Pair<>(strK.charAt(i - 1) - 48, strK.charAt(i) - 48));
            }
        }
        Collections.reverse(result);

        return result;
    }

    public static int findDigitValue(int prefix, int value) {
        int i = 0;

        while (getNumberFromPrefix(i, prefix) * i <= value)
            i++;

        return --i;
    }

    public static int getValueForDigit(int prefix, int k) {
        return getNumberFromPrefix(k, prefix) * k;
    }

    private static int getNumberFromPrefix(int postfix, int prefix) {
        return Integer.valueOf(Integer.toString(prefix) + Integer.toString(postfix));
    }

    private static int dubleToInt(Pair<Integer, Integer> input) {
        return input.getKey() * 10 + input.getValue();
    }
}
