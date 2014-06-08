/**
 * JUnit tests for CS 1332, Homework 9, Spring 2014.
 * @Version Integer.MAX_VALUE
 * @Author Alex Freeman
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.Test;


public class GraphSearchTestSomeGuy {
    //private GraphSearch search = new GraphSearch();
    private Map<String, List<String>> adjList;
    private Map<String, List<Pair<String, Integer>>> weightedAdjList;
    private String start;
    private String goal;
    private static final int TIMEOUT = 200;
    
    private String a = "A";
    private String b = "B";
    private String c = "C";
    private String d = "D";
    private String e = "E";
    private String f = "F";
    private String g = "G";
    private String h = "H";
    private String i = "I";
    private String j = "J";
    private String k = "K";
    
    @Test(timeout = TIMEOUT)
    public void treeBFStest() {
        createTree();
        assertTrue(GraphSearch.breadthFirstSearch(start, adjList, goal));
    }
    @Test(timeout = TIMEOUT)
    public void treeDFStest() {
        createTree();
        assertTrue(GraphSearch.depthFirstSearch(start, adjList, goal));
    }
    @Test(timeout = TIMEOUT)
    public void basicBFStest() {
        createBasicGraph();
        assertTrue(GraphSearch.breadthFirstSearch(start, adjList, goal));
    }
    @Test(timeout = TIMEOUT)
    public void basicDFStest() {
        createBasicGraph();
        assertTrue(GraphSearch.depthFirstSearch(start, adjList, goal));
    }
    @Test(timeout = TIMEOUT)
    public void basicDtest() {
        createBasicWeightedGraph();
        assertEquals(1, GraphSearch.djikstraShortestPathAlgorithm(start, weightedAdjList, goal));
    }
    @Test(timeout = TIMEOUT)
    public void dTrapTest() {
        createWeightedTrap();
        assertEquals(2, GraphSearch.djikstraShortestPathAlgorithm(start, weightedAdjList, goal));
    }
    @Test(timeout = TIMEOUT)
    public void dLoopTest() {
        createWeightedLoopTrap();
        assertEquals(100000000, GraphSearch.djikstraShortestPathAlgorithm(start, weightedAdjList, goal));
    }
    @Test(timeout = TIMEOUT)
    public void disconnectedTreeBFStest() {
        createTree();
        adjList.put("b5", new LinkedList<String>());
        assertFalse(GraphSearch.breadthFirstSearch(start, adjList, goal));
    }
    @Test(timeout = TIMEOUT)
    public void disconnectedTreeDFStest() {
        createTree();
        adjList.put("b5", new LinkedList<String>());
        assertFalse(GraphSearch.depthFirstSearch(start, adjList, goal));
    }
    @Test(timeout = TIMEOUT)
    public void disconnectedGraphDtest() {
        createWeightedTestGraph();
        weightedAdjList.put(g, new LinkedList<Pair<String, Integer>>());
        weightedAdjList.put(h, new LinkedList<Pair<String, Integer>>());
        assertEquals(-1, GraphSearch.djikstraShortestPathAlgorithm(a, weightedAdjList, i));
    }
    @Test(timeout = TIMEOUT)
    public void fakeVertexBFStest() {
        start = "Start";
        assertFalse(GraphSearch.breadthFirstSearch(start, new HashMap<String, List<String>>(), start));
    }
    @Test(timeout = TIMEOUT)
    public void fakeVertexDFStest() {
        start = "Start";
        assertFalse(GraphSearch.depthFirstSearch(start, new HashMap<String, List<String>>(), start));
    }
    @Test(timeout = TIMEOUT)
    public void fakeVertexDtest() {
        createBasicWeightedGraph();
        weightedAdjList.remove(start);
        assertEquals(-1, GraphSearch.djikstraShortestPathAlgorithm(start, weightedAdjList, start));
    }
    @Test(timeout = TIMEOUT)
    public void realVertexBFStest() {
        createBasicGraph();
        assertTrue(GraphSearch.breadthFirstSearch(goal, adjList, goal));
    }
    @Test(timeout = TIMEOUT)
    public void realVertexDFStest() {
        createBasicGraph();
        assertTrue(GraphSearch.depthFirstSearch(goal, adjList, goal));
    }
    @Test(timeout = TIMEOUT)
    public void realVertexDTest() {
        createBasicWeightedGraph();
        assertEquals(0, GraphSearch.djikstraShortestPathAlgorithm(goal, weightedAdjList, goal));
    }
    @Test(timeout = TIMEOUT)
    public void fakeGoalBFStest() {
        createTree();
        adjList.remove(goal);
        assertFalse(GraphSearch.breadthFirstSearch(start, adjList, goal));
    }
    @Test(timeout = TIMEOUT)
    public void fakeGoalTreeDFStest() {
        createTree();
        adjList.remove(goal);
        assertFalse(GraphSearch.depthFirstSearch(start, adjList, goal));
    }
    @Test(timeout = TIMEOUT)
    public void fakeGoalDtest() {
        createWeightedTestGraph();
        //weightedAdjList.remove(i);
        assertEquals(-1, GraphSearch.djikstraShortestPathAlgorithm(g, weightedAdjList, i));
    }
    @Test(timeout = TIMEOUT)
    public void graphTestA() {
        createWeightedTestGraph();
        assertEquals(0, GraphSearch.djikstraShortestPathAlgorithm(a, weightedAdjList, a));
    }
    @Test(timeout = TIMEOUT)
    public void graphTestB() {
        createWeightedTestGraph();
        assertEquals(1, GraphSearch.djikstraShortestPathAlgorithm(a, weightedAdjList, b));
    }
    @Test(timeout = TIMEOUT)
    public void graphTestC() {
        createWeightedTestGraph();
        assertEquals(2, GraphSearch.djikstraShortestPathAlgorithm(a, weightedAdjList, c));
    }
    @Test(timeout = TIMEOUT)
    public void graphTestD() {
        createWeightedTestGraph();
        assertEquals(3, GraphSearch.djikstraShortestPathAlgorithm(a, weightedAdjList, d));
    }
    @Test(timeout = TIMEOUT)
    public void graphTestE() {
        createWeightedTestGraph();
        assertEquals(5, GraphSearch.djikstraShortestPathAlgorithm(a, weightedAdjList, e));
    }
    @Test(timeout = TIMEOUT)
    public void graphTestF() {
        createWeightedTestGraph();
        assertEquals(4, GraphSearch.djikstraShortestPathAlgorithm(a, weightedAdjList, f));
    }
    @Test(timeout = TIMEOUT)
    public void graphTestG() {
        createWeightedTestGraph();
        assertEquals(6, GraphSearch.djikstraShortestPathAlgorithm(a, weightedAdjList, g));
    }
    @Test(timeout = TIMEOUT)
    public void graphTestH() {
        createWeightedTestGraph();
        assertEquals(6, GraphSearch.djikstraShortestPathAlgorithm(a, weightedAdjList, h));
    }
    @Test(timeout = TIMEOUT)
    public void graphTestI() {
        createWeightedTestGraph();
        assertEquals(7, GraphSearch.djikstraShortestPathAlgorithm(a, weightedAdjList, i));
    }
    @Test(timeout = TIMEOUT)
    public void graphTestJ() {
        createWeightedTestGraph();
        assertEquals(7, GraphSearch.djikstraShortestPathAlgorithm(a, weightedAdjList, j));
    }
    @Test(timeout = TIMEOUT)
    public void graphTestK() {
        createWeightedTestGraph();
        assertEquals(6, GraphSearch.djikstraShortestPathAlgorithm(a, weightedAdjList, k));
    }
    
    public void createBasicGraph() {
        adjList = new HashMap<String, List<String>>();
        start = "Start";
        goal = "Goal";
        LinkedList<String> startAdj = new LinkedList<String>();
        startAdj.add(goal);
        adjList.put(start, startAdj);
        adjList.put(goal, new LinkedList<String>());
    }
    
    public void createBasicWeightedGraph() {
        weightedAdjList = new HashMap<String, List<Pair<String, Integer>>>();
        start = "Start";
        goal = "Goal";
        LinkedList<Pair<String, Integer>> startAdj = new LinkedList<Pair<String, Integer>>();
        startAdj.add(new Pair<String, Integer>(goal, new Integer(1)));
        weightedAdjList.put(start, startAdj);
        weightedAdjList.put(goal, new LinkedList<Pair<String, Integer>>());
    }
    
    public void createWeightedTrap() {
        weightedAdjList = new HashMap<String, List<Pair<String, Integer>>>();
        start = "Start";
        goal = "Goal";
        String a1 = "a1";
        String a2 = "a2";
        LinkedList<Pair<String, Integer>> startAdj = new LinkedList<Pair<String, Integer>>();
        startAdj.add(new Pair<String, Integer>(goal, new Integer(2)));
        startAdj.add(new Pair<String, Integer>(a1, new Integer(1)));
        LinkedList<Pair<String, Integer>> a1adj = new LinkedList<Pair<String, Integer>>();
        a1adj.add(new Pair<String, Integer>(a2, new Integer(1)));
        LinkedList<Pair<String, Integer>> a2adj = new LinkedList<Pair<String, Integer>>();
        a2adj.add(new Pair<String, Integer>(goal, new Integer(1)));
        weightedAdjList.put(start, startAdj);
        weightedAdjList.put(a1, a1adj);
        weightedAdjList.put(a2, a2adj);
        weightedAdjList.put(goal, new LinkedList<Pair<String, Integer>>());
    }
    
    public void createWeightedLoopTrap() {
        weightedAdjList = new HashMap<String, List<Pair<String, Integer>>>();
        start = "Start";
        goal = "Goal";
        String bounce = "Bounce";
        LinkedList<Pair<String, Integer>> startAdj = new LinkedList<Pair<String, Integer>>();
        startAdj.add(new Pair<String, Integer>(goal, new Integer(100000000)));
        startAdj.add(new Pair<String, Integer>(bounce, new Integer(1)));
        LinkedList<Pair<String, Integer>> bounceAdj = new LinkedList<Pair<String, Integer>>();
        bounceAdj.add(new Pair<String, Integer>(start, new Integer(1)));
        weightedAdjList.put(start, startAdj);
        weightedAdjList.put(bounce, bounceAdj);
        weightedAdjList.put(goal, new LinkedList<Pair<String, Integer>>());
    }
    
    public void createTree(){
        adjList = new HashMap<String, List<String>>();
        start = "Start";
        goal = "Goal";
        String a1 = "a1";
        String a2 = "a2";
        String a3 = "a3";
        String b1 = "b1";
        String b2 = "b2";
        String b3 = "b3";
        String b4 = "b4";
        String b5 = "b5";
        String b6 = "b6";
        String b7 = "b7";
        String b8 = "b8";
        String b9 = "b9";
        LinkedList<String> startAdj = new LinkedList<String>();
        startAdj.add(a1);
        startAdj.add(a2);
        startAdj.add(a3);
        adjList.put(start, startAdj);
        LinkedList<String> a1Adj = new LinkedList<String>(), a2Adj =  new LinkedList<String>(), a3Adj = new LinkedList<String>();
        a1Adj.add(b1);
        a1Adj.add(b2);
        a1Adj.add(b3);
        a1Adj.add(start);
        a2Adj.add(b4);
        a2Adj.add(b5);
        a2Adj.add(b6);
        a2Adj.add(start);
        a3Adj.add(b7);
        a3Adj.add(b8);
        a3Adj.add(b9);
        a3Adj.add(start);
        adjList.put(a1, a1Adj);
        adjList.put(a2, a2Adj);
        adjList.put(a3, a3Adj);
        LinkedList<String> b5Adj = new LinkedList<String>();
        b5Adj.add(a2);
        b5Adj.add(goal);
        adjList.put(b1, new LinkedList<String>());
        adjList.put(b2, new LinkedList<String>());
        adjList.put(b3, new LinkedList<String>());
        adjList.put(b4, new LinkedList<String>());
        adjList.put(b5, b5Adj);
        adjList.put(b6, new LinkedList<String>());
        adjList.put(b7, new LinkedList<String>());
        adjList.put(b8, new LinkedList<String>());
        adjList.put(b9, new LinkedList<String>());
        adjList.put(goal, new LinkedList<String>());
    }
    
    public void createWeightedTestGraph() {
        weightedAdjList = new HashMap<String, List<Pair<String, Integer>>>();
        /*String a = "A";
		String b = "B";
		String c = "C";
		String d = "D";
		String e = "E";
		String f = "F";
		String g = "G";
		String h = "H";
		String i = "I";
		String j = "J";*/
        
        LinkedList<Pair<String, Integer>> adj = new LinkedList<Pair<String, Integer>>();
        adj.add(new Pair<String, Integer>(b, new Integer(1)));
        adj.add(new Pair<String, Integer>(c, new Integer(3)));
        LinkedList<Pair<String, Integer>> bdj = new LinkedList<Pair<String, Integer>>();
        bdj.add(new Pair<String, Integer>(c, new Integer(1)));
        bdj.add(new Pair<String, Integer>(d, new Integer(2)));
        bdj.add(new Pair<String, Integer>(g, new Integer(5)));
        LinkedList<Pair<String, Integer>> cdj = new LinkedList<Pair<String, Integer>>();
        cdj.add(new Pair<String, Integer>(d, new Integer(4)));
        cdj.add(new Pair<String, Integer>(e, new Integer(3)));
        cdj.add(new Pair<String, Integer>(k, new Integer(4)));
        LinkedList<Pair<String, Integer>> ddj = new LinkedList<Pair<String, Integer>>();
        ddj.add(new Pair<String, Integer>(f, new Integer(1)));
        ddj.add(new Pair<String, Integer>(g, new Integer(3)));
        ddj.add(new Pair<String, Integer>(h, new Integer(4)));
        LinkedList<Pair<String, Integer>> edj = new LinkedList<Pair<String, Integer>>();
        edj.add(new Pair<String, Integer>(f, new Integer(2)));
        edj.add(new Pair<String, Integer>(k, new Integer(2)));
        edj.add(new Pair<String, Integer>(j, new Integer(5)));
        LinkedList<Pair<String, Integer>> fdj = new LinkedList<Pair<String, Integer>>();
        fdj.add(new Pair<String, Integer>(e, new Integer(2)));
        fdj.add(new Pair<String, Integer>(h, new Integer(2)));
        fdj.add(new Pair<String, Integer>(j, new Integer(6)));
        LinkedList<Pair<String, Integer>> gdj = new LinkedList<Pair<String, Integer>>();
        gdj.add(new Pair<String, Integer>(h, new Integer(0)));
        //gdj.add(new Pair<String, Integer>(i, new Integer(2)));
        LinkedList<Pair<String, Integer>> hdj = new LinkedList<Pair<String, Integer>>();
        hdj.add(new Pair<String, Integer>(f, new Integer(2)));
        hdj.add(new Pair<String, Integer>(g, new Integer(4)));
        // hdj.add(new Pair<String, Integer>(i, new Integer(1)));
        //LinkedList<Pair<String, Integer>> idj = new LinkedList<Pair<String, Integer>>();
        //LinkedList<Pair<String, Integer>> jdj = new LinkedList<Pair<String, Integer>>();
        LinkedList<Pair<String, Integer>> kdj = new LinkedList<Pair<String, Integer>>();
        kdj.add(new Pair<String, Integer>(e, new Integer(1)));
        kdj.add(new Pair<String, Integer>(j, new Integer(1)));
        
        weightedAdjList.put(a, adj);
        weightedAdjList.put(b, bdj);
        weightedAdjList.put(c, cdj);
        weightedAdjList.put(d, ddj);
        weightedAdjList.put(e, edj);
        weightedAdjList.put(f, fdj);
        weightedAdjList.put(g, gdj);
        weightedAdjList.put(h, hdj);
        weightedAdjList.put(i, new LinkedList<Pair<String, Integer>>());
        weightedAdjList.put(j, new LinkedList<Pair<String, Integer>>());
        weightedAdjList.put(k, kdj);
    }
    
}
