package Transport;

import Application.Entity;

public abstract class Hub extends Entity {

	protected String ville;

	protected Hub(String ville, String ID)
	{
		this.ville = ville;
		this.ID = ID;
	}

}