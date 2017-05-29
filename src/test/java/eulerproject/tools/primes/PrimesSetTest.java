package eulerproject.tools.primes;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2016-10-10.
 */
public class PrimesSetTest {

    PrimesSet primes = new PrimesSet(100);


    @Test
    public void isPrime() throws Exception {
        Assert.assertTrue(primes.isPrime(11));
        Assert.assertTrue(primes.isPrime(37));

    }

    @Test
    public void getNextPrime() throws Exception {
        Assert.assertEquals(new Integer(11),primes.getNextPrime(7));
        Assert.assertEquals(new Integer(13),primes.getNextPrime(12));
        Assert.assertNull(primes.getNextPrime(99));
    }


    @Test
    public void isPrimeValue() throws Exception {
        Assert.assertTrue(primes.isPrime(11));
        Assert.assertTrue(primes.isPrime(37));
        Assert.assertTrue(primes.isPrime(102643));
        Assert.assertTrue(primes.isPrime(104729));

    }

    @Test
    public void isPrimeValueBig() throws Exception {
        Assert.assertTrue(primes.isPrime(11));
        Assert.assertTrue(primes.isPrime(37));
        Assert.assertTrue(primes.isPrime(102643));
        Assert.assertTrue(primes.isPrime(104729));

    }

}
