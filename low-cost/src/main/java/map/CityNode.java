package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author André Schmer
 *
 */
public class CityNode {

	private final String name;

	// id, distanz
	private final Map<String, Integer> successors;

	public CityNode(final String name) {
		this.name = name;
		successors = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public Map<String, Integer> getSuccessor() {
		return successors;
	}

	public void putSuccessor(final String node, final int distance) {
		successors.put(node, distance);
	}

}
