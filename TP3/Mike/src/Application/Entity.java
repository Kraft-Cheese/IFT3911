package Application;

public abstract class Entity implements IVisitable {

	protected String ID;
//	@Override
//	public String accept(Visitor v) {
//		return visitor.visit(this);
//	}


	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
}