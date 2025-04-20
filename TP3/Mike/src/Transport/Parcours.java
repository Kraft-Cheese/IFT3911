package Transport;

import Application.Entity;
import Application.Visitor;

import java.util.ArrayList;
import java.time.LocalDateTime;

public abstract class Parcours extends Entity {

	protected LocalDateTime date_depart;
	protected LocalDateTime date_arrivee;
	protected float duree;
	private Cie compagnie;
	private ArrayList<Hub> hubs;
	private ModeTransport mode;

	public Parcours(ArrayList<Hub> hubs, ModeTransport mode, Cie cie, String id, String date_d, String date_a)
	{
		this.hubs = hubs;
		this.mode = mode;
		this.compagnie = cie;
		this.ID = id;
		this.date_depart = createDate(date_d);
		this.date_arrivee = createDate(date_a);
	}

	private LocalDateTime createDate(String str)
	{
		String[] dateStr = str.split("[.]");
		int[] date = new int[dateStr.length];
		for (int i = 0; i < date.length; i++)
		{
			date[i] = Integer.parseInt(dateStr[i]);
		}
		return LocalDateTime.of(date[0], date[1], date[2], date[3], date[4]);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	public Parcours check_available() {
		// TODO - implement Parcours.check_available
		throw new UnsupportedOperationException();
	}

	public void showInfo() {
		// TODO - implement Parcours.showInfo
		throw new UnsupportedOperationException();
	}

	public LocalDateTime getDepart() {
		return this.date_depart;
	}
	public String getDepartStr() {
		return getDateString(this.date_depart);
	}

	public LocalDateTime getArrivee() {
		return this.date_arrivee;
	}
	public String getArriveeStr() {
		return getDateString(this.date_arrivee);
	}

	private String getDateString(LocalDateTime date)
	{
		return date.getYear() + "."
				+ date.getMonthValue() + "."
				+ date.getDayOfMonth() + "."
				+ date.getHour() + "."
				+ date.getMinute();
	}

	public Cie getCompagnie() {
		return compagnie;
	}

	public ArrayList<Hub> getHubs() {
		return hubs;
	}

	public ModeTransport getMode() {
		return mode;
	}
}