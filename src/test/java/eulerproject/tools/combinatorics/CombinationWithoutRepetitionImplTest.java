package eulerproject.tools.combinatorics;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class CombinationWithoutRepetitionImplTest
{

    @Test
    public void testGenerate() {
        Listener<Integer> listener = new ListenerImpl<>();
        Combination<Integer> combination = new CombinationWithoutRepetitionImpl<>(4);
        Set<Integer> testSet = new HashSet<>();
        testSet.add(1);
        testSet.add(2);
        testSet.add(3);
        testSet.add(4);
        testSet.add(5);
        testSet.add(6);
        testSet.add(7);
        testSet.add(8);
        testSet.add(9);
        testSet.add(10);

        combination.generate(testSet, listener);

        System.out.println(listener.getResults());

    }
}