package eulerproject.tools.graph;

public class Edge<E extends Comparable> implements Comparable
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

    @Override
    public int compareTo(final Object o)
    {
        if(o instanceof Edge) {
            Edge other = (Edge)o;

            return getValue() - other.getValue();
        }
        return -1;
    }
}
