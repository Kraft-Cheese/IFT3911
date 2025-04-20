package Transport;

import Application.Visitor;

public class Paquebot extends ModeTransport {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}