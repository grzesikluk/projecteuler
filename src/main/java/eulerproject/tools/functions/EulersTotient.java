package eulerproject.tools.functions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lukasz on 2016-11-12.
 */
public class EulersTotient {

    public static int eulersTotientFunction(int k) {
        int counter = 1;
        Set<Integer> notPrimes = new HashSet();

        for (int i = 2; i < k; i++) {
            if (!notPrimes.contains(new Integer(i)) && k % i != 0)
                counter++;
            else {
                for (int j = 1; j * i < k; j++)
                    notPrimes.add(new Integer(i * j));

            }
        }
        return counter;
    }

}
