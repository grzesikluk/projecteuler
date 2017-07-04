package eulerproject.level4.problem96;

import java.io.IOException;

/**
 * Created by Lukasz on 2017-07-02.
 */
public class Solution {
    private static final String FILENAME = "src\\main\\resources\\eulerproject\\level4\\problem96\\p096_sudoku.txt";

    public static void main(String[] args) throws IOException, InterruptedException {

        FileReader fileReader = new FileReader(FILENAME);
        fileReader.read();

        SudokuMatrix sudokuMatrix;

        int result = 0;

        while ((sudokuMatrix = fileReader.getNext()) != null) {
            SudokuSolver sudokuSolver = new SudokuSolver(sudokuMatrix);


            result += sudokuSolver.getSolution();

        }
        System.out.println(result);


    }
}
