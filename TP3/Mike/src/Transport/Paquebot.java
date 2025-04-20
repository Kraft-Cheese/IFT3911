package Transport;

import Application.Visitor;

public class Paquebot extends ModeTransport {


    public Paquebot(String sections, String modele, String ID) {
        super(sections, modele, ID);
    }

    @Override
    public void accept(Visitor v) {

    }
}