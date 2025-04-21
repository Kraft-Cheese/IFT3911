package SystemView;

import SystemControl.CustController;
import SystemCore.Reservation;
import SystemCore.SysModel;
import Transport.Parcours;
import Transport.Section;
import Transport.Place;
import Transport.ModeTransport;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class CustView extends View {
	private final CustController controller;

	public CustView(SysModel model) {
		super(model);
		this.controller = new CustController(model);
	}

	public void custInput() {
		Scanner in = new Scanner(System.in);
		boolean back = false;
		while (!back) {
			affMenuPrincipal();
			System.out.print("  Customer> ");
			int cmd;
			try {
				cmd = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number.");
				continue;
			}
			switch (cmd) {
				case 1: affParcours();      break;
				case 2: doReserve(in);     break;
				case 3: doPayment(in);     break;
				case 4: controller.undo(); break;
				case 5: back = true;       break;
				default:
					System.out.println("Unknown option.");
			}
		}
	}

	public void affParcours() {
		System.out.println("\n--- Parcours ---");

	}

	public void affMenuPrincipal() {
		System.out.println("\n--- Customer Menu ---");
		System.out.println("1. See trips");
		System.out.println("2. Reserve a seat");
		System.out.println("3. Pay for reservation");
		System.out.println("4. Undo last action");
		System.out.println("5. Back to Main Menu");
	}

	private void doReserve(Scanner in) {
		List<Parcours> list = model.getCurrSearchResults();
		if (list==null || list.isEmpty()) {
			System.out.println("No results found.");
			return;
		}
		affResRecherche(list);
		System.out.print("    Select trip #: ");
		int sel;
		try {
			sel = Integer.parseInt(in.nextLine()) - 1;
		} catch (Exception e) {
			System.out.println("Invalid.");
			return;
		}
		if (sel < 0 || sel >= list.size()) {
			System.out.println("Out of range.");
			return;
		}
		Parcours chosen = list.get(sel);

		List<Section> secs = chosen.getMode().getSections();
		System.out.println("    Sections:");
		for (int i = 0; i < secs.size(); i++) {
			Section s = secs.get(i);
			System.out.printf(
					"      %d) %s (%d/%d) $%.2f\n",
					i + 1,
					s.getType(),
					s.getCapacite() - s.getOccupation(),
					s.getCapacite(),
					s.getPrix()
			);
		}
		System.out.print("    Select section #: ");
		int sidx;
		try {
			sidx = Integer.parseInt(in.nextLine()) - 1;
		} catch (Exception e) {
			System.out.println("Invalid.");
			return;
		}
		if (sidx < 0 || sidx >= secs.size()) {
			System.out.println("Out of range.");
			return;
		}
		Section sec = secs.get(sidx);

		System.out.print("    Row: ");
		int row;
		try {
			row = Integer.parseInt(in.nextLine());
		} catch (Exception e) {
			System.out.println("Invalid.");
			return;
		}
		System.out.print("    Column: "); char col = in.nextLine().charAt(0);
		Place place = null;
		for (Place p : sec.getListePlaces()) {
			if (p.getRow().equals(String.valueOf(row)) && p.getCol().equals(String.valueOf(col))) {
				place = p;
				break;
			}
		}
		if (place == null) {
			System.out.println("Seat not found.");
			return;
		}
		controller.faireReservation(sec, place, String.valueOf(UUID.randomUUID()), LocalDateTime.now(), sec.getPrix());
		List<Reservation> resList = model.getReservations();
		Reservation r = resList.get(resList.size() - 1);
		if(r == null) {
			System.out.println("Reservation failed.");
			return;
		}
		affFormReservation(r);
	}

	private void doPayment(Scanner in) {
		System.out.print("    Reservation ID: "); String id = in.nextLine();
		System.out.print("    (Simulated) Pay now? (y/n): "); String ans = in.nextLine();
		if (!ans.equalsIgnoreCase("y")) {
			System.out.println("Payment cancelled.");
			return;
		}
		controller.payerReservation(id);
		affPaiementConfirm();
	}

	private void affPaiementConfirm() {
		System.out.println("\n--- Payment Confirmed ---");
		System.out.println("Your payment has been processed successfully.");
		System.out.println("Thank you for your reservation!");
		System.out.println("You will receive a confirmation email shortly.");
		System.out.println("Have a great trip!");
		System.out.println("------------------------");
		System.out.println();
//		model.updateDB();
	}

	public void affResRecherche(List<Parcours> liste) {
		System.out.println("\n--- Search Results ---");
		if (liste == null || liste.isEmpty()) {
			System.out.println("No matching trips.");
		} else {
			for (int i = 0; i < liste.size(); i++) {
				Parcours p = liste.get(i);
				System.out.printf(
						"%d) %s -> %s | %s | Mode: %s\n",
						i + 1,
						p.getDepartStr(),
						p.getArriveeStr(),
						p.getDepart().toLocalDate(),
						p.getMode().getID()
				);
			}
		}
	}

	public void affFormReservation(Reservation r) {
		System.out.println("\n--- Reservation Confirmed ---");
		System.out.println("ID: " + r.getReservationId());
		System.out.println("Trip: " + r.getParcoursId());
		System.out.println("Seat: " + r.getSection().getType() + " " + r.getPlace().getRow() + r.getPlace().getCol());
		System.out.println("Total: $" + r.getTotal());
	}

	@Override
	public void updateView() {
		// View should update itself based on the model
		System.out.println("Update view called");

	}
}
