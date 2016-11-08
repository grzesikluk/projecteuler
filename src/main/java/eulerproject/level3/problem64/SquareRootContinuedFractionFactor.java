package eulerproject.level3.problem64;

/**
 * Created by grzesikl on 08/11/2016.
 * <p>
 * The factor is An = An-1, 1/(sqrt(square)-denomNumber))
 */
public class SquareRootContinuedFractionFactor {

    private int factor;

    public SquareRootContinuedFractionFactor(int prevFactor, int square, int nominator, int denomNumber) {
        this.factor = prevFactor;
        this.square = square;
        this.nominator = nominator;
        this.denomNumber = denomNumber;
    }

    private int square;
    private int nominator;
    private int denomNumber;

    public int getDenomNumber() {
        return denomNumber;
    }

    public void setDenomNumber(int denomNumber) {
        this.denomNumber = denomNumber;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getNominator() {
        return nominator;
    }

    public void setNominator(int nominator) {
        this.nominator = nominator;
    }


    public SquareRootContinuedFractionFactor getNextFractionFactor() {
        int nominatorCalculated = this.square - this.factor * this.factor;
        int denominatorNotNormalised = factor - square + factor*factor;
        int denominatorCalculated = denominatorNotNormalised%nominatorCalculated;
        int factorCorrection = denominatorCalculated/nominatorCalculated;

        return new SquareRootContinuedFractionFactor(1+factorCorrection,square,nominatorCalculated,denominatorCalculated);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SquareRootContinuedFractionFactor that = (SquareRootContinuedFractionFactor) o;

        if (factor != that.factor) return false;
        if (square != that.square) return false;
        if (nominator != that.nominator) return false;
        return denomNumber == that.denomNumber;

    }

    @Override
    public int hashCode() {
        int result = factor;
        result = 31 * result + square;
        result = 31 * result + nominator;
        result = 31 * result + denomNumber;
        return result;
    }

    @Override
    public String toString() {
        return "S: " + square + " F: " + factor + " N: " + nominator + " D: " + denomNumber;
    }
}
