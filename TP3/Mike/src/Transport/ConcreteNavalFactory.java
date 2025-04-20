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
	public Hub createHub(String v, String id)
	{
		return new Port(v, id);
	}

	@Override
	public ModeTransport createModeTransport(String s, String m, String id)
	{
		return new Paquebot(s, m, id);
	}

	@Override
	public Cie createCie(String id, String shortId)
	{
		return new Cie_croisière(id, shortId);
	}

	@Override
	public Parcours createParcours(ArrayList<Hub> h, ModeTransport m, Cie c, String id, String date_d, String date_a)
	{
		return new Itinéraire(h, m, c, id, date_d, date_a);
	}
}