package eulerproject.tools.primes;

/**
 * Created by Lukasz on 2016-08-30.
 */
public class Primes {

    public Primes(int max) {
        max_value = max;
        primes = new boolean[max_value];
        generatePrimes();
    }

    private  int max_value;
    private  boolean[] primes;

    public void generatePrimes() {
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < max_value; i++)
            primes[i] = true;

        for (int i = 2; i < max_value / 2; i++) {
            for (int j = i + i; j < max_value; j += i) {
                primes[j] = false;
            }
        }


    }

    public boolean isPrime(int k) {
        return primes[k];
    }


    public int getNextPrime(int k) {
        for(int i=k+1;i<max_value;i++) {
            if(primes[i] == true)
                return i;
        }

        return 0;
    }


}
