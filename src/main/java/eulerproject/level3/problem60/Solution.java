package eulerproject.level3.problem60;

import eulerproject.tools.primes.Primes;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class Solution {
    private static int[] primesArray;
    private static int MAX = 1000;
    private static int MAX_PRIME = MAX * MAX * 10;
    private static Primes primes;


    static {
        primes = new Primes(MAX_PRIME);
        primes.generatePrimes();
        primesArray = primes.asList();

        System.out.println("Primes initiated. " + primesArray.length);
    }


    public static void main(String[] args) {
        Set<Pair> initialPairSet = createInitialPrimePairSet();
        List<Set<Pair>> listOfChains = findChains(initialPairSet, initChains(initialPairSet), 5);
        Map<Integer,List<Integer>> resultMap = new LinkedHashMap<>();

        for (Set<Pair> chainOfPairsSet : listOfChains) {
            List<Integer> tempList = convertToIntegerList(chainOfPairsSet);

            if (tempList.size() >= 4 && isPrimeList(tempList)) {
                resultMap.put(getListSum(tempList),tempList);
            }
        }

        for(Integer i:resultMap.keySet().stream().sorted().collect(Collectors.toList())) {

            System.out.println(resultMap.get(i) + " " + i);
        }


    }

    private static Set<Pair> createInitialPrimePairSet() {
        Set<Pair> result = new HashSet<>();

        for (int i = 2; i < MAX; i++)
            for (int j = i + 1; j < MAX; j++) {
                Pair p = new Pair(i, j);

                if (isPrimePair(p)) {
                    result.add(p);
                }
            }
        return result;
    }

    public static List<Set<Pair>> initChains(Set<Pair> inputList) {
        List<Set<Pair>> resultSet = new ArrayList<>();

        for (Pair p : inputList) {
            Set<Pair> firstElement = new HashSet<>();
            firstElement.add(p);
            resultSet.add(firstElement);
        }
        return resultSet;

    }

    public static List<Set<Pair>> findChains(Set<Pair> inputList, List<Set<Pair>> resultSet, int maxLength) {

        for (Set<Pair> pairSet : resultSet) {
            for (Pair p : inputList) {
                if (!pairSet.contains(p) && canBeChained(pairSet, p) && pairSet.size() < maxLength) {
                    pairSet.add(p);
                }
            }
        }

        return resultSet.stream().filter(s -> s.size() > 1).collect(Collectors.toList());

    }

    public static boolean canBeChained(Set<Pair> set, Pair p) {

        for (Pair pair : set)
            if (!isPrimePair(pair, p))
                return false;

        return true;
    }

    public static boolean isPrimePair(Pair a) {
        return primes.isPrime(a.getConcatenatedFirstSecond()) && primes.isPrime(a.getConcatenatedSecondFirst());
    }

    public static boolean isPrimePair(Pair a, Pair b) {

        if (isPrimePair(a) == false || isPrimePair(b) == false)
            return false;

        for (int i : a.getConcatenatedOfTwoPairs(b)) {
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

    public static boolean isPrimeList(List<Integer> list) {

        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j < list.size(); j++)
                if (!isPrimePair(new Pair(list.get(i), list.get(j))))
                    return false;

        return true;
    }

    public static int countPrimeHits(List<Integer> list) {
        int counter = 0;

        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j < list.size(); j++)
                if (isPrimePair(new Pair(list.get(i), list.get(j))))
                    counter++;


        return counter;
    }

    public static int getListSum(List<Integer> list) {
        return list.stream().mapToInt(s -> s).sum();
    }

}