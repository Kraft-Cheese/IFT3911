package Application;

import Transport.Cie;
import Transport.Hub;
import Transport.ModeTransport;
import Transport.Parcours;

public class ConcreteAdminVisitor implements Visitor {

	private String entityString;

	@Override
	public String visit(Hub hub) {
		// Hub: CODE + City
//		entityString = String.format("%s + %s",
//				hub.getCode(),
//				hub.getCity());
//		return entityString;
				return null;
	}

	@Override
	public String visit(ModeTransport modeTransport) {
		// ModeTransport: CODE + TYPE["N", "A", "R"]
//		entityString = String.format("%s + %s",
//				modeTransport.getCode(),
//				modeTransport.getType());
//		return entityString;
				return null;
	}

	@Override
	public String visit(Parcours parcours) {
		// Origin + Desination + Date + Mode
//		entityString = String.format("%s + %s + %s + %s",
//				parcours.getOrigin(),
//				parcours.getDestination(),
//				parcours.getDate(),
//				parcours.getMode());
//		return entityString;
				return null;
	}

	@Override
	public String visit(Cie cie) {
		// Cie: CODE + NAME + TYPE["N", "A", "R"]
//		entityString = String.format("%s + %s + %s",
//				cie.getCode(),
//				cie.getName(),
//				cie.getType());
//		return entityString;
				return null;
	}
}