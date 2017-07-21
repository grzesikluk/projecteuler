package eulerproject.level4.problem83;

import eulerproject.tools.graph.Edge;
import eulerproject.tools.graph.Graph;
import eulerproject.tools.graph.MinimalPathAlgorithm;
import eulerproject.tools.graph.Vertex;

import java.util.*;

public class DijkstraAlgorithm<E extends Comparable> implements MinimalPathAlgorithm<E>
{
    @Override
    public List<Edge<E>> getMinimalPathByEdges(Vertex<E> source, Vertex<E> destination, Graph<E> graph) {
        Map<Vertex<E>, Vertex<E>> neighbourPath = getMinimalPath(source, destination, graph);
        List<Edge<E>> result = new LinkedList<>();

        Vertex<E> prev = destination;

        while(prev != null) {
            Vertex<E> tmp = neighbourPath.get(prev);

            if(tmp != null) {
                Vertex<E> finalPrev = prev;
                Edge<E> edge = tmp.getEdgeList().stream().filter(e -> e.getNodeTwo().equals(finalPrev)).findFirst().get();
                result.add(edge);
            }

            prev = tmp;
        }

        return result;
    }

    public int getMinimalPathValue(Vertex<E> source, Vertex<E> destination, Graph<E> graph) {
        List<Edge<E>> edges = getMinimalPathByEdges(source,destination,graph);
        return edges.stream().mapToInt(e->e.getValue()).sum();
    }

    class Distance implements  Comparable {
        Vertex<E> vertex;

        public boolean isVisited() {
            return visited;
        }

        int distance;

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        boolean visited;

        Distance(Vertex<E> vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
            this.visited = false;
        }


        @Override
        public int compareTo(Object o) {
            if( o instanceof DijkstraAlgorithm.Distance) {
                Distance other = (Distance)o;

                return this.distance - ((Distance) o).distance;

            }
            return -1;
        }
    }


    public Map<Vertex<E>, Vertex<E>> getMinimalPath(final Vertex source, final Vertex destination, final Graph graph)
    {
        List<Distance> distances = new ArrayList<>();
        Map<Vertex<E>, Vertex<E>> neighbourPath = new HashMap<>();

        graph.getVertices().stream().forEach(s -> {
            if(!s.equals(source))
                distances.add(new Distance((Vertex<E>)s, Integer.MAX_VALUE)); //means infinity
            neighbourPath.put((Vertex<E>) s, null);
        });

        distances.add(new Distance(source, 0));

        Distance minimumDistance = getMinimumDistance(distances);

        while(minimumDistance != null) {

            Vertex<E> minimumVertex = minimumDistance.vertex;

            for(Vertex<E> neighbour:minimumVertex.getNeighbours()) {
                int dist_u = minimumDistance.distance;
                int dist_v = getDistanceValue(neighbour, distances);
                int w_uv = minimumVertex.getEdgeList().stream().filter(e->e.getNodeTwo().equals(neighbour)).findFirst().get().getValue();

                if(dist_v > dist_u + w_uv) {
                    Distance neighbourDist = getDistance(neighbour, distances);
                    neighbourDist.distance = dist_u + w_uv;
                    neighbourPath.put(neighbour, minimumVertex);
                }
            }
            minimumDistance.visited = true;
            minimumDistance = getMinimumDistance(distances);
        }

        return neighbourPath;
    }

    @Override
    public List<Vertex<E>> getMinimalPathByVertex(final Vertex source, final Vertex destination, final Graph graph)
    {
        Map<Vertex<E>, Vertex<E>> neighbourPath = getMinimalPath(source, destination, graph);
        List<Vertex<E>> result = new LinkedList<>();

        Vertex<E> prev = destination;

        while(prev != null) {
            result.add(prev);
            prev = neighbourPath.get(prev);
        }

        return result;
    }

    private Distance getDistance(Vertex<E> vertex, List<Distance> list) {
        return list.stream().filter(s-> s.vertex.equals(vertex)).findFirst().get();
    }

    private int getDistanceValue(Vertex<E> vertex, List<Distance> list) {
        return getDistance(vertex, list).distance;
    }

    private Distance getMinimumDistance(List<Distance> distances) {
        return distances.stream().filter(dist->dist.isVisited()!=true).sorted().findFirst().orElse(null);
    }

}
