package Transport;

import Application.Visitor;

public class Port extends Hub
{

    protected Port(String ville, String ID) {
        super(ville, ID);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}