package map;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * The algorithm of Dijkstra solves the problem of shortest path for a given startnode.
 * <p>
 * See {@code https://de.wikipedia.org/wiki/Dijkstra-Algorithmus}
 * 
 * @author André Schmer
 * @since v0.1
 *
 */
public class Dijkstra {

	private final Map<String, Integer> distances;
	private final Map<String, String> ancestor;
	private SortedSet<Entry<String, Integer>> sortedSet;
	private List<CityNode> q;
	private String goal;

	public Dijkstra() {
		distances = new HashMap<>();
		ancestor = new HashMap<>();
	}

	/**
	 * Calculates the shortest (low cost) way through a given graph.
	 * 
	 * @return a list with the involved nodes from start to target includinng those nodes.
	 */
	public List<String> calculate() {
		while (!q.isEmpty()) {
			final Entry<String, Integer> uEntry = sortedSet.first();

			CityNode uNode = null;
			for (final CityNode cityNode : q) {
				if (cityNode.getName().equals(uEntry.getKey())) {
					uNode = cityNode;
				}
			}
			q.remove(uNode);

			for (final Entry<String, Integer> successor : uNode.getSuccessor().entrySet()) {
				for (final CityNode cityNode : q) {
					if (cityNode.getName().equals(successor.getKey())) {
						distanz_update(uNode.getName(), successor.getKey(), successor.getValue());
					}
				}
			}

			distances.remove(uEntry.getKey());
			sortedSet = entriesSortedByValues(distances);
		}
		return shortestPath();
	}

	private List<String> shortestPath() {
		final LinkedList<String> path = new LinkedList<>();
		String u_ = goal;
		do {
			u_ = ancestor.get(u_);
			if (u_ != null) {
				path.addFirst(u_);
			}
		}
		while (u_ != null);

		path.addLast(goal);
		return path;
	}

	private void distanz_update(final String u, final String v, final Integer distance_u_v) {
		final int abstand_u = distances.get(u);
		int abstand_v = 0;
		Entry<String, Integer> entry_v = null;
		for (final Entry<String, Integer> entry : distances.entrySet()) {
			if (entry.getKey().equals(v)) {
				abstand_v = entry.getValue();
				entry_v = entry;
				break;
			}
		}

		final int alternative = abstand_u + distance_u_v;
		if (alternative < abstand_v) {
			entry_v.setValue(alternative);
			ancestor.put(entry_v.getKey(), u);
		}
	}

	/**
	 * Initializes the graph with start and goal. A graph contains a node with its successors and the distances (costs) to its successors.
	 * 
	 * @param graph
	 * @param start
	 * @param goal
	 */
	public void initialize(final List<CityNode> graph, final String start, final String goal) {
		this.goal = goal;
		q = graph;
		for (final CityNode cityNode : graph) {
			distances.put(cityNode.getName(), Integer.MAX_VALUE);
			ancestor.put(cityNode.getName(), null);
		}
		distances.put(start, 0);

		sortedSet = entriesSortedByValues(distances);
	}

	private <K, V extends Comparable<? super V>> SortedSet<Entry<K, V>> entriesSortedByValues(final Map<K, V> map) {
		final SortedSet<Entry<K, V>> sortedEntries = new TreeSet<>(new Comparator<Entry<K, V>>() {
			@Override
			public int compare(final Entry<K, V> e1, final Entry<K, V> e2) {
				final int res = e1.getValue().compareTo(e2.getValue());
				return res != 0 ? res : 1;
			}
		});

		for (final Entry<K, V> entry : map.entrySet()) {
			sortedEntries.add(new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue()));
		}

		return sortedEntries;
	}

}
