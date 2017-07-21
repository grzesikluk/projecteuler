package eulerproject.tools.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vertex<E extends Comparable> implements Comparable
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

    @Override
    public int compareTo(final Object o)
    {
        if (o instanceof Vertex) {
            Vertex other = (Vertex)o;

            if(other.getValue() != null)
                return getValue().compareTo((E) other.getValue());
        }

        return -1;
    }
}
