package Transport;

import Application.Visitor;

import java.util.ArrayList;

public class Vol extends Parcours {
    public Vol(ArrayList<Hub> hubs, ModeTransport mode, Cie cie, String id, String date_d, String date_a) {
        super(hubs, mode, cie, id, date_d, date_a);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}