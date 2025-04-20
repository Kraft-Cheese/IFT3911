package Transport;

import java.util.ArrayList;

public class ConcreteAerialFactory extends AbstractEntityFactory {

	private static ConcreteAerialFactory instance = null;

	public static ConcreteAerialFactory getInstance()
	{
		if (instance == null)
		{
			instance = new ConcreteAerialFactory();
		}
		return instance;
	}

	private ConcreteAerialFactory() { }

	@Override
	public Hub createHub(String v, String id) {
		return new Aéroport(v, id);
	}

	@Override
	public ModeTransport createModeTransport(String s, String m, String id) {
		return new Avion(s, m, id);
	}

	@Override
	public Cie createCie(String id, String shortId) {
		return new Cie_aérienne(id, shortId);
	}

	@Override
	public Parcours createParcours(ArrayList<Hub> h, ModeTransport m, Cie c, String id, String date_d, String date_a) {
		return new Vol(h, m, c, id, date_d, date_a);
	}
}