package Application;

public interface IVisitable {

	/**
	 * 
	 * @param v
	 */
	void accept(Visitor v);
//	String accept(Visitor v);

}