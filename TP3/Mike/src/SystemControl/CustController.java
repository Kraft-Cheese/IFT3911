package SystemControl;

import SystemCore.SysModel;
import Transport.Parcours;
import Transport.Section;
import Transport.Place;
import Transport.ModeTransport;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustController {
	private final SysModel model;
	private final CommandManager commandManager;

	public CustController(SysModel model) {
		this.model = model;
		this.commandManager = new CommandManager();
	}

	public void faireRecherche(String origine, String destination, LocalDate date, ModeTransport mode) {
		ICommand cmd = new Search(model, origine, destination, date, mode);
		commandManager.executeCommand(cmd);
	}

	public void selectParcours(Parcours choix) {
		ICommand cmd = new ChoixParcours(model, choix);
		commandManager.executeCommand(cmd);
	}

	public void faireReservation(Section section, Place place, String userId, LocalDateTime dateTime, float total) {
		ICommand cmd = new FaireReservation(model, userId, section, place, dateTime, total);
		commandManager.executeCommand(cmd);
	}

	public void choisirPreferencesRes(String preference) {
		ICommand cmd = new ChoixPreference(model, preference);
		commandManager.executeCommand(cmd);
	}

//	public void demanderInfoPaiement() {
//		ICommand cmd = new DemanderInfoPaiement(model);
//		commandManager.executeCommand(cmd);
//	}
//
//	public void demanderInfoClient() {
//		ICommand cmd = new RequestClient(model);
//		commandManager.executeCommand(cmd);
//	}

	public void payerReservation(String reservationId) {
		ICommand cmd = new PayerReservation(model, reservationId);
		commandManager.executeCommand(cmd);
	}

	public void undo() {
		commandManager.undoLast();
	}
}
