package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// A class to store a graph edge
class Edge
{
	public final int source, dest;

	private Edge(int source, int dest)
	{
		this.source = source;
		this.dest = dest;
	}

	// Factory method for creating an immutable instance of `Edge`
	public static Edge of(int a, int b) {
		return new Edge(a, b);		// calls private constructor
	}
}

// A class to represent a graph object
class Graph
{
	// A list of lists to represent an adjacency list
	List<List<Integer>> adjList = null;

	// Constructor
	Graph(List<Edge> edges, int n)
	{
		adjList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		// add edges to the directed graph
		for (Edge edge: edges) {
			adjList.get(edge.source).add(edge.dest);
		}
	}
}

class Main
{
	// Function to perform DFS traversal in a directed graph to find the
	// complete path between source and destination vertices
	public static boolean isReachable(Graph graph, int src, int dest,
							boolean[] discovered, Stack<Integer> path)
	{
		// mark the current node as discovered
		discovered[src] = true;

		// include the current node in the path
		path.add(src);

		// if destination vertex is found
		if (src == dest) {
			return true;
		}

		// do for every edge (src, i)
		for (int i: graph.adjList.get(src))
		{
			// if `u` is not yet discovered
			if (!discovered[i])
			{
				// return true if the destination is found
				if (isReachable(graph, i, dest, discovered, path)) {
					return true;
				}
			}
		}

		// backtrack: remove the current node from the path
		path.pop();

		// return false if destination vertex is not reachable from src
		return false;
	}

	public static void main(String[] args)
	{
		// List of graph edges as per the above diagram
		List<Edge> edges = Arrays.asList(
				Edge.of(0, 3), Edge.of(1, 0), Edge.of(1, 2), Edge.of(1, 4),
				Edge.of(2, 7), Edge.of(3, 4), Edge.of(3, 5), Edge.of(4, 3),
				Edge.of(4, 6), Edge.of(5, 6), Edge.of(6, 7));

		// total number of nodes in the graph (labeled from 0 to 7)
		int n = 8;

		// build a graph from the given edges
		Graph graph = new Graph(edges, n);

		// to keep track of whether a vertex is discovered or not
		boolean[] discovered = new boolean[n];

		// source and destination vertex
		int src = 1, dest = 7;

		// To store the complete path between source and destination
		Stack<Integer> path = new Stack<>();

		// perform DFS traversal from the source vertex to check the connectivity
		// and store path from the source vertex to the destination vertex
		if (isReachable(graph, src, dest, discovered, path))
		{
			System.out.println("Path exists from vertex " + src + " to vertex " + dest);
			System.out.println("The complete path is " + path);
		}
		else {
			System.out.println("No path exists between vertices " + src +
					" and " + dest);
		}
	}
}