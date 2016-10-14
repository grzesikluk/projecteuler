package eulerproject.level3.problem60;

import eulerproject.tools.primes.PrimesSet;
import eulerproject.tools.subsets.FixedSubSet;
import eulerproject.tools.subsets.FixedSubSetImpl4;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class Solution {

    private static PrimesSet primes;
    private static int MAX = 1000000;

    static {
        primes = new PrimesSet(MAX);
        System.out.println("Primes initiated.");
    }


    public static void main(String[] args) {
        FixedSubSet<Integer> fixedSubSet = new FixedSubSetImpl4<>();
        fixedSubSet.generate(primes.getSet(),new Problem60Listener(primes),500);
    }

}
