package eulerproject.tools.arithmetic;

public enum ArithmeticOperator
{
    ADD("+"), SUB("-"), MUL("*"), DIV("/");

    private String operatorString;

    ArithmeticOperator(String operatorString) {
        this.operatorString = operatorString;
    }

    public static boolean isOperator(String x)
    {
        return (x.equals("+") |
                x.equals("-") |
                x.equals("*") |
                x.equals("/"));
    }


    public String toString() {
        return operatorString;
    }

    public static ArithmeticOperator fromString(String s) {
        if(isOperator(s)) {
            switch (s) {
                case "+": return ADD;
                case "-": return SUB;
                case "*": return MUL;
                case "/": return DIV;
                default:
                    throw new IllegalArgumentException("Unknown operator");
            }
        }
        return ADD;
    }
}
