package eulerproject.level4.problem82;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Lukasz on 2017-03-07.
 */
public class Solution {
    private static final int MAX = 80;
    protected static int[][] array = new int[MAX][MAX];
    private static String FILENAME = "src/main/resources/eulerproject/level4/problem82/matrix.txt";

    public static void main(String[] args) throws IOException {
        loadContents(FILENAME);
        System.out.println(getMinimumPath(array));
    }

    protected static void loadContents(String fileName) throws IOException {
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


    protected static void copyArray(int[][] source, int[][] dest) {
        if (source.length != dest.length)
            return;

        for (int i = 0; i < source.length; i++)
            for (int j = 0; j < source.length; j++) {
                dest[i][j] = source[i][j];
            }

    }


    public static int getMinimumPath(int[][] array) {
        int[] solution = new int[array.length];
        int max = array.length - 1;

        for (int i = 0; i <= max; i++)
            solution[i] = array[i][max];

        for (int i = max - 1; i >= 0; i--) {
            solution[0] += array[0][i];

            for (int j = 1; j <= max; j++)
                solution[j] = Math.min(solution[j - 1] + array[j][i], solution[j] + array[j][i]);

            for (int j = max-1; j >=0; j--)
                solution[j] = Math.min(solution[j], solution[j+1] + array[j][i]);
        }

        return IntStream.of(solution).min().getAsInt();
    }

}
