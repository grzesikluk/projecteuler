package eulerproject.level3.problem65;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static eulerproject.level3.problem65.Solution.getConvergentsListForEulerConstant;

/**
 * Created by Lukasz on 2016-11-07.
 */
public class SolutionTest {
    @Test
    public void testGetConvergentsListForEulerConstant() throws Exception {
        List<Integer> list = Arrays.asList(new Integer[]{new Integer(2),new Integer(1),new Integer(2),new Integer(1)});

        Assert.assertEquals(list,getConvergentsListForEulerConstant(list.size()));

    }

    @Test
    public void testGetConvergentsListForEulerConstant2() throws Exception {
        List<Integer> list = Arrays.asList(new Integer[]{new Integer(2),new Integer(1),new Integer(2),new Integer(1),
                new Integer(1),new Integer(4),new Integer(1),
                new Integer(1),new Integer(6),new Integer(1),
                new Integer(1),new Integer(8),new Integer(1)});

        Assert.assertEquals(list,getConvergentsListForEulerConstant(list.size()));

    }
}