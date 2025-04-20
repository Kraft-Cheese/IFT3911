package Transport;

import Application.Entity;
import Application.Visitor;

public abstract class Hub extends Entity{

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	protected String ville;

	protected Hub(String ville, String ID)
	{
		this.ville = ville;
		this.ID = ID;
	}

}