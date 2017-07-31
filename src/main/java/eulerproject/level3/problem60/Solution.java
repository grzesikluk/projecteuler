package eulerproject.level3.problem60;

import eulerproject.tools.primes.Primes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution
{
    private static int MAX = 30000;
    private static int NO_NUMBERS = 5;

    public static void setSetOfPrimes(final Primes setOfPrimes)
    {
        Solution.setOfPrimes = setOfPrimes;
    }

    private static Primes setOfPrimes;
    private static Set<List<Integer>> result;

    public static void main(String[] args)
    {
        result = new HashSet<>();

        //primes
        setOfPrimes = new Primes(MAX);
        setOfPrimes.init();

        int startPrime = 2;
        int maxSum = MAX;

        while (startPrime * NO_NUMBERS < MAX && startPrime != 0) {
            searchForChain(Arrays.asList(startPrime), setOfPrimes, NO_NUMBERS, maxSum);
            startPrime = setOfPrimes.getNextPrime(startPrime);
        }

        for (List<Integer> list : result) {
            System.out.println(list.stream().mapToInt(s -> s).sum() + " " + list);
        }
    }

    public static void searchForChain(final List<Integer> chain, final Primes primes, final int size, final int maxSum)
    {
        int sum = chain.stream().mapToInt(s -> s).sum();
        int max = chain.stream().mapToInt(s -> s).max().orElse(maxSum);
        int nextPrime = max;

        while (chain != null && (nextPrime = primes.getNextPrime(nextPrime)) != 0) {

            if ((nextPrime * (size - chain.size()) + sum) > maxSum)
                break;
            else if (isChainedPrime(nextPrime, chain)) {
                List<Integer> inputList = new ArrayList<>(chain);
                inputList.add(nextPrime);
                searchForChain(inputList, primes, size, maxSum);
            }

            if (chain != null && chain.size() == size)
                result.add(chain);
            else continue;
        }
    }

    public static boolean isChainedPrime(final int prime, final List<Integer> inputList)
    {

        for (Integer i : inputList) {
            if (!isPrimePair(new Pair(prime, i)))
                return false;
        }
        return true;
    }

    public static boolean isPrimePair(final Pair a)
    {
        return setOfPrimes.isPrimeValueBig(a.getConcatenatedFirstSecond()) &&
                setOfPrimes.isPrimeValueBig(a.getConcatenatedSecondFirst()) &&
                setOfPrimes.isPrime(a.getA()) &&
                setOfPrimes.isPrime(a.getB());
    }
}
