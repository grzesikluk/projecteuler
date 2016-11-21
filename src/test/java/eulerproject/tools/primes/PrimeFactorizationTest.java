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

    @Before
    public void init() {
        primes = new Primes(100);
        primes.generatePrimes();
    }

    @Test
    public void getPrimeFactors1() throws Exception {

        Assert.assertArrayEquals(new int[]{3, 5}, PrimeFactorization.getPrimeFactors(15, primes));
    }

    @Test
    public void getPrimeFactors2() throws Exception {
        Assert.assertArrayEquals(new int[]{2, 2, 2, 3, 3, 5}, PrimeFactorization.getPrimeFactors(360, primes));
    }

    @Test
    public void getPrimeFactors3() throws Exception {

        Assert.assertArrayEquals(new int[]{2, 2, 2, 5, 5, 5}, PrimeFactorization.getPrimeFactors(1000, primes));

    }


    @Test
    public void getPrimeFactors4() throws Exception {

        Assert.assertArrayEquals(new int[]{17}, PrimeFactorization.getPrimeFactors(17, primes));

    }

    @Test
    public void getPrimeFactorsWithPower1() throws Exception {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(3,1);
        map.put(5,1);

        Assert.assertEquals(map, PrimeFactorization.getPrimeFactorsWithPower(15, primes));

    }


    @Test
    public void getPrimeFactorsWithPower2() throws Exception {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(2,3);
        map.put(3,2);
        map.put(5,1);


        Assert.assertEquals(map, PrimeFactorization.getPrimeFactorsWithPower(360, primes));

    }

}