package eulerproject.level4.problem82;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static eulerproject.level4.problem82.Solution.*;

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

        //just copy the array
        convArray = new int[5][5];
        copyArray(array, convArray);
    }

    @Test
    public void testConvertColumnTopDown_col4() {
        copyArray(array, convArray);
        convertColumnTopDown(convArray, 4);

        Assert.assertArrayEquals(new int[]{131, 673, 234, 103, 18}, convArray[0]);
        Assert.assertArrayEquals(new int[]{201, 96, 342, 965, 150}, convArray[1]);
        Assert.assertArrayEquals(new int[]{630, 803, 746, 422, 111}, convArray[2]);
        Assert.assertArrayEquals(new int[]{537, 699, 497, 121, 956}, convArray[3]);
        Assert.assertArrayEquals(new int[]{805, 732, 524, 37, 331}, convArray[4]);

    }

    @Test
    public void testConvertColumnTopDown_col3() {
        copyArray(array, convArray);
        convertColumnTopDown(convArray, 3);

        Assert.assertArrayEquals(new int[]{131, 673, 234,  121, 18}, convArray[0]);
        Assert.assertArrayEquals(new int[]{201, 96, 342,  1086, 150}, convArray[1]);
        Assert.assertArrayEquals(new int[]{630, 803, 746,  533, 111}, convArray[2]);
        Assert.assertArrayEquals(new int[]{537, 699, 497,  654, 956}, convArray[3]);
        Assert.assertArrayEquals(new int[]{805, 732, 524,  368, 331}, convArray[4]);

    }

    @Test
    public void testConvertColumnTopDown_col2() {
        copyArray(array, convArray);
        convertColumnTopDown(convArray, 2);

        Assert.assertArrayEquals(new int[]{131, 673,  337, 103, 18}, convArray[0]);
        Assert.assertArrayEquals(new int[]{201, 96,   679, 965, 150}, convArray[1]);
        Assert.assertArrayEquals(new int[]{630, 803, 1168, 422, 111}, convArray[2]);
        Assert.assertArrayEquals(new int[]{537, 699,  618, 121, 956}, convArray[3]);
        Assert.assertArrayEquals(new int[]{805, 732,  561, 37, 331}, convArray[4]);

    }


    @Test
    public void testConvertColumnBottomUp_col4() {
        copyArray(array, convArray);
        convertColumnBottomUp(convArray, 4);

        Assert.assertArrayEquals(new int[]{131, 673, 234, 103, 18}, convArray[0]);
        Assert.assertArrayEquals(new int[]{201, 96, 342, 965, 150}, convArray[1]);
        Assert.assertArrayEquals(new int[]{630, 803, 746, 422, 111}, convArray[2]);
        Assert.assertArrayEquals(new int[]{537, 699, 497, 121, 956}, convArray[3]);
        Assert.assertArrayEquals(new int[]{805, 732, 524, 37, 331}, convArray[4]);

    }

    @Test
    public void testConvertColumnBottomUp_col3() {
        copyArray(array, convArray);
        convertColumnBottomUp(convArray, 3);

        Assert.assertArrayEquals(new int[]{131, 673, 234, 121, 18}, convArray[0]);
        Assert.assertArrayEquals(new int[]{201, 96, 342,  1115, 150}, convArray[1]);
        Assert.assertArrayEquals(new int[]{630, 803, 746, 533, 111}, convArray[2]);
        Assert.assertArrayEquals(new int[]{537, 699, 497, 489, 956}, convArray[3]);
        Assert.assertArrayEquals(new int[]{805, 732, 524, 368, 331}, convArray[4]);

    }

    @Test
    public void testGetMinimalPath() throws Exception {

//        Assert.assertEquals(994, getMinimalPath(array));
    }

}
