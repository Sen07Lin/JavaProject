import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
/**
 * @author Sen lin   
 * again add soemthing
 * add somethingg
 */
public class GraphSearch {
    /**
     * Searches the Graph passed in as an AdjcencyList(adjList) to find if a
     * path exists from the start node to the goal node using General Graph
     * Search.
     * Assume the AdjacencyList contains adjacent nodes of each node in the
     * order they should be added to the Structure.
     * The structure(struct) passed in is an empty structure may behave as a
     * Stack or Queue and the correspondingly search function should execute
     * DFS(Stack) or BFS(Queue) on the graph.
     * @param start , Starting point of the search process
     * @param struct , could be stack or queue
     * @param adjList , the adjacent list
     * @param goal , the query points
     * @return true if path exists false otherwise
     */
    public static <T> boolean generalGraphSearch(T start, Structure<T> struct,
            Map<T, List<T>> adjList, T goal) {
        if (start == null || goal == null
                || adjList == null || struct == null) {
            throw new IllegalArgumentException();
        }
        // visited set
        Set<T> visited = new HashSet<T>();
        // add the first node to the structure
        struct.add(start);
        // loop to traverse graph
        while (!struct.isEmpty()) {
            T current = struct.remove();
            if (!visited.contains(current)) {
                visited.add(current);
                for (T item : adjList.get(current)) {
                    struct.add(item);
                }
            }
        }
        return visited.contains(goal);
    }
    /**
     * Searches the Graph passed in as an AdjcencyList(adjList) to find if a
     * path exists from the start node to the goal node using Bredth First
     * Search.
     * Assume the AdjacencyList contains adjacent nodes of each node in the
     * order they should be added to the Structure.
     * @param start , Starting point of the search process
     * @param adjList , the adjacent list
     * @param goal , the query point
     * @return true if path exists false otherwise
     */
    public static <T> boolean breadthFirstSearch(T start,
            Map<T, List<T>> adjList, T goal) {
        return generalGraphSearch(start,
                new StructureQueue<T>(), adjList, goal);
    }
    /**
     * Searches the Graph passed in as an AdjcencyList(adjList) to find if a
     * path exists from the start node to the goal node using Depth First
     * Search.
     * Assume the AdjacencyList contains adjacent nodes of each node in the
     * order they should be added to the Structure.
     * @param start , Starting point of the search process
     * @param adjList , the adjacent list
     * @param goal , the query point
     * @return true if path exists false otherwise
     */
    public static <T> boolean depthFirstSearch(T start,
            Map<T, List<T>> adjList, T goal) {
        return generalGraphSearch(start,
                new StructureStack<T>(), adjList, goal);
    }
    /**
     * Find the shortest distance between the start node and the goal node in
     * the given a weighted graph in the form of an adjacency list where the
     * edges only have positive weights Return the aforementioned shortest
     * distance if there exists a path between the start and goal,-1 otherwise.
     * There are no negative edge weights in the graph.
     * @param start , Starting point of the search process
     * @param adjList , the adjacent list
     * @param goal , the query point
     * @return the shortest distance between the start and the goal node
     */
    public static <T> int djikstraShortestPathAlgorithm(T start,
            Map<T, List<Pair<T, Integer>>> adjList, T goal) {
        if (start == null || goal == null || adjList == null) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<EntryPQ<T>> priorityQueue =
                new PriorityQueue<EntryPQ<T>>();
        priorityQueue.add(new EntryPQ<T>(start, 0, null));
        Set<T> visited = new HashSet<T>();
        while (!priorityQueue.isEmpty()) {
            EntryPQ<T> frontEntry = priorityQueue.remove();
            T frontVertex = frontEntry.u;
            if (!visited.contains(frontVertex)) {
                visited.add(frontVertex);
                if (frontVertex.equals(goal)) {
                    return frontEntry.w;
                } else {
                    for (Pair<T, Integer> neighbor : adjList.get(frontVertex)) {
                        if (!visited.contains(neighbor.a)) {
                            Integer nextCost = neighbor.b + frontEntry.w;
                            priorityQueue.add(new EntryPQ<T>(neighbor.a,
                                    nextCost, frontVertex));
                        }
                    }
                }
            }
        }
        return -1;
    }
    /**
     * This class has edge property having two ends of the edge, and the total.
     * travel length of the searching process
     * @author Sen lin
     * @param <T> type of entryPQ
     */
    private static class EntryPQ<T> implements Comparable<T> {
        private T u;
        private T v;
        private Integer w;
        /**
         * Constructor of EntryPQ class.
         * @param u beginning vertex of the edge
         * @param w shortest travel length
         * @param v ending vertex of the edge
         */
        public EntryPQ(T u, Integer w, T v) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Object o) {
            @SuppressWarnings("unchecked")
            EntryPQ<T> e = (EntryPQ<T>) o;
            return w.compareTo(e.w);
        }
    }
}