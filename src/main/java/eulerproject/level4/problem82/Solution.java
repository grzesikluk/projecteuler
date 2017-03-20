package eulerproject.level4.problem82;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Lukasz on 2017-03-07.
 */
public class Solution {
    private static final int MAX = 80;
    private static int[][] array = new int[MAX][MAX];
    private static String FILENAME = "src\\main\\resources\\eulerproject\\level4\\problem82\\matrix.txt";

    public static void main(String[] args) throws IOException {
        loadContents(FILENAME);

    }

    private static void loadContents(String fileName) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(fileName));
        int i = 0;
        int j;

        for (String s : lines.collect(Collectors.toList())) {
            j = 0;

            for (String number : s.split(",")) {
                array[i][j] = new Integer(number);
                j++;
            }
            i++;
        }
        lines.close();
    }


    public static void copyArray(int[][] source, int[][] dest) {
        if (source.length != dest.length)
            return;

        for (int i = 0; i < source.length; i++)
            for (int j = 0; j < source.length; j++) {
                dest[i][j] = source[i][j];
            }

    }


    public static void convertColumnTopDown(int[][] array, int k) {

        if (k > array.length || k < 0)
            throw new IllegalArgumentException("Wrong value of k " + k);

        if (k < array.length - 1) {
            array[0][k] += array[0][k + 1]; //right

            for (int i = 1; i < array.length; i++)
                array[i][k] += (array[i][k + 1] > array[i - 1][k]) ? array[i - 1][k] : array[i][k + 1];
        }
    }

    public static void convertColumnBottomUp(int[][] array, int k) {
        if (k > array.length || k < 0)
            throw new IllegalArgumentException("Wrong value of k " + k);

        if (k < array.length - 1) {
            array[array.length - 1][k] += array[array.length - 1][k + 1]; //right

            for (int i = array.length - 2; i >=0 ; i--)
                array[i][k] += (array[i][k + 1] > array[i + 1][k]) ? array[i + 1][k] : array[i][k + 1];
        }
    }

}
