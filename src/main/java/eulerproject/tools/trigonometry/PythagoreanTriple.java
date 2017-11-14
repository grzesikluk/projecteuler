package eulerproject.tools.trigonometry;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lukasz on 2017-03-23.
 */
public class PythagoreanTriple {
    public long getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public long getC() {
        return c;
    }

    private long a, b, c;

    public PythagoreanTriple(long a, long b, long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public PythagoreanTriple(long m, long n) {
        long generated_a = m * m - n * n;
        long generated_b = 2 * m * n;
        long generated_c = m * m + n * n;

        if (generated_a <= 0 || generated_b <= 0 || generated_c <= 0)
            throw new IllegalArgumentException("m = " + m + " or n =  " + n + " wrong");

        List<Long> list = Arrays.asList(generated_a, generated_b, generated_c);
        list.sort(Long::compareTo);

        a = list.get(0);
        b = list.get(1);
        c = list.get(2);

    }

    public long length() {
        return a + b + c;
    }

    public PythagoreanTriple getNext(long k) {
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
        int result = (int)a;
        result = 31 * result + (int)b;
        result = 31 * result + (int)c;
        return result;
    }

    @Override
    public String toString() {
        return "a=" + a + " b=" + b + " c=" + c;
    }
}
