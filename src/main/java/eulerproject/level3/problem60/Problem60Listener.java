package eulerproject.level3.problem60;

import eulerproject.tools.primes.PrimesSet;
import eulerproject.tools.subsets.Listener;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-10-10.
 */
public class Problem60Listener<T> implements Listener<T> {
    PrimesSet primes;

    Problem60Listener(PrimesSet p) {
        primes = p;
    }


    @Override
    public void activate(Set<T> set) {
        if (check(set))
            System.out.println(set);
    }


    public boolean check(Set<T> set) {

        List<T> list = set.stream().collect(Collectors.toList());

        for(int i =0; i < list.size()-1;i++) {
            for (int j=i+1;j<list.size();j++) {
                if (!isConcatenationPrime((Integer)list.get(i),(Integer)list.get(j)))
                    return false;
            }
        }

        return true;
    }


    private boolean isConcatenationPrime(Integer a, Integer b)     {
        Integer ab = new Integer(a.toString()+b.toString());
        Integer ba = new Integer(b.toString()+a.toString());

        return primes.isPrime(ab) && primes.isPrime(ba);
    }

}
