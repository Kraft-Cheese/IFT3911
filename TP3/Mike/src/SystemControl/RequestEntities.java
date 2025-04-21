package SystemControl;

import SystemCore.SysModel;
import SystemView.AdminView;
import Transport.ModesCollection;

public class RequestEntities implements ICommand {

    private final SysModel model;

    public RequestEntities(SysModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
       // Print using Iterators
        System.out.println("List of entities:");
        // TODO this crashes...they are empty
        System.out.println("Modes Transports: " + model.getModesCollection());
        System.out.println("Parcours: " + model.getParcoursCollection());
        System.out.println("Cie: " + model.getCieCollection());
        System.out.println("Hub: " + model.getHubCollection());
        System.out.println("Reservations: " + model.getReservations());
    }

    @Override
    public void undo() {
        System.out.println("Undo list entities: no state to revert.");
    }
}