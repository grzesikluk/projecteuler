package eulerproject.tools.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lgrzesik on 19/07/17.
 */
public class Vertex<E>
{
    public List<Edge> getEdgeList()
    {
        return edgeList;
    }

    public E getValue()
    {
        return value;
    }

    private List<Edge> edgeList;
    private E value;

    public Vertex(final E value)
    {
        this.value = value;
        edgeList = new ArrayList<>();
    }

    public void addEdge(final Edge<E> edge)
    {
        edgeList.add(edge);
    }

    public void addEdge(final int value, Vertex neighbour)
    {
        edgeList.add(new Edge(this, neighbour, value));
    }

    public List<Vertex> getNeighbours()
    {
        return edgeList.stream().map(s -> s.getNodeTwo()).collect(Collectors.toList());
    }

    @Override
    public String toString()
    {
        return value.toString();
    }
}
