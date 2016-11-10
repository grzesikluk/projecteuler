package eulerproject.level11.problem243;

import eulerproject.tools.fractions.BigFraction;
import eulerproject.tools.fractions.Fraction;
import eulerproject.tools.primes.Primes;

import java.math.BigInteger;

/**
 * Created by grzesikl on 10/11/2016.
 */
public class Solution {

    private static Primes primes;

    static {
        primes = new Primes(1000000);
        primes.generatePrimes();
    }

    public static void main(String[] args) {
        getSoluton();

    }

    public static void getSolutionBig() {
        BigInteger jump = new BigInteger("1");
        BigInteger i = new BigInteger("1");
        BigFraction thr = new BigFraction(new BigInteger("15499"), new BigInteger("94744"));

        BigFraction fraction;
        BigFraction factor;

        do {
            if (i.isProbablePrime(1)) {
                i = i.add(jump);
                continue;
            } else {
                fraction = new BigFraction(new BigInteger("1"), i);
                factor = fraction.getResilenceFactor();
                System.out.println(fraction + " " + factor);

                if (factor.compareTo(thr) <= 0)
                    break;
                i = i.add(jump);
            }


        } while (true);

        System.out.println(fraction);
    }

    public static void getSoluton() {
        Fraction thr = new Fraction(15499, 94744);
        Fraction fraction;
        Fraction factor;

        long i = DenominatorGenerator.getNext();

        do {
            fraction = new Fraction(1, i);
            factor = fraction.getResilenceFactor();

            System.out.println(fraction + " " + factor + " " + (factor.asDouble()- thr.asDouble()));

            if (factor.compareTo(thr) <= 0) {
                break;
            }

        } while ((i = DenominatorGenerator.getNext()) > 0);


    }


}
