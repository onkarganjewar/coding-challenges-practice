package practice.graphs;

import java.util.*;
import java.util.stream.Collectors;

public class GraphMain {

	/** Map storing all the bindings of nodes with its labels */
	public static HashMap<String, UndirectedGraphNode> nodesLookup = new HashMap<String, UndirectedGraphNode>();

	public static void main(String[] args) {
		// no of vertices to form a graph
		int nVertices = 6;

		// initialize the graph w/ default values for given no of vertices
		buildGraph(nVertices);

		// add edges in a graph
		// A --> B
		UndirectedGraphNode.addEdge(getNode("A"), getNode("B"));
		// B --> C
		UndirectedGraphNode.addEdge(getNode("B"), getNode("C"));
		// C --> D
		// UndirectedGraphNode.addEdge(getNode("C"), getNode("D"));
		// D --> E
		UndirectedGraphNode.addEdge(getNode("D"), getNode("E"));
		// E --> F
		UndirectedGraphNode.addEdge(getNode("E"), getNode("F"));

		// convert the map values to a list
		List<UndirectedGraphNode> list = nodesLookup.values().stream().collect(Collectors.toList());
		// print the no of connected components
		System.out.println(countComponents(list));

		// print the connected components
		System.out.println(connectedSet(new ArrayList<>(nodesLookup.values())));
	}

	/**
	 * Builds the graph consisting given vertices with default values for each.
	 * 
	 * @param nVertices
	 *            No of vertices to include
	 */
	private static void buildGraph(int nVertices) {
		char i = 'A';
		while (nVertices > 0) {
			UndirectedGraphNode node = new UndirectedGraphNode(Character.toString(i));
			nodesLookup.put(Character.toString(i), node);
			i++;
			nVertices--;
		}
		// UndirectedGraphNode a = new UndirectedGraphNode("A");
		// UndirectedGraphNode b = new UndirectedGraphNode("B");
		// UndirectedGraphNode c = new UndirectedGraphNode("C");
		// UndirectedGraphNode d = new UndirectedGraphNode("D");
		// UndirectedGraphNode e = new UndirectedGraphNode("E");
		// UndirectedGraphNode f = new UndirectedGraphNode("F");
		// nodesLookup.put("A", a);
		// nodesLookup.put("B", b);
		// nodesLookup.put("C", c);
		// nodesLookup.put("D", d);
		// nodesLookup.put("E", e);
		// nodesLookup.put("F", f);
	}

	/**
	 * Returns the node from the label of the node.
	 * 
	 * @param string
	 *            The label of the graph node
	 * @return UndirectedGraphNode
	 */
	private static UndirectedGraphNode getNode(String string) {
		return nodesLookup.get(string);
	}

	/**
	 * Returns the number of connected components present in the given vertices
	 * of a graph. <br>
	 * <br>
	 * Note: One single isolated vertex is also considered as a component.
	 * 
	 * @param list
	 *            List of vertices/nodes of the given graph
	 * @return
	 */
	private static int countComponents(List<UndirectedGraphNode> list) {
		int count = 0;

		// base case
		if (list.isEmpty() || list == null)
			return count;

		// visited set for lookup
		Set<UndirectedGraphNode> visited = new HashSet<>();

		// queue for BFS
		Queue<UndirectedGraphNode> queue = new LinkedList<>();

		queue.offer(list.get(0));

		// traverse for all the vertices in the list
		while (!list.isEmpty()) {
			if (!queue.isEmpty()) {
				// poll the front of the queue
				UndirectedGraphNode front = queue.poll();
				// if not already visited
				// if (!visited.contains(front)) {
				// visited.add(front);

				// remove the current parent to not revisit
				list.remove(front);

				for (UndirectedGraphNode child : front.neighbors) {
					queue.offer(child);
				}
				// }
			} else {
				// increment the count
				count++;
				// the first node of the modified nodes list will be the
				// unvisited node, since we delete the nodes from the original
				// list once we add them in components
				queue.offer(list.get(0)); // reinitialize the queue
			}
		}
		return ++count;
	}

	/**
	 * Returns the list of all the connected components of a given graph.
	 * 
	 * @param nodes
	 *            a array of Undirected graph node
	 * @return a connected set of a Undirected graph
	 */
	private static List<List<String>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
		List<List<String>> result = new ArrayList<>();
		if (nodes == null || nodes.size() == 0) {
			return result;
		}

		// set to store visited nodes
		Set<UndirectedGraphNode> visited = new HashSet<>();

		// queue for BFS
		Queue<UndirectedGraphNode> queue = new LinkedList<>();

		// temp list to store the current connected components
		ArrayList<String> tempComponentsList = new ArrayList<String>();

		// add the first node/vertex from the list of vertices/nodes
		queue.offer(nodes.get(0));

		// traverse all the nodes/vertices individually
		while (!nodes.isEmpty()) {
			// if queue is empty then add next node for the traversal
			if (queue.isEmpty()) {
				Collections.sort(tempComponentsList);
				// add the currently stored connected components to the result
				result.add(tempComponentsList);
				// the first node of the modified nodes list will be the
				// unvisited node, since we delete the nodes from the original
				// list once we add them in components
				queue.offer(nodes.get(0));
				// reset the temp components list
				tempComponentsList = new ArrayList<>();
			} else {
				// poll the front of the queue
				UndirectedGraphNode curr = queue.poll();
				// if (!visited.contains(curr)) {
				// visited.add(curr);
				// add it to the components list
				tempComponentsList.add(curr.label);
				// remove that node from original nodes array to not revisit
				nodes.remove(curr);
				// add all the children of current node to the queue
				for (UndirectedGraphNode node : curr.neighbors) {
					queue.add(node);
				}
				// }
			}
		}

		// add the remaining components to the final result
		if (!tempComponentsList.isEmpty()) {
			result.add(tempComponentsList);
		}
		return result;
	}
}
