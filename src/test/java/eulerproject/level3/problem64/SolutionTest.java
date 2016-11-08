package eulerproject.level3.problem64;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.level3.problem64.Solution.findPeriodInSubstring;

/**
 * Created by Lukasz on 2016-11-08.
 */
public class SolutionTest {
    @Test
    public void testFindPeriodInSubstring() throws Exception {

//        Assert.assertEquals("123",findPeriodInSubstring("4123123123",1));
//        Assert.assertEquals("",findPeriodInSubstring("4122435162738192031",1));
//        Assert.assertEquals("1",findPeriodInSubstring("4111111",1));
//        Assert.assertEquals("41",findPeriodInSubstring("414141414141",0));
//        Assert.assertEquals("141",findPeriodInSubstring("141141141141141",0));
        Assert.assertEquals("1114",findPeriodInSubstring("1114111411141",0));
    }

}