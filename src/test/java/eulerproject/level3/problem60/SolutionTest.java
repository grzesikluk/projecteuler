package eulerproject.level3.problem60;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class SolutionTest {


    @Test
    public void isPrimePair1() throws Exception {
        Assert.assertTrue(Solution.isPrimePair(new Pair(3,7)));
        Assert.assertTrue(Solution.isPrimePair(new Pair(109,673)));
        Assert.assertTrue(Solution.isPrimePair(new Pair(3,109)));
        Assert.assertTrue(Solution.isPrimePair(new Pair(673,7)));

    }

    @Test
    public void isPrimePair2() throws Exception {
        Assert.assertTrue(Solution.isPrimePair(new Pair(511,811)));
        Assert.assertTrue(Solution.isPrimePair(new Pair(961,991)));
    }

    @Test
    public void isPrimePair_two() throws Exception {
        Assert.assertTrue(Solution.isPrimePair(new Pair(3,7),new Pair(109,673)));
        Assert.assertTrue(Solution.isPrimePair(new Pair(673,3),new Pair(109,7)));
        Assert.assertTrue(Solution.isPrimePair(new Pair(7,19),new Pair(97,213)));

    }


    @Test
    public void isPrimePairList1() throws Exception {
        List<Integer> list = Arrays.asList(3,7,109,673) ;
        Assert.assertTrue(Solution.isPrimeList(list));
    }

    @Test
    public void isPrimePairList2() throws Exception {
        List<Integer> list = Arrays.asList(3,8,109,673) ;
        Assert.assertFalse(Solution.isPrimeList(list));
    }


    @Test
    public void convertToList() throws Exception {
        List<Pair> list = Arrays.asList(new Pair(3,5), new Pair(4,5), new Pair(10,3));
        Assert.assertEquals(Arrays.asList(3,4,5,10),Solution.convertToIntegerList(list));

    }

    @Test
    public void countPrimeHits() throws Exception {
        List<Integer> list = Arrays.asList(3,7,109,673) ;
        Assert.assertEquals(6,Solution.countPrimeHits(list));
    }


}