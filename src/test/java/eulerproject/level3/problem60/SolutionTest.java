package eulerproject.level3.problem60;

import eulerproject.tools.primes.Primes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class SolutionTest {


    private Primes primes;
    private static final int MAX = 1000000;

    @Before
    public void init() {
        primes = new Primes(MAX);
        primes.init();

    }


    @Test
    public void isPrimePair_one() throws Exception {
        Assert.assertTrue(Solution.isPrimePair(new Pair(3, 7)));
        Assert.assertTrue(Solution.isPrimePair(new Pair(109, 673)));
        Assert.assertTrue(Solution.isPrimePair(new Pair(3, 109)));
        Assert.assertTrue(Solution.isPrimePair(new Pair(673, 7)));

    }


    @Test
    public void isPrimePairList_true() throws Exception {
        List<Integer> list = Arrays.asList(3, 7, 109, 673);
        Assert.assertTrue(Solution.isPrimeList(list));
    }

    @Test
    public void isPrimePairList_false() throws Exception {
        List<Integer> list = Arrays.asList(3, 8, 109, 673);
        Assert.assertFalse(Solution.isPrimeList(list));
    }


    @Test
    public void convertToList() throws Exception {
        List<Pair> list = Arrays.asList(new Pair(3, 5), new Pair(4, 5), new Pair(10, 3));
        Assert.assertEquals(Arrays.asList(3, 4, 5, 10), Solution.convertToIntegerList(list));

    }

    @Test
    public void countPrimeHits() throws Exception {
        List<Integer> list = Arrays.asList(3, 7, 109, 673);
        Assert.assertEquals(6, Solution.countPrimeHits(list));
    }


    @Test(timeout = 100000)
    public void testCreateInitialPrimePairSet1() throws Exception {
        Primes primes = new Primes(100);
        primes.init();

        Solution.createInitialPrimePairSet(primes.asList());
    }


}
