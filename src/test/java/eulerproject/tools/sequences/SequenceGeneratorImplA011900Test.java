package eulerproject.tools.sequences;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Lukasz on 2017-07-26.
 */
public class SequenceGeneratorImplA011900Test {
    @Test
    public void testGetNext() throws Exception {
        SequenceGeneratorImplA011900 seq = new SequenceGeneratorImplA011900();
        Assert.assertEquals(BigInteger.ONE, seq.getNext());
        Assert.assertEquals(BigInteger.valueOf(3), seq.getNext());
        Assert.assertEquals(BigInteger.valueOf(15), seq.getNext());
        Assert.assertEquals(BigInteger.valueOf(85), seq.getNext());
        Assert.assertEquals(BigInteger.valueOf(493), seq.getNext());
        Assert.assertEquals(BigInteger.valueOf(2871), seq.getNext());

    }

}