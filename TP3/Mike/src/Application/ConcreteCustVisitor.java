package Application;

import Transport.Cie;
import Transport.Hub;
import Transport.ModeTransport;
import Transport.Parcours;

public class ConcreteCustVisitor implements Visitor {

	private int entityString;

	@Override
	public String visit(Hub hub) {
//		entityString = String.format("%s + %s",
//				hub.getCode(),
//				hub.getCity());
//		return entityString;
		return null;
	}

	@Override
	public String visit(ModeTransport modeTransport) {
//		entityString = String.format("%s + %s",
//				modeTransport.getCode(),
//				modeTransport.getType());
//		return entityString;
		return null;
	}

	@Override
	public String visit(Parcours parcours) {
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
//		entityString = String.format("%s + %s + %s",
//				cie.getCode(),
//				cie.getName(),
//				cie.getType());
//		return entityString;
		return null;
	}
}