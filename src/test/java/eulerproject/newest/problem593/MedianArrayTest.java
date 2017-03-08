package eulerproject.newest.problem593;

import org.junit.Assert;
import org.junit.Test;


public class MedianArrayTest {

    @Test
    public void testAdd_toEmpty() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(1);
        Assert.assertEquals(1, medianArray.get(0));

    }

    @Test
    public void testAdd_toNext() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(2);
        medianArray.add(1);

        Assert.assertEquals(1, medianArray.get(0));
        Assert.assertEquals(2, medianArray.get(1));

    }

    @Test
    public void testAdd_toNextLast() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(2);
        medianArray.add(1);
        medianArray.add(3);

        Assert.assertEquals(1, medianArray.get(0));
        Assert.assertEquals(2, medianArray.get(1));
        Assert.assertEquals(3, medianArray.get(2));

    }

    @Test
    public void testAdd_toNextLastSmaller() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(2);
        medianArray.add(3);
        medianArray.add(1);

        Assert.assertEquals(1, medianArray.get(0));
        Assert.assertEquals(2, medianArray.get(1));
        Assert.assertEquals(3, medianArray.get(2));

    }

    @Test
    public void testAdd_toNextInMiddleSmaller() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(4);
        medianArray.add(3);
        medianArray.add(1);
        medianArray.add(2);

        Assert.assertEquals(1, medianArray.get(0));
        Assert.assertEquals(2, medianArray.get(1));
        Assert.assertEquals(3, medianArray.get(2));
        Assert.assertEquals(4, medianArray.get(3));

    }

    @Test
    public void testRemove_NotFound() throws Exception {
        MedianArray medianArray = new MedianArray(10);


        medianArray.add(4);
        medianArray.add(3);
        medianArray.add(1);
        medianArray.add(2);

        medianArray.remove(5);

        Assert.assertEquals(1, medianArray.get(0));
        Assert.assertEquals(2, medianArray.get(1));
        Assert.assertEquals(3, medianArray.get(2));
        Assert.assertEquals(4, medianArray.get(3));

    }

    @Test
    public void testRemove_FoundAtBeginning() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(4);
        medianArray.add(3);
        medianArray.add(1);
        medianArray.add(2);

        medianArray.remove(1);

        Assert.assertEquals(2, medianArray.get(0));
        Assert.assertEquals(3, medianArray.get(1));
        Assert.assertEquals(4, medianArray.get(2));

    }

    @Test
    public void testRemove_FoundAtEnd() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(4);
        medianArray.add(3);
        medianArray.add(1);
        medianArray.add(2);

        medianArray.remove(4);

        Assert.assertEquals(1, medianArray.get(0));
        Assert.assertEquals(2, medianArray.get(1));
        Assert.assertEquals(3, medianArray.get(2));

    }

    @Test
    public void testRemove_FoundMiddle() throws Exception {
        MedianArray medianArray = new MedianArray(10);

        medianArray.add(4);
        medianArray.add(3);
        medianArray.add(1);
        medianArray.add(2);

        medianArray.remove(3);

        Assert.assertEquals(1, medianArray.get(0));
        Assert.assertEquals(2, medianArray.get(1));
        Assert.assertEquals(4, medianArray.get(2));

    }

    @Test
    public void testMedian() throws Exception {
        MedianArray medianArray = new MedianArray(new int[]{4, 3, 1, 2, 5});
        Assert.assertEquals(3.0, medianArray.median(), 0.0);


    }

    @Test
    public void testMedian2() throws Exception {
        MedianArray medianArray = new MedianArray(new int[]{1, 2, 50, 50, 3, 4, 5});
        Assert.assertEquals(4.0, medianArray.median(), 0.0);
    }

}
