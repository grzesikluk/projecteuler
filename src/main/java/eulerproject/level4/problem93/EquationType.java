package eulerproject.level4.problem93;

import java.util.LinkedList;
import java.util.List;

public enum EquationType
{
    DDODODO, DDDODOO, DDODDOO, DDDDOOO, DDDOODO;

    public static List<String> getEquation(EquationType type, final List<String> digits, final List<String> operators)
    {
        List<String> equation = new LinkedList<>();

        switch (type) {
            case DDODODO: {
                equation.add(digits.get(0));
                equation.add(digits.get(1));
                equation.add(operators.get(0));
                equation.add(digits.get(2));
                equation.add(operators.get(1));
                equation.add(digits.get(3));
                equation.add(operators.get(2));
                return equation;
            }
            case DDDODOO: {
                equation.add(digits.get(0));
                equation.add(digits.get(1));
                equation.add(digits.get(2));
                equation.add(operators.get(0));
                equation.add(digits.get(3));
                equation.add(operators.get(1));
                equation.add(operators.get(2));
                return equation;
            }
            case DDODDOO: {
                equation.add(digits.get(0));
                equation.add(digits.get(1));
                equation.add(operators.get(0));
                equation.add(digits.get(2));
                equation.add(digits.get(3));
                equation.add(operators.get(1));
                equation.add(operators.get(2));
                return equation;
            }
            case DDDDOOO: {
                equation.add(digits.get(0));
                equation.add(digits.get(1));
                equation.add(digits.get(2));
                equation.add(digits.get(3));
                equation.add(operators.get(0));
                equation.add(operators.get(1));
                equation.add(operators.get(2));
                return equation;
            }
            case DDDOODO: {
                equation.add(digits.get(0));
                equation.add(digits.get(1));
                equation.add(digits.get(2));
                equation.add(operators.get(0));
                equation.add(operators.get(1));
                equation.add(digits.get(3));
                equation.add(operators.get(2));
                return equation;
            }
        }
        return equation;
    }
}
