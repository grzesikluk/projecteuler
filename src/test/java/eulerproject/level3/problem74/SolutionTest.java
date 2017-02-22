package eulerproject.level3.problem74;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by grzesikl on 22/02/2017.
 */
public class SolutionTest {
    @Test
    public void testGetChainListForFactorials() throws Exception {
        Set<Integer> expected = new LinkedHashSet<>();

        expected.add(145);
        Assert.assertEquals(expected,Solution.getChainListForFactorials(145));

        expected.clear();
        expected.add(169);
        expected.add(363601);
        expected.add(1454);
        Assert.assertEquals(expected,Solution.getChainListForFactorials(169));

        expected.clear();
        expected.add(871);
        expected.add(45361);
        Assert.assertEquals(expected,Solution.getChainListForFactorials(871));

        expected.clear();
        expected.add(69);
        expected.add(363600);
        expected.add(1454);
        expected.add(169);
        expected.add(363601);
        Assert.assertEquals(expected,Solution.getChainListForFactorials(69));

        expected.clear();
        expected.add(78);
        expected.add(45360);
        expected.add(871);
        expected.add(45361);
        Assert.assertEquals(expected,Solution.getChainListForFactorials(78));
    }

    @Test
    public void testGetSumOfFactorialsOfDigits() throws Exception {
        Assert.assertEquals(145,Solution.getSumOfFactorialsOfDigits(145));
        Assert.assertEquals(363601,Solution.getSumOfFactorialsOfDigits(169));
        Assert.assertEquals(1454,Solution.getSumOfFactorialsOfDigits(363601));
    }

    @Test
    public void testGetFactorial() throws Exception {
        Assert.assertEquals(24, Solution.getFactorial(4));
        Assert.assertEquals(120, Solution.getFactorial(5));
    }




}