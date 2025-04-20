package Transport;

import Application.Visitor;

import java.util.ArrayList;

public class Trajet extends Parcours {

	public Trajet(ArrayList<Hub> hubs, ModeTransport mode, Cie cie, String id, String date_d, String date_a) {
		super(hubs, mode, cie, id, date_d, date_a);
	}

	public void modifier_gares() {
		// TODO - implement Trajet.modifier_gares
		throw new UnsupportedOperationException();
	}

	@Override
	public void accept(Visitor v) {

	}
}