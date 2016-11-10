package eulerproject.level11.problem243;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2016-11-10.
 */
public class DenominatorGeneratorTest {
    @Test
    public void getNext() throws Exception {

        Assert.assertEquals(30,DenominatorGenerator.getNext());
        Assert.assertEquals(60,DenominatorGenerator.getNext());
        Assert.assertEquals(90,DenominatorGenerator.getNext());
        Assert.assertEquals(120,DenominatorGenerator.getNext());
        Assert.assertEquals(150,DenominatorGenerator.getNext());
        Assert.assertEquals(180,DenominatorGenerator.getNext());
        Assert.assertEquals(210,DenominatorGenerator.getNext());
        Assert.assertEquals(420,DenominatorGenerator.getNext());
        Assert.assertEquals(630,DenominatorGenerator.getNext());
        Assert.assertEquals(840,DenominatorGenerator.getNext());
        Assert.assertEquals(1050,DenominatorGenerator.getNext());

    }

}