package eulerproject.tools.combinatorics;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationWithRepetitionsImplTest
{
    private Listener<Integer> listener = new ListenerImpl<>();

    @Test
    public void testGenerate() throws Exception
    {
        Permutation<Integer> permutation = new PermutationWithRepetitionsImpl<>(5);

        permutation.generate(Arrays.asList(1,2,3,4,5),listener);

        assertThat(listener.getResults())
                .contains(Arrays.asList(1,2,3,4,5))
                .contains(Arrays.asList(1,2,4,3,5))
                .contains(Arrays.asList(2,3,4,5,1))
                .contains(Arrays.asList(1,2,3,5,4))
                .contains(Arrays.asList(1,2,3,5,5))
                .contains(Arrays.asList(1,2,3,5,5))
                .contains(Arrays.asList(1,1,1,1,1))
                .contains(Arrays.asList(1,1,1,1,1))
                .contains(Arrays.asList(2,2,2,2,2))
                .doesNotContain(Arrays.asList(1,1,1,1))
                .doesNotContain(Arrays.asList())
                .hasSize(3125)
        ;

    }

    @Test
    public void testGenerate2() throws Exception
    {
        Permutation<Integer> permutation = new PermutationWithRepetitionsImpl<>(3);

        permutation.generate(Arrays.asList(1,2,3,4,5),listener);

        assertThat(listener.getResults())
                .contains(Arrays.asList(1,2,3))
                .contains(Arrays.asList(1,2,4))
                .contains(Arrays.asList(2,3,4))
                .contains(Arrays.asList(1,2,3))
                .contains(Arrays.asList(1,2,3))
                .contains(Arrays.asList(1,2,3))
                .contains(Arrays.asList(1,1,1))
                .contains(Arrays.asList(1,1,1))
                .contains(Arrays.asList(2,2,2))
                .doesNotContain(Arrays.asList(1,1,1,1))
                .doesNotContain(Arrays.asList())
                .hasSize(125)
        ;

    }
}