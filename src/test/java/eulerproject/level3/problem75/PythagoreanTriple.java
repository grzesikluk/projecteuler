package eulerproject.level3.problem75;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lukasz on 2017-03-23.
 */
public class PythagoreanTriple {
    private int a, b, c;

    public PythagoreanTriple(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public PythagoreanTriple(int m, int n) {
        int generated_a = m * m - n * n;
        int generated_b = 2 * m * n;
        int generated_c = m * m + n * n;

        List<Integer> list = Arrays.asList(generated_a, generated_b, generated_c);
        list.sort(Integer::compareTo);

        a = list.get(0);
        b = list.get(1);
        c = list.get(2);

    }

    public int length() {
        return a + b + c;
    }

    public PythagoreanTriple getNext(int k) {
        return new PythagoreanTriple(a * k, b * k, c * k);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PythagoreanTriple that = (PythagoreanTriple) o;

        if (a != that.a) return false;
        if (b != that.b) return false;
        return c == that.c;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }

    @Override
    public String toString() {
        return "a=" + a + " b=" + b + " c=" + c;
    }
}
