package eulerproject.tools.functions;

import javafx.util.Pair;

import java.math.BigInteger;
import java.util.*;


public class SquaresBigIntImpl implements Squares {

    @Override
    public Set<Integer> getIrrationalSquares(int max) {
        Set<Integer> irrationalSquareRootsNumbers = new HashSet<>();

        for(int i=1;i<=max;i++)
            irrationalSquareRootsNumbers.add(i);

        for(int i=1;i*i<=max;i++)
            if(irrationalSquareRootsNumbers.contains(i*i))
                irrationalSquareRootsNumbers.remove(i*i);

        return irrationalSquareRootsNumbers;
    }
    
    @Override
    public Pair<List<Integer>, List<Integer>> getSquareRootDigits(int k, int maxLength) {

        List<Pair<Integer, Integer>> dubles = getDublesFromNumber(k);
        BigInteger prefix = BigInteger.ZERO;
        int temp = 0;
        BigInteger result = BigInteger.ZERO;
        BigInteger value = BigInteger.ZERO;
        int counter = 0;
        boolean digit = false;

        Pair<List<Integer>,List<Integer>> resultPair = new Pair<>(new LinkedList<>(), new LinkedList<>());

        for (Pair<Integer, Integer> duble : dubles) {
            value = dubleToBigInteger(duble).add(new BigInteger(value.toString()).multiply(new BigInteger("100")));
            temp = findDigitValue(prefix, value);
            value = value.subtract(getValueForDigit(prefix, temp));
            result = result.multiply(new BigInteger("10")).add(new BigInteger(Integer.toString(temp)));
            prefix = result.multiply(new BigInteger("2"));

            counter++;
            if (counter >= maxLength)
                break;

            if(result.multiply(result).compareTo(new BigInteger(Integer.toString(k))) <= 0 && digit == false)
                resultPair.getKey().add(temp);
            else {
                resultPair.getValue().add(temp);
                digit = true;
            }


        }

        while (value.compareTo(BigInteger.ZERO) != 0 && counter < maxLength) {
            value = value.multiply(new BigInteger("100")) ;
            temp = findDigitValue(prefix, value);
            value = value.subtract(getValueForDigit(prefix, temp));
            result = result.multiply(new BigInteger("10")).add(new BigInteger(Integer.toString(temp)));
            prefix = result.multiply(new BigInteger("2"));
            counter++;

            if(result.multiply(result).compareTo(new BigInteger(Integer.toString(k))) <= 0 && digit == false)
                resultPair.getKey().add(temp);
            else {
                resultPair.getValue().add(temp);
                digit = true;
            }
        }


        return resultPair;
    }

    private static List<Pair<Integer, Integer>> getDublesFromNumber(int k) {
        String strK = Integer.toString(k);
        List<Pair<Integer, Integer>> result = new LinkedList<>();

        for (int i = strK.length() - 1; i >= 0; i -= 2) {

            if (i - 1 < 0) {
                result.add(new Pair<Integer,Integer>(0, strK.charAt(i) - 48));

            } else {
                result.add(new Pair<Integer,Integer>(strK.charAt(i - 1) - 48, strK.charAt(i) - 48));
            }
        }
        Collections.reverse(result);

        return result;
    }

    private static int findDigitValue(BigInteger prefix, BigInteger value) {
        int i = 0;

        while (getNumberFromPrefix(i, prefix).multiply(new BigInteger(Integer.toString(i))).compareTo(value) <= 0)
            i++;

        return --i;
    }

    private static BigInteger getValueForDigit(BigInteger prefix, int k) {
        return getNumberFromPrefix(k, prefix).multiply(new BigInteger(Integer.toString(k)));
    }

    private static BigInteger getNumberFromPrefix(int postfix, BigInteger prefix) {
        return new BigInteger(prefix.toString() + Integer.toString(postfix));
    }

    private static BigInteger dubleToBigInteger(Pair<Integer, Integer> input) {
        return new BigInteger(Integer.toString(input.getKey() * 10)).add(new BigInteger(input.getValue().toString()));
    }

}
