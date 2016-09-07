package eulerproject.problem49;

import eulerproject.problem43.Permutation;
import eulerproject.problem43.PermutationImpl;
import eulerproject.problem50.Primes;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lukasz on 2016-09-06.
 */
public class Solution {
    private static final int MAX = 9999;
    private static final int MIN = 1000;

    private static Primes primes = new Primes(9999);
    private static LinkedList<Character> list = new LinkedList<Character>();

    public static void main(String[] args) {
        Permutation<Character> perm = new PermutationImpl<Character>();
        PermListenerImpl<Character> listener = new PermListenerImpl<Character>();

        for (int i = MIN; i<MAX; i= primes.getNextPrime(i) )     {
            addToList(i);
            listener.clear();
            perm.generate(list.size() - 1, list, listener);
            check(listener.getList());
        }

    }


    private static void addToList(int k) {
        char[] charArray = new Integer(k).toString().toCharArray();

        list.clear();
        for (Character c:charArray)
            list.add(c);

    }

    private static boolean check(List<Integer> l) {
        //TODO check
        return false;
    }






}
