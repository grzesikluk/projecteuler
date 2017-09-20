package eulerproject.tools.bitarrays;

import org.junit.Test;

import java.util.BitSet;

import static org.assertj.core.api.Assertions.assertThat;

public class BitSetUtilsTest
{
    @Test
    public void getAllLexographicBitSet() throws Exception
    {
        BitSet testInput = new BitSet();
        testInput.set(0);
        testInput.set(1);

        BitSet testResult1 = new BitSet();
        testResult1.set(0);
        testResult1.set(2);

        BitSet testResult2 = new BitSet();
        testResult2.set(2);
        testResult2.set(3);

        assertThat(BitSetUtils.getAllLexographicBitSet(2,4))
                .contains(testResult1)
                .contains(testResult2)
                .hasSize(6)
        ;
    }

    @Test
    public void testGetNextLexographicBitSet() throws Exception
    {
        BitSet testInput = new BitSet();
        testInput.set(0);
        testInput.set(1);
        testInput.set(2);
        testInput.set(3, false);

        BitSet testResult = new BitSet();
        testResult.set(0);
        testResult.set(1);
        testResult.set(2, false);
        testResult.set(3);

        BitSet testResult2 = new BitSet();
        testResult2.set(0);
        testResult2.set(1, false);
        testResult2.set(2);
        testResult2.set(3);

        System.out.println(testResult2);

        assertThat(BitSetUtils.getNextLexographicBitSet(testInput, 4)).isEqualTo(testResult);
        assertThat(BitSetUtils.getNextLexographicBitSet(testResult, 4)).isEqualTo(testResult2);
    }

    @Test
    public void testConvertLongToBitSet() throws Exception
    {
        BitSet testResult3bits = new BitSet();
        testResult3bits.set(0, false); //LSB
        testResult3bits.set(1);
        testResult3bits.set(2);

        BitSet testResult2bits = new BitSet();
        testResult2bits.set(0, false);
        testResult2bits.set(1);

        assertThat(BitSetUtils.convertLongToBitSet(6, 3)).isEqualTo(testResult3bits);
        assertThat(BitSetUtils.convertLongToBitSet(6, 2)).isEqualTo(testResult2bits);
        assertThat(BitSetUtils.convertLongToBitSet(0, 3)).isEqualTo(new BitSet(0));
    }

    @Test
    public void testConvertBitSetToLong() throws Exception
    {
        BitSet testInput = new BitSet();
        testInput.set(0);
        testInput.set(1);
        testInput.set(2);

        assertThat(BitSetUtils.convertBitSetToLong(testInput)).isEqualTo(7L);
        assertThat(BitSetUtils.convertBitSetToLong(new BitSet(0))).isEqualTo(0L);
    }
}