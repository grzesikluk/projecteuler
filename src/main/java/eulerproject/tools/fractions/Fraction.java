package eulerproject.tools.fractions;
/**
 * Created by grzesikl on 15/09/2016.
 */
public class Fraction {

    public Fraction(long nominator, long denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }

    public Fraction(Fraction a){
        this.nominator = a.getNominator();
        this.denominator = a.getDenominator();
    }

    public long getNominator() {
        return nominator;
    }

    public void setNominator(long nominator) {
        this.nominator = nominator;
    }

    public long getDenominator() {
        return denominator;
    }

    public void setDenominator(long denominator) {
        this.denominator = denominator;
    }

    private long nominator;
    private long denominator;

    @Override
    public String toString() {
        return "["+nominator+"/"+denominator+"]";
    }

    public Fraction add(Fraction oth) {
        Fraction result;

        if(!isCommonDenominator(oth)) {
            long denominator = getDenominator()*oth.getDenominator();
            long nominator = getNominator()*oth.getDenominator()+oth.getNominator()*getDenominator();

            result = new Fraction(nominator,denominator);

        }
        else {
            result = new Fraction(getNominator()+oth.getNominator(),getDenominator());
        }

        return result;

    };

    public boolean isCommonDenominator(Fraction oth) {
        return oth.getDenominator() == getDenominator();
    }

    public Fraction simplifyFraction() {
        Fraction result = new Fraction(this);
        int i = 2;

        while(i>0 && i<=result.getDenominator() && i<=result.getDenominator()) {

            if(result.getNominator()%i == 0&& result.getDenominator()%i == 0) {
                result = new Fraction(result.getNominator()/i,result.getDenominator()/i);
            }
            else {
                i = primes.getNextPrime(i);
            }
        }

        return result;
    }

    public Fraction revertFraction() {
        return new Fraction(getDenominator(),getNominator());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (nominator != fraction.nominator) return false;
        return denominator == fraction.denominator;

    }


}
