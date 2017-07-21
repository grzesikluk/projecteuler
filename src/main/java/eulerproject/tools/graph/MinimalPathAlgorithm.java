package eulerproject.tools.graph;

import java.util.List;

public interface MinimalPathAlgorithm<E extends Comparable>
{
    public List<Edge<E>> getMinimalPathByEdges(Vertex<E> source, Vertex<E> destination, Graph<E> graph);

    public List<Vertex<E>> getMinimalPathByVertex(Vertex<E> source, Vertex<E> destination, Graph<E> graph);

}
