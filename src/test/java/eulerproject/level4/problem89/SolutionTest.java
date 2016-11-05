package eulerproject.level4.problem89;

import org.junit.Assert;
import org.junit.Test;

import static eulerproject.level4.problem89.Solution.*;
import static eulerproject.level4.problem89.Solution.RomanNumbers.*;

/**
 * Created by Lukasz on 2016-11-05.
 */
public class SolutionTest {
    @Test
    public void testFindNextSubstractivePair() throws Exception {

    }

    @Test
    public void testEqualsOnRomanNumber() throws Exception {
        Assert.assertTrue(C.compareTo(D) < 0);
        Assert.assertTrue(M.compareTo(D) > 0);
        Assert.assertTrue(C.compareTo(C) == 0);
    }

    @Test
    public void testCheckRuleOne() throws Exception {
        Assert.assertEquals(1,checkRuleOne("MXCI"));
        Assert.assertEquals(3,checkRuleOne("MCVIC"));
        Assert.assertEquals(-1,checkRuleOne("MCI"));
    }

    @Test
    public void testCheckRuleTwo() throws Exception {
        Assert.assertEquals(-1,checkRuleTwo("XCI"));
        Assert.assertEquals(0,checkRuleTwo("IIIIIIIIII"));
        Assert.assertEquals(1,checkRuleTwo("MXXXXXXXXXXXI"));
        Assert.assertEquals(1,checkRuleTwo("MCCCCCCI"));
        Assert.assertEquals(0,checkRuleTwo("DDDXXXXI"));
        Assert.assertEquals(2,checkRuleTwo("MCLLL"));
    }

    @Test
    public void testCheckRuleThree() throws Exception {
        Assert.assertEquals(1,checkRuleThree("XCDID"));
        Assert.assertEquals(1,checkRuleThree("XVVVI"));
        Assert.assertEquals(1,checkRuleThree("LLCI"));
        Assert.assertEquals(-1,checkRuleThree("LCI"));
    }

}