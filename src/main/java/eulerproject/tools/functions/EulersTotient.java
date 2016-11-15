package eulerproject.tools.functions;

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
     *
     * @param k
     * @param primes
     * @return
     */
    public static int eulersTotientFunction(int k, int[] primes) {
        double result = k;
        int temp = k;
        int i = 0;
        int p = primes[0];

        while (p*p <= temp) {

            if (temp % primes[i] == 0)        {

                while(temp % p == 0)
                    temp/=p;

                    result *= (1 - 1 / (double) p);

            }
            i++;
            p  = primes[i];
        }

        if (temp > 1)
            result *= (1.0 - (1.0 / (float) temp));

        return (int) result;

    }


}
