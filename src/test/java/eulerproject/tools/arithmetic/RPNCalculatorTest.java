package eulerproject.tools.arithmetic;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RPNCalculatorTest
{
    @Test
    public void testCalculateExpression() throws Exception
    {
        assertThat(RPNCalculator.calculateExpression("2 2 *")).isEqualTo(4);
        assertThat(RPNCalculator.calculateExpression("2 2 /")).isEqualTo(1);
        assertThat(RPNCalculator.calculateExpression("2 2 / 3 +")).isEqualTo(4);
        assertThat(RPNCalculator.calculateExpression("3 3 * 3 +")).isEqualTo(12);
        assertThat(RPNCalculator.calculateExpression("3 4 - 5 +")).isEqualTo(4);
        assertThat(RPNCalculator.calculateExpression("3 4 5 * -")).isEqualTo(-17);
        assertThat(RPNCalculator.calculateExpression("5 3 2 * +")).isEqualTo(11);
        assertThat(RPNCalculator.calculateExpression("15 13 -")).isEqualTo(2);

        //sanity check
        assertThat(RPNCalculator.calculateExpression("1 2 3 + - 4 -")).isEqualTo(-8);
        assertThat(RPNCalculator.calculateExpression("1 2 3 + 4 - -")).isEqualTo(0);
        assertThat(RPNCalculator.calculateExpression("1 2 + 3 + 4 -")).isEqualTo(2);
        assertThat(RPNCalculator.calculateExpression("1 2 + 3 4 - +")).isEqualTo(2);
        assertThat(RPNCalculator.calculateExpression("1 2 3 4 + + -")).isEqualTo(-8);
    }

    @Test
    public void testIsDigit() throws Exception
    {
        assertThat(RPNCalculator.isOperand("1")).isTrue();
        assertThat(RPNCalculator.isOperand("9")).isTrue();
        assertThat(RPNCalculator.isOperand("0")).isTrue();
        assertThat(RPNCalculator.isOperand("a")).isFalse();
    }

    @Test
    public void testEvaluate() throws Exception
    {
        assertThat(RPNCalculator.evaluate("1","2",ArithmeticOperator.ADD)).isEqualTo(3);
        assertThat(RPNCalculator.evaluate("4", "2",ArithmeticOperator.SUB)).isEqualTo(2);
        assertThat(RPNCalculator.evaluate("4", "2", ArithmeticOperator.MUL)).isEqualTo(8);
        assertThat(RPNCalculator.evaluate("4","3",ArithmeticOperator.MUL)).isEqualTo(12);
        assertThat(RPNCalculator.evaluate("4","2",ArithmeticOperator.DIV)).isEqualTo(2);
    }
}