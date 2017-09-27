package eulerproject.tools.generators;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RandomGeneratorTest
{
    private static final int MAX = 100000000;
    private static final int MAX_DEVIATION = (int) (MAX * 0.0001);

    @Test
    public void testGetNext() throws Exception
    {
        final int elementsNumber = 5;
        RandomGenerator<Integer> randomGeneratorEqualProbabilities = new RandomGenerator<Integer>(IntStream.range(0,elementsNumber).mapToObj(Integer::new).collect(Collectors.toSet()));

        int[] results = new int[elementsNumber];

        IntStream.range(0, MAX).forEach(i-> {
            results[randomGeneratorEqualProbabilities.getNext()]++;
        });

        int expectedNumber = MAX/elementsNumber;

        IntStream.range(0,elementsNumber).forEach(k-> {
            assertThat(results[k]).isBetween(expectedNumber-MAX_DEVIATION,expectedNumber+MAX_DEVIATION);
        });

    }

    @Test
    public void testGetNextDifferentProbability() throws Exception
    {
        final int elementsNumber = 5;

        Map<Integer,Double> probabilitiesMap = new HashMap<>();
        probabilitiesMap.put(0,0.1);
        probabilitiesMap.put(1,0.1);
        probabilitiesMap.put(2,0.1);
        probabilitiesMap.put(3,0.1);
        probabilitiesMap.put(4,0.6);

        RandomGenerator<Integer> randomGeneratorEqualProbabilities = new RandomGenerator<Integer>(probabilitiesMap);

        int[] results = new int[5];

        int[] expectedNumbers = new int[elementsNumber];

        IntStream.range(0,elementsNumber).forEach(i->{
            expectedNumbers[i] = (int) (MAX*probabilitiesMap.get(i));
        });

        IntStream.range(0, MAX).forEach(i-> {
            results[randomGeneratorEqualProbabilities.getNext()]++;
        });

        IntStream.range(0,elementsNumber).forEach(k-> {
            assertThat(results[k]).isBetween(expectedNumbers[k]-MAX_DEVIATION,expectedNumbers[k]+MAX_DEVIATION);
        });

    }

    @Test
    public void testGetNextDifferentProbabilityWrongMap() throws Exception
    {
        Map<Integer, Double> probabilitiesMap = new HashMap<>();
        probabilitiesMap.put(0, 0.1);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                new RandomGenerator<Integer>(probabilitiesMap)).withMessage("Wrong probabilities definition");
    }
}