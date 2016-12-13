package eulerproject.level3.problem67;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Lukasz on 2016-12-13.
 */
public class TriangleNumbers {
    private List<List<Integer>> arrayOfNumbers;

    private List<List<Integer>> readFileAsArray(String fileName) throws IOException {
        List<List<Integer>> resultArray = new ArrayList<>();

        Stream<String> lines = Files.lines(Paths.get(fileName));

        resultArray = lines.map(s -> s.split(" ")).map(t -> {
            List<Integer> res = new ArrayList<Integer>();
            for (String s : t)
                res.add(new Integer(s));
            return res;
        }).collect(Collectors.toList());

        return resultArray;
    }

    public List<Integer> getRow(int rowNumber) {
        return arrayOfNumbers.get(rowNumber);
    }


    public TriangleNumbers(String fileName) {
        try {
            arrayOfNumbers = readFileAsArray(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getMaximumPath() {

        for (int i = arrayOfNumbers.size() - 1; i >= 0; i--)
            convertRow(i);

        return arrayOfNumbers.get(0).get(0);
    }

    public void convertRow(int k) {

        if (k < getSize() - 1) {
            for (int i = 0; i < arrayOfNumbers.get(k).size(); i++) {
                int l = arrayOfNumbers.get(k).get(i);
                int v = getProperNeighbourValue(i, k);
                arrayOfNumbers.get(k).set(i, l + v);
            }

        }

    }

    public int getRightNeighbour(int col, int row) {

        if (row < getSize())
            return arrayOfNumbers.get(row + 1).get(col + 1);
        else return 0;

    }

    public int getLeftNeighbour(int col, int row) {

        if (row < getSize())
            return arrayOfNumbers.get(row + 1).get(col);

        else return 0;

    }


    public int getProperNeighbourValue(int col, int row) {
        return (getRightNeighbour(col, row) > (getLeftNeighbour(col, row))) ? getRightNeighbour(col, row) : getLeftNeighbour(col, row);
    }

    public int getSize() {
        return arrayOfNumbers.size();

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (List<Integer> list : arrayOfNumbers)
            sb.append(list.toString() + "\n");

        return sb.toString();
    }
}
