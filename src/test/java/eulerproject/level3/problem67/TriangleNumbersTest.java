package eulerproject.level3.problem67;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lukasz on 2016-12-13.
 */
public class TriangleNumbersTest {
    private final static String FILENAME = "src\\test\\java\\eulerproject\\level3\\problem67\\test_triangle.txt";
    private TriangleNumbers tn;

    @Before
    public void init() throws Exception {
        tn = new TriangleNumbers(FILENAME);
    }

    @Test
    public void testReadFile() throws Exception {
        List<List<Integer>> testList = new ArrayList<>();

        testList.add(Arrays.asList(3));
        testList.add(Arrays.asList(7,4));
        testList.add(Arrays.asList(2,4,6));
        testList.add(Arrays.asList(8,5,9,3));

        for(int i=0;i<testList.size();i++)
            Assert.assertEquals(testList.get(i), tn.getRow(i));

    }

    @Test
    public void testGetMaximumPath() throws Exception {
        Assert.assertEquals(23,tn.getMaximumPath());
    }

    @Test
    public void testConvertRow_noEffect() throws Exception {
        tn.convertRow(3);

        List<List<Integer>> testList = new ArrayList<>();

        testList.add(Arrays.asList(3));
        testList.add(Arrays.asList(7,4));
        testList.add(Arrays.asList(2,4,6));
        testList.add(Arrays.asList(8,5,9,3));

        for(int i=0;i<testList.size();i++)
            Assert.assertEquals(testList.get(i), tn.getRow(i));
    }

    @Test
    public void testConvertRow_First() throws Exception {
        tn.convertRow(2);

        List<List<Integer>> testList = new ArrayList<>();

        testList.add(Arrays.asList(3));
        testList.add(Arrays.asList(7,4));
        testList.add(Arrays.asList(10,13,15));
        testList.add(Arrays.asList(8,5,9,3));

        for(int i=0;i<testList.size();i++)
            Assert.assertEquals(testList.get(i), tn.getRow(i));
    }


    @Test
    public void testGetSize() throws Exception {

    }

}