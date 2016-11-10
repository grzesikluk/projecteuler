package eulerproject.level11.problem243;

import eulerproject.tools.fractions.BigFraction;

import java.math.BigInteger;

/**
 * Created by grzesikl on 10/11/2016.
 */
public class Solution {

    public static void main(String[] args) {
        BigInteger jump = new BigInteger("1");
        BigInteger i = new BigInteger("2");
//        BigFraction thr = new BigFraction(new BigInteger("15499"), new BigInteger("94744"));
        BigFraction thr = new BigFraction(new BigInteger("4"), new BigInteger("11"));

        BigFraction fraction;
        BigFraction factor;

        do {
            if(i.isProbablePrime(1)) {
                i=i.add(jump);
                continue;
            }
            else {
                fraction = new BigFraction(new BigInteger("1"), i);
                factor = fraction.getResilenceFactor();
                System.out.println(factor + " " + fraction);
                if(factor.compareTo(thr)<=0)
                    break;
                i=i.add(jump);
            }


        } while(true);

        System.out.println(fraction);
    }


}
