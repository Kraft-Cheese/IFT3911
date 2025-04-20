package SystemControl;

import SystemCore.SysModel;

public class ChoixPreference implements ICommand {
    private SysModel model;
    private String pref;
    private String old;

    public ChoixPreference(SysModel model, String preference)
    {
        this.model = model;
        this.pref = preference;
    }

    @Override
    public void execute() {
//        old = model.getPreference(pref);
//        model.setPreference(pref, "newValue"); // Assuming "newValue" is the new preference value
    }

    @Override
    public void undo() {

//        model.setPreference(old);
    }
}