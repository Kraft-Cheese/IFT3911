package SystemControl;
import SystemCore.Reservation;
import SystemCore.SysModel;
import Transport.*;

import java.time.LocalDateTime;

public class FaireReservation implements ICommand {

    private final SysModel model;
    private final String userId;
    private Section section;
    private Place place;
    private LocalDateTime dateTime;
    private float total;
    public FaireReservation(SysModel model, String userId, Section section, Place place, LocalDateTime dateTime, float total) {
        this.model = model;
        this.userId = userId;
        this.section = section;
        this.place = place;
        this.dateTime = dateTime;
        this.total = total;
    }
    @Override
    public void execute() {
//        model.newReservation(userId, section, place, dateTime, total);
    }

    @Override
    public void undo() {
//        model.cancelReservation(userId, section, place, dateTime, total);
    }
}