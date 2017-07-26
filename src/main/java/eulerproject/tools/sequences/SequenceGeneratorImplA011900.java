package eulerproject.tools.sequences;

import java.math.BigInteger;

public class SequenceGeneratorImplA011900 implements SequenceGeneratorIterative {
    /* a(n) = 6*a(n-1) - a(n-2) - 2 with a(0) = 1, a(1) = 3.*/

    BigInteger n;
    BigInteger val_prev2;
    BigInteger val_prev1;

    public SequenceGeneratorImplA011900() {
        n = BigInteger.ZERO;
        val_prev2 = BigInteger.ONE;
        val_prev1 = BigInteger.valueOf(3);
    }

    public BigInteger getNext() {

        if (n.equals(BigInteger.ZERO)) {
            n = n.add(BigInteger.ONE);
            return val_prev2;
        } else if (n.equals(BigInteger.ONE)) {
            n = n.add(BigInteger.ONE);
            return val_prev1;
        } else {

            BigInteger result = BigInteger.valueOf(6).multiply(val_prev1).subtract(val_prev2).subtract(BigInteger.valueOf(2));
            val_prev2 = val_prev1;
            val_prev1 = result;
            return result;
        }
    }

}
