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
        Map<Character,Double> probabilities = new HashMap<>();
        probabilities.put('I',0.5);
        probabilities.put('#',0.5);


        assertThat(Solution.getSolution(probabilities, 100000))
                .isCloseTo(7.0/8, Percentage.withPercentage(0.01));
    }
}