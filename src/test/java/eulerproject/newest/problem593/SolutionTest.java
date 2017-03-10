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
        primes = new Primes(200_000_000).asList();
    }

    @Test
    @Ignore
    public void getFValue_100() throws Exception {
        Assert.assertEquals(463628.5, Solution.getFValue(100, 10, primes), 0.01);
    }

    @Test
    @Ignore
    public void getFValue_10e4() throws Exception {
        Assert.assertEquals(44975488.5, Solution.getFValue(10000, 1000, primes), 0.01);
    }

    @Test //45s
    @Ignore
    public void testGetFValue_10e5_e4() throws Exception {
        Assert.assertEquals(675348207.5, Solution.getFValue(100000, 10000, primes), 0.01);
    }

    @Test(timeout = 60* 8 * 1000) //8m 9*10^5
    @Ignore
    public void testGetFValue_10e6_e5() throws Exception {
        Assert.assertEquals(8.956402482E9, Solution.getFValue(1_000_000, 100_000, primes), 0.01);
    }

    @Test(timeout = 85 * 60 * 60 * 1000) //1h 19m
    @Ignore
    public void testGetFValue_10e7_e5() throws Exception {
        Assert.assertEquals(9.6632320042E10, Solution.getFValue(10_000_000, 100_000, primes), 0.01);
    }

    @Test
    @Ignore
    public void testMedianOfS2Value() throws Exception {
        Assert.assertEquals(2021.5, Solution.medianOfS2Value(1, 10, primes), 0.1);
        Assert.assertEquals(4715.0, Solution.medianOfS2Value(100, 1000, primes), 0.1);
    }

    @Test
    public void testGetSValueNew() throws Exception {
        Assert.assertEquals(2, Solution.getSValue(1, primes, 11));
        Assert.assertEquals(9, Solution.getSValue(2, primes, 11));
        Assert.assertEquals(1, Solution.getSValue(6062, primes,10007));
        Assert.assertEquals(8621, Solution.getSValue(5004, primes,10007));

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
    @Ignore
    public void testGetSValueCached() throws Exception {

        for (int i = 0; i < 10000; i++) {
            double k = Solution.getFValue(10000, 10000 - i, primes);
            System.out.println(k);
        }
    }


}
