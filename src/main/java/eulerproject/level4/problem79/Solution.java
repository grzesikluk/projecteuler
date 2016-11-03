package eulerproject.level4.problem79;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    private static final String FILENAME = "C:\\Users\\grzesikl\\IdeaProjects\\ProjectEuler\\src\\main\\java\\eulerproject\\level4\\problem79\\keylog.txt";
    private static Set<String> codesArray;


    public static void main(String[] args) throws IOException {

        getFileContent(FILENAME);
        System.out.println(decodePassword());

    }


    private static void getFileContent(String fileName) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(fileName));
        codesArray = lines.collect(Collectors.toSet());
        lines.close();
    }

    public static String decodePassword() {

        return "";
    }


}
