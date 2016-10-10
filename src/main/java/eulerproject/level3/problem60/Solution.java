package eulerproject.level3.problem60;

import eulerproject.tools.primes.PrimesSet;
import eulerproject.tools.subsets.FixedSubSet;
import eulerproject.tools.subsets.FixedSubSetImpl;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class Solution {

    private static PrimesSet primes;
    private static int MAX = 1000000;
    private static int NUMBER_DIGITS = 4;

    static {
        primes = new PrimesSet(MAX);
    }


    public static void main(String[] args) {

        FixedSubSet<Integer> fixedSubSet = new FixedSubSetImpl<>();
        fixedSubSet.generate(primes.getSet(),new Problem60Listener(primes),NUMBER_DIGITS);

    }







}
