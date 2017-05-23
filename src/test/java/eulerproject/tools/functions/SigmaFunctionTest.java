package eulerproject.tools.functions;

import eulerproject.tools.primes.Primes;
import org.junit.Assert;
import org.junit.Test;

public class SigmaFunctionTest {


    SigmaFunction sigmaFunction;


    @Test
    public void getValue() throws Exception {
        sigmaFunction = new SigmaFunctionImpl();

        Assert.assertEquals(1, sigmaFunction.getValue(1, 1));

        Assert.assertEquals(2, sigmaFunction.getValue(2, 0));
        Assert.assertEquals(3, sigmaFunction.getValue(2, 1));

        Assert.assertEquals(2, sigmaFunction.getValue(3, 0));
        Assert.assertEquals(4, sigmaFunction.getValue(3, 1));

        Assert.assertEquals(12, sigmaFunction.getValue(140, 0));
        Assert.assertEquals(336, sigmaFunction.getValue(140, 1));
        Assert.assertEquals(27300, sigmaFunction.getValue(140, 2));
        Assert.assertEquals(3164112, sigmaFunction.getValue(140, 3));
    }


    @Test
    public void getValueModular() throws Exception {
        sigmaFunction = new SigmaFunctionImpl();

        Assert.assertEquals(1, sigmaFunction.getValueModular(1, 1, 1000));

        Assert.assertEquals(2, sigmaFunction.getValueModular(2, 0, 1000));
        Assert.assertEquals(3, sigmaFunction.getValueModular(2, 1, 1000));

        Assert.assertEquals(2, sigmaFunction.getValueModular(3, 0, 1000));
        Assert.assertEquals(4, sigmaFunction.getValueModular(3, 1, 1000));

        Assert.assertEquals(12, sigmaFunction.getValueModular(140, 0, 1000));
        Assert.assertEquals(36, sigmaFunction.getValueModular(140, 1, 300));
        Assert.assertEquals(0, sigmaFunction.getValueModular(140, 2, 100));
        Assert.assertEquals(164112, sigmaFunction.getValueModular(140, 3, 1000000));
    }

    @Test
    public void getValueModularWithPrimes() throws Exception {
        sigmaFunction = new SigmaFunctionImpl();

        Primes primes = new Primes(1000);
        primes.init();

        Assert.assertEquals(1, sigmaFunction.getValueModular(1, 1, 1000));

        Assert.assertEquals(2, sigmaFunction.getValueModular(2, 0, 1000));
        Assert.assertEquals(3, sigmaFunction.getValueModular(2, 1, 1000));

        Assert.assertEquals(2, sigmaFunction.getValueModular(3, 0, 1000));
        Assert.assertEquals(4, sigmaFunction.getValueModular(3, 1, 1000));

        Assert.assertEquals(12, sigmaFunction.getValueModular(140, 0, 1000));
        Assert.assertEquals(36, sigmaFunction.getValueModular(140, 1, 300));
        Assert.assertEquals(0, sigmaFunction.getValueModular(140, 2, 100));
        Assert.assertEquals(164112, sigmaFunction.getValueModular(140, 3, 1000000));
    }

    @Test
    public void getValueBerndt() throws Exception {


        Primes primes = new Primes(1000);
        primes.init();

        sigmaFunction = new SigmaFunctionBerndtImpl(primes);

        Assert.assertEquals(1, sigmaFunction.getValue(1, 1));

        Assert.assertEquals(2, sigmaFunction.getValue(2, 0));
        Assert.assertEquals(3, sigmaFunction.getValue(2, 1));

        Assert.assertEquals(2, sigmaFunction.getValue(3, 0));
        Assert.assertEquals(4, sigmaFunction.getValue(3, 1));

        Assert.assertEquals(12, sigmaFunction.getValue(140, 0));
        Assert.assertEquals(336, sigmaFunction.getValue(140, 1));
        Assert.assertEquals(27300, sigmaFunction.getValue(140, 2));
        Assert.assertEquals(3164112, sigmaFunction.getValue(140, 3));


        Assert.assertEquals(1, sigmaFunction.getValueModular(1, 1, 1000));

        Assert.assertEquals(2, sigmaFunction.getValueModular(2, 0, 1000));
        Assert.assertEquals(3, sigmaFunction.getValueModular(2, 1, 1000));

        Assert.assertEquals(2, sigmaFunction.getValueModular(3, 0, 1000));
        Assert.assertEquals(4, sigmaFunction.getValueModular(3, 1, 1000));

        Assert.assertEquals(12, sigmaFunction.getValueModular(140, 0, 1000));
        Assert.assertEquals(36, sigmaFunction.getValueModular(140, 1, 300));
        Assert.assertEquals(0, sigmaFunction.getValueModular(140, 2, 100));
        Assert.assertEquals(164112, sigmaFunction.getValueModular(140, 3, 1000000));

        Assert.assertEquals(2, sigmaFunction.getValueModular(3, 4, 10));


    }

}