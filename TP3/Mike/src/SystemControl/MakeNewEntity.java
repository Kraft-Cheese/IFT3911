package SystemControl;

import SystemCore.SysModel;
import java.time.LocalDate;
import java.util.List;

/**
 * A command to create (and undo) a new Hub, ModeTransport, Cie or Parcours.
 */
public class MakeNewEntity implements ICommand {
    private final SysModel model;
    private final String entityType;
    private final List<String> args;
    public MakeNewEntity(SysModel model, String entityType, List<String> args) {
        this.model      = model;
        this.entityType = entityType;
        this.args       = args;
    }

    @Override
    public void execute() {
        switch (entityType) {
            case "Hub": {
                String code = args.get(0);
                String city = args.get(1);
//                model.addHub(code, city);
                break;
            }
            case "ModeTransport": {
                String code = args.get(0);
                String desc = args.get(1);
                String serial = args.get(2);
//                model.addModeTransport(code, desc, serial);
                break;
            }
            case "Cie": {
                String code = args.get(0);
                String name = args.get(1);
                String type = args.get(2);
//                model.addCie(code, name, type);
                break;
            }
            case "Parcours": {
                String origin = args.get(0);
                String destination = args.get(1);
                LocalDate date = LocalDate.parse(args.get(2));
                String modeCode = args.get(3);
//                model.addParcours(origin, destination, date, modeCode);
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown entityType: " + entityType);
        }
    }

    @Override
    public void undo() {
        switch (entityType) {
            case "Hub": {
                String code = args.get(0);
//                model.removeHub(code);
                break;
            }
            case "ModeTransport": {
                String code = args.get(0);
//                model.removeModeTransport(code);
                break;
            }
            case "Cie": {
                String code = args.get(0);
//                model.removeCie(code);
                break;
            }
            case "Parcours": {
                String origin = args.get(0);
                String destination = args.get(1);
                LocalDate date = LocalDate.parse(args.get(2));
                String modeCode = args.get(3);
//                model.removeParcours(origin, destination, date, modeCode);
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown entityType: " + entityType);
        }
    }
}
