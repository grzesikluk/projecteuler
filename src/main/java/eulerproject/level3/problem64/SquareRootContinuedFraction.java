package eulerproject.level3.problem64;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grzesikl on 08/11/2016.
 * <p>
 * The factor is An = An-1, 1/(sqrt(square)-denomNumber))
 * <p>
 * https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Continued_fraction_expansion
 */
public class SquareRootContinuedFraction {

    private int m;
    private int S;
    private int d;

    public int getA() {
        return a;
    }

    private int a;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SquareRootContinuedFraction that = (SquareRootContinuedFraction) o;

        if (m != that.m) return false;
        if (S != that.S) return false;
        if (d != that.d) return false;
        return a == that.a;

    }

    @Override
    public int hashCode() {
        int result = m;
        result = 31 * result + S;
        result = 31 * result + d;
        result = 31 * result + a;
        return result;
    }

    public SquareRootContinuedFraction(int m, int S, int d, int a) {
        this.m = m;
        this.a = a;

        this.d = d;
        this.S = S;
    }

    public SquareRootContinuedFraction(int S) {
        this.m = 0;
        this.S = S;
        this.a = (int)Math.floor(Math.sqrt(S));
        this.d = 1;

    }

    @Override
    public String toString() {
        return "SquareRootContinuedFraction{" +
                "m=" + m +
                ", S=" + S +
                ", d=" + d +
                ", a=" + a +
                '}';
    }

    public SquareRootContinuedFraction getNextFractionFactor() {
        int nextM = d * a - m;
        int nextD = (S - nextM * nextM) / d;
        int floorS = (int) Math.floor(Math.sqrt(S));
        int nextA = (int) Math.floor((floorS + nextM) / nextD);

        return new SquareRootContinuedFraction(nextM, S, nextD, nextA);
    }


    public List<Integer> getFactors(int limit) {
        int l = limit-1;
        int s = (int) Math.floor(Math.sqrt(S));
        List<Integer> result = new ArrayList<>();
        SquareRootContinuedFraction sFactor = new SquareRootContinuedFraction(0, S, 1, s);

        result.add(s);

        while (l > 0) {
            sFactor = sFactor.getNextFractionFactor();
            result.add(sFactor.getA());

            l--;
        }

        return result;
    }

}
