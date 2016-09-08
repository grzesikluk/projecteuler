package eulerproject.problem42;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by grzesikl on 26/08/2016.
 */
public class Solution {
    public static final String FILE_NAME = "C:\\UBS\\Dev\\IDEs\\repos\\Workspace\\OCP8_Exam\\src\\main\\java\\eulerproject\\problem42\\p042_words.txt";
    public static final int MAX_N = 50;

    private static int[] triangleNumbers = new int[MAX_N];

    static {
        for(int i =1; i<MAX_N;i++) {
            triangleNumbers[i] = getTriangleNumber(i);
        }
    }

    public static void main(String[] args) {

        readFile();
    }

    public static void readFile() {

        String fileName = FILE_NAME;

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            System.out.println(stream.map(s -> s.replace("\"","")).filter(s->checkWord(s)).count());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean checkWord(String word) {
        String convertedWord = word.toUpperCase();

        return isTriangleNumber(getWordValue(word));

    }

    public static int getWordValue(String word) {
        int result=0;
        for(Character c:word.toCharArray()) {
            result+= normalizeChar(c);
        }
        return result;
    }

    public static int normalizeChar(Character c) {
        return (int)c-64;
    }


    public static int getTriangleNumber(int n) {
        return n*(n+1)/2;
    }

    public static boolean isTriangleNumber(int n) {
        for(int i=1;i<MAX_N;i++) {
            if (triangleNumbers[i] == n)
                return true;
        };
        return false;
    }
}
