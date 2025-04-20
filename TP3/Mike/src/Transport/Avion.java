package Transport;

import Application.Visitor;

public class Avion extends ModeTransport {
    public Avion(String sections, String modele, String ID) {
        super(sections, modele, ID);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}