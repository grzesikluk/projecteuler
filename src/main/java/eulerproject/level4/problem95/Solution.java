package eulerproject.level4.problem95;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution
{
    private static int MAX = 1000_000;

    public static void setValArray(final PriorityQueue<Integer> valArray)
    {
        Solution.valArray = valArray;
    }

    private static PriorityQueue<Integer> valArray;

    public static void main(String[] args)
    {
        valArray = new PriorityQueue<>(IntStream.range(2, MAX + 1).mapToObj(s -> s).collect(Collectors.toList()));
        int maxlen = 0;
        int maxK = 0;

        while (!valArray.isEmpty()) {
            int k = valArray.peek();

            Pair<List<Integer>, List<Integer>> chain = getChain(k);

            if (chain.getKey().size() > maxlen) {
                maxlen = chain.getKey().size();
                maxK = chain.getKey().stream().min(Integer::compare).get();
            }

            valArray.poll(); //remove
            chain.getValue().stream().forEach(s -> valArray.remove(s));
        }

        System.out.println(maxK + " " + maxlen + " " + getChain(maxK));
    }

    public static int getSumOfProperDivisors(int k)
    {
        return IntStream
                .range(1, k / 2 + 1)
                .parallel()
                .filter(s -> k % s == 0)
                .sum();
    }

    public static Pair<List<Integer>, List<Integer>> getChain(int startNumber)
    {
        List<Integer> result = new ArrayList<>();
        List<Integer> toRemove = new ArrayList<>();

        Integer current = startNumber;
        do {

            //before adding check if not exists already
            if (result.contains(current)) {
                if (!current.equals(startNumber)) {
                    toRemove.addAll(result);
                    result = getChain(current).getKey();
                    return new Pair<>(result,toRemove);

                } else {
                    toRemove.addAll(result);
                    return new Pair<>(result,toRemove);
                }
            } else {
                result.add(current);
                current = getSumOfProperDivisors(current);
            }

            if (current.equals(0) || !valArray.contains(current)) {
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
