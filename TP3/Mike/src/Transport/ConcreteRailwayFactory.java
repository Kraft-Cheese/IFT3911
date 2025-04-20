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
		return null;
	}

	@Override
	public ModeTransport createModeTransport(String s, String m, String id) {
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