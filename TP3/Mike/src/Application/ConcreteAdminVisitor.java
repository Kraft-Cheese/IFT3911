package Application;

import Transport.Cie;
import Transport.Hub;
import Transport.ModeTransport;
import Transport.Parcours;

public class ConcreteAdminVisitor implements Visitor {

	private String entityString;

	@Override
	public String visit(Hub hub) {
		// Hub: CODE
		entityString = hub.getID();
		return entityString;
	}

	@Override
	public String visit(ModeTransport modeTransport) {

		// get le nom de chaque section du mode de transport
		ArrayList<Section> sections = modeTransport.getSections();

		for (Section section : sections) {
			// get le nom de chaque section du mode de transport
			entityString = String.format("|%s(%s/%s)%s,
					section.getType(),
					section.getOccupation(),
					section.getCapacite(),
					section.getPrix()
					);
		}
		return entityString;
	}

	@Override
	public String visit(Parcours parcours) {

		// second part of the string, for as many sections as there are in the mode transport, build the string
		entityString = String.format("%s-%s:[%s]%s",
				parcours.getDepart(),
				parcours.getDestination(),
				visit(parcours.getCie()),
				parcours.getID()
				);

		String mode_info = "";
		// visiter le mode de transport pour obtenir son info
		mode_info = visit(parcours.getMode);
		entityString += mode_info;

		return entityString;
	}

	@Override
	public String visit(Cie cie) {
		// Cie: CODE + NAME + TYPE["N", "A", "R"]
		entityString = cie.getId();

		return entityString;
	}
}