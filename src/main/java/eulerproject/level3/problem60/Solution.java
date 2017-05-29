package eulerproject.level3.problem60;

import eulerproject.tools.primes.Primes;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    private static int[] primesArray;

    private static int MAX = 50000;
    private static Primes setOfPrimes;


    Solution() {
        initPrimes();
    }

    private void initPrimes() {
        setOfPrimes = new Primes(MAX);
        setOfPrimes.init();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int startPrime = 2;
        int maxSum = 0;

        while (startPrime < MAX) {

            List<Integer> result = solution.searchForChain(setOfPrimes, 5, startPrime, maxSum);
            maxSum = result.stream().mapToInt(s -> s).sum();
            System.out.println(maxSum + " " + result);
            startPrime = result.stream().mapToInt(s -> s).min().orElse(MAX);


        }


    }


    public static List<Integer> searchForChain(Primes primes, int size, int startPrime, int maxSum) {
        List<Integer> resultList = new ArrayList<>();

        int primeI = startPrime;

        while ((primeI = primes.getNextPrime(primeI)) != 0) {

            int primeJ = primeI;

            resultList.add(primeI);

            while ((primeJ = primes.getNextPrime(primeJ)) != 0) {

                if (isChainedPrime(primeJ, resultList)) {
                    resultList.add(primeJ);

                    if (maxSum != 0 && resultList.stream().mapToInt(s -> s).sum() > maxSum) {
                        break;

                    } else if (resultList.size() == size)
                        break;
                }
            }

            if (resultList.size() == size)
                break;
            else {
                resultList.clear();
            }
        }

        return resultList;
    }

    public static boolean isChainedPrime(int prime, List<Integer> inputList) {

        for (Integer i : inputList) {
            if (!isPrimePair(new Pair(prime, i)))
                return false;

        }
        return true;
    }

    public static boolean isPrimePair(Pair a) {
        return setOfPrimes.isPrimeValueBig(a.getConcatenatedFirstSecond()) &&
                setOfPrimes.isPrimeValueBig(a.getConcatenatedSecondFirst()) &&
                setOfPrimes.isPrime(a.getA()) &&
                setOfPrimes.isPrime(a.getB());
    }


}
