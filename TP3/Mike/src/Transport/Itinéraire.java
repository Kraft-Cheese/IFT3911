package Transport;

import Application.Visitor;

import java.util.ArrayList;

public class Itinéraire extends Parcours {

	public Itinéraire(ArrayList<Hub> hubs, ModeTransport mode, Cie cie, String id, String date_d, String date_a) {
		super(hubs, mode, cie, id, date_d, date_a);
	}

	public void modifier_ports() {
		// TODO - implement Itinéraire.modifier_ports
		throw new UnsupportedOperationException();
	}

	@Override
	public void accept(Visitor v) {

	}
}