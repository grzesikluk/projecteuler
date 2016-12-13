package eulerproject.level4.problem81;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static eulerproject.level4.problem81.Solution.*;

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
    public void testUpdateField_lastField() {
        copyArray(array, convArray);
        updateField(convArray.length - 1, convArray.length - 1, convArray);

        Assert.assertArrayEquals(new int[]{131, 673, 234, 103, 18}, convArray[0]);
        Assert.assertArrayEquals(new int[]{201, 96, 342, 965, 150}, convArray[1]);
        Assert.assertArrayEquals(new int[]{630, 803, 746, 422, 111}, convArray[2]);
        Assert.assertArrayEquals(new int[]{537, 699, 497, 121, 956}, convArray[3]);
        Assert.assertArrayEquals(new int[]{805, 732, 524, 37, 331}, convArray[4]);

    }

    @Test
    public void testUpdateField_xAxisUpdate() {
        copyArray(array, convArray);
        updateField(4, 3, convArray);

        Assert.assertArrayEquals(new int[]{131, 673, 234, 103, 18}, convArray[0]);
        Assert.assertArrayEquals(new int[]{201, 96, 342, 965, 150}, convArray[1]);
        Assert.assertArrayEquals(new int[]{630, 803, 746, 422, 111}, convArray[2]);
        Assert.assertArrayEquals(new int[]{537, 699, 497, 121, 1287}, convArray[3]);
        Assert.assertArrayEquals(new int[]{805, 732, 524, 37, 331}, convArray[4]);
    }

    @Test
    public void testUpdateField_yAxisUpdate() {
        copyArray(array, convArray);
        updateField(3, 4, convArray);

        Assert.assertArrayEquals(new int[]{131, 673, 234, 103, 18}, convArray[0]);
        Assert.assertArrayEquals(new int[]{201, 96, 342, 965, 150}, convArray[1]);
        Assert.assertArrayEquals(new int[]{630, 803, 746, 422, 111}, convArray[2]);
        Assert.assertArrayEquals(new int[]{537, 699, 497, 121, 956}, convArray[3]);
        Assert.assertArrayEquals(new int[]{805, 732, 524, 368, 331}, convArray[4]);

    }

    @Test

    public void testUpdateField_NormalField() {
        copyArray(array, convArray);
        updateField(3, 3, convArray);

        Assert.assertArrayEquals(new int[]{131, 673, 234, 103, 18}, convArray[0]);
        Assert.assertArrayEquals(new int[]{201, 96, 342, 965, 150}, convArray[1]);
        Assert.assertArrayEquals(new int[]{630, 803, 746, 422, 111}, convArray[2]);
        Assert.assertArrayEquals(new int[]{537, 699, 497, 158, 956}, convArray[3]);
        Assert.assertArrayEquals(new int[]{805, 732, 524, 37, 331}, convArray[4]);

    }

    @Test
    public void testUpdateField_FirstField() {
        copyArray(array, convArray);
        updateField(0, 0, convArray);

        Assert.assertArrayEquals(new int[]{332, 673, 234, 103, 18}, convArray[0]);
        Assert.assertArrayEquals(new int[]{201, 96, 342, 965, 150}, convArray[1]);
        Assert.assertArrayEquals(new int[]{630, 803, 746, 422, 111}, convArray[2]);
        Assert.assertArrayEquals(new int[]{537, 699, 497, 121, 956}, convArray[3]);
        Assert.assertArrayEquals(new int[]{805, 732, 524, 37, 331}, convArray[4]);

    }

    @Test
    public void testUpdateField_yAxisZeroField() {
        copyArray(array, convArray);
        updateField(1, 0, convArray);

        Assert.assertArrayEquals(new int[]{131, 769, 234, 103, 18}, convArray[0]);
        Assert.assertArrayEquals(new int[]{201, 96, 342, 965, 150}, convArray[1]);
        Assert.assertArrayEquals(new int[]{630, 803, 746, 422, 111}, convArray[2]);
        Assert.assertArrayEquals(new int[]{537, 699, 497, 121, 956}, convArray[3]);
        Assert.assertArrayEquals(new int[]{805, 732, 524, 37, 331}, convArray[4]);

    }

    @Test
    public void testUpdateField_xAxisZeroField() {
        copyArray(array, convArray);
        updateField(0, 3, convArray);

        Assert.assertArrayEquals(new int[]{131, 673, 234, 103, 18}, convArray[0]);
        Assert.assertArrayEquals(new int[]{201, 96, 342, 965, 150}, convArray[1]);
        Assert.assertArrayEquals(new int[]{630, 803, 746, 422, 111}, convArray[2]);
        Assert.assertArrayEquals(new int[]{1236, 699, 497, 121, 956}, convArray[3]);
        Assert.assertArrayEquals(new int[]{805, 732, 524, 37, 331}, convArray[4]);

    }

    @Test
    public void testUpdateField_yAxisZeroField2() {
        copyArray(array, convArray);
        updateField(1, 0, convArray);

        Assert.assertArrayEquals(new int[]{131, 769, 234, 103, 18}, convArray[0]);
        Assert.assertArrayEquals(new int[]{201, 96, 342, 965, 150}, convArray[1]);
        Assert.assertArrayEquals(new int[]{630, 803, 746, 422, 111}, convArray[2]);
        Assert.assertArrayEquals(new int[]{537, 699, 497, 121, 956}, convArray[3]);
        Assert.assertArrayEquals(new int[]{805, 732, 524, 37, 331}, convArray[4]);

    }

    @Test
    public void testCreateConvArray() {
        int[][] convArray = createConvertArray(array);

        Assert.assertArrayEquals(new int[]{2427, 2576, 1903, 1669, 1566}, convArray[0]);
        Assert.assertArrayEquals(new int[]{2296, 2095, 1999, 1876, 1548}, convArray[1]);
        Assert.assertArrayEquals(new int[]{2852, 2460, 1657, 911, 1398}, convArray[2]);
        Assert.assertArrayEquals(new int[]{2222, 1685, 986, 489, 1287}, convArray[3]);
        Assert.assertArrayEquals(new int[]{2429, 1624, 892, 368, 331}, convArray[4]);

    }


    @Test
    public void testGetMinimalPath() throws Exception {

        Assert.assertEquals(2427, getMinimalPath(array));
    }

}
