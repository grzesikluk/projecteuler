package eulerproject.tools.combinatorics;

import eulerproject.tools.bitarrays.BitSetUtils;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationWithoutRepetitionImpl<T> implements Combination<T>
{
    private int size;

    CombinationWithoutRepetitionImpl(int size)
    {
        this.size = size;
    }

    @Override
    public void generate(final Set<T> input, final Listener<T> listener)
    {
        if(input.size() < size)
            throw new IllegalArgumentException("Wrong size of input data");

        List<T> inputAsArray = input.stream().collect(Collectors.toList());
        BitSet element = BitSetUtils.getInitBitSet(size);

        while(element.length() >= size) {
            listener.activate(getListFromBitSet(element, inputAsArray));
            element = BitSetUtils.getNextLexographicBitSet(element,input.size());
        }
    }

    private List<T> getListFromBitSet(BitSet bitSet, List<T> input) {
        List<T> output = new ArrayList<>();
        bitSet.stream().forEach(i->output.add(input.get(i)));
        return output;
    }



}
