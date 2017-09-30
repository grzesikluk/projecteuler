package eulerproject.tools.arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static eulerproject.tools.arithmetic.RomanNumber.RomanNumerals.C;
import static eulerproject.tools.arithmetic.RomanNumber.RomanNumerals.D;
import static eulerproject.tools.arithmetic.RomanNumber.RomanNumerals.I;
import static eulerproject.tools.arithmetic.RomanNumber.RomanNumerals.L;
import static eulerproject.tools.arithmetic.RomanNumber.RomanNumerals.M;
import static eulerproject.tools.arithmetic.RomanNumber.RomanNumerals.V;
import static eulerproject.tools.arithmetic.RomanNumber.RomanNumerals.X;

public class RomanNumber
{
    private final static Map<RomanNumerals, RomanNumerals> ALLOWED_SUBSTRACTIVE_PAIRS;

    static {
        ALLOWED_SUBSTRACTIVE_PAIRS = new HashMap<>();
        ALLOWED_SUBSTRACTIVE_PAIRS.put(V, I);
        ALLOWED_SUBSTRACTIVE_PAIRS.put(X, I);
        ALLOWED_SUBSTRACTIVE_PAIRS.put(L, X);
        ALLOWED_SUBSTRACTIVE_PAIRS.put(C, X);
        ALLOWED_SUBSTRACTIVE_PAIRS.put(D, C);
        ALLOWED_SUBSTRACTIVE_PAIRS.put(M, C);
    }

    public String getNumberString()
    {
        return numberString;
    }

    private String numberString;

    public RomanNumber(final String value)
    {
        numberString = new String(value);
    }

    public enum RomanNumerals implements Comparable<RomanNumerals>
    {
        I(1), V(5), X(10), L(50), C(100), D(500), M(1000), UNSET(0);

        public int getVal()
        {
            return val;
        }

        private int val;

        RomanNumerals(int v)
        {
            val = v;
        }

        public static RomanNumerals getRomanNumber(char c)
        {
            switch (c) {
                case 'I':
                    return I;
                case 'V':
                    return V;
                case 'X':
                    return X;
                case 'L':
                    return L;
                case 'C':
                    return C;
                case 'D':
                    return D;
                case 'M':
                    return M;
                default:
                    return I;
            }
        }

    }

    public boolean checkAllRules()
    {
        return
                !(checkRuleOne(this) != -1 ||
                        checkRuleTwo(this) != -1 ||
                        checkRuleThree(this) != -1 ||
                        checkRuleFour(this) != -1 ||
                        checkRuleFive(this) != -1);
    }

    /**
     * Numerals must be arranged in descending order of size.
     * This rule doesn't apply to substractive pairs.
     * <p>
     * todo: this must be revised for example correct number is: XLII but we have to discard CIIICIICL
     *
     * @param number
     * @return int position index where the rule is broken
     */
    public static int checkRuleOne(final RomanNumber number)
    {
        String copy = new String(number.getNumberString());
        RomanNumerals HSN = RomanNumerals.UNSET;

        int i = 0;
        while (i < copy.length() - 1) {
            RomanNumerals first = RomanNumerals.getRomanNumber(copy.charAt(i));
            RomanNumerals second = RomanNumerals.getRomanNumber(copy.charAt(i + 1));

            if (first.compareTo(second) >= 0) {

                if (second.compareTo(HSN) >= 0)
                    return i;
            } else {
                if (isAllowedSubstractionPair(first, second)) {
                    if (second.compareTo(HSN) >= 0)
                        return i;
                    else
                        HSN = first;
                } else
                    return i;
            }

            i++;
        }
        return -1;
    }

    /**
     * M, C, and X cannot be equalled or exceeded by smaller denominations.
     *
     * @param number
     * @return int position index where the rule is broken
     */
    public static int checkRuleTwo(RomanNumber number)
    {

        int ix = -1;

        if ((ix = number.numberString.indexOf("IIIII")) >= 0)
            return ix;

        if ((ix = number.numberString.indexOf("VV")) >= 0)
            return ix;

        if ((ix = number.numberString.indexOf("IIIII")) >= 0)
            return ix;

        if ((ix = number.numberString.indexOf("XXXXX")) >= 0)
            return ix;

        if ((ix = number.numberString.indexOf("CCCCC")) >= 0)
            return ix;

        if ((ix = number.numberString.indexOf("LL")) >= 0) //
            return ix;

        if ((ix = number.numberString.indexOf("DD")) >= 0) //
            return ix;

        return -1;
    }

    /**
     * D, L, and V can each only appear once.
     *
     * @param number
     * @return int position index where the rule is broken
     */
    public static int checkRuleThree(RomanNumber number)
    {

        if ((number.numberString.length() - number.numberString.replace("V", "").length() > 1) ||
                (number.numberString.length() - number.numberString.replace("D", "").length()) > 1 ||
                (number.numberString.length() - number.numberString.replace("L", "").length()) > 1) {
            return 1;
        }

        return -1;
    }

    /**
     * Only one I, X, and C can be used as the leading numeral in part of a subtractive pair.
     * I can only be placed before V and X.
     * X can only be placed before L and C.
     * C can only be placed before D and M.
     *
     * @param s
     * @return
     */
    public static int checkRuleFour(RomanNumber s)
    {
        int result;

        if ((result = findString(s.numberString, "[IXVLD]M")) >= 0)
            return result;

        if ((result = findString(s.numberString, "[V]X")) >= 0)
            return result;

        if ((result = findString(s.numberString, "[IV]L")) >= 0)
            return result;

        if ((result = findString(s.numberString, "[IVL]C")) >= 0)
            return result;

        if ((result = findString(s.numberString, "[IVXL]D")) >= 0)
            return result;

        return -1;
    }

    /**
     * This rule checks if non optimal sequence found.
     *
     * @param s
     * @return
     */
    public static int checkRuleFive(RomanNumber s)
    {
        int result;

        if ((result = findString(s.numberString, "VIIII")) >= 0)
            return result;
        if ((result = findString(s.numberString, "DCCCC")) >= 0)
            return result;
        if ((result = findString(s.numberString, "CCCC[LXVI]")) >= 0)
            return result;
        if ((result = findString(s.numberString, "IIII")) >= 0)
            return result;
        if ((result = findString(s.numberString, "XXXX")) >= 0)
            return result;
        if ((result = findString(s.numberString, "LXXXX")) >= 0)
            return result;

        return -1;
    }

    private static int findString(String input, String search)
    {
        Pattern pattern = Pattern.compile(search);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find())
            return matcher.start();
        else
            return -1;
    }

    public static RomanNumber optimiseRomanNumber(RomanNumber input)
    {
        RomanNumber output = new RomanNumber(input.numberString);
        String oldValue = "";
        int index = -1;

        while (!output.getNumberString().equals(oldValue)) {
            oldValue = output.numberString;

            //part one optimisation
            if ((index = checkRuleTwo(output)) != -1) {
                Character c = output.numberString.charAt(index);
                switch (c) {
                    case 'I':
                        output.numberString = output.numberString.replace("IIIII", "V");
                        break;
                    case 'V':
                        output.numberString = output.numberString.replace("VV", "X");
                        break;
                    case 'X':
                        output.numberString = output.numberString.replace("XXXXX", "L");
                        break;
                    case 'L':
                        output.numberString = output.numberString.replace("LL", "C");
                        break;
                    case 'C':
                        output.numberString = output.numberString.replace("CCCCC", "D");
                        break;
                }
                continue;
            }
        }
        oldValue = "";
        //part two optimisation
        while (!output.getNumberString().equals(oldValue)) {
            oldValue = output.numberString;

            output.numberString = output.numberString.replace("VIIII", "IX");
            output.numberString = output.numberString.replace("DCCCC", "CM");
            output.numberString = output.numberString.replace("CCCC", "CD");
            output.numberString = output.numberString.replace("IIII", "IV");
            output.numberString = output.numberString.replace("XXXX", "XL");
            output.numberString = output.numberString.replace("LXXXX", "XC");
            output.numberString = output.numberString.replace("DCD", "CM");
            output.numberString = output.numberString.replace("LXL", "XC");
            output.numberString = output.numberString.replace("VIV", "IX");
        }
        return output;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final RomanNumber that = (RomanNumber) o;

        return numberString != null ? numberString.equals(that.numberString) : that.numberString == null;
    }

    @Override
    public int hashCode()
    {
        return numberString != null ? numberString.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return "RomanNumber{" +
                "numberString='" + numberString + '\'' +
                '}';
    }

    public long asLong()
    {
        final long[] returnValue = {0};

        IntStream.range(0, numberString.length()).forEach(i -> {
            RomanNumerals currSymbol = RomanNumerals.getRomanNumber(numberString.charAt(i));
            RomanNumerals nextSymbol = (i < numberString.length() - 1) ? RomanNumerals.getRomanNumber(numberString.charAt(i + 1)) : RomanNumerals.getRomanNumber('I');

            if (currSymbol.compareTo(nextSymbol) >= 0)
                returnValue[0] += currSymbol.getVal();
            else
                returnValue[0] -= currSymbol.getVal();
        });

        return returnValue[0];
    }

    private static boolean isAllowedSubstractionPair(RomanNumerals a, RomanNumerals next)
    {
        return ALLOWED_SUBSTRACTIVE_PAIRS.containsKey(next) && ALLOWED_SUBSTRACTIVE_PAIRS.get(next).equals(a);
    }
}
