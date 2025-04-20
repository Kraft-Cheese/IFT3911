package Transport;

import java.util.ArrayList;

public class ConcreteRailwayFactory extends AbstractEntityFactory {

	private static ConcreteRailwayFactory instance = new ConcreteRailwayFactory();

	public static ConcreteRailwayFactory getInstance() {
		return instance;
	}

	private ConcreteRailwayFactory() {
		// TODO - implement Transport.ConcreteRailwayFactory.Transport.ConcreteRailwayFactory
		throw new UnsupportedOperationException();
	}

	@Override
	public Hub createHub(String v, String id) {
		return null;
	}

	@Override
	public ModeTransport createModeTransport(String s, String m, String n, String id) {
		return null;
	}

	@Override
	public Cie createCie(String id, String shortId) {
		return null;
	}

	@Override
	public Parcours createParcours(ArrayList<Hub> h, ModeTransport m, Cie c, String id, String date_d, String date_a) {
		return null;
	}
}