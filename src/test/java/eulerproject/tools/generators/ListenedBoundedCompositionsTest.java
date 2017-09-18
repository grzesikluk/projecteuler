package eulerproject.tools.generators;

import eulerproject.level4.problem88.Solution;
import eulerproject.tools.combinatorics.Listener;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;


public class ListenedBoundedCompositionsTest {
    private static Listener<Integer> listener = new Listener<Integer>() {
        @Override
        public void activate(List<Integer> list) {
            //nothing;
        }

        @Override
        public List<List<Integer>> getResults()
        {
            return null;
        }
    };

    private static Predicate<List<Integer>> predicate = new Predicate<List<Integer>>() {
        @Override
        public boolean test(List<Integer> integers) {
            return Solution.checkOneComposition(integers) != 0;
        }
    };


    @Test
    public void testGenerateColex_case1() throws Exception {

        ListenedBoundedCompositions boundedCompositions = new ListenedBoundedCompositions(4, 2, 1, 4, listener, predicate);

        Set<List<Integer>> expectedResult = new HashSet<>();
        expectedResult.add(Arrays.asList(2, 2));

        Assert.assertEquals(expectedResult, boundedCompositions.generate());

    }

    @Test
    public void testGenerateColex_case2() throws Exception {

        ListenedBoundedCompositions boundedCompositions = new ListenedBoundedCompositions(6, 3, 1, 6, listener, predicate);

        Set<List<Integer>> expectedResult = new HashSet<>();
        expectedResult.add(Arrays.asList(1, 2, 3));

        Assert.assertEquals(expectedResult, boundedCompositions.generate());

        boundedCompositions = new ListenedBoundedCompositions(6, 3, 1, 3, listener, predicate);

        expectedResult.clear();
        expectedResult.add(Arrays.asList(1, 2, 3));

        Assert.assertEquals(expectedResult, boundedCompositions.generate());


    }


    @Test
    public void testGenerateColex_case3() throws Exception {

        ListenedBoundedCompositions boundedCompositions = new ListenedBoundedCompositions(8, 4, 1, 8, listener, predicate);

        Set<List<Integer>> expectedResult = new HashSet<>();

        expectedResult.clear();
        expectedResult.add(Arrays.asList(1, 1, 2, 4));

        Assert.assertEquals(expectedResult, boundedCompositions.generate());
    }

    @Test
    public void testGenerateColex_case4() throws Exception {

        ListenedBoundedCompositions boundedCompositions = new ListenedBoundedCompositions(12, 2, 1, 12, listener, predicate);

        Set<List<Integer>> expectedResult = new HashSet<>();

        expectedResult.clear();

        Assert.assertEquals(expectedResult, boundedCompositions.generate());


    }

    @Test
    public void testGenerateColex_case5() throws Exception {

        ListenedBoundedCompositions boundedCompositions = new ListenedBoundedCompositions(10, 5, 1, 100, listener, predicate);
        System.out.println(boundedCompositions.generate());
        
    }


    @Test
    public void testfindValue() throws Exception {

        ListenedBoundedCompositions boundedCompositions = new ListenedBoundedCompositions(4,2,1,4, listener, predicate);

        Assert.assertEquals(-1, boundedCompositions.findValue(4, 1, 2));
        Assert.assertEquals(2, boundedCompositions.findValue(4, 2, 2));
        Assert.assertEquals(5, boundedCompositions.findValue(10, 12, 2));


    }

    @Test
    public void testGenerateMin() throws Exception {

        ListenedBoundedCompositions boundedCompositions = new ListenedBoundedCompositions(4,2,1,4, listener, predicate);
        Assert.assertArrayEquals(new int[]{0, 1, 1, 2, 2}, boundedCompositions.generateMin(4, 10, 2));

    }

}