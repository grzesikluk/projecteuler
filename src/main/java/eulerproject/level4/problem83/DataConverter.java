package eulerproject.level4.problem83;

import eulerproject.tools.graph.Graph;
import eulerproject.tools.graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class DataConverter
{
    protected static Graph<List<Integer>> generateGraphFromArray(final int[][] array)
    {
        List<Vertex<ValueWithCoords>> vertices = new ArrayList<>();

        Vertex<ValueWithCoords>[][] vertexArray = new Vertex[array.length][array.length];

        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++) {
                Vertex<ValueWithCoords> newVertex = createVertex(i, j, array);
                vertices.add(newVertex);
                vertexArray[i][j] = newVertex;
            }

        linkNeighbours(vertexArray);

        return new Graph(vertices);
    }

    private static Vertex<ValueWithCoords> createVertex(int x, int y, int[][] array)
    {
        return new Vertex<ValueWithCoords>(new ValueWithCoords(x, y, array[x][y]));
    }

    private static void linkNeighbours(Vertex<ValueWithCoords>[][] arrayOfVertexes)
    {
        for (int i = 0; i < arrayOfVertexes.length; i++)
            for (int j = 0; j < arrayOfVertexes.length; j++) {
                linkNeighbours(i, j, arrayOfVertexes);
            }
    }

    private static void linkNeighbours(int x, int y, Vertex<ValueWithCoords>[][] arrayOfVertexes)
    {
        Vertex<ValueWithCoords> vertex = arrayOfVertexes[x][y];

        //add N neighbour
        if (x > 0)
            vertex.addEdge(arrayOfVertexes[x - 1][y].getValue().getVal(), arrayOfVertexes[x - 1][y]);

        if (x < arrayOfVertexes.length - 1)
            vertex.addEdge(arrayOfVertexes[x + 1][y].getValue().getVal(), arrayOfVertexes[x + 1][y]);

        if (y > 0)
            vertex.addEdge(arrayOfVertexes[x][y - 1].getValue().getVal(), arrayOfVertexes[x][y - 1]);

        if (y < arrayOfVertexes.length - 1)
            vertex.addEdge(arrayOfVertexes[x][y + 1].getValue().getVal(), arrayOfVertexes[x][y + 1]);
    }
}
