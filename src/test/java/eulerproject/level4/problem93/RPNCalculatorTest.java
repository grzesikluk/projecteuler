package eulerproject.level4.problem93;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RPNCalculatorTest
{
    @Test
    public void testCalculateExpression() throws Exception
    {
        assertThat(RPNCalculator.calculateExpression("22*")).isEqualTo(4);
        assertThat(RPNCalculator.calculateExpression("22/")).isEqualTo(1);
        assertThat(RPNCalculator.calculateExpression("22/3+")).isEqualTo(4);
        assertThat(RPNCalculator.calculateExpression("33*3+")).isEqualTo(12);
        assertThat(RPNCalculator.calculateExpression("34-5+")).isEqualTo(4);
        assertThat(RPNCalculator.calculateExpression("345*-")).isEqualTo(-17);
        assertThat(RPNCalculator.calculateExpression("532*+")).isEqualTo(11);
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
    public void testIsOperator() throws Exception
    {
        assertThat(RPNCalculator.isOperator("+")).isTrue();
        assertThat(RPNCalculator.isOperator("-")).isTrue();
        assertThat(RPNCalculator.isOperator("/")).isTrue();
        assertThat(RPNCalculator.isOperator("*")).isTrue();
        assertThat(RPNCalculator.isOperator("1")).isFalse();
    }

    @Test
    public void testEvaluate() throws Exception
    {
        assertThat(RPNCalculator.evaluate("1","2","+")).isEqualTo(3);
        assertThat(RPNCalculator.evaluate("4", "2","-")).isEqualTo(2);
        assertThat(RPNCalculator.evaluate("4", "2", "*")).isEqualTo(8);
        assertThat(RPNCalculator.evaluate("4","3","*")).isEqualTo(12);
        assertThat(RPNCalculator.evaluate("4","2","/")).isEqualTo(2);
    }
}