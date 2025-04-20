package Transport;

import Application.Entity;

public abstract class Cie extends Entity {

	private String shortId;

	public Cie(String ID, String shortID)
	{
		this.ID = ID;
		this.shortId = shortID;
	}

}