package eulerproject.level4.problem89;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Lukasz on 2016-11-02.
 */
public class Solution {
    private static final String FILENAME = "C:\\Users\\Lukasz\\IdeaProjects\\projecteuler\\src\\main\\java\\eulerproject\\level4\\problem89\\roman.txt";
    private static List<String> romanNumbers;

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
        System.out.println(romanNumbers);


    }

    private static void loadContents(String fileName) throws IOException {
        romanNumbers = Files.lines(Paths.get(fileName)).collect(toList());
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

        if((ix=s.indexOf("IIIII"))>=0)
            return ix;

        if((ix=s.indexOf("VV"))>=0)
            return ix;

        if((ix=s.indexOf("IIIII"))>=0)
            return ix;

        if((ix=s.indexOf("XXXXX"))>=0)
            return ix;

        if((ix=s.indexOf("CCCCC"))>=0)
            return ix;

        if((ix=s.indexOf("LL"))>=0) //
            return ix;

        if((ix=s.indexOf("DD"))>=0) //
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

    public static int findNextSubstractivePair(String s, int ix) {

        return 0;

    }

}
