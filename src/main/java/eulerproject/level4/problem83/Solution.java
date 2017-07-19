package eulerproject.level4.problem83;

import eulerproject.tools.graph.Graph;
import eulerproject.tools.graph.Vertex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

        Graph<List<Integer>> graph = generateGraphFromArray(array);

        System.out.println(graph);
    }

    protected static Graph<List<Integer>> generateGraphFromArray(final int[][] array)
    {
        List<Vertex<List<Integer>>> vertices = new ArrayList<>();
        Vertex<List<Integer>>[][] vertexArray = new Vertex[array.length][array.length];

        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++) {
                Vertex<List<Integer>> newVertex = createVertex(i, j, array);
                vertices.add(newVertex);
                vertexArray[i][j] = newVertex;
            }

        linkNeighbours(vertexArray);

        return new Graph<>(vertices);
    }

    private static Vertex<List<Integer>> createVertex(int x, int y, int[][] array)
    {
        return new Vertex<List<Integer>>(Arrays.asList(x, y, array[x][y]));
    }

    private static void linkNeighbours(Vertex<List<Integer>>[][] arrayOfVertexes)
    {
        for (int i = 0; i < arrayOfVertexes.length; i++)
            for (int j = 0; j < arrayOfVertexes.length; j++) {
                linkNeighbours(i, j, arrayOfVertexes);
            }
    }

    private static void linkNeighbours(int x, int y, Vertex<List<Integer>>[][] arrayOfVertexes)
    {
        Vertex<List<Integer>> vertex = arrayOfVertexes[x][y];

        //add N neighbour
        if (x > 0)
            vertex.addEdge(arrayOfVertexes[x - 1][y].getValue().get(2), arrayOfVertexes[x - 1][y]);

        if (x < arrayOfVertexes.length - 1)
            vertex.addEdge(arrayOfVertexes[x + 1][y].getValue().get(2), arrayOfVertexes[x + 1][y]);

        if (y > 0)
            vertex.addEdge(arrayOfVertexes[x][y - 1].getValue().get(2), arrayOfVertexes[x][y - 1]);

        if (y < arrayOfVertexes.length - 1)
            vertex.addEdge(arrayOfVertexes[x][y + 1].getValue().get(2), arrayOfVertexes[x][y + 1]);
    }
}
