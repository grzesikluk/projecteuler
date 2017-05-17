package eulerproject.tools.sequences;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by grzesikl on 17/05/2017.
 */
public class SequenceGeneratorImplA109976Test {
    SequenceGenerator sequenceGenerator;

    @Before
    public void init() {
        sequenceGenerator = new SequenceGeneratorImplA109976();
        sequenceGenerator.init(10000L);

    }

    @Test
    public void getNumber() throws Exception {

        List<Long> checkValues = Arrays.asList(0L, 1L, 2L, 3L, 6L, 7L, 16L, 19L, 46L, 66L, 159L, 274L, 667L);

        for (int i = 1; i < checkValues.size(); i++)
            Assert.assertEquals(checkValues.get(i), new Long(sequenceGenerator.getNumber(i)));


    }

}
