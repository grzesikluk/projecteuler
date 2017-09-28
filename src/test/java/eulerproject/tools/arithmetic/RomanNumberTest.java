package eulerproject.tools.arithmetic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumberTest
{

    @Test
    public void testOptimiseRomanNumber() throws Exception {
        List<String> testInput = Arrays.asList("XXIIIII","XVVV","MCXXXXXX","MCCCCCXXXXXX");
        List<String> testExpectedResults = Arrays.asList("XXV","XXV","MCLX","MDLX");

        IntStream.range(0,testExpectedResults.size()).forEach(i-> {
            assertThat(RomanNumber.optimiseRomanNumber(new RomanNumber(testInput.get(i)))).isEqualTo(new RomanNumber(testExpectedResults.get(i)));
        });
    }


    @Test
    public void testEqualsOnRomanNumber() throws Exception {
        Assert.assertTrue(RomanNumber.RomanNumerals.C.compareTo(RomanNumber.RomanNumerals.D) < 0);
        Assert.assertTrue(RomanNumber.RomanNumerals.M.compareTo(RomanNumber.RomanNumerals.D) > 0);
        Assert.assertTrue(RomanNumber.RomanNumerals.C.compareTo(RomanNumber.RomanNumerals.C) == 0);
    }

    @Test
    public void testCheckRuleOne() throws Exception {
        List<String> testInput = Arrays.asList(
                "MXCI",
                "MCVIC",
                "MCI",
                "MMCCVLVI",
                "CXVIXIIIXXCMLXCXXXCIXCXXI",
                "CVIXIII",
                "IXX",
                "IXIVI",
                "IXIVIX",
                "IIVII",
                "VIIXIII",
                "IVIII",
                "DCCIVII",
                "XLIX"

        );
        List<Integer> testExpectedResults = Arrays.asList(
                -1,3,-1,4,3,2,1,1,4,1,2,1,4,-1);

        IntStream.range(0,8).forEach(i-> {
            assertThat(RomanNumber.checkRuleOne(new RomanNumber(testInput.get(i))))
                    .isEqualTo(testExpectedResults.get(i)).describedAs("wrong" + testInput.get(i));
        });

    }

    @Test
    public void testCheckRuleTwo() throws Exception {
        List<String> testInput = Arrays.asList("XCI","IIIIIIIIII","MXXXXXXXXXXXI","MCCCCCCI","DDDXXXXI","MCLLL");
        List<Integer> testExpectedResults = Arrays.asList(-1,0,1,1,0,2);

        IntStream.range(0,testExpectedResults.size()).forEach(i-> {
            assertThat(RomanNumber.checkRuleTwo(new RomanNumber(testInput.get(i)))).isEqualTo(testExpectedResults.get(i));
        });
    }

    @Test
    public void testCheckRuleThree() throws Exception {

        List<String> testInput = Arrays.asList("XCDID","XVVVI","LLCI","LCI");
        List<Integer> testExpectedResults = Arrays.asList(1,1,1,-1);

        IntStream.range(0,testExpectedResults.size()).forEach(i-> {
            assertThat(RomanNumber.checkRuleThree(new RomanNumber(testInput.get(i)))).isEqualTo(testExpectedResults.get(i));
        });
    }

    /**
     * I can only be placed before V and X.
     X can only be placed before L and C.
     C can only be placed before D and M.
     * @throws Exception
     */
    @Test
    public void testCheckRuleFour() throws Exception
    {
        List<String> testInput = Arrays.asList("XXIX", "XXIV", "MCXL", "MCXC", "MCDXX", "MCMCDXX", "XVXI", "LIL", "MCVC", "MCIL", "MLMCDXX", "MDMCDXX", "MMMMVMCDXX");
        List<Integer> testExpectedResults = Arrays.asList(-1, -1, -1, -1, -1, -1, 1, 1, 2, 2, 1, 1, 4);

        IntStream.range(0, testExpectedResults.size()).forEach(i -> {
            assertThat(RomanNumber.checkRuleFour(new RomanNumber(testInput.get(i)))).isEqualTo(testExpectedResults.get(i));
        });

    }

    @Test
    public void testCheckRuleFive() throws Exception {

        List<String> testInput = Arrays.asList("MCVIIII", "MMMMDCCCCVII", "IIIIIIII", "IIIIIIII");
        List<Integer> testExpectedResults = Arrays.asList(2, 4, 0, 0);

        IntStream.range(0, testExpectedResults.size()).forEach(i -> {
            assertThat(RomanNumber.checkRuleFive(new RomanNumber(testInput.get(i)))).isEqualTo(testExpectedResults.get(i));
        });

    }

    @Test
    public void testAsLong() {

        assertThat(new RomanNumber("I").asLong()).isEqualTo(1L);
        assertThat(new RomanNumber("III").asLong()).isEqualTo(3L);
        assertThat(new RomanNumber("IV").asLong()).isEqualTo(4L);
        assertThat(new RomanNumber("V").asLong()).isEqualTo(5L);
        assertThat(new RomanNumber("IX").asLong()).isEqualTo(9L);
        assertThat(new RomanNumber("X").asLong()).isEqualTo(10L);
        assertThat(new RomanNumber("XI").asLong()).isEqualTo(11L);
        assertThat(new RomanNumber("XLIV").asLong()).isEqualTo(44L);
        assertThat(new RomanNumber("LIV").asLong()).isEqualTo(54L);
        assertThat(new RomanNumber("LXIV").asLong()).isEqualTo(64L);
        assertThat(new RomanNumber("LXX").asLong()).isEqualTo(70L);
        assertThat(new RomanNumber("XC").asLong()).isEqualTo(90L);
        assertThat(new RomanNumber("C").asLong()).isEqualTo(100L);
        assertThat(new RomanNumber("CXC").asLong()).isEqualTo(190L);
        assertThat(new RomanNumber("CCCXX").asLong()).isEqualTo(320L);
        assertThat(new RomanNumber("CD").asLong()).isEqualTo(400L);
        assertThat(new RomanNumber("CM").asLong()).isEqualTo(900L);
        assertThat(new RomanNumber("M").asLong()).isEqualTo(1000L);
        assertThat(new RomanNumber("MCCLX").asLong()).isEqualTo(1260L);
        assertThat(new RomanNumber("MCDXL").asLong()).isEqualTo(1440L);

    }
}