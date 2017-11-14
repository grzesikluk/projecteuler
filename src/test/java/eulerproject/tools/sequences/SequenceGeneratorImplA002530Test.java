package eulerproject.tools.sequences;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SequenceGeneratorImplA002530Test
{
    private int[] values = {0, 1, 1, 3, 4, 11, 15, 41, 56, 153, 209, 571, 780, 2131, 2911, 7953, 10864, 29681, 40545, 110771};

    @Test
    public void testGetNumber() throws Exception
    {
        SequenceGeneratorIterative<Long> sg = new SequenceGeneratorImplA002530();

        IntStream.range(0, values.length).forEach(i -> {
            assertThat(sg.getNext()).isEqualTo(values[i]);
        });
    }
}