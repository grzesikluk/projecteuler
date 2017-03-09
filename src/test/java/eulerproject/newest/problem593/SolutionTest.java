package eulerproject.newest.problem593;

import eulerproject.tools.primes.Primes;
import org.junit.*;

/**
 * Created by Lukasz on 2017-03-07.
 */
public class SolutionTest {


    private static int[] primes;

    @BeforeClass
    public static void init() {
        primes = new Primes(1000_000).asList();
    }

    @Test
    public void getFValue_100() throws Exception {
        Assert.assertEquals(463628.5, Solution.getFValue(100, 10, primes), 0.01);
    }

    @Test(timeout = 60 * 1000)
    public void testGetFValue_100000() throws Exception {
        Assert.assertEquals(675348207.5, Solution.getFValue(100000, 10000, primes), 0.01);
    }

    @Test
    @Ignore
    public void testGetFValue_1000000() throws Exception {
        Assert.assertEquals(0, Solution.getFValue(1000000, 100000, primes), 0.01);
    }

    @Test
    public void testMedianOfS2Value() throws Exception {
        Assert.assertEquals(2021.5, Solution.medianOfS2Value(1, 10, primes), 0.1);
        Assert.assertEquals(4715.0, Solution.medianOfS2Value(100, 1000, primes), 0.1);
    }

    @Test
    public void testGetSValue() throws Exception {

        Assert.assertEquals(2, Solution.getSValue(1, primes));
        Assert.assertEquals(9, Solution.getSValue(2, primes));
        Assert.assertEquals(125, Solution.getSValue(3, primes));
        Assert.assertEquals(2401, Solution.getSValue(4, primes));
        Assert.assertEquals(939, Solution.getSValue(5, primes));
        Assert.assertEquals(3435, Solution.getSValue(6, primes));
    }

    @Test
    public void testGetS2Value() throws Exception {

        Assert.assertEquals(4, Solution.getS2Value(1, primes));
        Assert.assertEquals(11, Solution.getS2Value(2, primes));
        Assert.assertEquals(127, Solution.getS2Value(3, primes));
        Assert.assertEquals(2403, Solution.getS2Value(4, primes));
        Assert.assertEquals(941, Solution.getS2Value(5, primes));
        Assert.assertEquals(3437, Solution.getS2Value(6, primes));
    }

    @Test
    public void testGetSValueCached() throws Exception {

        for (int i = 0; i < 100; i++) {
            double k = Solution.getFValue(100, 100 - i, primes);
            System.out.println(k);
        }
    }


}
