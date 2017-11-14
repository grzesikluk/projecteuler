package eulerproject.newest.problem610;

import org.assertj.core.data.Percentage;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest
{
    @Test
    public void testGetSolution() throws Exception
    {
        Map<Character,Integer> probabilities = new HashMap<>();
        probabilities.put('I',50);
        probabilities.put('#',50);


        assertThat(Solution.getSolution(probabilities, 10_000_000))
                .isCloseTo(7.0/8, Percentage.withPercentage(1));
    }
}