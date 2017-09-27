package eulerproject.level4.problem89;

import eulerproject.tools.arithmetic.RomanNumber;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by Lukasz on 2016-11-02.
 */
public class Solution {
    private static final String FILENAME = "src/main/resources/eulerproject/level4/problem89/roman.txt";

    private static List<RomanNumber> romanNumbers;
    private static List<RomanNumber> optimisedRomanNumbers;

    public static void main(String[] args) throws IOException {
        romanNumbers = getNumbersFromFile(FILENAME);
        optimisedRomanNumbers = optimiseRomanNumbers(romanNumbers);
        System.out.println(getSolution());
    }

    private static List<RomanNumber> optimiseRomanNumbers(List<RomanNumber> input) {
        return input.stream().map(RomanNumber::optimiseRomanNumber).collect(Collectors.toList());
    }

    private static List<RomanNumber> getNumbersFromFile(final String fileName) throws IOException {
        return Files.lines(Paths.get(fileName)).map(s -> s.trim()).map(RomanNumber::new).collect(toList());
    }

    public static long getSolution()
    {
        return romanNumbers.stream().mapToInt(s -> s.getNumberString().length()).sum()-optimisedRomanNumbers.stream().mapToInt(s -> s.getNumberString().length()).sum();
    }
}
