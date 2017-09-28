package eulerproject.newest.problem610;

import eulerproject.tools.arithmetic.RomanNumber;
import eulerproject.tools.generators.RandomGenerator;
import eulerproject.tools.statistics.ExpectedValueAggregator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution
{
    private static final Character[] SYMBOLS = {'I', 'V', 'X', 'L', 'C', 'D', 'M', '#'};
    private static final int MAX = 1000000;

    private static final Map<Character, Double> SYMBOLS_PROBABILITIES_MAP;

    static {
        SYMBOLS_PROBABILITIES_MAP = new HashMap<>();
        Arrays.stream(SYMBOLS).forEach(c -> SYMBOLS_PROBABILITIES_MAP.put(c, 0.14));
        SYMBOLS_PROBABILITIES_MAP.put('#', 0.02);
    }

    public static void main(String[] args)
    {

        RandomGenerator<Character> generator = new RandomGenerator(SYMBOLS_PROBABILITIES_MAP);
        ExpectedValueAggregator expectedValueAggregator = new ExpectedValueAggregator();

        IntStream.range(0, MAX).forEach(i -> {
            expectedValueAggregator.increment(getRandomRoman(generator).asLong());
        });

        System.out.println(expectedValueAggregator.getExpectedValue());
    }

    public static long getSolution()
    {
        return 0;
    }

    public static RomanNumber getRandomRoman(final RandomGenerator<Character> generator)
    {
        Character newChar = ' ';
        StringBuilder sb = new StringBuilder();

        while (!(newChar = generator.getNext()).equals('#')) {
            if (new RomanNumber(sb.toString() + newChar).checkAllRules())
                sb.append(newChar);
        }

        return new RomanNumber(sb.toString());
    }
}
