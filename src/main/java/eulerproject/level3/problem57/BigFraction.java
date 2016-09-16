package eulerproject.level3.problem57;

import java.math.BigInteger;

/**
 * Created by grzesikl on 15/09/2016.
 */
public class BigFraction {
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
        return "["+nominator.toString()+"/"+denominator.toString()+"]";
    }

    public BigFraction add(BigFraction oth) {
        BigFraction result;

        if(!isCommonDenominator(oth)) {
            BigInteger denominator = getDenominator().multiply(oth.getDenominator());
            BigInteger nominator = getNominator().multiply(oth.getDenominator()).add(oth.getNominator().multiply(getDenominator()));

            result = new BigFraction(nominator,denominator);

        }
        else {
            result = new BigFraction(getNominator().add(oth.getNominator()),getDenominator());
        }

        return result;

    };

    public boolean isCommonDenominator(BigFraction oth) {
        return oth.getDenominator() == getDenominator();
    }

    public BigFraction simplifyFraction() {
        BigInteger i = new BigInteger(getDenominator().toString()).divide(new BigInteger("2"));
        BigInteger zero = new BigInteger("0");
        BigInteger one  = new BigInteger("1");
        BigFraction result = new BigFraction(this);

        while(i.compareTo(zero)>0)  {
            BigInteger bigI = new BigInteger(i.toString());

            if(result.getNominator().mod(bigI).equals(zero) && result.getDenominator().mod(bigI).equals(zero)) {
                result = new BigFraction(result.getNominator().divide(bigI),result.getDenominator().divide(bigI));
            }

            i = i.subtract(one);
        }

        return result;
    }

    public BigFraction revertFraction() {
        return new BigFraction(getDenominator(),getNominator());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BigFraction fraction = (BigFraction) o;

        if (nominator.compareTo(fraction.nominator) !=0) return false;
        return denominator.compareTo(fraction.denominator) == 0;

    }


}
