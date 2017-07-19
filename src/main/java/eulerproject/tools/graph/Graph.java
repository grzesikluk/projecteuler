package eulerproject.tools.graph;

import java.util.List;

/**
 * Created by lgrzesik on 19/07/17.
 */
public class Graph<E>
{
    public Graph(final List<Vertex<E>> vertices)
    {
        this.vertices = vertices;
    }

    List<Vertex<E>> vertices;

    @Override
    public String toString()
    {
        return vertices.toString();
    }
}
