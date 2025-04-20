package Transport;

import java.util.ArrayList;

public class ConcreteRailwayFactory extends AbstractEntityFactory {

	private static ConcreteRailwayFactory instance = null;

	public static ConcreteRailwayFactory getInstance()
	{
		if (instance == null)
		{
			instance = new ConcreteRailwayFactory();
		}
		return instance;
	}

	private ConcreteRailwayFactory() { }

	@Override
	public Hub createHub(String v, String id) {
		return new Gare(v, id);
	}

	@Override
	public ModeTransport createModeTransport(String s, String m, String id) {
		return new Train(s, m, id);
	}

	@Override
	public Cie createCie(String id, String shortId) {
		return new Ligne_de_train(id, shortId);
	}

	@Override
	public Parcours createParcours(ArrayList<Hub> h, ModeTransport m, Cie c, String id, String date_d, String date_a) {
		return new Trajet(h, m, c, id, date_d, date_a);
	}
}