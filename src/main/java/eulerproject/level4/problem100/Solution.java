package eulerproject.level4.problem100;


import eulerproject.tools.sequences.SequenceGeneratorImplA046090;

import java.math.BigInteger;

public class Solution {

    private static final BigInteger MAX = new BigInteger("1000000000000");

    public static void main(String[] args) {
        SequenceGeneratorImplA046090 sequence = new SequenceGeneratorImplA046090();
        BigInteger value = sequence.getNext();

        while (value.compareTo(MAX) < 0)
            value = sequence.getNext();

        System.out.println(getBlueDiscNumber(value));
    }

    public static BigInteger getBlueDiscNumber(final BigInteger numberOfDiscs) {
        BigInteger NminusOne = new BigInteger(numberOfDiscs.toString()).subtract(BigInteger.ONE);
        BigInteger sqrtVal = new BigInteger("8").multiply(numberOfDiscs).multiply(NminusOne).add(new BigInteger("4"));

        sqrtVal = sqrt(sqrtVal);

        if (sqrtVal.equals(BigInteger.ZERO))
            return BigInteger.ZERO;
        else
            return sqrtVal.add(new BigInteger("2")).divide(new BigInteger("4"));

    }


    public static BigInteger sqrt(final BigInteger number) {
        BigInteger hi = new BigInteger(number.toString());
        BigInteger lo = BigInteger.ZERO;
        BigInteger mid = hi.add(lo).divide(BigInteger.valueOf(2));
        BigInteger mid2 = mid.multiply(mid);

        while (lo.compareTo(hi.subtract(BigInteger.ONE)) < 0 && !mid2.equals(number)) {
            if (mid2.compareTo(number) < 0)
                lo = mid;
            else
                hi = mid;
            mid = hi.add(lo).divide(BigInteger.valueOf(2));
            mid2 = mid.multiply(mid);
        }

        if (mid.multiply(mid).equals(number))
            return mid;
        else
            return BigInteger.ZERO;
    }

}
