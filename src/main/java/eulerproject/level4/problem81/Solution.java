package eulerproject.level4.problem81;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Lukasz on 2016-11-02.
 */
public class Solution {
    private static final int MAX = 80;
    private static int[][] array = new int[MAX][MAX];
    
    private static String FILENAME = "C:\\Users\\Lukasz\\IdeaProjects\\projecteuler\\src\\main\\java\\eulerproject\\level4\\problem81\\p01_matrix.txt";
    public static void main(String[] args) throws IOException {
        loadContents(FILENAME);
        System.out.println(getMinimalPath(array));

    }

    private static void loadContents(String fileName) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(fileName));
        int i = 0;
        int j = 0;

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

    public static void printArray() {
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                System.out.print("[" + array[i][j] + "]");
            }
            System.out.println("\n");
        }
    }

    public static int getMinimalPath(int[][] tab) {
        int[][] convArray = createConvertArray(tab);
        return convArray[0][0];
    }

    /**
     * create converted array for solving problem
     */
    public static int[][] createConvertArray(int[][] tab) {
        int[][] convArray = new int[tab.length][tab.length];

        copyArray(tab, convArray);

        for (int y = convArray.length - 1; y >= 0; y--)
            for (int x = convArray.length - 1; x >= 0; x--) {
                updateField(x,y,convArray);
            }


        return convArray;
    }

    /**
     * copy square matrix from source to dest.
     *
     * @param source
     * @param dest
     */
    public static void copyArray(int[][] source, int[][] dest) {
        if (source.length != dest.length)
            return;

        for (int i = 0; i < source.length; i++)
            for (int j = 0; j < source.length; j++) {
                dest[i][j] = source[i][j];
            }

    }


    public static void updateField(int y, int x, int[][] convArray) {
        int range = convArray.length - 1;

        //normal case
        if ((x + 1) <= range && (y + 1) <= range) {
            convArray[x][y] += (convArray[x][y + 1] < convArray[x + 1][y]) ? convArray[x][y + 1] : convArray[x + 1][y];
            return;
        }

        //y axis out of range
        if ((x + 1) <= range && !((y + 1) <= range)) {
            convArray[x][y] += convArray[x + 1][y];
            return;
        }

        //x axis out of range
        if (!((x + 1) <= range) && ((y + 1) <= range)) {
            convArray[x][y] += convArray[x][y + 1];
            return;
        }


        //last field
        if (!((x + 1) <= range) && !((y + 1) <= range)) {
            //do not update
            return;
        }


    }

}
