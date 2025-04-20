package Transport;

import Application.Visitor;

public class Ligne_de_train extends Cie {
    public Ligne_de_train(String ID, String shortID) {
        super(ID, shortID);
    }

    @Override
    public void accept(Visitor v) {

    }
}