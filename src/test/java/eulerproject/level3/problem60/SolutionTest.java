package eulerproject.level3.problem60;

import eulerproject.tools.primes.Primes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static eulerproject.level3.problem60.Solution.*;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class SolutionTest {


    private Primes primes;
    private static final int MAX = 1000000;

    @Before
    public void init() {
        primes = new Primes(MAX);
        primes.generatePrimes();

    }


    @Test
    public void isPrimePair1() throws Exception {
        Assert.assertTrue(Solution.isPrimePair(new Pair(3,7), primes));
        Assert.assertTrue(Solution.isPrimePair(new Pair(109,673), primes));
        Assert.assertTrue(Solution.isPrimePair(new Pair(3,109), primes));
        Assert.assertTrue(Solution.isPrimePair(new Pair(673,7), primes));

    }

    @Test
    public void isPrimePair2() throws Exception {
        Assert.assertTrue(Solution.isPrimePair(new Pair(511,811), primes));
        Assert.assertTrue(Solution.isPrimePair(new Pair(961,991), primes));
    }

    @Test
    public void isPrimePair_two() throws Exception {
        Assert.assertTrue(Solution.isPrimePair(new Pair(3,7),new Pair(109,673), primes));
        Assert.assertTrue(Solution.isPrimePair(new Pair(673,3),new Pair(109,7), primes));
        Assert.assertTrue(Solution.isPrimePair(new Pair(7,19),new Pair(97,213), primes));

    }


    @Test
    public void isPrimePairList1() throws Exception {
        List<Integer> list = Arrays.asList(3,7,109,673) ;
        Assert.assertTrue(Solution.isPrimeList(list, primes));
    }

    @Test
    public void isPrimePairList2() throws Exception {
        List<Integer> list = Arrays.asList(3,8,109,673) ;
        Assert.assertFalse(Solution.isPrimeList(list, primes));
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

    @Test
    public void testCreateInitialPrimePairSet() throws Exception {
        Primes smallPrime = new Primes(500500);
        Assert.assertEquals(12,createInitialPrimePairSet(smallPrime,30).size());
        Assert.assertEquals(100,createInitialPrimePairSet(smallPrime,100).size());
        Assert.assertEquals(1755,createInitialPrimePairSet(smallPrime,500).size());

    }

    @Test
    public void testFindChains() throws Exception {
        Primes smallPrime = new Primes(100100);
        Set<Pair> initialPairSet = createInitialPrimePairSet(smallPrime,30);

        System.out.println(initialPairSet);
        List<Set<Pair>> listOfChains = findChains(initialPairSet, initChains(initialPairSet, primes), 2, primes);

        for (Set<Pair> set:listOfChains) {
            List<Integer> list = convertToIntegerList(set);
            System.out.println(set + " " + list + " " + isPrimeList(list, smallPrime));

        }
//        System.out.println(listOfChains);


    }




}
