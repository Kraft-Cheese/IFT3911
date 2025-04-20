package Transport;

import Application.Visitor;

public class Trajet extends Parcours {

	public void modifier_gares() {
		// TODO - implement Trajet.modifier_gares
		throw new UnsupportedOperationException();
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}