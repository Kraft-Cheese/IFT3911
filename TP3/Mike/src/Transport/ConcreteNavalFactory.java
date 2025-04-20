package Transport;

import java.util.ArrayList;

public class ConcreteNavalFactory extends AbstractEntityFactory {

	private static ConcreteNavalFactory instance = null;

	public static ConcreteNavalFactory getInstance()
	{
		if (instance == null)
		{
			instance = new ConcreteNavalFactory();
		}
		return instance;
	}

	private ConcreteNavalFactory() { }

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