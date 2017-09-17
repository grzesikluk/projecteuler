package eulerproject.level4.problem93;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest
{
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

    @Test
    public void testGetRandomRPNEquation() throws Exception
    {
        System.out.println(Solution.createEquation(1,2,3,4));
    }
}