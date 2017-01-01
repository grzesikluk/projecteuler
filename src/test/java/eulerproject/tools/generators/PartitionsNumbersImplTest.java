package eulerproject.tools.generators;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2017-01-01.
 */
public class PartitionsNumbersImplTest {

    @Test
    public void testPartitionFunction() throws Exception {
        int[] outputValues = new int[]{1, 1, 2, 3, 5, 7, 11, 15, 22, 30, 42, 56, 77, 101, 135, 176, 231, 297, 385, 490, 627, 792, 1002};
        PartitionsNumbers partitionsNumbers = new PartitionsNumbersImpl(30);

        for (int i = 0; i < outputValues.length; i++)
            Assert.assertEquals(new Integer(outputValues[i]), partitionsNumbers.partitionFunction(i));

    }

    @Test
    public void testPartitionFunction_big() throws Exception {
        PartitionsNumbers partitionsNumbers = new PartitionsNumbersImpl(40);
        Assert.assertEquals(new Integer(5604), partitionsNumbers.partitionFunction(30));
    }

    @Test
    public void testPartitionFunction_big1() throws Exception {
        PartitionsNumbers partitionsNumbers = new PartitionsNumbersImpl(35);
        Assert.assertEquals(new Integer(14883), partitionsNumbers.partitionFunction(35));
    }

    @Test(timeout = 1*60*1000)
    public void testPartitionFunction_big2() throws Exception {
        PartitionsNumbers partitionsNumbers = new PartitionsNumbersImpl(100);
        Assert.assertEquals(new Integer(190_569_292), partitionsNumbers.partitionFunction(100));
    }

}