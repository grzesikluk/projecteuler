package eulerproject.tools.functions;

import java.util.List;

/**
 * Created by Lukasz on 2016-11-12.
 */
public class EulersTotient {

    public static int eulersTotientFunction(int k) {
        int counter = 1;
        boolean[] tab = new boolean[k];

        for (int i = 0; i < tab.length; i++)
            tab[i] = true;

        for (int i = 2; i < k; i++) {
            if (tab[i] == true && k % i != 0)
                counter++;
            else {
                for (int j = 1; j * i < k; j++)
                    tab[i * j] = false;

            }
        }
        return counter;
    }

    /**
     * Fast solution based on following
     * @param k
     * @param primes
     * @return
     */
    public static  int eulersTotientFunction(int k, List<Integer> primes) {
        double result = k;
        int i=0;

        do {
            if(k%primes.get(i)==0)
                result*=(1-1/(double)primes.get(i));
            i++;
        }
        while(i< primes.size() && primes.get(i)<= k);

        return (int)result;

    }


}
