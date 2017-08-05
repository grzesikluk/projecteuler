package eulerproject.level11.problem243;

import eulerproject.tools.fractions.BigFraction;
import eulerproject.tools.primes.Primes;

import java.math.BigInteger;

/**
 * Created by grzesikl on 10/11/2016.
 */
public class Solution {
    private static final int MAX = 10000000;
    private static Primes primes;

    static {
        primes = new Primes(MAX);
        primes.init();
    }

    public static void main(String[] args) {

        BigInteger i;
        BigFraction fraction;
        BigFraction factor;

        BigFraction thr = new BigFraction(new BigInteger("15499"), new BigInteger("94744")); //0,16358819555855779785527315713924
        int[] primesList = primes.toArray();
        DenominatorGeneratorBig generatorBig = new DenominatorGeneratorBig();


        while ((i = generatorBig.getNext()).compareTo(BigInteger.ZERO) > 0) {

            fraction = new BigFraction(BigInteger.ONE, i);
            factor = fraction.getResilenceFactor(primesList);

            if (factor.asDecimal().compareTo(thr.asDecimal()) <= 0) {
                System.out.println("Found : " + fraction + " " + factor.asDecimal());
                break;
            }
        }

    }

}
