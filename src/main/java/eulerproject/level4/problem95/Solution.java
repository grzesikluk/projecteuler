package eulerproject.level4.problem95;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {

    private static Map<Integer, Integer> divMap;
    private static int MAX = 1_000_000;


    public static void main(String[] args) {
        fillSumDivMap();
        System.out.println("finished");
    }

    public static void fillSumDivMap() {
        divMap = new HashMap<>();
        IntStream
                .range(0, MAX)
                .parallel()
                .forEach(i->divMap.put(i, getSumOfProperDivisors(i)));
    }


    public static int getSumOfProperDivisors(int k) {
        return IntStream
                .range(1, k/2+1)
                .parallel()
                .filter(s -> k % s == 0)
                .sum();
    }
}
