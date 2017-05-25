package eulerproject.tools.generators;

import org.junit.Assert;
import org.junit.Test;


public class PartitionsNumbersModuloIntImplTest {

    @Test
    public void testPartitionFunction() throws Exception {
        int[] outputValues = new int[]{1, 1, 2, 3, 5, 7, 11, 15, 22, 30, 42, 56, 77, 101, 135, 176, 231, 297, 385, 490, 627, 792, 1002};
        PartitionsNumbers partitionsNumbers = new PartitionsNumbersModuloIntImpl(10000);

        for (int i = 0; i < outputValues.length; i++)
            Assert.assertEquals(new Integer(outputValues[i]), partitionsNumbers.partitionFunction(i));

    }

    @Test
    public void testPartitionFunction_big() throws Exception {
        PartitionsNumbers partitionsNumbers = new PartitionsNumbersModuloIntImpl(10000);
        Assert.assertEquals(new Integer(5604), partitionsNumbers.partitionFunction(30));
    }

    @Test
    public void testPartitionFunction_withModulo100() throws Exception {
        int[] outputValues = new int[]{1, 1, 2, 3, 5, 7, 11, 15, 22, 30, 42, 56, 77, 1, 35, 76, 31, 97, 85, 90, 27, 92, 2};
        PartitionsNumbers partitionsNumbers = new PartitionsNumbersModuloIntImpl(100);

        for (int i = 0; i < outputValues.length; i++)
            Assert.assertEquals(new Integer(outputValues[i]), partitionsNumbers.partitionFunction(i));

    }

    @Test
    public void testPartitionFunction_withModulo10() throws Exception {
        int[] outputValues = new int[]{1, 1, 2, 3, 5, 7, 1, 5, 2, 0, 2, 6, 7, 1, 5, 6, 1, 7, 5, 0, 7, 2, 2};
        PartitionsNumbers partitionsNumbers = new PartitionsNumbersModuloIntImpl(10);

        for (int i = 0; i < outputValues.length; i++)
            Assert.assertEquals(new Integer(outputValues[i]), partitionsNumbers.partitionFunction(i));

    }
    @Test
    public void testPartitionFunction_big1() throws Exception {
        PartitionsNumbers partitionsNumbers = new PartitionsNumbersModuloIntImpl(1000000);
        Assert.assertEquals(new Integer(0), partitionsNumbers.partitionFunction(55374));
    }

    @Test(timeout = 1*60*1000)
    public void testPartitionFunction_big2() throws Exception {
        PartitionsNumbers partitionsNumbers = new PartitionsNumbersModuloIntImpl(1000000000);
        Assert.assertEquals(new Integer(190_569_292), partitionsNumbers.partitionFunction(100));
    }

}
