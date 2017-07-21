package eulerproject.level4.problem83;

import eulerproject.tools.graph.Edge;
import eulerproject.tools.graph.Graph;
import eulerproject.tools.graph.MinimalPathAlgorithm;
import eulerproject.tools.graph.Vertex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraAlgorithm<E extends Comparable> implements MinimalPathAlgorithm<E>
{
    @Override
    public List<Edge> getMinimalPathByEdges(final Vertex source, final Vertex destination, final Graph graph)
    {
        Map<Vertex<E>, Integer> distancesMap = new HashMap<>();
        Map<Vertex<E>, Vertex<E>> neighbourMap = new HashMap<>();

        graph.getVertices().stream().forEach(s -> {
            distancesMap.put((Vertex<E>) s, Integer.MAX_VALUE);
            neighbourMap.put((Vertex<E>) s, null);
        });

        distancesMap.put(source, 0);

        //todo algo follows here

        return null;
    }

    @Override
    public List<Vertex> getMinimalPathByVertex(final Vertex source, final Vertex destination, final Graph graph)
    {
        return null;
    }

    private PriorityQueue<Vertex<E>> getPriorityQueue(List<Vertex<E>> input)
    {

        //todo: implement me
        return null;

    }
}
