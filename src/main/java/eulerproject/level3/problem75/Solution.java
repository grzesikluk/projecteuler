package eulerproject.level3.problem75;

import java.util.*;

/**
 * Created by Lukasz on 2017-03-23.
 */
public class Solution {
    private static final int MAX_LEN = 1_500_000;

    public static void main(String[] args) {
        System.out.println(getNumberOfEuclides(MAX_LEN,1));
    }

    public static int getNumberOfEuclides(int max, int number) {

        Map<Long,Set<PythagoreanTriple>> tabOfCounts = new HashMap<>();


        for (long n = 1; n <= max; n++) {
            for (long m = n + 1; 2 * m * n + 2 * m * m <= max; m++) {

                PythagoreanTriple triple = new PythagoreanTriple(m, n);

                int k = 1;
                PythagoreanTriple next = triple.getNext(k);

                while (next.length() > 0 && next.length() <= max ) {

                    if(!tabOfCounts.containsValue(next.length())) {
                        tabOfCounts.put(next.length(),new HashSet<>(Arrays.asList(next)));
                    }
                    else {
                        tabOfCounts.get(next.length()).add(next);
                    }

                    ++k;
                    next = triple.getNext(k);
                }

            }
        }

        int counter = 0;

        for(Set sets:tabOfCounts.values()) {
            if(sets.size() == number)
                counter++;

        }
        return counter;
    }

}
