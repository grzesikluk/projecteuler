package eulerproject.level3.problem60;

import eulerproject.tools.primes.Primes;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    private static int[] primesArray;

    private static int MAX = 40000;
    private static int NO_NUMBERS = 5;
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

            List<Integer> result = solution.searchForChain(setOfPrimes, NO_NUMBERS, startPrime, maxSum);

            if (result != null) {
                maxSum = result.stream().mapToInt(s -> s).sum();
                System.out.println(maxSum + " " + result);
                startPrime = result.stream().mapToInt(s -> s).min().orElse(MAX);
            }

            if(startPrime == 0)
                break;

            if (startPrime * NO_NUMBERS > maxSum)
                break;

        }
    }


    public static List<Integer> searchForChain(Primes primes, int size, int startPrime, int maxSum) {
        List<Integer> resultList = new ArrayList<>();

        int primeI = startPrime;

        while ((primeI = primes.getNextPrime(primeI)) != 0) {

            if (maxSum != 0 && (NO_NUMBERS * primeI > maxSum))
                break;

            int primeJ = primeI;

            resultList.add(primeI);

            while ((primeJ = primes.getNextPrime(primeJ)) != 0){

                if (maxSum != 0 && (NO_NUMBERS * primeJ > maxSum))
                    break;

                if (isChainedPrime(primeJ, resultList)) {
                    resultList.add(primeJ);

                    if (maxSum != 0 &&
                            ((resultList.stream().mapToInt(s -> s).sum() > maxSum) )) {
                        return null;

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
