package Transport;
import java.util.ArrayList;

public abstract class AbstractEntityFactory {

	private int attribute;

	/**
	 * 
	 * @param v
	 * @param id
	 */
	public abstract Hub createHub(String v, String id);

	/**
	 * 
	 * @param s
	 * @param m
	 * @param n
	 * @param id
	 */
	public abstract ModeTransport createModeTransport(String s, String m, String n, String id);

	/**
	 * 
	 * @param id
	 * @param shortId
	 */
	public abstract Cie createCie(String id, String shortId);

	/**
	 * 
	 * @param h
	 * @param m
	 * @param c
	 * @param id
	 * @param date_d
	 * @param date_a
	 */
	public abstract Parcours createParcours(ArrayList<Hub> h, ModeTransport m, Cie c, String id, String date_d, String date_a);

}