package eulerproject.tools.combinatorics;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CombinationImplTest
{
    @Test
    public void testGenerate() throws Exception
    {
        List<Integer> inputList= Arrays.asList(1,2,3);
        Combination<Integer> combination = new CombinationImpl<>();
        Listener<Integer> listener = new ListenerImpl<>();

        combination.generate(3,inputList,listener);
        assertThat(listener.getResults())
                .contains(Arrays.asList(1,1,1))
                .contains(Arrays.asList(2,2,2))
                .contains(Arrays.asList(3,3,3))
                .contains(Arrays.asList(1,2,3))
                .contains(Arrays.asList(1,2,2))
                .contains(Arrays.asList(1,3,3))
                .contains(Arrays.asList(2,3,3))
                .contains(Arrays.asList(1,1,3))
                .contains(Arrays.asList(2,2,3))
        ;

    }
}