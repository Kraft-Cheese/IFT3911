package SystemCore;
import java.util.ArrayList;
import java.time.LocalDate;

import Transport.*;

public class SysModel {

	private ArrayList<Reservation> reservations_actives;
	private ParcoursCollection all_parcours;
	private ModesCollection all_modes;
	private CiesCollection all_cies;
	private HubsCollection all_hubs;
	private boolean currUserRole;
	private AbstractEntityFactory navalFactory;
	private AbstractEntityFactory aerialFactory;
	private AbstractEntityFactory railwayFactory;

	/**
	 * 
	 * @param reservation_no
	 */
	public boolean checkReservation(String reservation_no) {
		// TODO - implement sysModel.checkReservation
		throw new UnsupportedOperationException();
	}

	private void sendConfirmation() {
		// TODO - implement sysModel.sendConfirmation
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param uid
	 */
	public void newReservation(String uid) {
		// TODO - implement sysModel.newReservation
		throw new UnsupportedOperationException();
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

	public void notifyEntity() {
		// TODO - implement sysModel.notify
		throw new UnsupportedOperationException();
	}

}