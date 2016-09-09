package projecteuler.problem49;

import projecteuler.problem43.Listener;
import projecteuler.problem43.ListenerImplCheck;
import projecteuler.problem43.Permutation;
import projecteuler.problem43.PermutationImpl;
import projecteuler.problem50.Primes;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * Created by grzesikl on 09/09/2016.
 */
public class Solution {
    public static final int MIN = 1000;
    public static final int MAX = 9999;

    private static Primes primes = new Primes(MAX);


    public static void main(String[] args) {

        for (int k = MIN; k <= MAX; k++) {
            if (checkCondition(k)) {
//                System.out.println(k);
//                System.exit(0); //found first

            }
        }
    }

    public static boolean checkCondition(int k) {
        LinkedList<Character> numberListChar = convertInteger(k);
        Permutation<Character> perm = new PermutationImpl<Character>();
        ListenerImplCheckProblem49<Character> listener = new ListenerImplCheckProblem49<>();
        LinkedList<Integer> primeList = new LinkedList<>();
        Map<Integer, Integer> primeListDifferences = new HashMap<>();

        perm.generate(numberListChar.size() - 1, numberListChar, listener);

        int counter = 0;

        for (Integer i : listener.getResults()) {
            if (i < MAX && i > MIN)
                if (primes.isPrime(i)) {
                    primeList.add(i);
                }
        }


        for (int i = 0; i < primeList.size(); i++)
            for (int j = i + 1; j < primeList.size(); j++) {
                int diff = Math.abs(primeList.get(i) - primeList.get(j)); //get diff

                if (primeListDifferences.containsKey(diff)) {
                    primeListDifferences.replace(diff, (primeListDifferences.get(diff)) + 1);


                } else {
                    primeListDifferences.put(diff, 1);
                }
                System.out.println(" Pair i =" + primeList.get(i) + " j= " + primeList.get(j) + " diff is " + diff + " count is " + primeListDifferences.get(diff));
            }

        for (Integer diff : primeListDifferences.keySet()) {
            if (primeListDifferences.get(diff) > 3)
                return true;
        }

        return false;

    }

    public static LinkedList<Character> convertInteger(int k) {
        String kStr = new Integer(k).toString();
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < kStr.length(); i++)
            list.add(kStr.charAt(i));
        return list;
    }


}
