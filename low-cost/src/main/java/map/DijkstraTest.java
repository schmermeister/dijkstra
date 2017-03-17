package map;

import java.util.List;

import org.junit.Test;

/**
 * 
 * @author André Schmer
 *
 */
public class DijkstraTest {

	/**
	 * @param args
	 */
	@Test
	public void testPath() {
		final List<CityNode> map = Data.load();

		final String start = "Frankfurt";
		final String ziel = "Innsbruck";

		final Dijkstra dijkstra = new Dijkstra();
		dijkstra.initialize(map, start, ziel);
		final List<String> path = dijkstra.calculate();

		System.out.println(path);
	}

}
