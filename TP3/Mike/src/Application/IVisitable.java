package Application;

public interface IVisitable {

	/**
	 * 
	 * @param v
	 */
	String accept(Visitor v);

}