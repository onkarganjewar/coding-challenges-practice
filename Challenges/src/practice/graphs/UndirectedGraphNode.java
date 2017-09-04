package practice.graphs;

import java.util.ArrayList;

class UndirectedGraphNode {
	String label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(String x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}

	public static void addEdge(UndirectedGraphNode v, UndirectedGraphNode v2) {
		v.neighbors.add(v2);
	}

	@Override
	public String toString() {
		return "Node [ " + this.label + " ]";
	}

}
