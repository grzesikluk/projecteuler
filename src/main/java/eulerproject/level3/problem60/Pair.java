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

        int[] result = new int[]{
                new Integer(Integer.toString(getA()) + Integer.toString(other.getA())),
                new Integer(Integer.toString(other.getA()) + Integer.toString(getA())),
                new Integer(Integer.toString(getB()) + Integer.toString(other.getB())),
                new Integer(Integer.toString(other.getB()) + Integer.toString(getB())),
                new Integer(Integer.toString(getA()) + Integer.toString(other.getB())),
                new Integer(Integer.toString(other.getA()) + Integer.toString(getB())),
                new Integer(Integer.toString(getB()) + Integer.toString(other.getA())),
                new Integer(Integer.toString(other.getB()) + Integer.toString(getA()))
        };

        return result;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;
        return (a == pair.a && b == pair.b) || (b == pair.a && a == pair.b);

    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        return result;
    }

}
