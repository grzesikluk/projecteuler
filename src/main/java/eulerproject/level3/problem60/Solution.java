package eulerproject.level3.problem60;

import eulerproject.tools.primes.Primes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class Solution {
    private static int[] primesArray;
    private static int MAX = 5000;
    private static int MAX_PRIME = MAX * 10000;
    private static Primes primes;


    static {
        primes = new Primes(MAX_PRIME);
        primes.generatePrimes();
        primesArray = primes.asList();

        System.out.println("Primes initiated. " + primesArray.length);
    }


    public static void main(String[] args) {
        extractResult(createPrimesSet());
    }

    private static Set<Pair> createPrimesSet() {
        Set<Pair> result = new HashSet<>();

        for (int i = 1; i < MAX; i++)
            for (int j = i + 1; j < MAX; j++) {
                Pair p = new Pair(i, j);

                if (isPrimePair(p)) {
                    result.add(p);
                }
            }
        return result;
    }

    private static void extractResult(Set<Pair> input) {

        List<Pair> listInput = input.stream().collect(Collectors.toList());

        for (int i = 0; i < listInput.size(); i++) {
            List<Pair> smallList = new ArrayList<>();
            smallList.add(listInput.get(i));

            for (int j = i + 1; j < listInput.size(); j++)
                if (listInput.get(i).isOneDigitSame(listInput.get(j)))
                    smallList.add(listInput.get(j));

            List<Integer> tempList = convertToList(smallList);

            if (countPrimeHits(tempList) == 10 && tempList.size() == 5) {
                System.out.println(tempList + " " + getListSum(tempList));
            }


        }
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

    public static List<Integer> convertToList(List<Pair> inputList) {

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