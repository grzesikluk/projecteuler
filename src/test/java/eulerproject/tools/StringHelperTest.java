package eulerproject.tools;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static eulerproject.tools.StringHelper.convertToCharList;
import static eulerproject.tools.StringHelper.isPermutation;


/**
 * Created by Lukasz on 2016-11-08.
 */
public class StringHelperTest {

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

