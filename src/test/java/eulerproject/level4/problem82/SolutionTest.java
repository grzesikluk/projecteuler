package eulerproject.level4.problem82;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lukasz on 2016-11-03.
 */

/**
 * Created by Lukasz on 2016-11-03.
 */
public class SolutionTest {

    int[][] array;
    int[][] convArray;

    @Before
    public void init() {
        array = new int[5][];
        array[0] = new int[]{131, 673, 234, 103, 18};
        array[1] = new int[]{201, 96, 342, 965, 150};
        array[2] = new int[]{630, 803, 746, 422, 111};
        array[3] = new int[]{537, 699, 497, 121, 956};
        array[4] = new int[]{805, 732, 524, 37, 331};
    }



    @Test
    public void testGetMinimalPath() throws Exception {
        Assert.assertEquals(994, Solution.getMinimumPath(array));
    }

}
