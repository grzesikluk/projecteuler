package eulerproject.level4.problem80;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by grzesikl on 06/03/2017.
 */
public class SolutionTest {
    @Test
    public void testGetSquareRoot() throws Exception {
        List<Integer> beforeDigit = new LinkedList<>();
        beforeDigit.add(5);
        beforeDigit.add(6);

        List<Integer> afterDigit = new LinkedList<>();
        afterDigit.add(1);
        afterDigit.add(2);

        Pair<List<Integer>, List<Integer>> expected = new Pair<>(beforeDigit,afterDigit);

        Assert.assertEquals(expected,Solution.getSquareRoot(3150,10));

    }

    @Test
    public void testGetDublesFromNumber_123() throws Exception {
        List<Pair<Integer,Integer>> expectedList = new LinkedList<>();
        expectedList.add(new Pair<>(0,1));
        expectedList.add(new Pair<>(2,3));
        Assert.assertEquals(expectedList,Solution.getDublesFromNumber(123));
    }

    @Test
    public void testGetDublesFromNumber_1223() throws Exception {
        List<Pair<Integer,Integer>> expectedList = new LinkedList<>();
        expectedList.add(new Pair<>(1,2));
        expectedList.add(new Pair<>(2,3));
        Assert.assertEquals(expectedList,Solution.getDublesFromNumber(1223));
    }

    @Test
    public void testGetDublesFromNumber_1() throws Exception {
        List<Pair<Integer,Integer>> expectedList = new LinkedList<>();
        expectedList.add(new Pair<>(0,1));
        Assert.assertEquals(expectedList,Solution.getDublesFromNumber(1));
    }

    @Test
    public void testFindDigitValue() throws Exception {
        Assert.assertEquals(5,Solution.findDigitValue(0, 31));
        Assert.assertEquals(6,Solution.findDigitValue(10, 650));
        Assert.assertEquals(1,Solution.findDigitValue(112, 1400));
    }

}
