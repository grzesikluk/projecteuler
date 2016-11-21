package eulerproject.level11.problem243;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by Lukasz on 2016-11-10.
 */
public class DenominatorGeneratorBigTest {
    @Test
    public void getNext() throws Exception {

        Assert.assertEquals(new BigInteger("30"),DenominatorGeneratorBig.getNext());
        Assert.assertEquals(new BigInteger("60"),DenominatorGeneratorBig.getNext());
        Assert.assertEquals(new BigInteger("90"),DenominatorGeneratorBig.getNext());
        Assert.assertEquals(new BigInteger("120"),DenominatorGeneratorBig.getNext());
        Assert.assertEquals(new BigInteger("150"),DenominatorGeneratorBig.getNext());
        Assert.assertEquals(new BigInteger("180"),DenominatorGeneratorBig.getNext());
        Assert.assertEquals(new BigInteger("210"),DenominatorGeneratorBig.getNext());
        Assert.assertEquals(new BigInteger("420"),DenominatorGeneratorBig.getNext());
        Assert.assertEquals(new BigInteger("630"),DenominatorGeneratorBig.getNext());
        Assert.assertEquals(new BigInteger("840"),DenominatorGeneratorBig.getNext());
        Assert.assertEquals(new BigInteger("1050"),DenominatorGeneratorBig.getNext());

    }

}