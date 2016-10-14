package eulerproject.tools.primes;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Lukasz on 2016-08-30.
 */
public class PrimesSet {
    Set<Integer> primeSet;

    public PrimesSet(int max) {
        Primes primes = new Primes(max);
        primeSet = new LinkedHashSet<>();

        for(int i =0;i<max;i++) {
            if (primes.isPrime(i)) {
                primeSet.add(i);
            }
        }
    }

    public boolean isPrime(int k) {
        return primeSet.contains(k);
    }


    public Integer getNextPrime(int k) {
        Iterator<Integer> iter = primeSet.iterator();
        Integer result = null;
        Integer temp = null;

        while(iter.hasNext()) {
            temp = iter.next();
            if (temp > k) {
                result = temp;
                break;
            }
        }

        return result;
    }

    public Set<Integer> getSet() {
        return primeSet;
    }

    public Integer getMax() {
        return primeSet.stream().max((a,b)->a-b).orElse(0);
    }

}
