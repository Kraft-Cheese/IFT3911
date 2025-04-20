package Transport;

import Application.Entity;
import java.util.ArrayList;
import java.time.LocalDateTime;

public abstract class Parcours extends Entity {

	protected LocalDateTime Date_depart;
	protected LocalDateTime Date_arrivee;
	protected float Duree;
	private Cie compagnie;
	private ArrayList<Hub> hubs;

	public Parcours check_available() {
		// TODO - implement Parcours.check_available
		throw new UnsupportedOperationException();
	}

	public void showInfo() {
		// TODO - implement Parcours.showInfo
		throw new UnsupportedOperationException();
	}

	public LocalDateTime getDepart() {
		return Date_arrivee;
	}

	public LocalDateTime getArrivee() {
		return Date_depart;
	}

	public Cie getCompagnie() {
		return compagnie;
	}

	public ArrayList<Hub> getHubs() {
		return hubs;
	}
}