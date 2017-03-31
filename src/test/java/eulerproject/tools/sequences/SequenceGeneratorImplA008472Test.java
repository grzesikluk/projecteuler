package eulerproject.tools.sequences;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lukasz on 2017-03-31.
 */
public class SequenceGeneratorImplA008472Test {

    public final long MAX = 1000000L;
    SequenceGenerator sg;

    @Before
    public void init() {
        sg = new SequenceGeneratorImplA008472();
        sg.init(MAX);
    }

    @Test
    public void getNumber() throws Exception {
        int[] checkArray = new int[]{0, 0, 2, 3, 2, 5, 5, 7, 2, 3, 7, 11, 5, 13, 9, 8, 2, 17, 5, 19, 7, 10, 13, 23, 5, 5,
                15, 3, 9, 29, 10, 31, 2, 14, 19, 12, 5, 37, 21, 16, 7, 41, 12, 43, 13, 8, 25, 47, 5, 7, 7, 20, 15, 53,
                5, 16, 9, 22, 31, 59, 10, 61, 33, 10, 2, 18, 16, 67, 19, 26, 14, 71, 5, 73};


        for (int i = 1; i < checkArray.length; i++) {
            Assert.assertEquals(checkArray[i], sg.getNumber(i));
        }


    }

}