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

    public long getConcatenatedFirstSecond() {
        return new Long(Long.toString(getA()) + Long.toString(getB()));
    }

    public long getConcatenatedSecondFirst() {
        return new Long(Long.toString(getB()) + Long.toString(getA()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair other = (Pair) o;
        return (a == other.a && b == other.b) || (b == other.a && a == other.b);

    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        return result;
    }

}
