import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class GraphSearchTestBen {
	
	private static final int NUM_ROUNDS = 1;
	private static final int CONNECTEDNESS_FACTOR = 5;
	private static final int MAX_WEIGHT = 10;
	
	@Test
	public void testBFS() {
		for (int i = 0; i < NUM_ROUNDS; i++) {
			System.out.println("BFS____________________________\n");
			Map<Character, List<Character>> graph = generateSimplyConnectedGraph();
			printGraph(graph.toString());
			assertTrue(GraphSearch.breadthFirstSearch('a', graph, 'z'));
		}
	}
	
	@Test
	public void testDFS() {
		for (int i = 0; i < NUM_ROUNDS; i++) {
			System.out.println("DFS_____________________________\n");
			Map<Character, List<Character>> graph = generateSimplyConnectedGraph();
			printGraph(graph.toString());
			assertTrue(GraphSearch.depthFirstSearch('a', graph, 'z'));
		}
	}
	
	@Test
	public void testDjikstras() {
		for (int i = 0; i < NUM_ROUNDS; i++) {
			System.out.println("Djikstra____________________________\n");
			Map<Character, List<Pair<Character, Integer>>> graph = generateDjikstraGraph();
			printGraph(graph.toString());
			assertTrue(GraphSearch.djikstraShortestPathAlgorithm('a', graph, 'z') > 0);
		}
	}
	
	/**
	 * creates an adjacency list for a simply connected graph made up of
	 * every lowercase letter in the alphabet. There are no cycles because
	 * characters can only be adjacent to characters that have already been added to the list. 
	 * @param adjList
	 */
	private Map<Character, List<Character>> generateSimplyConnectedGraph() {
		
		Random rand = new Random();
		Character node = 'b';
		Map<Character, List<Character>> list = new HashMap<>();
		list.put('a', new ArrayList<Character>());
		
		do {
			list.put(node, new ArrayList<Character>());

			// select a random letter of the ones already generated
			// to be adjacent to node. If letter == node, select a
			// new letter
			char letter = 0;
			do {
				letter = (char) (rand.nextInt(node - 'a' + 1) + 'a');
			} while (letter == node);
			list.get(letter).add(node);
		} while (node++ < 'z'); 
		
		return list;
	}
	
	/**
	 * creates an adjacency list for a connected graph made up
	 * of all lowercase letters with a random weight assigned
	 * to each edge.
	 * @return adjList
	 */
	private Map<Character, List<Pair<Character, Integer>>> generateDjikstraGraph() {
		
		Random rand = new Random();
		Character node = 'b';
		Map<Character, List<Pair<Character, Integer>>> list = new HashMap<>();
		list.put('a', new ArrayList<Pair<Character, Integer>>());
		
		do {
			list.put(node, new ArrayList<Pair<Character, Integer>>());
			
			// select a random letter of the ones already generated
			// to be adjacent to node. If letter == node, select a
			// new letter. assign a random weight in the range
			// [0, MAX_WEIGHT]
			char letter = 0;
			do {
				letter = (char) (rand.nextInt(node - 'a' + 1) + 'a');
			} while (letter == node);
			int weight = rand.nextInt(MAX_WEIGHT + 1);
			list.get(letter).add(new Pair<Character, Integer>(node, weight));	
			
		} while (node++ < 'z'); 
		
		return list;
	}
	
	@SuppressWarnings("resource")
	private void printGraph(String out) {
		Scanner scanner = (new Scanner(out)).useDelimiter("],");
		StringBuilder output = new StringBuilder();
		
		while (scanner.hasNext()) {
			String next = scanner.next();
			output.append(next);
			output.append("]\n");
		}
		output.delete(output.length() - 2, output.length());
		scanner.close();
		
		System.out.println(output.toString());
	}
}
