package eulerproject.tools.sequences;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SequenceGeneratorImplA002531Test
{
    private int[] values = {1, 1, 2, 5, 7, 19, 26, 71, 97, 265, 362, 989, 1351, 3691, 5042, 13775, 18817, 51409,
            70226, 191861, 262087, 716035, 978122, 2672279};

    @Test
    public void testGetNumber() throws Exception
    {
        SequenceGeneratorIterative<Long> sg = new SequenceGeneratorImplA002531();

        IntStream.range(0,10).forEach(i->{
                assertThat(sg.getNext()).isEqualTo(values[i]);
        });
    }
}