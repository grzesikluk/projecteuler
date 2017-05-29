package eulerproject.level2.problem43;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

import static eulerproject.level2.problem43.ListenerImplCheck.toNumber;

/**
 * Created by Lukasz on 2016-08-28.
 */
public class ListenerImplCheckTest {

    @Test
    public void testToNumber() throws Exception {
        LinkedList<Character> list = new LinkedList<Character>();
        list.add('1'); //0
        list.add('2'); //1
        list.add('3');
        list.add('4');
        list.add('5');
        list.add('6'); //5

        Assert.assertEquals(123, toNumber(list, 0, 1, 2));
        Assert.assertEquals(23,toNumber(list,1,2));
        Assert.assertEquals(2345,toNumber(list,1,2,3,4));
        Assert.assertEquals(23456,toNumber(list,1,2,3,4,5,6));
    }

    @Test
    public void testCheck() throws Exception {
        LinkedList<Character> list = new LinkedList<Character>();

        list.add('1'); //0
        list.add('4'); //1
        list.add('0');
        list.add('6');
        list.add('3');
        list.add('5'); //5
        list.add('7'); //0
        list.add('2'); //1
        list.add('8');
        list.add('9');

        Assert.assertTrue(new ListenerImplCheck<Character>().check(list));
    }
}
