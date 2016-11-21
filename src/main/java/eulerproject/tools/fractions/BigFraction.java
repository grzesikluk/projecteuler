package eulerproject.tools.fractions;

import eulerproject.tools.functions.EulersTotient;
import eulerproject.tools.primes.Primes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Created by grzesikl on 15/09/2016.
 */
public class BigFraction implements Comparable {

    static final Primes primes;
    private static final int MAX = 10000000;

    static {
        primes = new Primes(10000000);
        primes.generatePrimes();
    }


    public BigFraction(BigInteger nominator, BigInteger denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }

    public BigFraction(BigFraction a) {
        this.nominator = new BigInteger(a.getNominator().toString());
        this.denominator = new BigInteger(a.getDenominator().toString());
    }

    public BigInteger getNominator() {
        return nominator;
    }

    public void setNominator(BigInteger nominator) {
        this.nominator = nominator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public void setDenominator(BigInteger denominator) {
        this.denominator = denominator;
    }

    private BigInteger nominator;
    private BigInteger denominator;

    @Override
    public String toString() {
        return "[" + nominator.toString() + "/" + denominator.toString() + "]";
    }

    public BigFraction add(BigFraction oth) {
        BigFraction result;

        if (!isCommonDenominator(oth)) {
            BigInteger denominator = getDenominator().multiply(oth.getDenominator());
            BigInteger nominator = getNominator().multiply(oth.getDenominator()).add(oth.getNominator().multiply(getDenominator()));

            result = new BigFraction(nominator, denominator);

        } else {
            result = new BigFraction(getNominator().add(oth.getNominator()), getDenominator());
        }

        return result;

    }

    ;


    public BigFraction sub(BigFraction oth) {
        BigFraction othRev = new BigFraction(oth.getNominator().negate(), oth.getDenominator());
        return this.add(othRev);

    }

    ;

    public boolean isCommonDenominator(BigFraction oth) {
        return oth.getDenominator() == getDenominator();
    }

    public BigFraction simplifyFraction() {
        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;
        BigFraction result = new BigFraction(this);
        BigInteger bigI = new BigInteger("2");
        int i = 2;

        while (i > 0 && bigI.compareTo(result.getDenominator()) <= 0 && bigI.compareTo(result.getNominator()) <= 0) {
            bigI = new BigInteger(new Integer(i).toString());

            try {
                if (result.getNominator().mod(bigI).equals(zero) && result.getDenominator().mod(bigI).equals(zero)) {
                    result = new BigFraction(result.getNominator().divide(bigI), result.getDenominator().divide(bigI));
                } else {
                    i = primes.getNextPrime(i);
                }
            } catch (Exception e) {
                System.out.println(i);
                System.out.println(result);
//                return result;
            }
        }

        return result;
    }

    public boolean isResilent() {
        BigInteger zero = BigInteger.ZERO;
        BigFraction result = new BigFraction(this);
        BigInteger bigI = new BigInteger("2");
        int i = 2;
        int nom = result.getNominator().intValue();
        int den = result.getDenominator().intValue();

        while ((i > 0) && (i <= nom ) && (i <= den )) {
            try {
                if (result.getNominator().mod(bigI).equals(zero) && result.getDenominator().mod(bigI).equals(zero)) {
                    return false;
                } else {
                    i = primes.getNextPrime(i);
                }
            } catch (Exception e) {
                System.out.println(i);
                System.out.println(result);
            }
            bigI = new BigInteger(new Integer(i).toString());
        }

        return true;
    }


    public BigFraction revertFraction() {
        return new BigFraction(getDenominator(), getNominator());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BigFraction fraction = (BigFraction) o;

        if (nominator.compareTo(fraction.nominator) != 0) return false;
        return denominator.compareTo(fraction.denominator) == 0;

    }


    public BigFraction getResilenceFactor(int[] primes) {

        BigInteger i = BigInteger.ONE;

        long den = this.denominator.intValue();
        int phi = EulersTotient.eulersTotientFunction((int)den,primes);  //TODO: I dont like this casting

        BigInteger d = denominator.subtract(i);
        BigInteger counter = new BigInteger(Integer.toString(phi));



        return new BigFraction(counter, d).simplifyFraction();

    }

    @Override
    public int compareTo(Object o) {
        return this.simplifyFraction().sub((BigFraction) o).getNominator().intValue();
    }


    public BigDecimal asDecimal() {
        BigDecimal bigNomin = new BigDecimal(nominator);
        BigDecimal bigDenomin = new BigDecimal(denominator);

        if(bigDenomin.equals(new BigDecimal("0")))
            throw new IllegalArgumentException("Denominator is zero.");

        return bigNomin.divide(bigDenomin,30, RoundingMode.HALF_UP);



    }
}


