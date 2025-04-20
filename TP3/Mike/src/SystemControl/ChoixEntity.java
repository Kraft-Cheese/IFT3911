package SystemControl;

import SystemControl.ICommand;
import SystemCore.SysModel;

public class ChoixEntity implements ICommand {
    private SysModel model;
    private String entityType;

    public ChoixEntity(SysModel model, String entityType) {
        this.model = model;
        this.entityType = entityType;
    }
    @Override
    public void execute() {


    }

    @Override
    public void undo() {

    }
}