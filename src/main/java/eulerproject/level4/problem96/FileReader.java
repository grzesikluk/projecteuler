package eulerproject.level4.problem96;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Lukasz on 2017-07-02.
 */
public class FileReader {

    public static final String FILENAME = "src\\main\\resources\\eulerproject\\level4\\problem96\\p096_sudoku.txt";
    private String filename;
    private int matrixPointer = -1;

    public List<String> getFileContent() {
        return fileContent;
    }

    private List<String> fileContent;

    public FileReader(String fileName) {
        filename = fileName;
    }

    public void read() throws IOException {
        fileContent = Files.lines(Paths.get(filename)).map(s -> s.trim()).collect(toList());
    }

    @Override
    public String toString() {
        return fileContent.toString();
    }


    public SudokuMatrix getNext() {
        if (fileContent.size() < 10)
            return null; //nothing to read
        else {
            if (matrixPointer == -1)

                matrixPointer = 0;
            else
                matrixPointer++;
        }

        try {
            List<String> subList = fileContent.subList(matrixPointer * 10, (matrixPointer + 1) * 10);
            return new SudokuMatrix(subList);
        }
        catch (IndexOutOfBoundsException e) {
            //no success
            return null;
        }
    }
}
