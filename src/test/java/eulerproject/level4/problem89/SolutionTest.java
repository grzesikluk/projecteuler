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
    public void testOptimiseRomanNumber() throws Exception {

        Assert.assertEquals("XXV",optimiseRomanNumber("XXIIIII"));
        Assert.assertEquals("XXV",optimiseRomanNumber("XVVV"));
        Assert.assertEquals("MCLX",optimiseRomanNumber("MCXXXXXX"));
        Assert.assertEquals("MDLX",optimiseRomanNumber("MCCCCCXXXXXX"));
//        Assert.assertEquals("IX",optimiseRomanNumber("VIIII"));

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

    /**
     * I can only be placed before V and X.
     X can only be placed before L and C.
     C can only be placed before D and M.
     * @throws Exception
     */
    @Test
    public void testCheckRuleFour() throws Exception {
        Assert.assertEquals(-1,checkRuleFour("XXIX"));
        Assert.assertEquals(-1,checkRuleFour("XXIV"));
        Assert.assertEquals(-1,checkRuleFour("MCXL"));
        Assert.assertEquals(-1,checkRuleFour("MCXC"));
        Assert.assertEquals(-1,checkRuleFour("MCDXX"));
        Assert.assertEquals(-1,checkRuleFour("MCMCDXX"));

        Assert.assertEquals(1,checkRuleFour("XVXI"));
        Assert.assertEquals(1,checkRuleFour("LIL"));
        Assert.assertEquals(2,checkRuleFour("MCVC"));
        Assert.assertEquals(2,checkRuleFour("MCIL"));
        Assert.assertEquals(1,checkRuleFour("MLMCDXX"));
        Assert.assertEquals(1,checkRuleFour("MDMCDXX"));
        Assert.assertEquals(4,checkRuleFour("MMMMVMCDXX"));
    }

    @Test
    public void testCheckRuleFive() throws Exception {
        Assert.assertEquals(2,checkRuleFive("MCVIIII"));
        Assert.assertEquals(4,checkRuleFive("MMMMDCCCCVII"));
        Assert.assertEquals(0,checkRuleFive("IIIIIIII"));
        Assert.assertEquals(4,checkRuleFive("IIIIIIII"));


    }
}