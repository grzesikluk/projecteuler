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
    private static boolean[][] updated = new boolean[MAX][MAX];

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

    private static void clearUpdated() {
        for (int i = 0; i < MAX; i++)
            for (int j = 0; j < MAX; j++)
                updated[i][j] = false;
    }

    public static int[][] createConvertArrayForLastPosition(final int[][] inputArray, int x, int y) {
        int[][] convArray = new int[inputArray.length][inputArray.length];

        /*
            Starting from last position of possible solutions we are tracing back updating
            the copy of initial array. The solution is minimum in first column.
        * */

        copyArray(inputArray, convArray);
        clearUpdated();
        updateField(x, y, convArray);

        return convArray;
    }

    public static void copyArray(int[][] source, int[][] dest) {
        if (source.length != dest.length)
            return;

        for (int i = 0; i < source.length; i++)
            for (int j = 0; j < source.length; j++) {
                dest[i][j] = source[i][j];
            }

    }

    public static void updateField(int x, int y, int[][] convArray) {
        int range = convArray.length - 1;

        //TODO: implement


    }

}
