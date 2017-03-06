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
    public static Pair<List<Long>, List<Long>> getSquareRoot(long k, int maxLength) {

        List<Pair<Long, Long>> dubles = getDublesFromNumber(k);
        long prefix = 0;
        long temp = 0;
        long result = 0;
        long value = 0;
        long counter = 0;
        boolean digit = false;

        Pair<List<Long>,List<Long>> resultPair = new Pair<>(new LinkedList<>(), new LinkedList<>());

        for (Pair<Long, Long> duble : dubles) {
            value = value * 100 + dubleToLong(duble);
            temp = findDigitValue(prefix, value);
            value -= getValueForDigit(prefix, temp);
            result = result * 10 + temp;
            prefix = result * 2;

            counter++;
            if (counter >= maxLength)
                break;

            if(result*result <= k && digit == false)
                resultPair.getKey().add(temp);
            else {
                resultPair.getValue().add(temp);
                digit = true;
            }


        }

        while (value != 0 && counter < maxLength) {
            value = value * 100;
            temp = findDigitValue(prefix, value);
            value -= getValueForDigit(prefix, temp);
            result = result * 10 + temp;
            prefix = result * 2;
            counter++;

            if(result*result <= k && digit == false)
                resultPair.getKey().add(temp);
            else {
                resultPair.getValue().add(temp);
                digit = true;
            }
        }


        return resultPair;
    }

    public static List<Pair<Long, Long>> getDublesFromNumber(long k) {
        String strK = Long.toString(k);
        List<Pair<Long, Long>> result = new LinkedList<>();

        for (int i = strK.length() - 1; i >= 0; i -= 2) {

            if (i - 1 < 0) {
                result.add(new Pair<Long,Long>(0L, strK.charAt(i) - 48L));

            } else {
                result.add(new Pair<Long,Long>(strK.charAt(i - 1) - 48L, strK.charAt(i) - 48L));
            }
        }
        Collections.reverse(result);

        return result;
    }

    public static long findDigitValue(long prefix, long value) {
        int i = 0;

        while (getNumberFromPrefix(i, prefix) * i <= value)
            i++;

        return --i;
    }

    public static long getValueForDigit(long prefix, long k) {
        return getNumberFromPrefix(k, prefix) * k;
    }

    private static long getNumberFromPrefix(long postfix, long prefix) {
        return Long.valueOf(Long.toString(prefix) + Long.toString(postfix));
    }

    private static long dubleToLong(Pair<Long, Long> input) {
        return input.getKey() * 10 + input.getValue();
    }
}
