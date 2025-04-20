package Transport;

import java.util.ArrayList;

public class Section {

	private int capacity;
	private float prix;
	private String type;
	private Transport.Org_sieges org_sieges;
	private ArrayList<Place> listePlaces;

	public Section(int capacity, String type, Org_sieges Org_sieges, float prix, ArrayList<Place> listePlaces)
	{
		this.capacity = capacity;
		this.type = type;
		this.org_sieges = Org_sieges;
		this.prix = prix;
		this.listePlaces = listePlaces;
	}
}