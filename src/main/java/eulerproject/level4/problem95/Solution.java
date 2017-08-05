package eulerproject.level4.problem95;

import eulerproject.tools.primes.PrimeFactorization;
import eulerproject.tools.primes.Primes;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution
{
    private static int MAX = 1000_000;
    private static Set<Integer> valueSet;

    public static void setValueSet(final Set<Integer> valueSet)
    {
        Solution.valueSet = valueSet;
    }

    public static void main(String[] args)
    {
        Primes primes = new Primes(MAX * 10);
        primes.init();
        int[] primesArray = primes.asList();

        valueSet = new HashSet<>(IntStream.range(2, MAX + 1).mapToObj(s -> s).collect(Collectors.toList()));

        int maxlen = 0;
        int maxK = 0;
        int i = 0;

        while (!valueSet.isEmpty()) {

            if(valueSet.contains(i)) {
                Pair<List<Integer>, List<Integer>> chain = getChain(i, primesArray);

                if (chain.getKey().size() > maxlen) {
                    maxlen = chain.getKey().size();
                    maxK = chain.getKey().stream().min(Integer::compare).get();
                }

                chain.getValue().stream().forEach(s -> valueSet.remove(s));
            }

            i++;

            if(valueSet.size() % 1000 == 0) {
                System.out.println(valueSet.size());
            }
        }

        System.out.println(maxK + " " + maxlen);
    }


    public static Pair<List<Integer>, List<Integer>> getChain(int startNumber, int[] primes)
    {
        List<Integer> result = new ArrayList<>();
        List<Integer> toRemove = new ArrayList<>();

        Integer current = startNumber;
        do {

            //before adding check if not exists already
            if (result.contains(current)) {
                if (!current.equals(startNumber)) {
                    toRemove.addAll(result);
                    result = getChain(current, primes).getKey();
                    return new Pair<>(result, toRemove);
                } else {
                    toRemove.addAll(result);
                    return new Pair<>(result, toRemove);
                }
            } else {
                result.add(current);
                current = PrimeFactorization.getSumOfProperDivisors(current, primes);
            }

            if (current.equals(0) || !valueSet.contains(current)) {
                toRemove.addAll(result);
                result.clear();
                return new Pair<>(result, toRemove);
            }
        }
        while (!current.equals(startNumber));

        toRemove.addAll(result);
        return new Pair<>(result, toRemove);
    }
}
