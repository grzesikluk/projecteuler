package eulerproject.newest.problem610;

import eulerproject.tools.arithmetic.RomanNumber;
import eulerproject.tools.generators.RandomGenerator;
import eulerproject.tools.generators.RandomGeneratorDoubleImpl;
import eulerproject.tools.statistics.ExpectedValueAggregator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution
{
    private static final Character[] SYMBOLS = {'I', 'V', 'X', 'L', 'C', 'D', 'M', '#'};
    private static final int MAX = 10_000_000;

    private static final Map<Character, Double> SYMBOLS_PROBABILITIES_MAP;

    static {
        SYMBOLS_PROBABILITIES_MAP = new HashMap<>();
        Arrays.stream(SYMBOLS).forEach(c -> SYMBOLS_PROBABILITIES_MAP.put(c, 0.14));
        SYMBOLS_PROBABILITIES_MAP.put('#', 0.02);
    }

    public static void main(String[] args)
    {
        System.out.println(getSolution(SYMBOLS_PROBABILITIES_MAP,MAX));
    }

    public static double getSolution(Map<Character,Double> probabilitiesMap, int max) {
        RandomGenerator<Character> generator = new RandomGeneratorDoubleImpl(probabilitiesMap);
        ExpectedValueAggregator expectedValueAggregator = new ExpectedValueAggregator();

        IntStream.range(0, max).parallel().forEach(i -> {
            RomanNumber number = getRandomRoman(generator);
            expectedValueAggregator.increment(number.asLong());
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
