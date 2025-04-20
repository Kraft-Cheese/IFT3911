package SystemControl;
import SystemCore.SysModel;
import Transport.*;
import java.time.LocalDate;
import java.util.*;

public class Search implements ICommand {

    private final SysModel model;
    private final String origine;
    private final String destination;
    private final LocalDate date;
    private final ModeTransport mode;
    private ArrayList<Parcours> lastResults;

    public Search(SysModel model, String origine, String destination, LocalDate date, ModeTransport mode) {
        this.model = model;
        this.origine = origine;
        this.destination = destination;
        this.date = date;
        this.mode = mode;
    }
    @Override
    public void execute() {
        lastResults = model.resultatsSearch(origine, destination, date, mode);
    }

    @Override
    public void undo() {
        lastResults = null;
    }
}