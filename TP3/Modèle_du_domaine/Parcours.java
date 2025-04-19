package Modèle_du_domaine;

public abstract class Parcours extends Entity {

	protected Hub Pt_depart;
	protected DateTime Date_depart;
	protected Hub Pt_arrivee;
	protected DateTime Date_arrivee;
	protected float Duree;
	private float prix;

	public Parcours check_available() {
		// TODO - implement Parcours.check_available
		throw new UnsupportedOperationException();
	}

	public void showInfo() {
		// TODO - implement Parcours.showInfo
		throw new UnsupportedOperationException();
	}

}