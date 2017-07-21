package eulerproject.level4.problem83;

import eulerproject.tools.graph.Graph;

import java.io.IOException;
import java.util.List;

/**
 * Created by lgrzesik on 19/07/17.
 */
public class Solution extends eulerproject.level4.problem82.Solution
{
    private static String FILENAME = "src/main/resources/eulerproject/level4/problem83/p083_matrix.txt";

    public static void main(String[] args) throws IOException
    {
        loadContents(FILENAME);
        Graph<ValueWithCoords> graph = DataConverter.generateGraphFromArray(array);
        System.out.println(graph);
    }



}
