package eulerproject.level4.problem89;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2016-11-05.
 */
public class SolutionTest {


    @Test
    public void testOptimiseRomanNumber() throws Exception {

        Assert.assertEquals("XXV", Solution.optimiseRomanNumber("XXIIIII"));
        Assert.assertEquals("XXV", Solution.optimiseRomanNumber("XVVV"));
        Assert.assertEquals("MCLX", Solution.optimiseRomanNumber("MCXXXXXX"));
        Assert.assertEquals("MDLX", Solution.optimiseRomanNumber("MCCCCCXXXXXX"));
//        Assert.assertEquals("IX",optimiseRomanNumber("VIIII"));

    }


    @Test
    public void testEqualsOnRomanNumber() throws Exception {
        Assert.assertTrue(Solution.RomanNumbers.C.compareTo(Solution.RomanNumbers.D) < 0);
        Assert.assertTrue(Solution.RomanNumbers.M.compareTo(Solution.RomanNumbers.D) > 0);
        Assert.assertTrue(Solution.RomanNumbers.C.compareTo(Solution.RomanNumbers.C) == 0);
    }

    @Test
    public void testCheckRuleOne() throws Exception {
        Assert.assertEquals(1, Solution.checkRuleOne("MXCI"));
        Assert.assertEquals(3, Solution.checkRuleOne("MCVIC"));
        Assert.assertEquals(-1, Solution.checkRuleOne("MCI"));
    }

    @Test
    public void testCheckRuleTwo() throws Exception {
        Assert.assertEquals(-1, Solution.checkRuleTwo("XCI"));
        Assert.assertEquals(0, Solution.checkRuleTwo("IIIIIIIIII"));
        Assert.assertEquals(1, Solution.checkRuleTwo("MXXXXXXXXXXXI"));
        Assert.assertEquals(1, Solution.checkRuleTwo("MCCCCCCI"));
        Assert.assertEquals(0, Solution.checkRuleTwo("DDDXXXXI"));
        Assert.assertEquals(2, Solution.checkRuleTwo("MCLLL"));
    }

    @Test
    public void testCheckRuleThree() throws Exception {
        Assert.assertEquals(1, Solution.checkRuleThree("XCDID"));
        Assert.assertEquals(1, Solution.checkRuleThree("XVVVI"));
        Assert.assertEquals(1, Solution.checkRuleThree("LLCI"));
        Assert.assertEquals(-1, Solution.checkRuleThree("LCI"));
    }

    /**
     * I can only be placed before V and X.
     X can only be placed before L and C.
     C can only be placed before D and M.
     * @throws Exception
     */
    @Test
    public void testCheckRuleFour() throws Exception {
        Assert.assertEquals(-1, Solution.checkRuleFour("XXIX"));
        Assert.assertEquals(-1, Solution.checkRuleFour("XXIV"));
        Assert.assertEquals(-1, Solution.checkRuleFour("MCXL"));
        Assert.assertEquals(-1, Solution.checkRuleFour("MCXC"));
        Assert.assertEquals(-1, Solution.checkRuleFour("MCDXX"));
        Assert.assertEquals(-1, Solution.checkRuleFour("MCMCDXX"));

        Assert.assertEquals(1, Solution.checkRuleFour("XVXI"));
        Assert.assertEquals(1, Solution.checkRuleFour("LIL"));
        Assert.assertEquals(2, Solution.checkRuleFour("MCVC"));
        Assert.assertEquals(2, Solution.checkRuleFour("MCIL"));
        Assert.assertEquals(1, Solution.checkRuleFour("MLMCDXX"));
        Assert.assertEquals(1, Solution.checkRuleFour("MDMCDXX"));
        Assert.assertEquals(4, Solution.checkRuleFour("MMMMVMCDXX"));
    }

    @Test
    public void testCheckRuleFive() throws Exception {
        Assert.assertEquals(2, Solution.checkRuleFive("MCVIIII"));
        Assert.assertEquals(4, Solution.checkRuleFive("MMMMDCCCCVII"));
        Assert.assertEquals(0, Solution.checkRuleFive("IIIIIIII"));
        Assert.assertEquals(4, Solution.checkRuleFive("IIIIIIII"));


    }
}