package eulerproject.level3.problem51;

import eulerproject.tools.primes.Primes;
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
        Set<Set<Integer>> subSets = new HashSet<>();
        Set<Integer> setOfPrimes = new HashSet<>();

        for (int number = 11; number < MAX; number++) {
            int tempLength = new Integer(number).toString().length();
            int checkNumber;
            int numLength = 1;

            if (tempLength != numLength) {
                numLength = tempLength;
                subSets = getSubset(numLength);
            }

            for (Set<Integer> subSet : subSets) {
                for (int i = 0; i < 10; i++) {
                    checkNumber = replaceNumbers(subSet,number,i);
                    if (checkNumber>=number)
                        if (primes.isPrime(checkNumber))
                            setOfPrimes.add(checkNumber);
                }

                if (setOfPrimes.size() == PRIME_FAMILY) {
                    System.out.println(setOfPrimes);
                    System.exit(0);
                }
                setOfPrimes.clear();

            }

        }

    }

    public static Set<Set<Integer>> getSubset(int length) {

        SubSets<Integer> generator = new SubSetsImpl<>();
        ListenerProblem51<Integer> listener = new ListenerProblem51<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < length; i++)
            set.add(i);

        generator.generate(set, listener);
        return listener.getResult();

    }

    public static int replaceNumbers(Set<Integer> subSet,int number, int k) {
        String strNumber = new Integer(number).toString();
        String resultString = "";
        String strK = new Integer(k).toString();

        for(int i =0;i<strNumber.length();i++) {
            if (subSet.contains(i))
                resultString+=strK;
            else
                resultString+=strNumber.charAt(i);
        }

        return new Integer(resultString);

    }

}
