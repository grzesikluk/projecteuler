package eulerproject.level3.problem60;

import eulerproject.tools.primes.Primes;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class Solution {
    private static int[] primesArray;

    /*let's judge the sizes*/
    private static int MAX = 1000;
    private static int NUMBER_PRIMES = 4;
    private static Primes primes;

    private static void initPrimes() {
        int max = MAX;

        primes = new Primes(max);
        primes.init();
        primesArray = primes.asList();
        System.out.println("Primes initiated. " + primesArray.length);
    }

    public static void main(String[] args) {
        initPrimes();

        /**
         * need to rethink:
         *
         * 1) do not create pairs,
         * 2) try to create chains of primes one by one
         *
         */


    }

    public static Set<Pair> createInitialPrimePairSet(int[] primesList) {
        Set<Pair> result = new HashSet<>();

        for (int i = 0; i < primesList.length - 1; i++)
            for (int j = i + 1; j < primesList.length; j++) {

                Pair p = new Pair(primesList[i], primesList[j]);

                if (isPrimePair(p))//, primes))
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




    public static boolean isPrimePair(Pair a) {
        return Primes.isPrimeValue(a.getConcatenatedFirstSecond()) &&
                Primes.isPrimeValue(a.getConcatenatedSecondFirst()) &&
                Primes.isPrimeValue(a.getA()) &&
                Primes.isPrimeValue(a.getB());
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
