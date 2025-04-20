package Modèle_du_domaine;

public class sysModel {

	private ArrayList<Reservation> reservations_actives;
	private ParcoursCollection all_parcours;
	private ModesCollection all_modes;
	private CiesCollection all_cies;
	private HubsCollection all_hubs;
	private boolean currUserRole;
	private AbstractFactory navalFactory;
	private AbstractFactory aerialFactory;
	private AbstractFactory railwayFactory;
	private CommandHistory history;

	/**
	 * 
	 * @param reservation_no
	 */
	public boolean checkReservation(string reservation_no) {
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
	public ArrayList<Parcours> resultatsSearch(string origine, string destination, DateTime date, ModeTransport mode) {
		// TODO - implement sysModel.resultatsSearch
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param uid
	 */
	public void newReservation(string uid) {
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

}