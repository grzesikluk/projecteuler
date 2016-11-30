package eulerproject.level3.problem60;

/**
 * Created by grzesikl on 30/11/2016.
 */
public class Pair {
    private int a;

    @Override
    public String toString() {
        return "Pair{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getConcatenatedFirstSecond() {
        return new Integer(Integer.toString(getA()) + Integer.toString(getB()));
    }

    public int getConcatenatedSecondFirst() {
        return new Integer(Integer.toString(getB()) + Integer.toString(getA()));
    }

    public int[] getConcatenatedOfTwoPairs(Pair other) {
        int[] result = new int[4];

        result[0] = new Integer(Integer.toString(getA()) + Integer.toString(other.getA()));
        result[1] = new Integer(Integer.toString(getB()) + Integer.toString(other.getB()));
        result[2] = new Integer(Integer.toString(getA()) + Integer.toString(other.getB()));
        result[3] = new Integer(Integer.toString(getB()) + Integer.toString(other.getA()));

        return result;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (a != pair.a) return false;
        return b == pair.b;

    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        return result;
    }

    public boolean isOneDigitSame(Pair other) {
        return other.getA() == getA() || other.getA() == getB() || other.getB() == getA() || other.getB() == getB();
    }
}
