package eulerproject.problem30;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static eulerproject.problem30.Coin.*;
import static org.junit.Assert.*;

/**
 * Created by grzesikl on 25/08/2016.
 */
public class CoinTest {
    @Test
    public void testGetCoinBiggestAndLessThanVal() throws Exception {

        Assert.assertEquals(one_p,getCoinBiggestAndLessThanVal(2));
        Assert.assertEquals(two_p,getCoinBiggestAndLessThanVal(3));
        Assert.assertEquals(two_p,getCoinBiggestAndLessThanVal(5));
        Assert.assertEquals(five_p,getCoinBiggestAndLessThanVal(6));

        Assert.assertEquals(ten_p,getCoinBiggestAndLessThanVal(11));
        Assert.assertEquals(ten_p,getCoinBiggestAndLessThanVal(19));
        Assert.assertEquals(ten_p,getCoinBiggestAndLessThanVal(20));


    }

    HashSet<ArrayList<Coin>> testSet = new HashSet<>();

    @Test
    public void testGenerateSmall_one_p() throws Exception {


        testSet.clear();
        testSet.add(covertArray(new Coin[]{one_p}));
        Assert.assertEquals(testSet, generateSmall(1));

    }
    @Test
    public void testGenerateSmall_two_p() throws Exception {
        testSet.clear();
        testSet.add(covertArray(new Coin[]{one_p,one_p}));
        testSet.add(covertArray(new Coin[]{two_p}));

        Assert.assertEquals(testSet,generateSmall(2));
    }

    @Test
    public void testGenerateSmall_five_p() throws Exception {
        testSet.clear();
        testSet.add(covertArray(new Coin[]{one_p,one_p,one_p,one_p,one_p}));
        testSet.add(covertArray(new Coin[]{two_p,one_p,one_p,one_p}));
        testSet.add(covertArray(new Coin[]{two_p,two_p,one_p}));
        testSet.add(covertArray(new Coin[]{five_p}));

        Assert.assertEquals(testSet,generateSmall(5));
    }


    @Test
    public void testGenerateSmall_ten_p() throws Exception {
        testSet.clear();
        testSet.add(covertArray(new Coin[]{one_p,one_p,one_p,one_p,one_p,one_p,one_p,one_p,one_p,one_p}));
        testSet.add(covertArray(new Coin[]{two_p,one_p,one_p,one_p,one_p,one_p,one_p,one_p,one_p}));
        testSet.add(covertArray(new Coin[]{two_p,two_p,one_p,one_p,one_p,one_p,one_p,one_p}));
        testSet.add(covertArray(new Coin[]{two_p,two_p,two_p,one_p,one_p,one_p,one_p}));
        testSet.add(covertArray(new Coin[]{two_p,two_p,two_p,two_p,one_p,one_p}));
        testSet.add(covertArray(new Coin[]{two_p,two_p,two_p,two_p,two_p}));
        testSet.add(covertArray(new Coin[]{five_p,one_p,one_p,one_p,one_p,one_p}));
        testSet.add(covertArray(new Coin[]{five_p,two_p,one_p,one_p,one_p}));
        testSet.add(covertArray(new Coin[]{five_p,two_p,two_p,one_p}));
        testSet.add(covertArray(new Coin[]{five_p,five_p}));
        testSet.add(covertArray(new Coin[]{ten_p}));

        Assert.assertEquals(testSet,generateSmall(10));
    }
}