import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.Test;


public class GraphSearchTest {
    private Map<String, List<Pair<String, Integer>>> adjListWeight;
    private Map<String, List<String>> adjListUnweight;
    
    // From http://optlab-server.sce.carleton.ca/POAnimations2007/DijkstrasAlgo.html
    public void setUpWeighted() {
        adjListWeight = new HashMap<String, List<Pair<String, Integer>>>();
        LinkedList<Pair<String, Integer>> O = new LinkedList<Pair<String, Integer>>();
        O.add(new Pair<String, Integer>("A", 2));
        O.add(new Pair<String, Integer>("B", 5));
        O.add(new Pair<String, Integer>("C", 4));
        adjListWeight.put("O", O);
        LinkedList<Pair<String, Integer>> A = new LinkedList<Pair<String, Integer>>();
        A.add(new Pair<String, Integer>("O", 2));
        A.add(new Pair<String, Integer>("B", 2));
        A.add(new Pair<String, Integer>("D", 7));
        A.add(new Pair<String, Integer>("F", 12));
        adjListWeight.put("A", A);
        LinkedList<Pair<String, Integer>> B = new LinkedList<Pair<String, Integer>>();
        B.add(new Pair<String, Integer>("O", 5));
        B.add(new Pair<String, Integer>("A", 2));
        B.add(new Pair<String, Integer>("C", 1));
        B.add(new Pair<String, Integer>("E", 3));
        B.add(new Pair<String, Integer>("D", 8));
        adjListWeight.put("B", B);
        LinkedList<Pair<String, Integer>> C = new LinkedList<Pair<String, Integer>>();
        C.add(new Pair<String, Integer>("O", 4));
        C.add(new Pair<String, Integer>("E", 4));
        C.add(new Pair<String, Integer>("B", 1));
        adjListWeight.put("C", C);
        LinkedList<Pair<String, Integer>> D = new LinkedList<Pair<String, Integer>>();
        D.add(new Pair<String, Integer>("A", 7));
        D.add(new Pair<String, Integer>("B", 4));
        D.add(new Pair<String, Integer>("T", 5));
        D.add(new Pair<String, Integer>("E", 1));
        adjListWeight.put("D", D);
        LinkedList<Pair<String, Integer>> E = new LinkedList<Pair<String, Integer>>();
        E.add(new Pair<String, Integer>("D", 1));
        E.add(new Pair<String, Integer>("C", 4));
        E.add(new Pair<String, Integer>("B", 3));
        E.add(new Pair<String, Integer>("T", 7));
        adjListWeight.put("E", E);
        LinkedList<Pair<String, Integer>> F = new LinkedList<Pair<String, Integer>>();
        F.add(new Pair<String, Integer>("A", 12));
        F.add(new Pair<String, Integer>("T", 3));
        adjListWeight.put("F", F);
        LinkedList<Pair<String, Integer>> T = new LinkedList<Pair<String, Integer>>();
        T.add(new Pair<String, Integer>("F", 3));
        T.add(new Pair<String, Integer>("E", 7));
        T.add(new Pair<String, Integer>("D", 5));
        adjListWeight.put("T", T);
    }
    
    // From pg 739 of textbook
    public void setUpUnweighted() {
        adjListUnweight = new HashMap<String, List<String>>();
        LinkedList<String> A = new LinkedList<String>();
        A.add("D");
        A.add("E");
        A.add("B");
        adjListUnweight.put("A", A);
        LinkedList<String> B = new LinkedList<String>();
        B.add("E");
        adjListUnweight.put("B", B);
        LinkedList<String> C = new LinkedList<String>();
        C.add("B");
        adjListUnweight.put("C", C);
        LinkedList<String> D = new LinkedList<String>();
        D.add("G");
        adjListUnweight.put("D", D);
        LinkedList<String> E = new LinkedList<String>();
        E.add("F");
        E.add("H");
        adjListUnweight.put("E", E);
        LinkedList<String> F = new LinkedList<String>();
        F.add("C");
        F.add("H");
        adjListUnweight.put("F", F);
        LinkedList<String> G = new LinkedList<String>();
        G.add("H");
        adjListUnweight.put("G", G);
        LinkedList<String> H = new LinkedList<String>();
        H.add("I");
        adjListUnweight.put("H", H);
        LinkedList<String> I = new LinkedList<String>();
        I.add("F");
        adjListUnweight.put("I", I);
    }
    
    @Test
    public void testBFS() {
        setUpUnweighted();
        assertTrue(GraphSearch.breadthFirstSearch("A", adjListUnweight, "I"));
        assertTrue(GraphSearch.breadthFirstSearch("E", adjListUnweight, "B"));
        assertTrue(GraphSearch.breadthFirstSearch("G", adjListUnweight, "E"));
        assertFalse(GraphSearch.breadthFirstSearch("G", adjListUnweight, "D"));
        assertFalse(GraphSearch.breadthFirstSearch("E", adjListUnweight, "A"));
    }
    
    @Test
    public void testDFS() {
        setUpUnweighted();
        assertTrue(GraphSearch.depthFirstSearch("A", adjListUnweight, "I"));
        assertTrue(GraphSearch.depthFirstSearch("E", adjListUnweight, "B"));
        assertTrue(GraphSearch.depthFirstSearch("G", adjListUnweight, "E"));
        assertFalse(GraphSearch.depthFirstSearch("G", adjListUnweight, "D"));
        assertFalse(GraphSearch.depthFirstSearch("E", adjListUnweight, "A"));
        assertFalse(GraphSearch.depthFirstSearch("E", new HashMap<String, List<String>>(), "A"));
        assertFalse(GraphSearch.depthFirstSearch("E", new HashMap<String, List<String>>(), "E"));
        
    }
    
    @Test
    public void testDijkstras() {
        setUpWeighted();
        assertEquals(13, GraphSearch.djikstraShortestPathAlgorithm("O", adjListWeight, "T"));
        assertEquals(8, GraphSearch.djikstraShortestPathAlgorithm("O", adjListWeight, "D"));
        assertEquals(4, GraphSearch.djikstraShortestPathAlgorithm("O", adjListWeight, "B"));
        assertEquals(13, GraphSearch.djikstraShortestPathAlgorithm("T", adjListWeight, "O"));
        assertEquals(7, GraphSearch.djikstraShortestPathAlgorithm("O", adjListWeight, "E"));
        assertEquals(0, GraphSearch.djikstraShortestPathAlgorithm("O", adjListWeight, "O"));
        assertEquals(-1, GraphSearch.djikstraShortestPathAlgorithm("O", adjListWeight, "Z"));
        assertEquals(14, GraphSearch.djikstraShortestPathAlgorithm("O", adjListWeight, "F"));
    }
    
    
}
