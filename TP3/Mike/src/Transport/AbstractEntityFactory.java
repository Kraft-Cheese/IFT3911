package Transport;
import java.util.ArrayList;

public abstract class AbstractEntityFactory {

	private int attribute;

	public abstract Hub createHub(String v, String id);

	public abstract ModeTransport createModeTransport(String s, String m, String id);

	public abstract Cie createCie(String id, String shortId);

	public abstract Parcours createParcours(ArrayList<Hub> h, ModeTransport m, Cie c, String id, String date_d, String date_a);

}