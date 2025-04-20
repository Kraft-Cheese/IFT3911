package Application;

import Transport.Cie;
import Transport.Hub;
import Transport.ModeTransport;
import Transport.Parcours;

public class ConcreteCustVisitor implements Visitor {

	private int entityString;

	@Override
	public String visit(Hub hub) {
		return null;
	}

	@Override
	public String visit(ModeTransport modeTransport) {
		return null;
	}

	@Override
	public String visit(Parcours parcours) {
		return null;
	}

	@Override
	public String visit(Cie cie) {
		return null;
	}
}