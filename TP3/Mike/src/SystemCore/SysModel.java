package SystemCore;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.*;
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

	private final List<View> observers = new ArrayList<>();

	public SysModel(
			AbstractEntityFactory navalFactory,
			AbstractEntityFactory aerialFactory,
			AbstractEntityFactory railwayFactory
	){
		this.navalFactory = navalFactory;
		this.aerialFactory = aerialFactory;
		this.railwayFactory = railwayFactory;

		//Init the collections
		this.reservations_actives = new ArrayList<>();
		this.all_parcours = new ParcoursCollection();
		this.all_modes = new ModesCollection();
		this.all_cies = new CiesCollection();
		this.all_hubs = new HubsCollection();
	}

	/**
	 * 
	 * @param reservation_no
	 */
	public boolean checkReservation(String reservation_no) {
		// TODO - implement sysModel.checkReservation
		//return if the resrvation in the list of active reservations
		return reservations_actives.stream().anyMatch(r -> r.getReservationId().equals(reservation_no));
	}

	private void sendConfirmation() {
		// TODO - implement sysModel.sendConfirmation correctly
		System.out.println("Confirmation sent");
	}

	/**
	 * 
	 * @param origine
	 * @param destination
	 * @param date
	 * @param mode
	 */
	public ArrayList<Parcours> resultatsSearch(String origine, String destination, LocalDate date, ModeTransport mode) {
		// TODO - implement sysModel.resultatsSearch
		// reservations_actives will be a list of all the reservations that are active
		//		return reservations_actives.stream().anyMatch(r -> r.getReservationId().equals(reservation_no));
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param uid
	 */
	public void newReservation(String section, String parcoursId, String place, LocalDateTime date, float total) {
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

	/**
	 * 
	 * @param elems
	 */
	public void addParcours(ArrayList<String> elems) {
		// TODO - implement sysModel.addParcours
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param s
	 */
	public void addMode(ArrayList<String> s) {
		// TODO - implement sysModel.addMode
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param h
	 */
	public void addHub(ArrayList<String> h) {
		// TODO - implement sysModel.addHub
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public void addCie(ArrayList<String> c) {
		// TODO - implement sysModel.addCie
		throw new UnsupportedOperationException();
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