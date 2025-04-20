package Transport;

import java.util.ArrayList;

public class Section {

	private int capacity;
	private float Prix;
	private String Type;
	private Transport.Org_sieges Org_sieges;
	private ArrayList<Place> listePlaces;

	public Section(int capacity, String type,  Org_sieges Org_sieges, float prix, ArrayList<Place> listePlaces){
		this.capacity = capacity;
		this.Type = type;
		this.Org_sieges = Org_sieges;
		this.Prix = prix;
		this.listePlaces = listePlaces;
	}
}