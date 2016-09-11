package eulerproject.level3.problem51;

import eulerproject.tools.Primes;
import eulerproject.tools.subsets.SubSets;
import eulerproject.tools.subsets.SubSetsImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lukasz on 2016-09-11.
 */
public class Solution {

    public static final int MAX = 1000000;
    public static Primes primes = new Primes(MAX);
    public static final int PRIME_FAMILY = 8; //eight prime value family

    public static void main(String[] args) {

        for(int number = 2; number < MAX; number++) {

            for(int i=0;i<10;i++){
                //generate sub sets if length of number changed
                //replace with {0-9] according to the subsets
                // check if prime
                // count how many primes there are
                // if eight return smallest prime got and exit.


            }


        }

    }

    public static Set<Set<Integer>> getSubset(int length) {

        SubSets<Integer> generator = new SubSetsImpl<>();
        ListenerProblem51<Integer> listener = new ListenerProblem51<>();
        Set<Integer> set = new HashSet<>();

        for (int i=0;i<length;i++)
            set.add(i);


        generator.generate(set,listener);
        return listener.getResult();


    }



}
