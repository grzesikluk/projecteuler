package eulerproject.level3.problem60;

import eulerproject.tools.subsets.Listener;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-10-10.
 */
public class Problem60Listener<T> implements Listener<T> {
    private List<T> list;


    @Override
    public void activate(Set<T> set) {

        if (check(set)) {
            final int[] sum = {0};
            set.stream().forEach(a-> sum[0] = sum[0] + (Integer)a);
            System.out.println(set + " " + sum[0]);
        }
    }


    public boolean check(Set<T> set) {

        list = set.stream().collect(Collectors.toList());

        for(int i =0; i < list.size()-1;i++) {
            for (int j=i+1;j<list.size();j++) {
                if (!isConcatenationPrime((Integer)list.get(i),(Integer)list.get(j)))
                    return false;
            }
        }

        return true;
    }


    private boolean isConcatenationPrime(Integer a, Integer b) {
        BigInteger ab = new BigInteger(a.toString()+b.toString());
        BigInteger ba = new BigInteger(b.toString()+a.toString());

        return ab.isProbablePrime(1) && ba.isProbablePrime(1);
    }


}
