package eulerproject.tools;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static eulerproject.tools.StringHelper.convertToCharList;
import static eulerproject.tools.StringHelper.findPeriodInSubstring;
import static eulerproject.tools.StringHelper.isPermutation;


/**
 * Created by Lukasz on 2016-11-08.
 */
public class StringHelperTest {
    @Test
    public void testFindPeriodInSubstring1() throws Exception {

        Assert.assertEquals("123", findPeriodInSubstring("4123123123123123123123123123123123123", 1));
    }

    @Test
    public void testFindPeriodInSubstring2() throws Exception {
        Assert.assertEquals("", findPeriodInSubstring("41224351627381922243516273819203103112243516273819222435162738192031031", 1));
    }

    @Test
    public void testFindPeriodInSubstring3() throws Exception {
        Assert.assertEquals("1", findPeriodInSubstring("4111111111111", 1));
    }

    @Test
    public void testFindPeriodInSubstring4() throws Exception {
        Assert.assertEquals("41", findPeriodInSubstring("414141414141414141414141", 0));
    }

    @Test
    public void testFindPeriodInSubstring5() throws Exception {
        Assert.assertEquals("141", findPeriodInSubstring("141141141141141141141141141141141141", 0));
    }

    @Test
    public void testFindPeriodInSubstring6() throws Exception {
        Assert.assertEquals("1114", findPeriodInSubstring("111411141114111411141114111411141114111411141114111411141114111411141114111411141114111411141114111411141114111411141114", 0));
    }

    @Test
    public void testFindPeriodInSubstring7() throws Exception {
        Assert.assertEquals("11116", findPeriodInSubstring("3111161111611116111161111611116111161111611116111161111611116111161111611116111161111611116111161111", 1));
    }

    @Test
    public void testFindPeriodInSubstring8() throws Exception {
        Assert.assertEquals("11111114", findPeriodInSubstring("711111114111111141111111411111114111111141111111411111114111111141111111411111114111111141111111411111114111111141", 1));
    }

    @Test
    public void testFindPeriodInSubstring9() throws Exception {
        Assert.assertEquals("214", findPeriodInSubstring("72142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142142", 1));
    }

    @Test
    public void testFindPeriodInSubstring10() throws Exception {
        Assert.assertEquals("11146411118", findPeriodInSubstring("91114641111811146411118111464111181114641111811146411118111464111181114641111811146411118111464111181114641111811146411118", 1));
    }

    @Test
    public void testFindPeriodInSubstring11() throws Exception {
        Assert.assertEquals("121411111029921011114211198", findPeriodInSubstring("99121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211198121411111029921011114211", 1));
    }



    @Test
    public void testIsPermutation() throws Exception {

        Assert.assertTrue(isPermutation("asdf","adfs"));
        Assert.assertTrue(isPermutation("1234","4321"));
        Assert.assertTrue(isPermutation("111234","121314"));

    }

    @Test
    public void testConvertToCharList() throws Exception {
        LinkedList<Character> list =   new LinkedList<Character>();
        list.addAll(Arrays.asList('a','b','c','d'));

        Assert.assertEquals(list,convertToCharList(new char[]{'a','b','c','d'}));

    }

}

