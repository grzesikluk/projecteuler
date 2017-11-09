package eulerproject.level4.problem94;

import eulerproject.tools.generators.SquareNumbers;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static eulerproject.level4.problem94.Solution.checkArea;
import static eulerproject.level4.problem94.Solution.getArraySqrt;
import static eulerproject.level4.problem94.Solution.getPerimeter;
import static eulerproject.level4.problem94.Solution.isInt;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest
{

    Set<Long> squareNumbers =  LongStream
            .range(0,100)
            .parallel()
            .mapToObj(i-> SquareNumbers.getNumber(i))
            .collect(Collectors.toSet());

    @Test
    public void testGetPerimeter() throws Exception
    {
        assertThat(getPerimeter(2,3,3)).isEqualTo(8);
    }

    @Test
    public void testGetArraySqrt() throws Exception
    {
        assertThat(getArraySqrt(5,5,6)).isEqualTo(144);
        assertThat(getArraySqrt(5,5,4)).isEqualTo(84);
    }

    @Test
    public void testIsInt() throws Exception
    {
        assertThat(isInt(2.1)).isFalse();
        assertThat(isInt(2.5)).isFalse();
        assertThat(isInt(2.99999)).isFalse();
        assertThat(isInt(2.0)).isTrue();
    }

    @Test
    public void testCheckTestArea() throws Exception
    {
        assertThat(checkArea(2.1,squareNumbers)).isFalse();
        assertThat(checkArea(64.0,squareNumbers)).isTrue();
        assertThat(checkArea(84.0,squareNumbers)).isFalse();
        assertThat(checkArea(81.0,squareNumbers)).isTrue();
    }

}