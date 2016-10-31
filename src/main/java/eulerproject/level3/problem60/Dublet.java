package eulerproject.level3.problem60;

import java.math.BigInteger;

/**
 * Created by Lukasz on 2016-10-16.
 */

public class Dublet {
    int a;
    int b;

    Dublet(int a, int b) {
        this.b = b;
        this.a = a;
    }

    @Override
    public String toString() {
        return "{"+a + ","+  b +"}";
    }


    public boolean isConcPrime() {
        BigInteger ab = new BigInteger(new Integer(a).toString()+new Integer(b).toString());
        BigInteger ba = new BigInteger(new Integer(b).toString()+new Integer(a).toString());

        return ab.isProbablePrime(1) && ba.isProbablePrime(1);
    }


    public boolean contains(int k) {
        return a == k || b == k;
    }

}