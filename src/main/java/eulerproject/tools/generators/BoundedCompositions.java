package eulerproject.tools.generators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2017-06-10.
 */
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


    public void generateColex(int r) {

        if (k == 0) {
            List<Integer> newList = Arrays.stream(c).boxed().collect(Collectors.toList());
            result.add(newList);
        } else {
            if (c[r] == b[r])
                r--;


        }


    }


}
