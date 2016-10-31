package eulerproject.tools.subsets;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by Lukasz on 2016-09-26.
 */
public class FixedSubSetImplTest {
    Set<Integer> set ;

    @Before
    public void init() {
        set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
    }

    @Test
    public void testGenerate() throws Exception {
        TestListener sluchacz = new TestListener();
        FixedSubSet<Integer> generator = new RecursiveFixSubsetImpl<>();
        generator.generate(set,sluchacz,2);

        List<Set<Integer>> resultArray = new ArrayList<>();

        resultArray.add(new HashSet<Integer>(Arrays.asList(1,2)));
        resultArray.add(new HashSet<Integer>(Arrays.asList(1,3)));
        resultArray.add(new HashSet<Integer>(Arrays.asList(2,3)));

        Assert.assertEquals(resultArray,sluchacz.getResultSet());

    }


    @Test
    public void testGenerate2() throws Exception {
        TestListener sluchacz = new TestListener();
        FixedSubSet<Integer> generator = new NonRecursiveFixedSubsetImpl<>();
        generator.generate(set,sluchacz,2);

        List<Set<Integer>> resultArray = new ArrayList<>();

        resultArray.add(new HashSet<Integer>(Arrays.asList(1,2)));
        resultArray.add(new HashSet<Integer>(Arrays.asList(1,3)));
        resultArray.add(new HashSet<Integer>(Arrays.asList(2,3)));

        Assert.assertEquals(resultArray,sluchacz.getResultSet());

    }

}