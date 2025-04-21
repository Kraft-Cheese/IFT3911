package SystemControl;
import SystemCore.Reservation;
import SystemCore.SysModel;
import Transport.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class FaireReservation implements ICommand {

    private final SysModel model;
    private final String parcoursId;
    private Section section;
    private Place place;
    private LocalDateTime dateTime;
    private float total;
    public FaireReservation(SysModel model, String parcoursId, Section section, Place place, LocalDateTime dateTime, float total) {
        this.model = model;
        this.parcoursId = parcoursId;
        this.section = section;
        this.place = place;
        this.dateTime = dateTime;
        this.total = total;
    }
    @Override
    public void execute() {
        model.newReservation(section,parcoursId, place, dateTime, total);
    }

    @Override
    public void undo() {
//        model.cancelReservation(userId, section, place, dateTime, total);
    }
}