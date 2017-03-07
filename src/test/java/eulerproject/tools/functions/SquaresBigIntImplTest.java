package eulerproject.tools.functions;


import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by Lukasz on 2017-03-07.
 */
public class SquaresBigIntImplTest {
    @Test
    public void testGetIrrationalSquares() throws Exception {
        Set<Integer> expectedSet = new HashSet<>();
        expectedSet.addAll(Arrays.asList(2,3,5,6,7,8,10));

        Assert.assertEquals(expectedSet, new SquaresBigIntImpl().getIrrationalSquares(10));

    }

    @Test
    public void testGetSquareRoot_2() throws Exception {
        List<Integer> beforeDigit = new LinkedList<>();
        beforeDigit.add(1);

        List<Integer> afterDigit = new LinkedList<>();
        afterDigit.addAll(Arrays.asList(4,1,4,2,1,3,5,6,2));

        Pair<List<Integer>, List<Integer>> expected = new Pair<>(beforeDigit,afterDigit);
        Squares squares = new SquaresBigIntImpl();
        Pair<List<Integer>, List<Integer>> calculated = squares.getSquareRootDigits(2,10);

        Assert.assertEquals(expected, calculated);

    }


    @Test
    public void testGetSquareRoot_3150() throws Exception {
        List<Integer> beforeDigit = new LinkedList<>();
        beforeDigit.addAll(Arrays.asList(5,6));

        List<Integer> afterDigit = new LinkedList<>();
        afterDigit.addAll(Arrays.asList(1,2,4,8,6,0,8,0));

        Pair<List<Integer>, List<Integer>> expected = new Pair<>(beforeDigit,afterDigit);

        Squares squares = new SquaresBigIntImpl();
        Pair<List<Integer>, List<Integer>> calculated = squares.getSquareRootDigits(3150,10);

        Assert.assertEquals(expected, calculated);

    }

}