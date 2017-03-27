package eulerproject.level3.problem75;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lukasz on 2017-03-23.
 */
public class Solution {
    private static final int MAX_LEN = 1_500_000;

    public static void main(String[] args) {


    }

    public static boolean checkIfIsPythLengh(long length) {
        // l = 2*k*m*(m+n)
        Set<PythagoreanTriple> tripleList = new HashSet<>();

        long k = 1;

        while ((length % (2 * k)) == 0) {

            for (long n = 1; n <= (length / (2 * k)); n++)

                for (long m = n + 1; length >= (2 * k * m * (m + n)); m++) {
                    PythagoreanTriple triple = new PythagoreanTriple(m, n).getNext(k);

                    if (length == triple.length()) {
                        tripleList.add(triple);

                        if (tripleList.size() > 1)
                            return false;
                    }
                }
            k++;

        }

        if (tripleList.size() == 1)
            return true;
        else
            return false;

    }

    public static boolean checkIfIsPythLengh_new(long length) {
        // l = 2*k*m*(m+n)
        Set<PythagoreanTriple> tripleList = new HashSet<>();

        long k = 1;

        while ((length % (2 * k)) == 0) {

            for (long n = 1; n <= (length / (2 * k)); n++) {
                long m = 0;
                double m1 = ((double) -n + Math.sqrt(n * n + 2 * length / k)) / 2;

                if ((Math.floor(m1) == m1) && !Double.isInfinite(m1))
                    m = (long) m1;

                if (m > n) {
                    PythagoreanTriple triple = new PythagoreanTriple((long) m, n).getNext(k);

                    if (length == triple.length()) {
                        tripleList.add(triple);

                        if (tripleList.size() > 1)
                            return false;
                    }
                }

            }
            k++;

        }

        if (tripleList.size() == 1)
            return true;
        else
            return false;

    }

    public static long countNumberOfUniqPythLength(long maxLength) {
        long count = 0;
        for (long i = 1; i <= maxLength; i++) {
            if (checkIfIsPythLengh_new(i))
                count++;
        }

        return count;
    }

}
