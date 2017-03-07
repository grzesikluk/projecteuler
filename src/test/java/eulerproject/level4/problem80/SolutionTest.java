package eulerproject.level4.problem80;

import eulerproject.tools.functions.Squares;
import eulerproject.tools.functions.SquaresBigIntImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by grzesikl on 06/03/2017.
 */
public class SolutionTest {
    @Test
    public void getSumOfAllDigits() throws Exception {
        Squares squares = new SquaresBigIntImpl();
        Assert.assertEquals(475,Solution.getSumOfAllDigits(squares.getSquareRootDigits(2,100)));

    }

}
