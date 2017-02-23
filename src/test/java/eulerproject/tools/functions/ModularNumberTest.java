package eulerproject.tools.functions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2017-02-23.
 */
public class ModularNumberTest {
    @Test
    public void addModular() throws Exception {
        ModularNumber number = new ModularNumber(10, 21);
        Assert.assertEquals(8, number.addModular(27L).getValue());
    }

    @Test
    public void multiplyModular() throws Exception {
        ModularNumber number = new ModularNumber(10, 2);
        Assert.assertEquals(2, number.multiplyModular(26L).getValue());
    }

    @Test
    public void equals() throws Exception {
        ModularNumber number = new ModularNumber(10, 2);
        Assert.assertTrue(number.equals(new ModularNumber(10, 12)));
        Assert.assertFalse(number.equals(new ModularNumber(10, 33)));
        Assert.assertFalse(number.equals(new ModularNumber(11, 12)));
    }

    @Test
    public void powerModular() throws Exception {
        ModularNumber number = new ModularNumber(100, 2);
        Assert.assertEquals(16, number.powerModular(4).getValue());
        Assert.assertEquals(76, number.powerModular(40).getValue());
        Assert.assertEquals(84, number.powerModular(14).getValue());
    }

}