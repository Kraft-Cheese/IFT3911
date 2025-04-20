package Transport;

import Application.Visitor;

public class Train extends ModeTransport {
    public Train(String sections, String modele, String ID) {
        super(sections, modele, ID);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}