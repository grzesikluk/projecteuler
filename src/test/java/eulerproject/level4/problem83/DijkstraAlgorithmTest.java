package eulerproject.level4.problem83;

import eulerproject.tools.graph.Graph;
import eulerproject.tools.graph.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Lukasz on 2017-07-21.
 */
public class DijkstraAlgorithmTest {
    private Graph<ValueWithCoords> graph;
    private static String FILENAME = "src\\test\\java\\eulerproject\\level4\\problem83\\testmatrix.txt";
    private static final int MAX = 5;
    protected int[][] array = new int[MAX][MAX];

    private Vertex<ValueWithCoords> source;
    private  Vertex<ValueWithCoords> destination;

    @Before
    public void init() throws IOException {
        Solution.loadContents(FILENAME, array);
        graph = DataConverter.generateGraphFromArray(array);

        source = graph.getVertices().stream().filter(v-> v.getValue().getX() == 0 && v.getValue().getY() == 0).findFirst().get();
        destination = graph.getVertices().stream().filter(v-> v.getValue().getX() == 4 && v.getValue().getY() == 4).findFirst().get();
    }

    @Test
    public void testGetMinimalPathByEdges() throws Exception {

        Assert.assertEquals(2297, new DijkstraAlgorithm<ValueWithCoords>().getMinimalPathValue(source, destination, graph) + source.getValue().getVal());
    }

}