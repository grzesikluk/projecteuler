package eulerproject.level4.problem79;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    private static final String FILENAME = "C:\\Users\\Lukasz\\IdeaProjects\\projecteuler\\src\\main\\java\\eulerproject\\level4\\problem79\\keylog.txt";
    private static Set<String> codesArray;

    public static void main(String[] args) throws IOException {

        getFileContent(FILENAME);
        System.out.println(decodePassword());

    }


    public static void getFileContent(String fileName) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(fileName));
        codesArray = lines.collect(Collectors.toSet());
        lines.close();
    }

    public static String decodePassword() {
        String result;

        //pick first elem
        result = codesArray.stream().collect(Collectors.toList()).get(0);

        char middleChar = 'x';
        int i = 0;

        while (i < result.length()-1) {
            while (((middleChar = getMiddleChar(result.charAt(i), result.charAt(i + 1))) != ' ')) {
                result = result.substring(0,i+1) + middleChar + result.substring(i+1,result.length());
            }
            i++;
        }

        return result;
    }


    public static char getMiddleChar(char a, char b) {

        for (String s : codesArray) {
            if (s.charAt(0) == a && s.charAt(2) == b)
                return s.charAt(1);
        }

        return ' ';
    }


}
