package SystemCore;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.*;

import Database.Database;
import Transport.*;
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

		ArrayList<String[]> parcoursCsv = DATABASE.readCSV();
		for (String[] parcours : parcoursCsv)
		{
			AbstractEntityFactory factory = chooseFactory(parcours[0]);
			Parcours temp = addParcours(parcours, factory);
		}
	}

	public boolean checkReservation(String reservation_no) {
		// TODO - implement sysModel.checkReservation
		//return if the reservation in the list of active reservations
		return reservations_actives.stream().anyMatch(r -> r.getReservationId().equals(reservation_no));
	}

	private void sendConfirmation() {
		// TODO - implement sysModel.sendConfirmation correctly
		System.out.println("Confirmation sent");
	}

	public ArrayList<Parcours> resultatsSearch(String origine, String destination, LocalDate date, ModeTransport mode) {
		// TODO - implement sysModel.resultatsSearch
		// reservations_actives will be a list of all the reservations that are active
		//		return reservations_actives.stream().anyMatch(r -> r.getReservationId().equals(reservation_no));
		throw new UnsupportedOperationException();
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

		String[] hubsStr = elems[1].split("[|]");
		for (String str : hubsStr)
		{
			Hub hub = addHub(str, factory);
			hubs.add(hub);
		}

		cie = addCie(elems[2], factory);

		List<String> modeInfo = Arrays.asList(elems[6], elems[7], elems[8]);
		mode = addMode((ArrayList<String>) modeInfo, factory);

		Parcours parcours = factory.createParcours(hubs, mode, cie, elems[3], elems[4], elems[5]);
		//all_parcours.add(parcours)
		return parcours;
	}

	public ModeTransport addMode(ArrayList<String> s, AbstractEntityFactory factory)
	{
		ModeTransport mode = factory.createModeTransport(s.get(0), s.get(1), s.get(2));
		//all_modes.add(mode);
		return mode;
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

}