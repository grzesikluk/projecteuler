package eulerproject.tools.generators;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RandomGeneratorIntImplTest
{
    private static final int MAX = 10000000;
    private static final int MAX_DEVIATION = (int) (MAX * 0.0001);

    @Test
    public void testGetNextDifferentProbability() throws Exception
    {
        Map<Integer,Integer> probabilitiesMap = new HashMap<>();
        probabilitiesMap.put(0,10);
        probabilitiesMap.put(1,10);
        probabilitiesMap.put(2,10);
        probabilitiesMap.put(3,10);
        probabilitiesMap.put(4,60);

        RandomGeneratorIntImpl<Integer> randomGeneratorEqualProbabilities = new RandomGeneratorIntImpl<>(probabilitiesMap);

        int[] results = new int[5];

        int[] expectedNumbers = new int[probabilitiesMap.size()];

        IntStream.range(0,probabilitiesMap.size()).forEach(i->{
            expectedNumbers[i] = (int) (MAX*probabilitiesMap.get(i)/100);
        });

        IntStream.range(0, MAX).forEach(i-> {
            results[randomGeneratorEqualProbabilities.getNext()]++;
        });

        IntStream.range(0,probabilitiesMap.size()).forEach(k-> {
            assertThat(results[k]).isBetween(expectedNumbers[k]-MAX_DEVIATION,expectedNumbers[k]+MAX_DEVIATION);
        });

    }

    @Test
    public void testGetNextDifferentProbabilityWrongMap() throws Exception
    {
        Map<Integer, Integer> probabilitiesMap = new HashMap<>();
        probabilitiesMap.put(0, 10);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                new RandomGeneratorIntImpl<Integer>(probabilitiesMap)).withMessage("Wrong probabilities definition");
    }
}