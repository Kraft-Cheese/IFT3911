package SystemControl;

import SystemCore.SysModel;
import SystemCore.Reservation;
import Transport.Cie;
import Transport.Hub;
import Transport.ModeTransport;
import Transport.Parcours;

import java.time.LocalDate;
import java.util.List;

/**
 * A command to create (and undo) a new Hub, ModeTransport, Cie or Parcours.
 */
public class MakeNewEntity implements ICommand {
    private final SysModel model;
    private final String entityType;
    private final List<String> args;

    // keep the created object so we can undo
    private Object createdEntity;

    public MakeNewEntity(SysModel model, String entityType, List<String> args) {
        this.model      = model;
        this.entityType = entityType;
        this.args        = args;
    }

    @Override
    public void execute() {
        switch (entityType) {
            case "Hub": {
                // args: [code, city]
                String code = args.get(0);
                String city = args.get(1);
//                createdEntity = model.addHub(code, city);
                break;
            }
            case "Cie": {
                // args: [companyName, shortId]
                String name = args.get(0);
                String shortId = args.get(1);
//                createdEntity = model.addCie(name, shortId);
                break;
            }
            case "Parcours": {
                // args: [origin, destination, date(YYYY‑MM‑DD), modeCode]
                String origin      = args.get(0);
                String destination = args.get(1);
                LocalDate date     = LocalDate.parse(args.get(2));
                String modeCode    = args.get(3);
//                createdEntity = model.addParcours(origin, destination, date, modeCode);
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown entityType: " + entityType);
        }
    }

    @Override
    public void undo() {
        if (createdEntity == null) return;  // nothing to undo

        switch (entityType) {
            case "Hub": {
                Hub hub = (Hub) createdEntity;
//                model.removeHub(hub.getCode());
                break;
            }
            case "ModeTransport": {
                ModeTransport m = (ModeTransport) createdEntity;
//                model.removeModeTransport(m.getID());
                break;
            }
            case "Cie": {
                Cie c = (Cie) createdEntity;
//                model.removeCie(c.getShortId());
                break;
            }
            case "Parcours": {
                Parcours p = (Parcours) createdEntity;
//                model.removeParcours(p.getId());
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown entityType: " + entityType);
        }
    }
}
