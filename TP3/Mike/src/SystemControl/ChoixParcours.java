package SystemControl;
import SystemCore.SysModel;
import Transport.Parcours;

public class ChoixParcours implements ICommand {
    private SysModel model;
    private Parcours parcours;

    public ChoixParcours(SysModel model, Parcours parcours) {
        this.model = model;
        this.parcours = parcours;
    }

    @Override
    public void execute() {

//        model.selectParcour(parcours);
    }
    @Override
    public void undo() {

//        model.selectParcour(null);
    }
}
