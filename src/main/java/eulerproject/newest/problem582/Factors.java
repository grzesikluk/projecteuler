package eulerproject.newest.problem582;

/**
 * Created by Lukasz on 2016-12-24.
 */
public class Factors {

    private double a_b, a_c, b_c;

    public Factors(Double ab, Double ac, Double bc) {
        a_b = ab;
        a_c = ac;
        b_c = bc;
    }

    public Factors(Long a, Long b, Long c) {
        a_b = (double)a/b;
        a_c = (double)a/c;
        b_c = (double)b/c;
    }


    public double[] getSides(int a) {
        double[] result = new double[3];

        result[0] = a;
        result[1] = a * 1 / a_b;
        result[2] = a * 1 / a_c;

        return result;
    }


    public boolean isProper(int a) {
        double[] sides = getSides(a);

        return (sides[0] % 1 == 0) && (sides[1] % 1 == 0) && (sides[2] % 1 == 0) && (sides[1]-sides[0])<=100;


    }

    @Override
    public String toString() {
        return "[a/b="+a_b+" a/c="+a_c+" b/c=" + b_c+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factors factors = (Factors) o;

        if (Double.compare(factors.a_b, a_b) != 0) return false;
        if (Double.compare(factors.a_c, a_c) != 0) return false;
        return Double.compare(factors.b_c, b_c) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(a_b);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(a_c);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b_c);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
