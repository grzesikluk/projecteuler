package eulerproject.tools.arithmetic;

import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class RPNCalculator
{


    public static int calculateExpression(String[] expression) {

        final Stack<String> stack = new Stack<>();

        IntStream.range(0, expression.length).forEach(
                i -> {
                    String token = expression[i];

                    if (isOperator(token)) {
                        String operand2 = stack.pop();
                        String operand1 = stack.pop();

                        if (operand1 == null || operand2 == null)
                            throw new ArithmeticException("Wrong expression");

                        try {
                            stack.push(Integer.toString(evaluate(operand1, operand2, "" + token)));
                        }
                        catch (ArithmeticException exc) {
                            //skip
                            stack.clear();
                            stack.push("0");
                        }


                    } else if (isOperand( token)) {
                        stack.push(token);
                    } else
                        throw new ArithmeticException("Could not process");
                });

        return Integer.parseInt(stack.pop());

    }

    public static int calculateExpression(String expression)
    {
        return calculateExpression(expression.split(" "));
    }

    public static int calculateExpression(List<String> expression) {
        return calculateExpression(expression.toArray(new String[expression.size()]));
    }


    public static boolean isOperand(String x)
    {
        try {
            Integer.parseInt(x);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isOperator(String x)
    {
        return (x.equals("+") |
                x.equals("-") |
                x.equals("*") |
                x.equals("/"));
    }

    public static int evaluate(String o1, String o2, String operator)
    {
        if (operator.length() > 1 && !isOperator(operator))
            throw new IllegalArgumentException("Wrong operator definition");

        int oper1 = Integer.parseInt(o1);
        int oper2 = Integer.parseInt(o2);

        switch (operator) {
            case "+":
                return oper1 + oper2;
            case "-":
                return oper1 - oper2;
            case "*":
                return oper1 * oper2;

            case "/": {
                if(oper2 != 0)
                    return oper1 / oper2;
                else
                    throw new ArithmeticException("Division by zero.");
            }
        }
        return 0;
    }
}
