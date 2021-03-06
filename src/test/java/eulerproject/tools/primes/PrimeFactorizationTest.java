package eulerproject.tools.primes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lukasz on 2016-11-21.
 */
public class PrimeFactorizationTest {
    private Primes primes;
    public static long MAX = 1000000L;
    public static int MAX_PRIME = 1000_000;

    @Before
    public void init() {
        primes = new Primes(MAX_PRIME);
        primes.init();
    }

    @Test
    public void getPrimeFactors1() throws Exception {
        Assert.assertArrayEquals(new long[]{3, 5}, PrimeFactorization.getPrimeFactors(15, primes));
    }

    @Test
    public void getPrimeFactors2() throws Exception {
        Assert.assertArrayEquals(new long[]{2, 2, 2, 3, 3, 5}, PrimeFactorization.getPrimeFactors(360, primes));
    }

    @Test
    public void getPrimeFactors3() throws Exception {
        Assert.assertArrayEquals(new long[]{2, 2, 2, 5, 5, 5}, PrimeFactorization.getPrimeFactors(1000, primes));
    }

    @Test
    public void getPrimeFactors4() throws Exception {
        Assert.assertArrayEquals(new long[]{17}, PrimeFactorization.getPrimeFactors(17, primes));
    }

    @Test
    public void getPrimeFactorsWithPower1() throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 1);
        map.put(5, 1);

        Assert.assertEquals(map, PrimeFactorization.getPrimeFactorsWithPower(15, primes));

    }


    @Test
    public void getPrimeFactorsWithPower2() throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 3);
        map.put(3, 2);
        map.put(5, 1);

        Assert.assertEquals(map, PrimeFactorization.getPrimeFactorsWithPower(360, primes));
    }


    @Test
    public void getPrimeFactorsWithPower3() throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 1);

        Assert.assertEquals(map, PrimeFactorization.getPrimeFactorsWithPower(3, primes));
    }



    @Test
    public void getPrimeFactorsWithPower4() throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 6);
        map.put(5, 6);

        Primes bigPrimes = new Primes(2000_000);
        bigPrimes.init();

        Assert.assertEquals(map, PrimeFactorization.getPrimeFactorsWithPower(1000_000, bigPrimes));
    }


    @Test
    public void getNumberFromFactorMap1() throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 3);
        map.put(3, 2);
        map.put(5, 1);


        Assert.assertEquals(360L, PrimeFactorization.getNumberFromFactorMap(map));

    }

    @Test
    public void getNumberFromFactorMap2() throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 1);
        map.put(5, 1);


        Assert.assertEquals(15L, PrimeFactorization.getNumberFromFactorMap(map));

    }


    @Test
    public void isDecreasingFactorized() throws Exception {
        Assert.assertTrue(PrimeFactorization.isIncreasingFactorized(0, primes));
        Assert.assertTrue(PrimeFactorization.isIncreasingFactorized(1, primes));
        Assert.assertTrue(PrimeFactorization.isIncreasingFactorized(7, primes));
        Assert.assertTrue(PrimeFactorization.isIncreasingFactorized(9, primes));

        Assert.assertTrue(PrimeFactorization.isIncreasingFactorized(10, primes));
        Assert.assertTrue(PrimeFactorization.isIncreasingFactorized(91, primes));
        Assert.assertTrue(PrimeFactorization.isIncreasingFactorized(19, primes));
        Assert.assertTrue(PrimeFactorization.isIncreasingFactorized(60, primes));
    }

    @Test
    public void isDecreasingFactorized2() throws Exception {
        Assert.assertFalse(PrimeFactorization.isIncreasingFactorized(18, primes));
        Assert.assertFalse(PrimeFactorization.isIncreasingFactorized(50, primes));
        Assert.assertFalse(PrimeFactorization.isIncreasingFactorized(54, primes));
        Assert.assertFalse(PrimeFactorization.isIncreasingFactorized(75, primes));
        Assert.assertFalse(PrimeFactorization.isIncreasingFactorized(90, primes));
        Assert.assertFalse(PrimeFactorization.isIncreasingFactorized(98, primes));
        Assert.assertFalse(PrimeFactorization.isIncreasingFactorized(162, primes));

    }

    @Test
    public void isDecreasingFactorized3() throws Exception {
        Assert.assertTrue(PrimeFactorization.isIncreasingFactorized(MAX, primes));

    }


    @Test
    public void testGgetPAdicValuationPrimes() throws Exception {
        Map<Long, Long> expected = new HashMap<>();

        expected.put(2L, 1L);
        Assert.assertEquals(expected, PrimeFactorization.getPAdicValuationPrimes(2));
        expected.clear();

        expected.put(2L, 1L);
        expected.put(3L, 1L);
        Assert.assertEquals(expected, PrimeFactorization.getPAdicValuationPrimes(3));
        expected.clear();
    }

    @Test
    public void testGgetPAdicValuationPrimes2() throws Exception {
        Map<Long, Long> expected = new HashMap<>();
        expected.put(2L, 3L);
        expected.put(3L, 1L);
        Assert.assertEquals(expected, PrimeFactorization.getPAdicValuationPrimes(4));
        expected.clear();
    }

    @Test
    public void testGgetPAdicValuationPrimes3() throws Exception {
        Map<Long, Long> expected = new HashMap<>();

        expected.put(2L, 3L);
        expected.put(3L, 1L);
        expected.put(5L, 1L);
        Assert.assertEquals(expected, PrimeFactorization.getPAdicValuationPrimes(5));
        expected.clear();
    }
    @Test
    public void testGetDivisorsSum() throws Exception
    {
        Assert.assertEquals(28, PrimeFactorization.getSumOfProperDivisors(28, primes.toArray()));
        Assert.assertEquals(284, PrimeFactorization.getSumOfProperDivisors(220, primes.toArray()));
        Assert.assertEquals(220, PrimeFactorization.getSumOfProperDivisors(284, primes.toArray()));
    }


    @Test
    public void testGetSumOfDivisorsForFactorial() throws Exception {

        Assert.assertEquals(3, PrimeFactorization.getSumOfDivisors(PrimeFactorization.getPrimeFactorsWithPower(2, primes)));
        Assert.assertEquals(12, PrimeFactorization.getSumOfDivisors(PrimeFactorization.getPrimeFactorsWithPower(6, primes)));
        Assert.assertEquals(360, PrimeFactorization.getSumOfDivisors(PrimeFactorization.getPrimeFactorsWithPower(120, primes)));

    }

    @Test
    public void testGetNumberOfDivisors() throws Exception {

        Assert.assertEquals(8, PrimeFactorization.getNumberOfDivisors(PrimeFactorization.getPrimeFactorsWithPower(24, primes)));
        Assert.assertEquals(2, PrimeFactorization.getNumberOfDivisors(PrimeFactorization.getPrimeFactorsWithPower(5, primes)));
        Assert.assertEquals(4, PrimeFactorization.getNumberOfDivisors(PrimeFactorization.getPrimeFactorsWithPower(6, primes)));

    }

}