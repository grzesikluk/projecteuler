package eulerproject.problem49;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

import static eulerproject.problem49.ListenerImplCheckProblem49.toNumber;

/**
 * Created by grzesikl on 09/09/2016.
 */
public class ListenerImplCheckProblem49Test {
    @Test
    public void testToNumber() throws Exception {
        LinkedList<Character> testList = new LinkedList<>();
        testList.add('1');
        testList.add('2');
        testList.add('5');

        Assert.assertEquals(125,toNumber(testList));

    }

}