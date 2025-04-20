package Transport;

import Application.Entity;


public abstract class Hub extends Entity{

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
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