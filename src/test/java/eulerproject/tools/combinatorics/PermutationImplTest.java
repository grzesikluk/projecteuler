package eulerproject.tools.combinatorics;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationImplTest
{
    private Listener<Integer> listener = new ListenerImpl<>();

    @Test
    public void testGenerate() throws Exception
    {
        Permutation<Integer> permutation = new PermutationWithoutRepetitionsImpl<>();

        permutation.generate(Arrays.asList(1,2,3,4,5),listener);

        assertThat(listener.getResults())
                .contains(Arrays.asList(1,2,3,4,5))
                .contains(Arrays.asList(1,2,4,3,5))
                .contains(Arrays.asList(2,3,4,5,1))
                .contains(Arrays.asList(1,2,3,5,4))
                .doesNotContain(Arrays.asList(1,2,3,5,5))
                .doesNotContain(Arrays.asList())
                .hasSize(720)
        ;


    }
}