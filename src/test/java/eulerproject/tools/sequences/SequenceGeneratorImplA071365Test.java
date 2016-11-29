package eulerproject.tools.sequences;

import eulerproject.tools.primes.Primes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by grzesikl on 29/11/2016.
 */
public class SequenceGeneratorImplA071365Test {
    private SequenceGenerator sg;
    private static final long MAX = 10_000_000_000_000L;
    private static final long MAX_PRIME = (long) Math.sqrt((double) MAX / 2);

    @Before
    public void init() {
        sg = new SequenceGeneratorImplA071365();
        Primes primes = new Primes((int)MAX_PRIME);
        sg.init(100000,primes.asList());
    }

    @Test
    public void getNumber() throws Exception {
        Assert.assertEquals(18,sg.getNumber(0));
        Assert.assertEquals(50,sg.getNumber(1));
        Assert.assertEquals(54,sg.getNumber(2));
        Assert.assertEquals(75,sg.getNumber(3));
        Assert.assertEquals(90,sg.getNumber(4));
        Assert.assertEquals(98,sg.getNumber(5));
        Assert.assertEquals(108,sg.getNumber(6));
        Assert.assertEquals(126,sg.getNumber(7));
        Assert.assertEquals(147,sg.getNumber(8));

    }

    @Test(timeout = 5000)
    public void getNumber_long() throws Exception {
        Assert.assertEquals(13086,sg.getNumber(1000));
    }

}