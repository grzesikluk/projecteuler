package eulerproject.newest.problem610;

import eulerproject.tools.arithmetic.RomanNumber;
import eulerproject.tools.generators.RandomGenerator;
import eulerproject.tools.generators.RandomGeneratorIntImpl;
import eulerproject.tools.statistics.ExpectedValueAggregator;
import eulerproject.tools.statistics.ExpectedValueAggregatorArrayImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

public class Solution
{
    private static final Character[] SYMBOLS = {'I', 'V', 'X', 'L', 'C', 'D', 'M', '#'};
    private static final long MAX = 1_000_000L;

    private static final Map<Character, Integer> SYMBOLS_PROBABILITIES_MAP;

    static {
        SYMBOLS_PROBABILITIES_MAP = new HashMap<>();
        Arrays.stream(SYMBOLS).forEach(c -> SYMBOLS_PROBABILITIES_MAP.put(c, 14));
        SYMBOLS_PROBABILITIES_MAP.put('#', 2);
    }

    public static void main(String[] args)
    {
        System.out.println(getSolution(SYMBOLS_PROBABILITIES_MAP,MAX));
    }

    public static double getSolution(Map<Character,Integer> probabilitiesMap, long max) {
        RandomGenerator<Character> generator = new RandomGeneratorIntImpl<>(probabilitiesMap);
        ExpectedValueAggregator expectedValueAggregator = new ExpectedValueAggregatorArrayImpl(100000);

        LongStream.range(0, max).parallel().forEach(i -> {
            RomanNumber number = getRandomRoman(generator);
            expectedValueAggregator.increment(number.asInt());
        });

        return expectedValueAggregator.getExpectedValue();
    }

    public static RomanNumber getRandomRoman(final RandomGenerator<Character> generator)
    {
        Character newChar;
        StringBuilder sb = new StringBuilder();

        while (!(newChar = generator.getNext()).equals('#')) {
            if (new RomanNumber(sb.toString() + newChar).checkAllRules())
                sb.append(newChar);
        }

        return new RomanNumber(sb.toString());
    }
}
