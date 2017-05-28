package eulerproject.level4.problem84;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2017-05-28.
 */
public class DicePairImplTest {
    @Test
    public void throwIt() throws Exception {
        DicePair dices = new DicePairImpl(6);

        int i = 0;
        while (i++ < 100000000) {
            int k = dices.throwIt();
            if (!(k <= 12 && k >= 2))
                throw new Exception("Wrong dice impl");
//            Thread.sleep(5);
        }

        Assert.assertEquals(true, dices.isThrown());

    }

    @Test
    public void isThrown() throws Exception {
        DicePair dices = new DicePairImpl(6);
        Assert.assertEquals(false, dices.isThrown());
        dices.throwIt();
        Assert.assertEquals(true, dices.isThrown());
    }

    @Test
    public void isDoubleDiceThreeTimes() throws Exception {
        DicePair dices = new DicePairImpl(6);

        int i = 0;
        while (i++ < 1000000) {
            int k = dices.throwIt();
            System.out.println(dices.getLastFirst() + " " + dices.getLastSecond());
            if (dices.isDoubleDiceThreeTimes()) {
                System.out.println("Found");
                break;
            }

        }

    }

    @Test
    public void howManyDoubleDiceInRow() throws Exception {

    }

}