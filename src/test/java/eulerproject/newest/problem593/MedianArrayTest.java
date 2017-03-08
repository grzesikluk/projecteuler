package eulerproject.newest.problem593;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by grzesikl on 08/03/2017.
 */
public class MedianArrayTest {

    @Test
    public void testAdd_toEmpty() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(1.0);
        Assert.assertEquals(1.0, medianArray.get(0), 0.0);

    }

    @Test
    public void testAdd_toNext() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(2.0);
        medianArray.add(1.0);

        Assert.assertEquals(1.0, medianArray.get(0), 0.0);
        Assert.assertEquals(2.0, medianArray.get(1), 0.0);

    }

    @Test
    public void testAdd_toNextLast() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(2.0);
        medianArray.add(1.0);
        medianArray.add(3.0);

        Assert.assertEquals(1.0, medianArray.get(0), 0.0);
        Assert.assertEquals(2.0, medianArray.get(1), 0.0);
        Assert.assertEquals(3.0, medianArray.get(2), 0.0);

    }

    @Test
    public void testAdd_toNextLastSmaller() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(2.0);
        medianArray.add(3.0);
        medianArray.add(1.0);

        Assert.assertEquals(1.0, medianArray.get(0), 0.0);
        Assert.assertEquals(2.0, medianArray.get(1), 0.0);
        Assert.assertEquals(3.0, medianArray.get(2), 0.0);

    }

    @Test
    public void testAdd_toNextInMiddleSmaller() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(4.0);
        medianArray.add(3.0);
        medianArray.add(1.0);
        medianArray.add(2.0);

        Assert.assertEquals(1.0, medianArray.get(0), 0.0);
        Assert.assertEquals(2.0, medianArray.get(1), 0.0);
        Assert.assertEquals(3.0, medianArray.get(2), 0.0);
        Assert.assertEquals(4.0, medianArray.get(3), 0.0);

    }

    @Test
    public void testRemove_NotFound() throws Exception {
        MedianArray medianArray = new MedianArray(10);


        medianArray.add(4.0);
        medianArray.add(3.0);
        medianArray.add(1.0);
        medianArray.add(2.0);

        medianArray.remove(5.0);

        Assert.assertEquals(1.0, medianArray.get(0), 0.0);
        Assert.assertEquals(2.0, medianArray.get(1), 0.0);
        Assert.assertEquals(3.0, medianArray.get(2), 0.0);
        Assert.assertEquals(4.0, medianArray.get(3), 0.0);

    }

    @Test
    public void testRemove_FoundAtBeginning() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(4.0);
        medianArray.add(3.0);
        medianArray.add(1.0);
        medianArray.add(2.0);

        medianArray.remove(1.0);

        Assert.assertEquals(2.0, medianArray.get(0), 0.0);
        Assert.assertEquals(3.0, medianArray.get(1), 0.0);
        Assert.assertEquals(4.0, medianArray.get(2), 0.0);

    }

    @Test
    public void testRemove_FoundAtEnd() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(4.0);
        medianArray.add(3.0);
        medianArray.add(1.0);
        medianArray.add(2.0);

        medianArray.remove(4.0);

        Assert.assertEquals(1.0, medianArray.get(0), 0.0);
        Assert.assertEquals(2.0, medianArray.get(1), 0.0);
        Assert.assertEquals(3.0, medianArray.get(2), 0.0);

    }

    @Test
    public void testRemove_FoundMiddle() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(4.0);
        medianArray.add(3.0);
        medianArray.add(1.0);
        medianArray.add(2.0);

        medianArray.remove(3.0);

        Assert.assertEquals(1.0, medianArray.get(0), 0.0);
        Assert.assertEquals(2.0, medianArray.get(1), 0.0);
        Assert.assertEquals(4.0, medianArray.get(2), 0.0);

    }

    @Test
    public void testMedian() throws Exception {
        MedianArray medianArray = new MedianArray(new double[]{4.0, 3.0, 1.0, 2.0, 5.0});
        Assert.assertEquals(3.0, medianArray.median(), 0.0);


    }

    @Test
    public void testMedian2() throws Exception {
        MedianArray medianArray = new MedianArray(new double[]{1.0, 2.0, 50.0, 50.0, 3.0, 4.0, 5.0});
        Assert.assertEquals(4.0, medianArray.median(), 0.0);
    }

}
