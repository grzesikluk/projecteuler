package eulerproject.level4.problem93;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest
{
    @Test
    public void testConsecutiveLengthOfIntegers() throws Exception
    {
        Set<Double> input = new HashSet<>();
        input.add(1.0);
        input.add(2.0);
        input.add(3.0);
        input.add(4.0);
        input.add(4.5);
        input.add(5.0);

        assertThat(Solution.consecutiveLengthOfIntegers(0,input)).isEqualTo(5);
    }


    @Test
    public void testGenerateAllOrders() throws Exception
    {
        assertThat(Solution.generateAllOrders(Arrays.asList("a","b","c")))
                .contains(Arrays.asList("a","b","c"))
                .contains(Arrays.asList("b","a","c"))
                .contains(Arrays.asList("b","c","a"))
                .contains(Arrays.asList("c","b","a"))
                .contains(Arrays.asList("c","a","b"))
                .contains(Arrays.asList("a","c","b"))
        ;

    }

}