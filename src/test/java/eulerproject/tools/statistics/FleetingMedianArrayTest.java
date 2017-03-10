package eulerproject.tools.statistics;

import org.junit.Assert;
import org.junit.Test;


public class FleetingMedianArrayTest {

    @Test
    public void testAdd_toEmpty() throws Exception {
        FleetingMedianArray fleetingMedianArray = new FleetingMedianArray(10);

        fleetingMedianArray.add(1);
        Assert.assertEquals(1, fleetingMedianArray.get(0));

    }

    @Test
    public void testAdd_toNext() throws Exception {
        FleetingMedianArray fleetingMedianArray = new FleetingMedianArray(10);

        fleetingMedianArray.add(2);
        fleetingMedianArray.add(1);

        Assert.assertEquals(1, fleetingMedianArray.get(0));
        Assert.assertEquals(2, fleetingMedianArray.get(1));

    }

    @Test
    public void testAdd_toNextLast() throws Exception {
        FleetingMedianArray fleetingMedianArray = new FleetingMedianArray(10);

        fleetingMedianArray.add(2);
        fleetingMedianArray.add(1);
        fleetingMedianArray.add(3);

        Assert.assertEquals(1, fleetingMedianArray.get(0));
        Assert.assertEquals(2, fleetingMedianArray.get(1));
        Assert.assertEquals(3, fleetingMedianArray.get(2));

    }

    @Test
    public void testAdd_toNextLastSmaller() throws Exception {
        FleetingMedianArray fleetingMedianArray = new FleetingMedianArray(10);

        fleetingMedianArray.add(2);
        fleetingMedianArray.add(3);
        fleetingMedianArray.add(1);

        Assert.assertEquals(1, fleetingMedianArray.get(0));
        Assert.assertEquals(2, fleetingMedianArray.get(1));
        Assert.assertEquals(3, fleetingMedianArray.get(2));

    }

    @Test
    public void testAdd_toNextInMiddleSmaller() throws Exception {
        FleetingMedianArray fleetingMedianArray = new FleetingMedianArray(10);

        fleetingMedianArray.add(4);
        fleetingMedianArray.add(3);
        fleetingMedianArray.add(1);
        fleetingMedianArray.add(2);

        Assert.assertEquals(1, fleetingMedianArray.get(0));
        Assert.assertEquals(2, fleetingMedianArray.get(1));
        Assert.assertEquals(3, fleetingMedianArray.get(2));
        Assert.assertEquals(4, fleetingMedianArray.get(3));

    }

    @Test
    public void testRemove_NotFound() throws Exception {
        FleetingMedianArray fleetingMedianArray = new FleetingMedianArray(10);


        fleetingMedianArray.add(4);
        fleetingMedianArray.add(3);
        fleetingMedianArray.add(1);
        fleetingMedianArray.add(2);

        fleetingMedianArray.remove(5);

        Assert.assertEquals(1, fleetingMedianArray.get(0));
        Assert.assertEquals(2, fleetingMedianArray.get(1));
        Assert.assertEquals(3, fleetingMedianArray.get(2));
        Assert.assertEquals(4, fleetingMedianArray.get(3));

    }

    @Test
    public void testRemove_FoundAtBeginning() throws Exception {
        FleetingMedianArray fleetingMedianArray = new FleetingMedianArray(10);

        fleetingMedianArray.add(4);
        fleetingMedianArray.add(3);
        fleetingMedianArray.add(1);
        fleetingMedianArray.add(2);

        fleetingMedianArray.remove(1);

        Assert.assertEquals(2, fleetingMedianArray.get(0));
        Assert.assertEquals(3, fleetingMedianArray.get(1));
        Assert.assertEquals(4, fleetingMedianArray.get(2));

    }

    @Test
    public void testRemove_FoundAtEnd() throws Exception {
        FleetingMedianArray fleetingMedianArray = new FleetingMedianArray(10);

        fleetingMedianArray.add(4);
        fleetingMedianArray.add(3);
        fleetingMedianArray.add(1);
        fleetingMedianArray.add(2);

        fleetingMedianArray.remove(4);

        Assert.assertEquals(1, fleetingMedianArray.get(0));
        Assert.assertEquals(2, fleetingMedianArray.get(1));
        Assert.assertEquals(3, fleetingMedianArray.get(2));

    }

    @Test
    public void testRemove_FoundMiddle() throws Exception {
        FleetingMedianArray fleetingMedianArray = new FleetingMedianArray(10);

        fleetingMedianArray.add(4);
        fleetingMedianArray.add(3);
        fleetingMedianArray.add(1);
        fleetingMedianArray.add(2);

        fleetingMedianArray.remove(3);

        Assert.assertEquals(1, fleetingMedianArray.get(0));
        Assert.assertEquals(2, fleetingMedianArray.get(1));
        Assert.assertEquals(4, fleetingMedianArray.get(2));

    }

    @Test
    public void testMedian() throws Exception {
        FleetingMedianArray fleetingMedianArray = new FleetingMedianArray(new int[]{4, 3, 1, 2, 5});
        Assert.assertEquals(3.0, fleetingMedianArray.median(), 0.0);


    }

    @Test
    public void testMedian2() throws Exception {
        FleetingMedianArray fleetingMedianArray = new FleetingMedianArray(new int[]{1, 2, 50, 50, 3, 4, 5});
        Assert.assertEquals(4.0, fleetingMedianArray.median(), 0.0);
    }

}
