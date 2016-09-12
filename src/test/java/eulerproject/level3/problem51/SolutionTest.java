package eulerproject.level3.problem51;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static eulerproject.level3.problem51.Solution.getSubset;
import static eulerproject.level3.problem51.Solution.replaceNumbers;

/**
 * Created by Lukasz on 2016-09-11.
 */
public class SolutionTest {

    @Test
    public void testGetSubset() throws Exception {

        System.out.println(getSubset(5));
    }

    @Test
    public void testReplaceNumbers1() throws Exception {
        Set<Integer> subSet = new HashSet<>();
        subSet.add(0);
        subSet.add(1);

        Assert.assertEquals(773456, replaceNumbers(subSet, 123456, 7));

    }


    @Test
    public void testReplaceNumbers2() throws Exception {
        Set<Integer> subSet = new HashSet<>();
        subSet.add(2);
        subSet.add(4);

        Assert.assertEquals(127476,replaceNumbers(subSet, 123456, 7));

    }
}