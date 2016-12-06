package eulerproject.level3.problem60;

import eulerproject.tools.primes.Primes;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class Solution {
    private static int[] primesArray;
    private static int MAX = 10000;
    private static int MAX_PRIME = new Integer(Integer.toString(MAX) + Integer.toString(MAX));
    private static Primes primes;

    private static void initPrimes(int max) {
        primes = new Primes(max);
        primes.generatePrimes();
        primesArray = primes.asList();
        System.out.println("Primes initiated. " + primesArray.length);
    }

    public static void main(String[] args) {
        initPrimes(MAX_PRIME);
        Set<Pair> initialPairSet = createInitialPrimePairSet(primesArray, MAX);
        List<Set<Pair>> firsSetOfPairs = copyToListOfSet(initialPairSet);

        List<Set<Pair>> listOfChains = findChains(initialPairSet, firsSetOfPairs, 10, primes);

        Map<Integer, List<Integer>> resultMap = new LinkedHashMap<>();

        for (Set<Pair> chainOfPairsSet : listOfChains) {
            List<Integer> tempList = convertToIntegerList(chainOfPairsSet);

            if ((tempList.size() >= 5) && isPrimeList(tempList, primes))
                resultMap.put(getListSum(tempList), tempList);
        }

        for (Integer i : resultMap.keySet().stream().sorted().collect(Collectors.toList()))
            System.out.println(resultMap.get(i) + " " + i);


    }

    public static Set<Pair> createInitialPrimePairSet(int[] primesList, int maxPrimeVal) {
        Set<Pair> result = new HashSet<>();

        for (int i = 0; primesList[i] < maxPrimeVal; i++)
            for (int j = i + 1; primesList[j] < maxPrimeVal; j++) {
                Pair p = new Pair(primesList[i], primesList[j]);
                if (isPrimePair(p, primes))
                    result.add(p);
            }

        return result;
    }

    public static List<Set<Pair>> copyToListOfSet(Set<Pair> inputList) {
        List<Set<Pair>> resultSet = new ArrayList<>();

        for (Pair p : inputList) {
            Set<Pair> firstElement = new HashSet<>();
            firstElement.add(p);
            resultSet.add(firstElement);
        }
        return resultSet;

    }

    public static List<Set<Pair>> findChains(Set<Pair> inputList, List<Set<Pair>> resultSet, int maxLength, Primes primes) {

        for (Set<Pair> pairSet : resultSet) {
            inputList.stream().filter(p -> !pairSet.contains(p) && canBeChained(pairSet, p, primes) && pairSet.size() < maxLength).forEach(pairSet::add);
        }

        return resultSet.stream().filter(s -> s.size() > 1).collect(Collectors.toList());

    }

    public static boolean canBeChained(Set<Pair> set, Pair p, Primes primes) {

        for (Pair pair : set)
            if (!isPrimePair(pair, p, primes))
                return false;

        return true;
    }

    public static boolean isPrimePair(Pair a, Primes primes) {
        return primes.isPrime(a.getConcatenatedFirstSecond()) &&
                primes.isPrime(a.getConcatenatedSecondFirst()) &&
                primes.isPrime(a.getA()) &&
                primes.isPrime(a.getB());
    }

    public static boolean isPrimePair(Pair a, Pair b, Primes primes) {

        if (isPrimePair(a, primes) == false || isPrimePair(b, primes) == false)
            return false;

        int[] list = a.getConcatenatedOfTwoPairs(b);

        for (int i : list) {
            if (primes.isPrime(i) == false)
                return false;
        }

        return true;
    }

    public static List<Integer> convertToIntegerList(List<Pair> inputList) {

        Set<Integer> list = new HashSet<>();

        for (Pair p : inputList) {
            list.add(p.getA());
            list.add(p.getB());
        }

        List<Integer> returnList = list.stream().sorted().collect(Collectors.toList());

        return returnList;
    }

    public static List<Integer> convertToIntegerList(Set<Pair> inputList) {

        Set<Integer> list = new HashSet<>();

        for (Pair p : inputList) {
            list.add(p.getA());
            list.add(p.getB());
        }

        List<Integer> returnList = list.stream().sorted().collect(Collectors.toList());

        return returnList;
    }

    public static boolean isPrimeList(List<Integer> list, Primes primes) {

        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j < list.size(); j++)
                if (!isPrimePair(new Pair(list.get(i), list.get(j)), primes))
                    return false;

        return true;
    }

    public static int countPrimeHits(List<Integer> list, Primes primes) {
        int counter = 0;

        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j < list.size(); j++)
                if (isPrimePair(new Pair(list.get(i), list.get(j)), primes))
                    counter++;


        return counter;
    }

    public static int getListSum(List<Integer> list) {
        return list.stream().mapToInt(s -> s).sum();
    }
}
