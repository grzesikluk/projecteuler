package eulerproject.level3.problem71;

import eulerproject.tools.fractions.Fraction;
import org.junit.Assert;
import org.junit.Test;

import static eulerproject.level3.problem71.Solution.getNominatorMaxValue;
import static eulerproject.level3.problem71.Solution.getNominatorMinValue;

/**
 * Created by Lukasz on 2017-01-01.
 */
public class SolutionTest {
    @Test
    public void testGetNominatorMinValue() throws Exception {
        Assert.assertEquals(0, getNominatorMinValue(2,new Fraction(1,3)));
        Assert.assertEquals(0, getNominatorMinValue(2,new Fraction(2,7)));
        Assert.assertEquals(2, getNominatorMinValue(5,new Fraction(1,2)));
        Assert.assertEquals(3, getNominatorMinValue(10,new Fraction(1,3)));
    }

    @Test
    public void testGetNominatorMaxValue() throws Exception {
        Assert.assertEquals(1, getNominatorMaxValue(2,new Fraction(2,3)));
        Assert.assertEquals(6, getNominatorMaxValue(10,new Fraction(2,3)));
        Assert.assertEquals(1, getNominatorMaxValue(3,new Fraction(2,3)));
        Assert.assertEquals(7, getNominatorMaxValue(10,new Fraction(3,4)));
        Assert.assertEquals(0, getNominatorMaxValue(2,new Fraction(3,7)));

    }

}