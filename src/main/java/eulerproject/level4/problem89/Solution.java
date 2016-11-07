package eulerproject.level4.problem89;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

/**
 * Created by Lukasz on 2016-11-02.
 */
public class Solution {
    private static final String FILENAME = "src\\main\\resources\\eulerproject\\level4\\problem89\\roman.txt";
    private static final String FILENAME_OUT = "src\\main\\resources\\eulerproject\\level4\\problem89\\roman_out.txt";

    private static List<String> romanNumbers;
    private static List<String> optimisedRomanNumbers;


    public static enum RomanNumbers implements Comparable<RomanNumbers> {
        I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

        private int val;

        RomanNumbers(int v) {
            val = v;
        }

        public static RomanNumbers getRomanNumber(char c) {
            switch (c) {
                case 'I':
                    return RomanNumbers.I;
                case 'V':
                    return RomanNumbers.V;
                case 'X':
                    return RomanNumbers.X;
                case 'L':
                    return RomanNumbers.L;
                case 'C':
                    return RomanNumbers.C;
                case 'D':
                    return RomanNumbers.D;
                case 'M':
                    return RomanNumbers.M;
                default:
                    return RomanNumbers.I;
            }
        }

    }

    ;


    public static void main(String[] args) throws IOException {
        loadContents(FILENAME);
        optimisedRomanNumbers = new LinkedList<>();

        romanNumbers.stream().forEach(s->optimisedRomanNumbers.add(optimiseRomanNumber(s)));

        System.out.println(romanNumbers.stream().mapToInt(s -> s.length()).sum()-optimisedRomanNumbers.stream().mapToInt(s -> s.length()).sum());

        writeContents(FILENAME_OUT);

    }

    private static void loadContents(String fileName) throws IOException {
        romanNumbers = Files.lines(Paths.get(fileName)).map(s -> s.trim()).collect(toList());

    }

    private static void writeContents(String fileName) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {

            for (String rn : romanNumbers) {
                String optimised = optimiseRomanNumber(rn);
                if (!optimised.equals(rn))
                    writer.write("* ");

                writer.write(rn + " " + optimiseRomanNumber(rn) + "\n");
                optimisedRomanNumbers.add(optimised);

            }

        } // the file will be automatically closed
    }

    /**
     * Numerals must be arranged in descending order of size.
     *
     * @param s
     * @return int position index where the rule is broken
     */
    public static int checkRuleOne(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (RomanNumbers.getRomanNumber(s.charAt(i)).compareTo(RomanNumbers.getRomanNumber(s.charAt(i + 1))) < 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * M, C, and X cannot be equalled or exceeded by smaller denominations.
     *
     * @param s
     * @return int position index where the rule is broken
     */
    public static int checkRuleTwo(String s) {

        int ix = -1;

        if ((ix = s.indexOf("IIIII")) >= 0)
            return ix;

        if ((ix = s.indexOf("VV")) >= 0)
            return ix;

        if ((ix = s.indexOf("IIIII")) >= 0)
            return ix;

        if ((ix = s.indexOf("XXXXX")) >= 0)
            return ix;

        if ((ix = s.indexOf("CCCCC")) >= 0)
            return ix;

        if ((ix = s.indexOf("LL")) >= 0) //
            return ix;

        if ((ix = s.indexOf("DD")) >= 0) //
            return ix;

        return -1;
    }

    /**
     * D, L, and V can each only appear once.
     *
     * @param s
     * @return int position index where the rule is broken
     */
    public static int checkRuleThree(String s) {

        if ((s.length() - s.replace("V", "").length() > 1) ||
                (s.length() - s.replace("D", "").length()) > 1 ||
                (s.length() - s.replace("L", "").length()) > 1) {
            return 1;
        }

        return -1;
    }

    /**
     * Only one I, X, and C can be used as the leading numeral in part of a subtractive pair.
     * I can only be placed before V and X.
     * X can only be placed before L and C.
     * C can only be placed before D and M.
     * I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
     *
     * @param s
     * @return
     */
    public static int checkRuleFour(String s) {
        int result;

        if ((result = findString(s, "[IXVLD]M")) >= 0)
            return result;

        if ((result = findString(s, "[V]X")) >= 0)
            return result;

        if ((result = findString(s, "[IV]L")) >= 0)
            return result;

        if ((result = findString(s, "[IVL]C")) >= 0)
            return result;

        if ((result = findString(s, "[IVXL]D")) >= 0)
            return result;

        return -1;
    }

    /**
     * This rule checks if non optimal sequence found.
     *
     * @param s
     * @return
     */
    public static int checkRuleFive(String s) {
        int result;

        if ((result = findString(s, "VIIII")) >= 0)
            return result;
        if ((result = findString(s, "DCCCC")) >= 0)
            return result;
        if ((result = findString(s, "CCCC[LXVI]")) >= 0)
            return result;
        if ((result = findString(s, "IIII")) >= 0)
            return result;
        if ((result = findString(s, "XXXX")) >= 0)
            return result;
        if ((result = findString(s, "LXXXX")) >= 0)
            return result;


        return -1;

    }

    private static int findString(String input, String search) {
        Pattern pattern = Pattern.compile(search);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find())
            return matcher.start();
        else
            return -1;

    }

    private static String getEvaluation(String number) {
        StringBuilder sb = new StringBuilder();
        if (checkRuleOne(number) != -1)
            sb.append("Rule one. ");
        if (checkRuleTwo(number) != -1)
            sb.append("Rule two. ");
        if (checkRuleThree(number) != -1)
            sb.append("Rule three. ");
        if (checkRuleFour(number) != -1)
            sb.append("Rule four. ");
        if (checkRuleFive(number) != -1)
            sb.append("Rule five. ");

        return sb.toString();
    }


    public static String optimiseRomanNumber(String input) {
        String output = new String(input);
        String oldValue = "";
        int index = -1;

        while (!output.equals(oldValue)) {
            oldValue = output;

            //part one optimisation
            if ((index = checkRuleTwo(output)) != -1) {
                Character c = output.charAt(index);
                switch (c) {
                    case 'I':
                        output = output.replace("IIIII", "V");
                        break;
                    case 'V':
                        output = output.replace("VV", "X");
                        break;
                    case 'X':
                        output = output.replace("XXXXX", "L");
                        break;
                    case 'L':
                        output = output.replace("LL", "C");
                        break;
                    case 'C':
                        output = output.replace("CCCCC", "D");
                        break;
                }
                continue;

            }
        }
        oldValue = "";
        //part two optimisation
        while (!output.equals(oldValue)) {
            oldValue = output;

            output = output.replace("VIIII", "IX");
            output = output.replace("DCCCC", "CM");
            output = output.replace("CCCC", "CD");
            output = output.replace("IIII", "IV");
            output = output.replace("XXXX", "XL");
            output = output.replace("LXXXX", "XC");

            output = output.replace("DCD", "CM");
            output = output.replace("LXL", "XC");
            output = output.replace("VIV", "IX");


        }


        return output;
    }

    ;

}
