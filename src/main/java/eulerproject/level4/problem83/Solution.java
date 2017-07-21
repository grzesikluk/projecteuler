package eulerproject.level4.problem83;

import eulerproject.tools.graph.Graph;
import eulerproject.tools.graph.Vertex;

import java.io.IOException;
import java.util.List;


public class Solution extends eulerproject.level4.problem82.Solution {
    private static String FILENAME = "src/main/resources/eulerproject/level4/problem83/p083_matrix.txt";
    private static final int MIN_IX = 0;
    private static final int MAX_IX = MAX - 1;

    public static void main(String[] args) throws IOException {

        loadContents(FILENAME, array);

        //create graph
        Graph<ValueWithCoords> graph = DataConverter.generateGraphFromArray(array);

        //indicate start, stop
        Vertex<ValueWithCoords> source = graph.getVertices().stream().filter(v -> v.getValue().getX() == MIN_IX && v.getValue().getY() == MIN_IX).findFirst().get();
        Vertex<ValueWithCoords> destination = graph.getVertices().stream().filter(v -> v.getValue().getX() == MAX_IX && v.getValue().getY() == MIN_IX).findFirst().get();

        System.out.println(new DijkstraAlgorithm<ValueWithCoords>().getMinimalPathValue(source, destination, graph) + source.getValue().getVal());
    }

}
