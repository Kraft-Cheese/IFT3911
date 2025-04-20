package Transport;

import java.util.ArrayList;

public class ConcreteNavalFactory extends AbstractEntityFactory {

	private static ConcreteNavalFactory instance = new ConcreteNavalFactory();

	public static ConcreteNavalFactory getInstance() {
		return instance;
	}

	private ConcreteNavalFactory() {
		// TODO - implement Transport.ConcreteNavalFactory.Transport.ConcreteNavalFactory
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