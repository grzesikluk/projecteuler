package eulerproject.tools.sequences;

import java.math.BigInteger;

public class SequenceGeneratorImplA046090 implements SequenceGeneratorIterative {
    /*
    * a(n) = 6*a(n-1)-a(n-2)-2, n >= 2, a(0) = 1, a(1) = 4
    * */

    BigInteger val_prev1;
    BigInteger val_prev2;
    BigInteger n;
    private final static BigInteger six = BigInteger.valueOf(6);
    private final static BigInteger two = BigInteger.valueOf(2);

    public SequenceGeneratorImplA046090() {
        val_prev2 = BigInteger.ONE;
        val_prev1 = BigInteger.valueOf(4);
        n = BigInteger.ZERO;
    }

    public BigInteger getNext() {
        BigInteger result;

        if (n.equals(BigInteger.ZERO))
            result = val_prev2;
        else if (n.equals(BigInteger.ONE))
            result = val_prev1;
        else {
            result = val_prev1.multiply(six).subtract(val_prev2).subtract(two);

            val_prev2 = val_prev1;
            val_prev1 = result;
            n = n.add(BigInteger.ONE);
            return result;
        }

        n = n.add(BigInteger.ONE);

        return result;
    }

}
