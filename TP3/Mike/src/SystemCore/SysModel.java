package SystemCore;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.*;

import Application.CollectionIterator;
import Application.Iterator;
import Database.Database;
import SystemView.AdminView;
import SystemView.CustView;
import Transport.*;
import Application.*;


import SystemView.View;

public class SysModel {

	private ArrayList<Reservation> reservations_actives;
	private ParcoursCollection all_parcours;
	private ModesCollection all_modes;
	private CiesCollection all_cies;
	private HubsCollection all_hubs;
	private boolean currUserRole; // true = admin, false = client
	private AbstractEntityFactory navalFactory;
	private AbstractEntityFactory aerialFactory;
	private AbstractEntityFactory railwayFactory;
	private static Database DATABASE = new Database();
	private ArrayList<Parcours> currSearchResults;

	private final List<View> observers = new ArrayList<>();

	public SysModel()
	{
		this.navalFactory = ConcreteNavalFactory.getInstance();
		this.aerialFactory = ConcreteAerialFactory.getInstance();
		this.railwayFactory = ConcreteRailwayFactory.getInstance();

		//Init the collections
		this.reservations_actives = new ArrayList<>();
		this.all_parcours = new ParcoursCollection();
		this.all_modes = new ModesCollection();
		this.all_cies = new CiesCollection();
		this.all_hubs = new HubsCollection();

		// TODO: attach the 2 observers
		addObserver(new AdminView(this));
		addObserver(new CustView(this));

		ArrayList<String[]> parcoursCsv = DATABASE.readCSV();
		for (String[] parcours : parcoursCsv)
		{
			AbstractEntityFactory factory = chooseFactory(parcours[0]);
			Parcours temp = addParcours(parcours, factory);
		}
	}

	public ArrayList<Parcours> getCurrSearchResults() {
		return currSearchResults;
	}

	/**
	 *
	 * @param reservation_no
	 */
	public boolean checkReservation(String reservation_no) {
		// TODO - implement sysModel.checkReservation
		//return if the reservation in the list of active reservations
		return reservations_actives.stream().anyMatch(r -> r.getReservationId().equals(reservation_no));
	}

	public List<Reservation> getReservations() {
		return reservations_actives;
	}

	private void sendConfirmation() {
		// TODO - implement sysModel.sendConfirmation correctly
		System.out.println("Confirmation sent");
	}

	public ArrayList<Parcours> resultatsSearch(String origine, String destination, LocalDate date, ModeTransport mode) {
		// TODO - implement sysModel.resultatsSearch
		// reservations_actives will be a list of all the reservations that are active
		//		return reservations_actives.stream().anyMatch(r -> r.getReservationId().equals(reservation_no));
		// throw new UnsupportedOperationException();

		// regarder à travers all_parcours pour voir si on trouve un parcours qui correspond à l'origine, destination, mode de transport
		CollectionIterator it = all_parcours.createIterator();
		ArrayList<Parcours> resultats = new ArrayList<>();

		while (it.next()!=null) {
			Parcours parcours = (Parcours) it.next();
			if (parcours.getDepart().equals(origine) && parcours.getArrivee().equals(destination) && parcours.getMode().equals(mode)) {
				resultats.add(parcours);
			}
		}

		this.currSearchResults = resultats;
		notifyEntity();

		return resultats;
	}


	public void newReservation(Section section, String parcoursId, Place place, LocalDateTime date, float total) {
//		 TODO - implement sysModel.newReservation
		Reservation reservation = new Reservation(
				section,
				parcoursId,
				place,
				date,
				total
		);
		reservations_actives.add(reservation);
		notifyEntity();
	}

	public boolean readDB() {
		// TODO - implement sysModel.readDB
		throw new UnsupportedOperationException();
	}

	public boolean updateDB() {
		// TODO - implement sysModel.updateDB
		throw new UnsupportedOperationException();
	}

	private AbstractEntityFactory chooseFactory(String type)
	{
		AbstractEntityFactory factory = null;

		// :(
		switch (type)
		{
			case "N":
				factory = this.navalFactory;
				break;

			case "A":
				factory = this.aerialFactory;
				break;

			case "R":
				factory = this.railwayFactory;
				break;
		}
		return factory;
	}

	public Parcours addParcours(String[] elems, AbstractEntityFactory factory)
	{
		ArrayList<Hub> hubs = new ArrayList<>();
		Cie cie;
		ModeTransport mode;

		if (elems == null || elems.length < 9) {
			System.err.println("Skipping invalid CSV row (expected ≥9 fields, got "
					+ (elems == null ? 0 : elems.length)
					+ "): " + Arrays.toString(elems));
			return null;
		}

		String[] hubsStr = elems[1].split("\\|");
		for (String str : hubsStr)
		{
			Hub hub = addHub(str, factory);
			hubs.add(hub);
		}

		cie = addCie(elems[2], factory);

		List<String> modeInfo = Arrays.asList(elems[6], elems[7], elems[8]);
		mode = addMode(new ArrayList<>(modeInfo), factory);

        //all_parcours.add(parcours)
		return factory.createParcours(hubs, mode, cie, elems[3], elems[4], elems[5]);
	}

	public ModeTransport addMode(ArrayList<String> s, AbstractEntityFactory factory)
	{
        //all_modes.add(mode);
		return factory.createModeTransport(s.get(0), s.get(1), s.get(2));
	}

	public Hub addHub(String h, AbstractEntityFactory factory)
	{
		Hub hub = factory.createHub("Ville", h);
		//all_hubs.add(hub) IMPLEMENTER ITERATOR
		return hub;
	}

	// paramètre : nomDeLaCompagnie|shortId
	// ex : AIRCAN|AC
	public Cie addCie(String c, AbstractEntityFactory factory)
	{
		String[] cieIds = c.split("[|]");
		Cie cie = factory.createCie(cieIds[0], cieIds[1]);
		//all_cies.add(cie)
		return cie;
	}


	public void addObserver(View obs) {
		observers.add(obs);
	}

	public void removeObserver(View obs) {
		observers.remove(obs);
	}

	public void notifyEntity() {
		// TODO - implement sysModel.notify
		for (View obs : observers) {
			obs.updateView();
		}
	}

	public void setCurrUserRole(boolean isAdmin) {
		this.currUserRole = isAdmin;
	}

	public boolean isCurrUserAdmin() {
		return currUserRole;
	}

	public List<ModeTransport> getModesCollection() {
		List<ModeTransport> modes = new ArrayList<>();
		Iterator it = all_modes.createIterator();
		// first element:
		try {
			Entity e = it.next();
			while (e != null) {
				modes.add((ModeTransport) e);
				e = it.next();
			}
		} catch (IndexOutOfBoundsException | ClassCastException ex) {
			// iterator exhausted (or bad cast) → stop
		}

		if (modes.isEmpty()) {
			System.err.println("No modes found in the collection.");
		}
		return modes;
	}

	/** Returns _all_ the parcours in the system. */
	public List<Parcours> getParcoursCollection() {
		List<Parcours> parcoursList = new ArrayList<>();
		Iterator it = all_parcours.createIterator();
		try {
			Entity e = it.next();
			while (e != null) {
				parcoursList.add((Parcours) e);
				e = it.next();
			}
		} catch (IndexOutOfBoundsException | ClassCastException _) {
		}
		if (parcoursList.isEmpty()) {
			System.err.println("No trips found in the collection.");
		}
		return parcoursList;
	}

	/** Returns _all_ the companies in the system. */
	public List<Cie> getCieCollection() {
		List<Cie> cies = new ArrayList<>();
		Iterator it = all_cies.createIterator();
		try {
			Entity e = it.next();
			while (e != null) {
				cies.add((Cie) e);
				e = it.next();
			}
		} catch (IndexOutOfBoundsException | ClassCastException _) {
		}
		if (cies.isEmpty()) {
			System.err.println("No companies found in the collection.");
		}
		return cies;
	}

	/** Returns _all_ the hubs in the system. */
	public List<Hub> getHubCollection() {
		List<Hub> hubs = new ArrayList<>();
		Iterator it = all_hubs.createIterator();
		try {
			Entity e = it.next();
			while (e != null) {
				hubs.add((Hub) e);
				e = it.next();
			}
		} catch (IndexOutOfBoundsException | ClassCastException _) {
		}
		if (hubs.isEmpty()) {
			System.err.println("No hubs found in the collection.");
		}
		return hubs;
	}

}