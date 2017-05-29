package eulerproject.level3.problem60;

import eulerproject.tools.primes.Primes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        Solution solution = new Solution();

        Assert.assertTrue(solution.isPrimePair(new Pair(3, 7)));
        Assert.assertTrue(solution.isPrimePair(new Pair(109, 673)));
        Assert.assertTrue(solution.isPrimePair(new Pair(3, 109)));
        Assert.assertTrue(solution.isPrimePair(new Pair(673, 7)));

    }


    @Test
    public void testSearchForChain() {
        Solution solution = new Solution();

        Assert.assertEquals(10, solution.searchForChain(primes, 2, 2).stream().mapToInt( s->s).sum());
        Assert.assertEquals(119, solution.searchForChain(primes, 3, 2).stream().mapToInt( s->s).sum());
        Assert.assertEquals(792, solution.searchForChain(primes, 4, 2 ).stream().mapToInt( s->s).sum());

    }

}
