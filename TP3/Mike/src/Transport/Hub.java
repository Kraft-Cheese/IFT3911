package Transport;

public abstract class Hub extends Entity {

	public Hub(String nom, String ville) {
		super(nom);
		this.Ville = ville;
	}

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

	protected String Ville;

}