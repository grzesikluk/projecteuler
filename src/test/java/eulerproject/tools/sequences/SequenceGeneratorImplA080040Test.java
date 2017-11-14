package eulerproject.tools.sequences;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SequenceGeneratorImplA080040Test
{
    private long[] values = {2, 2, 8, 20, 56, 152, 416, 1136, 3104, 8480, 23168, 63296, 172928, 472448, 1290752, 3526400};

    @Test
    public void testGetNext() throws Exception
    {
        SequenceGeneratorIterative sg = new SequenceGeneratorImplA080040();

        IntStream.range(0, 10).forEach(
                i -> {
                    long n = (long) sg.getNext();
                    System.out.println(n);
                    assertThat(n).isEqualTo(values[i]);
                }

        );
    }
}