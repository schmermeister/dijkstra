package map;

import java.util.ArrayList;
import java.util.List;

/**
 * @author André Schmer
 *
 */
public class Data {

	public static List<CityNode> load() {
		final List<CityNode> map = new ArrayList<>();

		// fill map from the bottom
		final CityNode landeck = new CityNode("Landeck");
		landeck.putSuccessor("Innsbruck", 73);
		map.add(landeck);

		final CityNode innsbruck = new CityNode("Innsbruck");
		innsbruck.putSuccessor("Landeck", 73);
		map.add(innsbruck);

		final CityNode rosenheim = new CityNode("Rosenheim");
		rosenheim.putSuccessor("Innsbruck", 93);
		rosenheim.putSuccessor("Muenchen", 59);
		rosenheim.putSuccessor("Salzburg", 81);
		map.add(rosenheim);

		final CityNode salzburg = new CityNode("Salzburg");
		salzburg.putSuccessor("Rosenheim", 81);
		salzburg.putSuccessor("Linz", 126);
		map.add(salzburg);

		final CityNode muenchen = new CityNode("Muenchen");
		muenchen.putSuccessor("Rosenheim", 59);
		muenchen.putSuccessor("Memmingen", 115);
		muenchen.putSuccessor("Nuernberg", 170);
		muenchen.putSuccessor("Ulm", 123);
		muenchen.putSuccessor("Passau", 189);
		map.add(muenchen);

		final CityNode linz = new CityNode("Linz");
		linz.putSuccessor("Salzburg", 126);
		linz.putSuccessor("Passau", 102);
		map.add(linz);

		final CityNode passau = new CityNode("Passau");
		passau.putSuccessor("Linz", 102);
		passau.putSuccessor("Muenchen", 189);
		passau.putSuccessor("Nuernberg", 220);
		map.add(passau);

		final CityNode memmingen = new CityNode("Memmingen");
		memmingen.putSuccessor("Muenchen", 115);
		memmingen.putSuccessor("Ulm", 55);
		memmingen.putSuccessor("Zuerich", 184);
		map.add(memmingen);

		final CityNode zuerich = new CityNode("Zuerich");
		zuerich.putSuccessor("Memmingen", 184);
		zuerich.putSuccessor("Bern", 120);
		zuerich.putSuccessor("Basel", 85);
		map.add(zuerich);

		final CityNode bern = new CityNode("Bern");
		bern.putSuccessor("Zuerich", 120);
		bern.putSuccessor("Basel", 91);
		map.add(bern);

		final CityNode basel = new CityNode("Basel");
		basel.putSuccessor("Zuerich", 85);
		basel.putSuccessor("Bern", 91);
		basel.putSuccessor("Karlsruhe", 191);
		map.add(basel);

		final CityNode ulm = new CityNode("Ulm");
		ulm.putSuccessor("Memmingen", 55);
		ulm.putSuccessor("Muenchen", 123);
		ulm.putSuccessor("Wuerzburg", 183);
		ulm.putSuccessor("Stuttgart", 107);
		ulm.putSuccessor("Nuernberg", 171);
		map.add(ulm);

		final CityNode nuernberg = new CityNode("Nuernberg");
		nuernberg.putSuccessor("Passau", 220);
		nuernberg.putSuccessor("Bayreuth", 75);
		nuernberg.putSuccessor("Muenchen", 170);
		nuernberg.putSuccessor("Ulm", 171);
		nuernberg.putSuccessor("Mannheim", 230);
		nuernberg.putSuccessor("Wuerzburg", 104);
		map.add(nuernberg);

		final CityNode bayreuth = new CityNode("Bayreuth");
		bayreuth.putSuccessor("Nuernberg", 75);
		map.add(bayreuth);

		final CityNode stuttgart = new CityNode("Stuttgart");
		stuttgart.putSuccessor("Ulm", 107);
		stuttgart.putSuccessor("Wuerzburg", 140);
		stuttgart.putSuccessor("Karlsruhe", 64);
		map.add(stuttgart);

		final CityNode karlsruhe = new CityNode("Karlsruhe");
		karlsruhe.putSuccessor("Basel", 191);
		karlsruhe.putSuccessor("Stuttgart", 64);
		karlsruhe.putSuccessor("Mannheim", 67);
		map.add(karlsruhe);

		final CityNode mannheim = new CityNode("Mannheim");
		mannheim.putSuccessor("Frankfurt", 85);
		mannheim.putSuccessor("Nuernberg", 230);
		mannheim.putSuccessor("Karlsruhe", 67);
		map.add(mannheim);

		final CityNode wuerzburg = new CityNode("Wuerzburg");
		wuerzburg.putSuccessor("Ulm", 183);
		wuerzburg.putSuccessor("Nuernberg", 104);
		wuerzburg.putSuccessor("Stuttgart", 140);
		wuerzburg.putSuccessor("Frankfurt", 111);
		map.add(wuerzburg);

		final CityNode frankfurt = new CityNode("Frankfurt");
		frankfurt.putSuccessor("Mannheim", 85);
		frankfurt.putSuccessor("Wuerzburg", 111);
		map.add(frankfurt);

		return map;

	}

}
