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

	public int getCapacite() {
		return capacity;
	}

	public void setCapacite(int capacity) {
		this.capacity = capacity;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Org_sieges getOrg_sieges() {
		return org_sieges;
	}

	public void setOrg_sieges(Org_sieges org_sieges) {
		this.org_sieges = org_sieges;
	}

	public ArrayList<Place> getListePlaces() {
		return listePlaces;
	}

	public void setListePlaces(ArrayList<Place> listePlaces) {
		this.listePlaces = listePlaces;
	}

	public int getOccupation()
	{
		return 0;
	}
}