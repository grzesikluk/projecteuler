package eulerproject.tools.subsets;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by Lukasz on 2016-09-11.
 */
public class SubSetGeneratorTest {
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
        SubSets<Integer> generator = new SubSetsImpl<>();
        generator.generate(set,sluchacz);

        List<Set<Integer>> resultArray = new ArrayList<>();

        resultArray.add(new HashSet<Integer>(Arrays.asList(1)));
        resultArray.add(new HashSet<Integer>(Arrays.asList(2)));
        resultArray.add(new HashSet<Integer>(Arrays.asList(1,2)));
        resultArray.add(new HashSet<Integer>(Arrays.asList(3)));
        resultArray.add(new HashSet<Integer>(Arrays.asList(1,3)));
        resultArray.add(new HashSet<Integer>(Arrays.asList(2,3)));
        resultArray.add(new HashSet<Integer>(Arrays.asList(1,2,3)));

        Assert.assertEquals(resultArray,sluchacz.getResultSet());


    }
}





