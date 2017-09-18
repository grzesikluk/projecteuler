package eulerproject.level2.problem49;

import eulerproject.tools.combinatorics.Listener;
import eulerproject.tools.combinatorics.Permutation;
import eulerproject.tools.combinatorics.PermutationWithoutRepetitionsImpl;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.LinkedList;

import static eulerproject.level2.problem49.Solution.checkCondition;
import static eulerproject.level2.problem49.Solution.convertInteger;

/**
 * Created by grzesikl on 09/09/2016.
 */
public class SolutionTest {
    @Test
    @Ignore
    public void testCheckCondition() throws Exception {

        Assert.assertTrue(checkCondition(1487));
//        Assert.assertTrue(checkCondition(4817));
//        Assert.assertFalse(checkCondition(1467));
    }

    @Test
    public void testConvertInteger() throws Exception {
        LinkedList<Character> testList = new LinkedList<>();
        testList.add('1');
        testList.add('2');
        testList.add('5');

        Assert.assertEquals(testList,convertInteger(125));

    }

    @Test
    public void testPermutation() {

        LinkedList<Character> numberListChar = new LinkedList<>();
        numberListChar.add('1');
        numberListChar.add('2');
        numberListChar.add('3');
        numberListChar.add('4');

        Permutation<Character> perm = new PermutationWithoutRepetitionsImpl<Character>();
        Listener<Character> listener = new ListenerImplTest();

        perm.generate(numberListChar,listener);
    }

}