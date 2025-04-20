package SystemControl;
import SystemCore.SysModel;

public class DeleteEntity implements ICommand {
    private final SysModel model;
    private final String entityType;

    public DeleteEntity(SysModel model, String entityType) {
        this.model = model;
        this.entityType = entityType;
    }

    @Override
    public void execute() {
        switch (entityType) {
            case "Reservation":
//                model.deleteClient(entityId);
                break;
            case "ModeTransport":
//                model.deleteTransporteur(entityId);
                break;
            case "Parcours":
//                model.deleteParcours(entityId);
                break;
            default:
                System.out.println("Unknown entity type.");
        }
    }

    @Override
    public void undo() {
        // Implement undo logic if necessary
    }
}
