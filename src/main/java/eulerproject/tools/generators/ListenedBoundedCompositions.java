package eulerproject.tools.generators;

import eulerproject.tools.combinatorics.Listener;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ListenedBoundedCompositions extends BoundedCompositions {

    Listener<Integer> listener;
    Predicate<List<Integer>> predicate;
    boolean recursionCutoff = false;
    List<List<Integer>> resultList;

    public ListenedBoundedCompositions(int n, int k, int a, int b, Listener<Integer> listener, Predicate<List<Integer>> predicate) {
        super(n,k,a,b);
        this.listener = listener;
        this.predicate = predicate;
        resultList = new ArrayList<>();
    }

    protected List<List<Integer>> generateColex(int n, int r, int b, int[] c, int[] min, List<List<Integer>> X) {

        if (!recursionCutoff) {

            if (n == 0) {
                List<Integer> newList = convertResultList(Arrays.stream(c).boxed().collect(Collectors.toList()));

                //here is the possible condition to be added and cut the recursion.
                if(predicate.test(newList)) {
                    listener.activate(newList);
                    recursionCutoff = true; //end recursion
                    resultList.add(newList);
                }
                
                X.add(newList);
                
            } else {

                if (c[r] == b) {
                    r--;
                }
                int l = min[n];

                for (int i = l; i <= r; i++) {
                    int e;

                    if (i == l)
                        e = n - (l - 1) * b;
                    else
                        e = 1;

                    c[i] += e;
                    generateColex(n - e, i, b, c, min, X);
                    c[i] -= e;
                }

            }
            return resultList;
        }
        else {
            return resultList;
        }

    }


    /**
     * todo: make recursive generation for this so that having solution for k-1 we can easy generate solution for k.
     * @return
     */
    public Set<List<Integer>> generate() {
        List<List<Integer>> resultList;

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

            for (List<Integer> inputList : resultList)
                updatedResult.add(inputList);

            return updatedResult;
        }
        return null;
    }

}
