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
    public static int MAX_PRIME = 1000000;


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

}