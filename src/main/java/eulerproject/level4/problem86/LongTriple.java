package eulerproject.level4.problem86;

import java.util.Arrays;

public class LongTriple {
    public long getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public long getC() {
        return c;
    }

    long a, b, c;

    public LongTriple(long a, long b, long c) {
        long[] sortArray = new long[3];

        sortArray[0] = a;
        sortArray[1] = b;
        sortArray[2] = c;

        Arrays.sort(sortArray);

        this.a = sortArray[0];
        this.b = sortArray[1];
        this.c = sortArray[2];

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LongTriple that = (LongTriple) o;

        if (a != that.a) return false;
        if (b != that.b) return false;
        return c == that.c;
    }

    @Override
    public int hashCode() {
        int result = (int) (a ^ (a >>> 32));
        result = 31 * result + (int) (b ^ (b >>> 32));
        result = 31 * result + (int) (c ^ (c >>> 32));
        return result;
    }


    @Override
    public String toString() {
        return "a=" + a + " b=" + b + " c=" + c + "\n";
    }
}
