package eulerproject.tools.generators;

import eulerproject.tools.permutation.Listener;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ListenedBoundedCompositions extends BoundedCompositions {

    Listener<Integer> listener;
    Predicate<List<Integer>> predicate;
    boolean recursionCutoff = false;

    public ListenedBoundedCompositions(int n, int k, int a, int b, Listener<Integer> listener, Predicate<List<Integer>> predicate) {
        super(n,k,a,b);
        this.listener = listener;
        this.predicate = predicate;
    }


    /**
     * This method needs rethinking and implementation that will result in returning first result.
     *
     * @param n
     * @param r
     * @param b
     * @param c
     * @param min
     * @param X
     * @return
     */
    protected List<List<Integer>> generateColex(int n, int r, int b, int[] c, int[] min, List<List<Integer>> X) {

        if (!recursionCutoff) {

            if (n == 0) {
                List<Integer> newList = convertResultList(Arrays.stream(c).boxed().collect(Collectors.toList()));

                //here is the possible condition to be added and cut the recursion.
                if(predicate.test(newList)) {
                    listener.activate(newList);
                    recursionCutoff = true; //end recursion
                }
                
                X.add(newList);
            } else {

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
                    generateColex(n - e, i, b, c, min, X);
                    c[i] -= e;
                }

            }
        }
        return X;

    }

}
