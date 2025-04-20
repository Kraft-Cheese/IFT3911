package Application;

public interface Iterator {

	/**
	 * 
	 * @param e
	 */
	void add(Entity e);

	void next();

	void previous();

	Entity getCurrent();

	/**
	 * 
	 * @param e
	 */
	void remove(Entity e);

	void first();

	void isDone();

}