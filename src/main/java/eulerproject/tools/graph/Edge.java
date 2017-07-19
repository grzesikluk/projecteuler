package eulerproject.tools.graph;

/**
 * Created by lgrzesik on 19/07/17.
 */
public class Edge<E>
{
    public Edge(final Vertex<E> nodeOne, final Vertex<E> nodeTwo, final int value)
    {
        this.nodeOne = nodeOne;
        this.nodeTwo = nodeTwo;
        this.value = value;
        this.directed = false;
    }

    public Vertex<E> getNodeOne()
    {
        return nodeOne;
    }

    public Vertex<E> getNodeTwo()
    {
        return nodeTwo;
    }

    public int getValue()
    {
        return value;
    }

    private Vertex<E> nodeOne;
    private Vertex<E> nodeTwo;
    private int value;

    public boolean isDirected()
    {
        return directed;
    }

    public void setDirected(final boolean directed)
    {
        this.directed = directed;
    }

    private boolean directed;

    @Override
    public String toString()
    {
        return "E=" + value + nodeOne + " " + nodeTwo;
    }
}
