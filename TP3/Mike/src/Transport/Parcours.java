package Transport;

import Application.Entity;
import Application.Visitor;

import java.util.ArrayList;
import java.time.LocalDateTime;

public abstract class Parcours extends Entity {

	protected LocalDateTime date_depart;
	protected LocalDateTime date_arrivee;
	protected float duree;
	protected Cie compagnie;
	protected ArrayList<Hub> hubs;
	protected ModeTransport mode;

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
		String[] parts = str.split("[-\\.:]");
		if (parts.length != 5) {
			throw new IllegalArgumentException(
					"Bad date‑time format, expected 5 fields but got "
							+ parts.length + " from \"" + str + "\""
			);
		}
		int year   = Integer.parseInt(parts[0]);
		int month  = Integer.parseInt(parts[1]);
		int day    = Integer.parseInt(parts[2]);
		int hour   = Integer.parseInt(parts[3]);
		int minute = Integer.parseInt(parts[4]);

		return LocalDateTime.of(year, month, day, hour, minute);
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