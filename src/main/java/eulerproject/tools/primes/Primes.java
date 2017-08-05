package eulerproject.tools.primes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lukasz on 2016-08-30.
 */
public class Primes {

    public Primes(int max) {
        max_value = max;
        primes = new boolean[max_value];
        init();
    }

    private int max_value;
    private boolean[] primes;

    public void init() {
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i < max_value; i++)
            primes[i] = true;

        for (int i = 2; i <= max_value / 2; i++) {
            for (int j = i + i; j < max_value; j += i) {
                primes[j] = false;
            }
        }
    }

    public boolean isPrime(int k) {
        if (k < max_value)
            return primes[k];
        else
            throw new IllegalArgumentException("Value too big " + k + " to be checked. Initiate instance with bigger max value.");
    }

    public int getNextPrime(int k) {
        for (int i = k + 1; i < max_value; i++) {
            if (primes[i] == true)
                return i;
        }

        return 0;
    }

    public int[] toArray() {
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i < primes.length; i++)
            if (primes[i])
                list.add(i);

        return list.stream().mapToInt(s -> s).toArray();
    }

    public boolean isPrimeValueBig(long k) {

        for (long i = 2; i*i <= k; i++)
            if (k % i == 0)
                return false;

        return true;


    }

}
