package eulerproject.level3.problem73;

import eulerproject.tools.fractions.Fraction;
import org.junit.Assert;
import org.junit.Test;

import static eulerproject.level3.problem73.Solution.getNominatorMaxValue;
import static eulerproject.level3.problem73.Solution.getNominatorMinValue;

/**
 * Created by Lukasz on 2017-01-01.
 */
public class SolutionTest {
    @Test
    public void testGetNominatorMinValue() throws Exception {
        Assert.assertEquals(0,getNominatorMinValue(3,new Fraction(1,3)));
        Assert.assertEquals(2,getNominatorMinValue(5,new Fraction(1,3)));
        Assert.assertEquals(3,getNominatorMinValue(8,new Fraction(1,3)));
        Assert.assertEquals(4,getNominatorMinValue(10,new Fraction(1,3)));
        Assert.assertEquals(6,getNominatorMinValue(10,new Fraction(1,2)));
    }

    @Test
    public void testGetNominatorMaxValue() throws Exception {
        Assert.assertEquals(1,getNominatorMaxValue(3,new Fraction(1,2)));
        Assert.assertEquals(2,getNominatorMaxValue(5,new Fraction(1,2)));
        Assert.assertEquals(3,getNominatorMaxValue(8,new Fraction(1,2)));
        Assert.assertEquals(4,getNominatorMaxValue(10,new Fraction(1,2)));
    }

}