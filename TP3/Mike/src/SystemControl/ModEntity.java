package SystemControl;

import SystemCore.SysModel;

public class ModEntity implements ICommand {

    // Change to the correct parameters
    public ModEntity(String entityName, String entityType, String entityId, String entityValue, String entityTypeId) {
    }

    public ModEntity(SysModel model, String id, String name, String description) {
        // Initialize the model and other parameters

    }

    @Override
    public void execute() {
        // Modify the entity in the system [Hub, ModeTransport, Parcours, Cie, etc..]



    }

    @Override
    public void undo() {

    }
}