package practice.graphs;

import java.util.*;

public class GraphSample {
	public static HashMap<Integer, Node> nodesMap = new HashMap<Integer, Node>();
	public int vertices; // no of vertices for the graph

	public void addEdge(int source, int dest) {
		Node s = getNode(source);
		Node d = getNode(dest);
		s.adjacencyList.add(d);
	}

	public GraphSample(int v) {
		super();
		this.vertices = v;
		// creates the v nodes numbered from 1 to v
		for (int i = 1; i <= v; i++) {
			Node node = new Node(i);
			nodesMap.put(i, node);
		}
	}

	public static class Node {
		private int id;
		List<Node> adjacencyList = new LinkedList<Node>();

		private Node(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "Node [ " + this.id + " ]";
		}
	}

	private Node getNode(int id) {
		return nodesMap.get(id);
	}

	public static void main(String[] args) {
		// // create the nodes for the graph
		// buildGraph();

		int vertices = 5;

		// create the graph w/ no of vertices
		GraphSample graph = new GraphSample(vertices);
		// add the edges for the graph
		// graph.addEdge(1, 6);
		// graph.addEdge(1, 7);
		// graph.addEdge(1, 8);
		graph.addEdge(1, 2); // A == B
		graph.addEdge(2, 3); // B == C
		// graph.addEdge(2, 4); // B == D

		graph.addEdge(4, 5); // D == E
		System.out.println(hasPathDFS(graph.getNode(1), graph.getNode(3)));
		System.out.println(hasPathBFS(graph.getNode(1), graph.getNode(4)));
	}

	private static boolean hasPathBFS(Node source, Node dest) {
		Set<Node> visited = new HashSet<Node>();
		LinkedList<Node> queue = new LinkedList<Node>();
		// start from the source
		queue.add(source);

		while (!queue.isEmpty()) {
			Node parent = queue.poll();
			// reached the destination
			if (parent == dest)
				return true;

			// already visited node
			if (visited.contains(parent))
				continue; // skip search for this node

			// mark it as visited
			visited.add(parent);

			// iterate/add all the children of polled node
			for (Node child : parent.adjacencyList) {
				// add elements to the queue
				queue.add(child);
			}
		}
		return false;
	}

	private static boolean hasPathDFS(Node node1, Node node2) {
		Set<Node> visited = new HashSet<Node>();
		return DFSUtil(node1, node2, visited);
	}

	private static boolean DFSUtil(Node source, Node dest, Set<Node> visited) {
		// if already visited node, then return
		if (visited.contains(source))
			return false;

		// mark the current node visited
		visited.add(source);

		// if reached the destination node, return true
		if (source == dest)
			return true;

		for (Node child : source.adjacencyList) {
			// recur for all the children of current node
			if (DFSUtil(child, dest, visited))
				return true;
		}
		return false;
	}

}
