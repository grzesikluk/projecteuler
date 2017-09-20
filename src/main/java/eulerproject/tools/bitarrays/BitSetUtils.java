package eulerproject.tools.bitarrays;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class BitSetUtils
{

    public static List<BitSet> getAllLexographicBitSet(final int k, final int n) {

        if(k>=n)
            throw new IllegalArgumentException("k is bigger than n.");

        List<BitSet> result = new ArrayList<>();
        BitSet element = getInitBitSet(k);

        while(element.length() >= k) {
            result.add(element);
            element = getNextLexographicBitSet(element,n);
        }

        return result;
    }

    public static BitSet getNextLexographicBitSet(final BitSet input, final int length) {
        if(length==0)
            throw new IllegalArgumentException("Wrong length.");

        long v = convertBitSetToLong(input);
        long t = (v | (v - 1)) + 1;
        long result = t | ((((t & -t) / (v & -v)) >> 1) - 1);
        return convertLongToBitSet(result, length);
    }

    public static long convertBitSetToLong(final BitSet input) {
        long value = 0L;
        for (int i = 0; i < input.length(); ++i) {
            value += input.get(i) ? (1L << i) : 0L;
        }
        return value;
    }

    public static BitSet convertLongToBitSet(final long v, int length) {
        BitSet bits = new BitSet(length);
        long value = v;
        int index = 0;
        while (value != 0L && index<length) {
            if (value % 2L != 0) {
                bits.set(index);
            }
            ++index;
            value = value >>> 1;
        }
        return bits;
    }

    public static BitSet getInitBitSet(final int k) {
        BitSet element = new BitSet();

        for(int i=0;i<k;i++)
            element.set(i);
        return element;
    }

}
