package Transport;

import Application.Visitor;

public class Cie_croisière extends Cie {
    public Cie_croisière(String ID, String shortID) {
        super(ID, shortID);
    }

    @Override
    public void accept(Visitor v) {

    }
}