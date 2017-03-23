package eulerproject.level3.problem75;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lukasz on 2017-03-23.
 */
public class Solution {
    private static final int MAX_LEN = 1_500_000;

    public static void main(String[] args) {

        Set<PythagoreanTriple>[] tabOfCounts = new HashSet[MAX_LEN];

        for (int n = 1; n < MAX_LEN; n++) {
            for (int m = n + 1; 2 * m * n + 2 * m * m < MAX_LEN; m++) {

                PythagoreanTriple triple = new PythagoreanTriple(m, n);

                int k = 1;
                PythagoreanTriple next = triple.getNext(k);

                while (next.length() > 0 && next.length() < MAX_LEN) {

                    if (tabOfCounts[next.length()] == null)
                        tabOfCounts[next.length()] = new HashSet<>();

                    tabOfCounts[next.length()].add(next);

                    ++k;
                    next = triple.getNext(k);

                }

            }
        }

        int counter = 0;
        for (int i = 1; i < tabOfCounts.length; i++) {
            if (tabOfCounts[i] != null && tabOfCounts[i].size() == 1) {
                counter++;
            }
        }

        System.out.println(counter);

    }

}
