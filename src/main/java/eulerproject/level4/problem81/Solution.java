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
    private static int[][] array = new int[80][80];
    private static String FILENAME = "C:\\Users\\Lukasz\\IdeaProjects\\projecteuler\\src\\main\\java\\eulerproject\\level4\\problem81\\p01_matrix.txt";

    public static void main(String[] args) throws IOException {
        loadContents(FILENAME);
//        printArray();
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

    private static void printArray() {
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                System.out.print("[" + array[i][j] + "]");
            }
            System.out.println("\n");
        }
    }


    public static int getMinimalPath(int[][] tab) {
        int result = 0;
        int i = tab.length - 1;
        int j = tab.length - 1;

        result += tab[0][0];


        do {
//            System.out.println("i= "+i + " j= " + j + " tab = " + tab[i][j]);
            result += tab[i][j];

            if (i == 0) {
                j--;
                continue;
            }
            if (j == 0) {
                i--;
                continue;
            }

            if (tab[i - 1][j] < tab[i][j - 1])
                i--;
            else
                j--;


        } while (!(i == 0 && j == 0));

        return result;

    }

}
