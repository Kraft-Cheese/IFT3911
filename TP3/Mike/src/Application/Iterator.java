package Application;

// iterator interface
public interface Iterator {

	void add(Entity e);

	void next();

	void previous();

	Entity getCurrent();

	void remove(Entity e);

	void first();

	void isDone();

}