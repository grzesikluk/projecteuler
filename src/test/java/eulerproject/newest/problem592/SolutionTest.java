package eulerproject.newest.problem592;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by grzesikl on 10/03/2017.
 */
public class SolutionTest {
    @Test
    public void factorialModulo() throws Exception {
        Assert.assertEquals(1,Solution.factorial(1L));
        Assert.assertEquals(6,Solution.factorial(3L));
        Assert.assertEquals(120,Solution.factorial(5L));
        Assert.assertEquals(720,Solution.factorial(6L));
        Assert.assertEquals(2432902008176640000L,Solution.factorial(20L));

    }

    @Test
    public void testFactorialModulo() {
        Assert.assertEquals(37123138552500L,Solution.factorialModulo(20L));
    }

    @Test
    public void getFactorialHexValue() throws Exception {
        Assert.assertEquals("21C3677C82B4",Solution.getFactorialHexValue(20L));
        Assert.assertEquals("2C5077D36B8C4",Solution.getFactorialHexValue(21L));
        Assert.assertEquals("3CEEA4C2B3E0D8",Solution.getFactorialHexValue(22L));

    }

}
