package Transport;

import Application.Entity;
import Application.Visitor;

public abstract class Cie extends Entity {

	private String shortId;

	public Cie(String ID, String shortID)
	{
		this.ID = ID;
		this.shortId = shortID;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}