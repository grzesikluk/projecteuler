package eulerproject.tools.sequences;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;


public class SequenceGeneratorImplA046090Test {
    @Test
    public void testGetNext() throws Exception {
        SequenceGeneratorImplA046090 seq = new SequenceGeneratorImplA046090();

        Assert.assertEquals(BigInteger.valueOf(1), seq.getNext());
        Assert.assertEquals(BigInteger.valueOf(4), seq.getNext());
        Assert.assertEquals(BigInteger.valueOf(21), seq.getNext());
        Assert.assertEquals(BigInteger.valueOf(120), seq.getNext());
        Assert.assertEquals(BigInteger.valueOf(697), seq.getNext());
        Assert.assertEquals(BigInteger.valueOf(4060), seq.getNext());
        Assert.assertEquals(BigInteger.valueOf(23661), seq.getNext());
    }

}