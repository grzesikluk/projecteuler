package eulerproject.tools.generators;

import java.util.*;
import java.util.stream.Collectors;


public class BoundedCompositions {

    /**
     * Generate all integer compositions of n with k parts each between a and b.
     *
     * @param n - integer to which we need to calculate compositions
     * @param k - number of parts
     * @param a - minimum value
     * @param b - maximum value
     * @return - List of compositions.
     */
    public Set<List<Integer>> generate(int n, int k, int a, int b) {
        List<List<Integer>> resultList ;

        //sanity check
        if (k * a > n || k * b < n || n < 0 || k < 0)
            throw new IllegalArgumentException("Wrong argument passed to function.");

        int[] minimum = generateMin(n - k * a, k, b - a);

        int[] c = new int[k + 1];

        for (int i = 0; i <= k; i++)
            c[i] = 0;

        if (minimum != null) {

            resultList = generateColex(n - k * a, k, b - a, c, minimum, new ArrayList<>());

            Set<List<Integer>> updatedResult = new HashSet<>();

            for (List<Integer> inputList : resultList) {

                inputList.remove(0);
                List<Integer> updatedList = inputList.stream().map(s -> s + a).sorted().collect(Collectors.toList());
                updatedResult.add(updatedList);

            }
            return updatedResult;


        }

        return null;
    }


    private List<List<Integer>> generateColex(int n, int r, int b, int[] c, int[] min, List<List<Integer>> X) {

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
                X = generateColex(n - e, i, b, c, min, X);
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
