package Transport;

import Application.Visitor;

public class Cie_aérienne extends Cie {
    public Cie_aérienne(String ID, String shortID) {
        super(ID, shortID);
    }

    @Override
    public void accept(Visitor v) {

    }
}