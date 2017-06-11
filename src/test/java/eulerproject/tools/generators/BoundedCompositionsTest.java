package eulerproject.tools.generators;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lgrzesik on 11/06/17.
 */
public class BoundedCompositionsTest {
    @Test
    public void testGenerateColex_case1() throws Exception {

        BoundedCompositions boundedCompositions = new BoundedCompositions();

        Set<List<Integer>> expectedResult = new HashSet<>();
        expectedResult.add(Arrays.asList(2, 2));
        expectedResult.add(Arrays.asList(1, 3));

        Assert.assertEquals(expectedResult, boundedCompositions.generate(4, 2, 1, 4));

    }

    @Test
    public void testGenerateColex_case2() throws Exception {

        BoundedCompositions boundedCompositions = new BoundedCompositions();

        Set<List<Integer>> expectedResult = new HashSet<>();
        expectedResult.add(Arrays.asList(1, 2, 3));
        expectedResult.add(Arrays.asList(2, 2, 2));
        expectedResult.add(Arrays.asList(1, 1, 4));

        Assert.assertEquals(expectedResult, boundedCompositions.generate(6, 3, 1, 6));

        expectedResult.clear();
        expectedResult.add(Arrays.asList(1, 2, 3));
        expectedResult.add(Arrays.asList(2, 2, 2));

        Assert.assertEquals(expectedResult, boundedCompositions.generate(6, 3, 1, 3));


    }


    @Test
    public void testGenerateColex_case3() throws Exception {

        BoundedCompositions boundedCompositions = new BoundedCompositions();

        Set<List<Integer>> expectedResult = new HashSet<>();

        expectedResult.clear();
        expectedResult.add(Arrays.asList(1, 1, 1, 5));
        expectedResult.add(Arrays.asList(1, 1, 2, 4));
        expectedResult.add(Arrays.asList(1, 2, 2, 3));
        expectedResult.add(Arrays.asList(2, 2, 2, 2));
        expectedResult.add(Arrays.asList(1, 1, 3, 3));

        Assert.assertEquals(expectedResult, boundedCompositions.generate(8, 4, 1, 8));


    }

    @Test
    public void testGenerateColex_case4() throws Exception {

        BoundedCompositions boundedCompositions = new BoundedCompositions();

        Set<List<Integer>> expectedResult = new HashSet<>();

        expectedResult.clear();
        expectedResult.add(Arrays.asList(6,6));
        expectedResult.add(Arrays.asList(5,7));
        expectedResult.add(Arrays.asList(4,8));
        expectedResult.add(Arrays.asList(3,9));
        expectedResult.add(Arrays.asList(2,10));
        expectedResult.add(Arrays.asList(1,11));

        Assert.assertEquals(expectedResult, boundedCompositions.generate(12, 2, 1, 12));


    }

    @Test
    public void testGenerateColex_case5() throws Exception {

        BoundedCompositions boundedCompositions = new BoundedCompositions();

        System.out.println(boundedCompositions.generate(10, 5, 1, 100).size());


    }


    @Test
    public void testfindValue() throws Exception {

        BoundedCompositions boundedCompositions = new BoundedCompositions();

        Assert.assertEquals(-1, boundedCompositions.findValue(4, 1, 2));
        Assert.assertEquals(2, boundedCompositions.findValue(4, 2, 2));
        Assert.assertEquals(5, boundedCompositions.findValue(10, 12, 2));


    }

    @Test
    public void testGenerateMin() throws Exception {

        BoundedCompositions boundedCompositions = new BoundedCompositions();
        Assert.assertArrayEquals(new int[]{0, 1, 1, 2, 2}, boundedCompositions.generateMin(4, 10, 2));

    }

}