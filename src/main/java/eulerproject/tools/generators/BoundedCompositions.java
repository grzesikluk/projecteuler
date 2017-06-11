package eulerproject.tools.generators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class BoundedCompositions {

    private int n, k;
    private int[] c;
    private int[] b;

    private List<List<Integer>> result;


    public BoundedCompositions(int n, int k) {
        this.n = n;
        this.k = k;

        result = new ArrayList<>();

        c = new int[k];
        b = new int[k];

        for (int i = 0; i < k; i++) {
            c[i] = 0;
            b[i] = 0;
        }
    }

    /**
     * Generate all integer compositions of n with k parts each between a and b.
     *
     * @param n - integer to which we need to calculate compositions
     * @param k - number of parts
     * @param a - minimum value
     * @param b - maximum value
     * @return - List of compositions.
     */
    public List<List<Integer>> generate(int n, int k, int a, int b) {
        List<List<Integer>> resultList = new ArrayList<>();

        //sanity check
        if (k * a > n || k * b < n || n < 0 || k < 0)
            throw new IllegalArgumentException("Wrong argument passed to function.");

        int[] minimum = generateMin(n - k * a, k, b - a);

        if (minimum != null) {

            resultList = generateColex(n - k * a, k, k, b - a, c, minimum, new ArrayList<>());
            //todo implement X = X+a;

        }

        return resultList;
    }


    public List<List<Integer>> generateColex(int n, int r, int k, int b, int[] c, int[] min, List<List<Integer>> X) {

        if (n == 0) {
            List<Integer> newList = Arrays.stream(c).boxed().collect(Collectors.toList());
            X.add(newList);
        } else {
            //todo implement

            if (c[r] == b) {
                r--;
            }
            int l = min[n];

            for (int i = l; i <= r; i++) {
                int e = 0;

                if (i == l)
                    e = n - (l - 1) * b;
                else
                    e = 1;

                c[i] += e;
                X = generateColex(n - e, i, k, b, c, min, X);
                c[i] -= e;
            }

        }
        return X;

    }

    public int findValue(int n, int k, int b) {

        //TODO: refactor this
        for (int s = 1; s <= k; s++) {
            if (s * b >= n)
                return s;
        }

        return -1;
    }

    public int[] generateMin(int n, int k, int b) {

        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++)
            result[i] = 0;

        for (int i = 1; i <= n; i++) {
            int q = findValue(i, k, b);

            if (q == -1)
                return null;

            result[i] = q;

        }
        return result;

    }


}
