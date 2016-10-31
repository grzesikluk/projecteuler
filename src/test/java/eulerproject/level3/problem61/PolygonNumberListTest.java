package eulerproject.level3.problem61;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static eulerproject.level3.problem61.Polygonals.initPolygonals;

/**
 * Created by Lukasz on 2016-10-31.
 */
public class PolygonNumberListTest {
    PolygonNumberList exc;

    @Before
    public void init() {
        exc = new PolygonNumberList();
        initPolygonals();
    }

    @Test
    public void getNextPolygonalNumber() throws Exception {


        exc.add(new PolygonNumber(PolygonNumber.polyTypes.TRI,8128));
        Assert.assertTrue(exc.getNextPolygonalNumberLists().get(PolygonNumber.polyTypes.PEN).contains(new PolygonNumber(PolygonNumber.polyTypes.PEN,2882)));
        exc.clear();

        exc.add( new PolygonNumber(PolygonNumber.polyTypes.PEN,2882));
        Assert.assertTrue(exc.getNextPolygonalNumberLists().get(PolygonNumber.polyTypes.SQU).contains(new PolygonNumber(PolygonNumber.polyTypes.SQU,8281)));
        exc.clear();

        exc.add( new PolygonNumber(PolygonNumber.polyTypes.SQU,8281));
        Assert.assertTrue(exc.getNextPolygonalNumberLists().get(PolygonNumber.polyTypes.TRI).contains(new PolygonNumber(PolygonNumber.polyTypes.TRI,8128)));
        exc.clear();

    }

    @Test
    public void testGetNextPolygonalList() throws Exception {

        exc.add(new PolygonNumber(PolygonNumber.polyTypes.TRI,8128));
        System.out.println(exc.getListOfNextPolygonalLists());
        exc.clear();
    }

    @Test
    public void testIsCyclic() {

        exc.add(new PolygonNumber(PolygonNumber.polyTypes.TRI,1223));
        exc.add(new PolygonNumber(PolygonNumber.polyTypes.SQU,2334));
        exc.add(new PolygonNumber(PolygonNumber.polyTypes.PEN,3445));
        exc.add(new PolygonNumber(PolygonNumber.polyTypes.HEX,4556));
        exc.add(new PolygonNumber(PolygonNumber.polyTypes.HEP,5667));
        exc.add(new PolygonNumber(PolygonNumber.polyTypes.OCT,6712));

        Assert.assertTrue(exc.isCyclic());
        exc.clear();

        exc.add(new PolygonNumber(PolygonNumber.polyTypes.TRI,1223));
        exc.add(new PolygonNumber(PolygonNumber.polyTypes.SQU,2334));
        exc.add(new PolygonNumber(PolygonNumber.polyTypes.PEN,3445));
        exc.add(new PolygonNumber(PolygonNumber.polyTypes.HEX,4556));
        exc.add(new PolygonNumber(PolygonNumber.polyTypes.OCT,6712));

        Assert.assertFalse(exc.isCyclic());
        exc.clear();

        exc.add(new PolygonNumber(PolygonNumber.polyTypes.TRI,1223));
        exc.add(new PolygonNumber(PolygonNumber.polyTypes.SQU,2334));
        exc.add(new PolygonNumber(PolygonNumber.polyTypes.PEN,3445));
        exc.add(new PolygonNumber(PolygonNumber.polyTypes.HEX,4556));
        exc.add(new PolygonNumber(PolygonNumber.polyTypes.OCT,6711));

        Assert.assertFalse(exc.isCyclic());
        exc.clear();

    }


}